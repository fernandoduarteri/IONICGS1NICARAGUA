package services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import Utilidades.Constantes;
import model.ObjectReturn;

public class GlobalServices {

	public void ValidarJSON(ObjectReturn objReturn) throws Exception {

		try {
			String strJson = (String) objReturn.getData();
			JSONParser objParser = new JSONParser();
			JSONObject objJson = (JSONObject) objParser.parse(strJson);
		} catch (Exception e) {
			objReturn.setExito(Constantes.FLAG_EXITO_FALLA);
			objReturn.setTotal(Constantes.SIN_REGISTROS);
			objReturn.setMensaje(e.getMessage());
		}
	}
}
