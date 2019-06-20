package services;

import dao.TipoIdentificacionDAO;
import model.ObjectReturn;
import model.TipoIdentificacion;

public class TipoIdentificacionServices {

	public void creartipoidentificacion(ObjectReturn objReturn) throws Exception{
		TipoIdentificacionDAO objCargoDAO = new TipoIdentificacionDAO(TipoIdentificacion.class);
		objCargoDAO.crearTipoIdentificacion(objReturn);
		
	}

	public void actualizartipoidentificacion(ObjectReturn objReturn) throws Exception{
		TipoIdentificacionDAO objCargoDAO = new TipoIdentificacionDAO(TipoIdentificacion.class);
		objCargoDAO.actualizarTipoIdentificacion(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		TipoIdentificacionDAO objCargoDAO = new TipoIdentificacionDAO(TipoIdentificacion.class);
		objCargoDAO.getall(objReturn);
		
	}

}
