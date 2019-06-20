package ws;

import java.sql.Timestamp;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.Afiliado;
import model.Departamento;
import model.Estandares;
import model.ItemsTrazable;
import model.ObjectReturn;
import services.DepartamentoServices;
import services.ItemsTrazableServices;

@Path("ItemsTrazables")
public class ItemsTrazablesWS {

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearItemTrazable(@FormParam("afiliado") Integer afiliado,
			@FormParam("estandares") Integer estandares, @FormParam("itemsTrazables") String itemsTrazables,
			@FormParam("itemsTrazableFinal") String itemsTrazableFinal, @FormParam("digitoVerificacion") String digitoVerificacion,
			@FormParam("estatus")  boolean estatus, @FormParam("marca") String marca,
			@FormParam("presentacion") String presentacion, @FormParam("descripcion") String descripcion,
			@FormParam("imagen") String imagen, @FormParam("fechaAltaItemTrazable") Timestamp fechaAltaItemTrazable) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			ItemsTrazable objItemTrazable = new ItemsTrazable();
			Afiliado objAfiliado = new Afiliado();
			Estandares objEstandares = new Estandares();
			objAfiliado.setIdAfiliado(afiliado);
			objEstandares.setIdEstandares(estandares);
			objItemTrazable.setAfiliado(objAfiliado);
			objItemTrazable.setEstandare(objEstandares);
			objItemTrazable.setItemsTrazables(itemsTrazables);
			objItemTrazable.setItemsTrazableFinal(itemsTrazableFinal);
			objItemTrazable.setDigitoVerificacion(digitoVerificacion);
			objItemTrazable.setEstatus(estatus);
			objItemTrazable.setMarca(marca);
			objItemTrazable.setPresentacion(presentacion);
			objItemTrazable.setDescripcion(descripcion);
			objItemTrazable.setFechaAltaItemTrazable(fechaAltaItemTrazable);
			
			ItemsTrazableServices objItemsTrazableService = new ItemsTrazableServices();
			objReturn.setData(objItemTrazable);
			objItemsTrazableService.crearitemtrazable(objReturn);
			if (!objReturn.getExito()) {
				throw new Exception(objReturn.getMensaje());
			}
			JsonElement objelement = objJSON.toJsonTree(objReturn.getData());
			objJsonAux.addProperty("Result", "OK");
			objJsonAux.add("Record", objelement);
			resultado = objJSON.toJson(objJsonAux);
			return resultado;
		} catch (Exception e) {
			objJsonAux.addProperty("Result", "ERROR");
			objJsonAux.addProperty("Message", e.getMessage());
			resultado = objJSON.toJson(objJsonAux);
			return resultado;
		}

	}

	@Path("/Actualizar")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String ActualizarItemTrazable(@FormParam("idItemsTrazables") Integer idItemsTrazables,
			@FormParam("afiliado") Integer afiliado,
			@FormParam("estandares") Integer estandares, @FormParam("itemsTrazables") String itemsTrazables,
			@FormParam("itemsTrazableFinal") String itemsTrazableFinal, @FormParam("digitoVerificacion") String digitoVerificacion,
			@FormParam("estatus")  boolean estatus, @FormParam("marca") String marca,
			@FormParam("presentacion") String presentacion, @FormParam("descripcion") String descripcion,
			@FormParam("imagen") String imagen, @FormParam("fechaAltaItemTrazable") Timestamp fechaAltaItemTrazable) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			ItemsTrazable objItemTrazable = new ItemsTrazable();
			Afiliado objAfiliado = new Afiliado();
			Estandares objEstandares = new Estandares();
			objAfiliado.setIdAfiliado(afiliado);
			objEstandares.setIdEstandares(estandares);
			objItemTrazable.setIdItemsTrazables(idItemsTrazables);
			objItemTrazable.setAfiliado(objAfiliado);
			objItemTrazable.setEstandare(objEstandares);
			objItemTrazable.setItemsTrazables(itemsTrazables);
			objItemTrazable.setItemsTrazableFinal(itemsTrazableFinal);
			objItemTrazable.setDigitoVerificacion(digitoVerificacion);
			objItemTrazable.setEstatus(estatus);
			objItemTrazable.setMarca(marca);
			objItemTrazable.setPresentacion(presentacion);
			objItemTrazable.setDescripcion(descripcion);
			objItemTrazable.setFechaAltaItemTrazable(fechaAltaItemTrazable);
			
			ItemsTrazableServices objItemsTrazableService = new ItemsTrazableServices();
			objReturn.setData(objItemTrazable);
			objItemsTrazableService.actualizaritemtrazable(objReturn);
			if (!objReturn.getExito()) {
				throw new Exception(objReturn.getMensaje());
			}
			objJsonAux.addProperty("Result", "OK");
			resultado = objJSON.toJson(objJsonAux);
			return resultado;
		} catch (Exception e) {
			objJsonAux.addProperty("Result", "ERROR");
			objJsonAux.addProperty("Message", e.getMessage());
			resultado = objJSON.toJson(objJsonAux);
			return resultado;
		}

	}

	@Path("/Lista")
	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String getItemTrazable(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new JsonObject();
		try {
			objReturn.setData(jtSorting);
			ItemsTrazableServices objItemsTrazableService = new ItemsTrazableServices();
			objItemsTrazableService.getall(objReturn);
			if (!objReturn.getExito()) {
				throw new Exception(objReturn.getMensaje());
			}
			resultado = objJSON.toJson(objReturn.getData());
			JsonElement objelement = objJSON.toJsonTree(objReturn.getData());
			JsonArray objJsonArray = objelement.getAsJsonArray();
			objJsonAux.addProperty("Result", "OK");
			objJsonAux.add("Records", objJsonArray);
			resultado = objJSON.toJson(objJsonAux);
			return resultado;
		} catch (Exception e) {
			objJsonAux.addProperty("Result", "ERROR");
			objJsonAux.addProperty("Message", e.getMessage());
			resultado = objJSON.toJson(objJsonAux);
			return resultado;
		}

	}
}
