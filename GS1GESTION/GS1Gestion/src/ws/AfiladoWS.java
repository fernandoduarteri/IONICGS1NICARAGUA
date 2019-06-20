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
import model.Departamento;
import model.Municipio;
import model.ObjectReturn;
import model.TipoEmpresa;
import services.AfiliadoServices;
import services.DepartamentoServices;

@Path("Afiliado")
public class AfiladoWS {

	@Path("/Crear")
	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String CrearAfiliado(@FormParam("direccion") String direccion,
			@FormParam("nomComercial") String nomComercial, @FormParam("razonSocial") String razonSocial,
			@FormParam("ruc") String ruc, @FormParam("telefono") String telefono,@FormParam("saldoPendiente") boolean saldoPendiente,
			@FormParam("departamento") Integer departamento, @FormParam("municipio") Integer municicpio, @FormParam("tipoEmpresa") Integer tipoEmpresa) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			Departamento objDepartamento = new Departamento();
			Municipio objMunicipio = new Municipio();
			TipoEmpresa objTipoEmpresa = new TipoEmpresa();
			objDepartamento.setIdDepartamentos(departamento);
			objMunicipio.setIdMunicipios(municicpio);
			objTipoEmpresa.setIdTipoEmpresa(tipoEmpresa);
			Afiliado objAfiliado= new Afiliado();
			objAfiliado.setDireccion(direccion);
			objAfiliado.setNomComercial(nomComercial);
			objAfiliado.setRazonSocial(razonSocial);
			objAfiliado.setRuc(ruc);
			objAfiliado.setTelefono(telefono);
			objAfiliado.setSaldoPendiente(saldoPendiente);
			objAfiliado.setDepartamento(objDepartamento);
			objAfiliado.setMunicipio(objMunicipio);
			objAfiliado.setTipoEmpresa(objTipoEmpresa);
			AfiliadoServices objAfiliadoService = new AfiliadoServices();
			objReturn.setData(objAfiliado);
			objAfiliadoService.crearafiliado(objReturn);
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
	public String ActualizarAfilliado(@FormParam("idAfiliado") Integer idAfiliado, @FormParam("direccion") String direccion,
			@FormParam("nomComercial") String nomComercial, @FormParam("razonSocial") String razonSocial,
			@FormParam("ruc") String ruc, @FormParam("telefono") String telefono,@FormParam("saldoPendiente") boolean saldoPendiente,
			@FormParam("departamento") Integer departamento, @FormParam("municipio") Integer municicpio, @FormParam("tipoEmpresa") Integer tipoEmpresa) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new GsonBuilder().create();
		JsonObject objJsonAux = new JsonObject();
		try {
			Departamento objDepartamento = new Departamento();
			Municipio objMunicipio = new Municipio();
			TipoEmpresa objTipoEmpresa = new TipoEmpresa();
			objDepartamento.setIdDepartamentos(departamento);
			objMunicipio.setIdMunicipios(municicpio);
			objTipoEmpresa.setIdTipoEmpresa(tipoEmpresa);
			Afiliado objAfiliado= new Afiliado();
			objAfiliado.setIdAfiliado(idAfiliado);
			objAfiliado.setDireccion(direccion);
			objAfiliado.setNomComercial(nomComercial);
			objAfiliado.setRazonSocial(razonSocial);
			objAfiliado.setRuc(ruc);
			objAfiliado.setTelefono(telefono);
			objAfiliado.setSaldoPendiente(saldoPendiente);
			objAfiliado.setDepartamento(objDepartamento);
			objAfiliado.setMunicipio(objMunicipio);
			objAfiliado.setTipoEmpresa(objTipoEmpresa);
			AfiliadoServices objAfiliadoService = new AfiliadoServices();
			objReturn.setData(objAfiliado);
			objAfiliadoService.actualizarafiliado(objReturn);
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
	public String getAfiliados(@QueryParam("jtSorting") String jtSorting) {
		ObjectReturn objReturn = new ObjectReturn();
		String resultado = "";
		Gson objJSON = new Gson();
		JsonObject objJsonAux = new JsonObject();
		try {
			objReturn.setData(jtSorting);
			AfiliadoServices objAfiliadoService = new AfiliadoServices();
			objAfiliadoService.getall(objReturn);
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
