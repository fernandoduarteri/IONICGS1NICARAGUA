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
import model.Afiliado;
import model.Cargo;
import model.Contacto;
import model.ObjectReturn;
import services.ContactoServices;

@Path("Contactos")
public class ContactosWS {

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearContacto(@FormParam("afiliado") Integer afiliado,
			@FormParam("titulo") String titulo, @FormParam("nombres") String nombres,
			@FormParam("apellidos") String apellidos, @FormParam("cargo") Integer cargo,
			@FormParam("estatus") boolean estatus) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			Contacto objContacto = new Contacto();
			Afiliado objAfiliado = new Afiliado();
			Cargo objCargo = new Cargo();
			objCargo.setIdCargos(cargo);
			objContacto.setAfiliado(objAfiliado);
			objContacto.setTitulo(titulo);
			objContacto.setNombres(nombres);
			objContacto.setApellidos(apellidos);
			objContacto.setCargo(objCargo);
			objContacto.setEstatus(estatus);
			ContactoServices objContactoService = new ContactoServices();
			objReturn.setData(objCargo);
			objContactoService.crearcontacto(objReturn);
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
	public String ActualizarContacto(@FormParam("idContactos") Integer idContactos,@FormParam("afiliado") Integer afiliado,
			@FormParam("titulo") String titulo, @FormParam("nombres") String nombres,
			@FormParam("apellidos") String apellidos, @FormParam("cargo") Integer cargo,
			@FormParam("estatus") boolean estatus) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			Contacto objContacto = new Contacto();
			Afiliado objAfiliado = new Afiliado();
			Cargo objCargo = new Cargo();
			objCargo.setIdCargos(cargo);
			objContacto.setIdContactos(idContactos);
			objContacto.setAfiliado(objAfiliado);
			objContacto.setTitulo(titulo);
			objContacto.setNombres(nombres);
			objContacto.setApellidos(apellidos);
			objContacto.setCargo(objCargo);
			objContacto.setEstatus(estatus);
			ContactoServices objContactoService = new ContactoServices();
			objReturn.setData(objCargo);
			objContactoService.actualizarcontacto(objReturn);
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
	public String getContactos(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new JsonObject();
		try {
			objReturn.setData(jtSorting);
			ContactoServices objContactoService = new ContactoServices();
			objContactoService.getall(objReturn);
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
