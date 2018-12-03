package services;


import dao.TipoAsignacionDAO;
import model.ObjectReturn;
import model.TipoAsignacion;

public class TipoAsignacionServices {

	public void crearTipoAsignacion(ObjectReturn objReturn) throws Exception {
		TipoAsignacionDAO objTipoAsignacionDAO = new TipoAsignacionDAO(TipoAsignacion.class);
		objTipoAsignacionDAO.crearTipoAsignacion(objReturn);
		
	}

	public void actualizarTipoAsignacion(ObjectReturn objReturn) throws Exception {
		TipoAsignacionDAO objTipoAsignacionDAO = new TipoAsignacionDAO(TipoAsignacion.class);
		objTipoAsignacionDAO.actualizarTipoAsignacion(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception {
		TipoAsignacionDAO objTipoAsignacionDAO = new TipoAsignacionDAO(TipoAsignacion.class);
		objTipoAsignacionDAO.getall(objReturn);
		
	}

}
