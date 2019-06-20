package ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.apache.commons.beanutils.BeanUtilsBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.Departamento;
import model.Municipio;
import model.ObjectReturn;
import services.DepartamentoServices;
import services.MunicipiosServices;

@Path("Municipios")
public class MunicipiosWS {

	
	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearMunicipios(@FormParam("municipios")String municipios, @FormParam("departamento")Integer departamentos) {
		ObjectReturn objReturn = new ObjectReturn();
		ObjectReturn objReturnAux = new ObjectReturn();
		BeanUtilsBean objBeanUtilities = new BeanUtilsBean();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			Departamento objDepartamento = new Departamento();
			objDepartamento.setIdDepartamentos(departamentos);
			objReturnAux.setData(objDepartamento);
			DepartamentoServices objDepartamentoServices = new DepartamentoServices();
			objDepartamentoServices.getone(objReturnAux);			
			objBeanUtilities.copyProperties(objDepartamento, (Departamento)objReturnAux.getData());
			Municipio objMunicipios = new Municipio();
			objMunicipios.setMunicipios(municipios);
			objMunicipios.setDepartamento(objDepartamento);
			MunicipiosServices objMunicipiosService = new MunicipiosServices();
			objReturn.setData(objMunicipios);
			objMunicipiosService.crearmunicipio(objReturn);
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
	public String ActualizarMunicipios(@FormParam("idMunicipios")Integer idMunicipios,@FormParam("municipios")String municipios,@FormParam("departamento")Integer departamento) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new	JsonObject();
		try {
			Departamento objDepartamento = new Departamento();
			objDepartamento.setIdDepartamentos(departamento);
			Municipio objMunicipios = new Municipio();
			objMunicipios.setIdMunicipios(idMunicipios);
			objMunicipios.setMunicipios(municipios);
			objMunicipios.setDepartamento(objDepartamento);
			MunicipiosServices objMunicipioService = new MunicipiosServices();

			objReturn.setData(objMunicipios);
			// objGlobalServices.ValidarJSON(objReturn);
			objMunicipioService.actualizarmunicipio(objReturn);
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
	public String getMunicipios(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new	JsonObject();
		try {
			objReturn.setData(jtSorting);
			MunicipiosServices objMunicipioService = new MunicipiosServices();
			objMunicipioService.getall(objReturn);
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
	public String getOptions(@QueryParam("IdDepartamento") Integer idDepartamento) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new	JsonObject();
		try {
			objReturn.setData(idDepartamento);
			MunicipiosServices objMunicipioService = new MunicipiosServices();
			objMunicipioService.getWhere(objReturn);
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
				int intId=objJsonObject.get("idMunicipios").getAsInt();
				String strMunicipios =objJsonObject.get("municipios").getAsString();
				objJsonObjectAux.addProperty("Value", intId);
				objJsonObjectAux.addProperty("DisplayText", strMunicipios);
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
