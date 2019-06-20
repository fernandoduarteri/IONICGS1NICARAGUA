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
import model.ObjectReturn;
import model.TipoIdentificacion;
import services.TipoIdentificacionServices;
@Path("TipoIdentificacion")
public class TipoIdentificacionWS {

	
	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearTipoIdentificacion(@FormParam("descripcion")String descripcion) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			TipoIdentificacion objTipoIdentificacion = new TipoIdentificacion();
			objTipoIdentificacion.setDescripcion(descripcion);
			TipoIdentificacionServices objTipoIdentificacionService = new TipoIdentificacionServices();
			objReturn.setData(objTipoIdentificacion);
			objTipoIdentificacionService.creartipoidentificacion(objReturn);
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
	public String ActualizarTipoIdentificacion(@FormParam("idTipoIdentificacion")Integer idTipoIdentificacion,@FormParam("descripcion")String descripcion) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			TipoIdentificacion objTipoIdentificacion = new TipoIdentificacion();
			objTipoIdentificacion.setIdTipoIdentificacion(idTipoIdentificacion);
			objTipoIdentificacion.setDescripcion(descripcion);
			
			TipoIdentificacionServices objTipoIdentificacionService = new TipoIdentificacionServices();

			objReturn.setData(objTipoIdentificacionService);
			// objGlobalServices.ValidarJSON(objReturn);
			objTipoIdentificacionService.actualizartipoidentificacion(objReturn);
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
	public String getTipoIdentificacion(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new	JsonObject();
		try {
			objReturn.setData(jtSorting);
			TipoIdentificacionServices objTipoIdentificacionService = new TipoIdentificacionServices();
			objTipoIdentificacionService.getall(objReturn);
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
	
	@Path("/Options")
	@POST
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String getOptions() {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new	JsonObject();
		try {
			TipoIdentificacionServices objTipoIdentificacionService = new TipoIdentificacionServices();
			objTipoIdentificacionService.getall(objReturn);
			if (!objReturn.getExito()) {
				throw new Exception(objReturn.getMensaje());
			}
			resultado = objJSON.toJson(objReturn.getData());
			JsonElement objelement= objJSON.toJsonTree(objReturn.getData());
			JsonArray objJsonArray = objelement.getAsJsonArray();
			JsonArray objJsonArrayAux = new JsonArray();
			for(int i=0; i<objJsonArray.size();i++) {
				JsonObject objJsonObject = objJsonArray.get(i).getAsJsonObject();
				JsonObject objJsonObjectAux = new JsonObject();
				int intId=objJsonObject.get("idTipoIdentificacion").getAsInt();
				String strCargo =objJsonObject.get("descripcion").getAsString();
				objJsonObjectAux.addProperty("Value", intId);
				objJsonObjectAux.addProperty("DisplayText", strCargo);
				objJsonArrayAux.add(objJsonObjectAux);
				
			}
			objJsonAux.addProperty("Result", "OK");
			objJsonAux.add("Options", objJsonArrayAux);
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
