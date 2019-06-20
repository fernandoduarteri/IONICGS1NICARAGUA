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
import model.DetalleEstatus;
import model.ObjectReturn;
import services.DetalleEstatusServices;
import services.GlobalServices;

@Path("DetalleEstatus")

public class DetalleEstatusWS {

	GlobalServices objGlobalServices = new GlobalServices();

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearDetalleEstatus(@FormParam("afiliado") Integer afiliado,
			@FormParam("fechaEstatus") Timestamp fechaEstatus, @FormParam("estatus") boolean estatus,
			@FormParam("comentario") String comentario) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			Afiliado objAfiliaddo = new Afiliado();
			objAfiliaddo.setIdAfiliado(afiliado);
			DetalleEstatus objDetalleEstatus = new DetalleEstatus();
			objDetalleEstatus.setAfiliado(objAfiliaddo);
			objDetalleEstatus.setFechaEstatus(fechaEstatus);
			objDetalleEstatus.setEstatus(estatus);
			objDetalleEstatus.setComentario(comentario);
			DetalleEstatusServices objDetalleEstatusService = new DetalleEstatusServices();
			objReturn.setData(objDetalleEstatus);
			objDetalleEstatusService.creardetalleestatus(objReturn);
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
	public String ActualizarDetalleEstatus(@FormParam("idDetalleEstatus") Integer idDetalleEstatus,
			@FormParam("afiliado") Integer afiliado,
			@FormParam("fechaEstatus") Timestamp fechaEstatus, @FormParam("estatus") boolean estatus,
			@FormParam("comentario") String comentario) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			Afiliado objAfiliaddo = new Afiliado();
			objAfiliaddo.setIdAfiliado(afiliado);
			DetalleEstatus objDetalleEstatus = new DetalleEstatus();
			objDetalleEstatus.setIdDetalleEstatus(idDetalleEstatus);
			objDetalleEstatus.setAfiliado(objAfiliaddo);
			objDetalleEstatus.setFechaEstatus(fechaEstatus);
			objDetalleEstatus.setEstatus(estatus);
			objDetalleEstatus.setComentario(comentario);
			DetalleEstatusServices objDetalleEstatusService = new DetalleEstatusServices();
			objReturn.setData(objDetalleEstatus);
			objDetalleEstatusService.actualizardetalleestatus(objReturn);
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
	public String getDetalleEstatus(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new JsonObject();
		try {
			objReturn.setData(jtSorting);
			DetalleEstatusServices objDetalleEstatusService = new DetalleEstatusServices();
			objDetalleEstatusService.getall(objReturn);
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
