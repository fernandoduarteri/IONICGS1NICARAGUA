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

import model.Contacto;
import model.Departamento;
import model.DetalleContacto;
import model.ObjectReturn;
import model.OperadorTelefonica;
import model.TipoCorreo;
import model.TipoTelefono;
import services.DepartamentoServices;
import services.DetalleContactoServices;

@Path("DetalleContactos")
public class DetalleContactosWS {

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearDetalleContacto(@FormParam("contacto") Integer contacto, @FormParam("telefono") String telefono,
			@FormParam("tipoTelefono") Integer tipoTelefono, @FormParam("email") String email,
			@FormParam("tipoCorreo") Integer tipoCorreo, @FormParam("operadorTelefonica") Integer operadorTelefonica) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			DetalleContacto objDetalleContacto = new DetalleContacto();
			Contacto objContacto = new Contacto();
			TipoTelefono objTipoTelefono = new TipoTelefono();
			TipoCorreo objTipoCorreo = new TipoCorreo();
			OperadorTelefonica objOperadorTelefonica = new OperadorTelefonica();
			objContacto.setIdContactos(contacto);
			objTipoTelefono.setIdTipoTelefono(tipoTelefono);
			objTipoCorreo.setIdTipoCorreo(tipoCorreo);
			objOperadorTelefonica.setIdOperadorTelefonica(operadorTelefonica);
			objDetalleContacto.setContacto(objContacto);
			objDetalleContacto.setTelefono(telefono);
			objDetalleContacto.setTipoTelefono(objTipoTelefono);
			objDetalleContacto.setEmail(email);
			objDetalleContacto.setTipoCorreo(objTipoCorreo);
			objDetalleContacto.setOperadorTelefonica(objOperadorTelefonica);
			DetalleContactoServices objDetalleContactoService = new DetalleContactoServices();
			objReturn.setData(objContacto);
			objDetalleContactoService.creardetallecontacto(objReturn);
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
	public String ActualizarDetalleContacto(@FormParam("idDetalleContacto") Integer idDetalleContacto, @FormParam("contacto") Integer contacto,
			@FormParam("telefono") String telefono, @FormParam("tipoTelefono") Integer tipoTelefono,
			@FormParam("email") String email, @FormParam("tipoCorreo") Integer tipoCorreo,
			@FormParam("operadorTelefonica") Integer operadorTelefonica) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			DetalleContacto objDetalleContacto = new DetalleContacto();
			Contacto objContacto = new Contacto();
			TipoTelefono objTipoTelefono = new TipoTelefono();
			TipoCorreo objTipoCorreo = new TipoCorreo();
			OperadorTelefonica objOperadorTelefonica = new OperadorTelefonica();
			objContacto.setIdContactos(contacto);
			objTipoTelefono.setIdTipoTelefono(tipoTelefono);
			objTipoCorreo.setIdTipoCorreo(tipoCorreo);
			objOperadorTelefonica.setIdOperadorTelefonica(operadorTelefonica);
			objDetalleContacto.setIdDetalleContacto(idDetalleContacto);
			objDetalleContacto.setContacto(objContacto);
			objDetalleContacto.setTelefono(telefono);
			objDetalleContacto.setTipoTelefono(objTipoTelefono);
			objDetalleContacto.setEmail(email);
			objDetalleContacto.setTipoCorreo(objTipoCorreo);
			objDetalleContacto.setOperadorTelefonica(objOperadorTelefonica);
			DetalleContactoServices objDetalleContactoService = new DetalleContactoServices();
			objReturn.setData(objContacto);
			objDetalleContactoService.actualizardetallecontacto(objReturn);
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
	public String getDetalleContacto(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new JsonObject();
		try {
			objReturn.setData(jtSorting);
			DetalleContactoServices objDetalleContactoService = new DetalleContactoServices();
			objDetalleContactoService.getall(objReturn);
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
