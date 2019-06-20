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

import model.Cargo;
import model.ObjectReturn;
import services.CargoServices;
import services.DepartamentoServices;

@Path("Cargo")
public class CargosWS {

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearCargo(@FormParam("cargo")String cargo,@FormParam("descripcion")String descripcion) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			Cargo objCargo = new Cargo();
			objCargo.setDescripcion(descripcion);
			objCargo.setCargo(cargo);
			CargoServices objCargoService = new CargoServices();
			objReturn.setData(objCargo);
			objCargoService.crearcargo(objReturn);
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
	public String ActualizarCargo(@FormParam("idCargos")Integer idCargos,@FormParam("cargo")String cargo,@FormParam("descripcion")String descripcion) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			Cargo objCargo = new Cargo();
			objCargo.setIdCargos(idCargos);
			objCargo.setCargo(cargo);
			objCargo.setDescripcion(descripcion);
			CargoServices objCargoService = new CargoServices();

			objReturn.setData(objCargoService);
			// objGlobalServices.ValidarJSON(objReturn);
			objCargoService.actualizarcargo(objReturn);
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
	public String getDepartamentos(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new	JsonObject();
		try {
			objReturn.setData(jtSorting);
			CargoServices objCargoService = new CargoServices();
			objCargoService.getall(objReturn);
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
			CargoServices objCargoService = new CargoServices();
			objCargoService.getall(objReturn);
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
				int intId=objJsonObject.get("idCargos").getAsInt();
				String strCargo =objJsonObject.get("cargo").getAsString();
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
