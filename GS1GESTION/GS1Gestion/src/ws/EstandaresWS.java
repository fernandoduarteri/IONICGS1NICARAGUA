package ws;

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
import model.Estandares;
import model.ObjectReturn;
import services.EstandaresServices;

@Path("Estandares")
public class EstandaresWS {

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearEstandares(@FormParam("descripcion")String descripcion,@FormParam("estandar")String estandar,@FormParam("estatus") boolean estatus) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			Estandares objEstandares = new Estandares();
			objEstandares.setDescripcion(descripcion);
			objEstandares.setEstandar(estandar);
			objEstandares.setEstatus(estatus);
			EstandaresServices objEstandaresServices = new EstandaresServices();
			objReturn.setData(objEstandares);
			objEstandaresServices.crearEstandar(objReturn);
			if (!objReturn.getExito()) {
				throw new Exception(objReturn.getMensaje());
			}
			JsonElement objelement= objJSON.toJsonTree(objReturn.getData());
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
	public String ActualizarEstandares(@FormParam("idEstandares")Integer idEstandares,@FormParam("descripcion")String descripcion,@FormParam("estandar")String estandar,@FormParam("estatus")boolean estatus) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			Estandares objEstandares = new Estandares();
			objEstandares.setDescripcion(descripcion);
			objEstandares.setEstandar(estandar);
			objEstandares.setEstatus(estatus);
			EstandaresServices objEstandaresServices = new EstandaresServices();

			objReturn.setData(objEstandares);
			// objGlobalServices.ValidarJSON(objReturn);
			objEstandaresServices.actualizarEstandares(objReturn);
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
	public String getEstandares(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new	JsonObject();
		try {
			objReturn.setData(jtSorting);
			EstandaresServices objEstandaresServices = new EstandaresServices();
			objEstandaresServices.getall(objReturn);
			if (!objReturn.getExito()) {
				throw new Exception(objReturn.getMensaje());
			}
			resultado = objJSON.toJson(objReturn.getData());
			JsonElement objelement= objJSON.toJsonTree(objReturn.getData());
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
