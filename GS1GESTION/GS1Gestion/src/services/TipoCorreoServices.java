package services;


import dao.TipoCorreoDAO;
import model.ObjectReturn;
import model.TipoCorreo;

public class TipoCorreoServices {

	public void crearTipoCorreo(ObjectReturn objReturn) {
		TipoCorreoDAO objTipoCorreoDAO = new TipoCorreoDAO(TipoCorreo.class);
		objTipoCorreoDAO.crearTipoCorreo(objReturn);
		
	}

	public void actualizarTipoCorreo(ObjectReturn objReturn) {
		TipoCorreoDAO objTipoCorreoDAO = new TipoCorreoDAO(TipoCorreo.class);
		objTipoCorreoDAO.actualizarTipoCorreo(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) {
		TipoCorreoDAO objTipoCorreoDAO = new TipoCorreoDAO(TipoCorreo.class);
		objTipoCorreoDAO.getall(objReturn);
	}

}
