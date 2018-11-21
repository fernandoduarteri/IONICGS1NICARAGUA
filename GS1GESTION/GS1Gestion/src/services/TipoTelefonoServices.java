package services;

import dao.TipoTelefonoDAO;
import model.ObjectReturn;
import model.TipoTelefono;

public class TipoTelefonoServices {

	public void creartipotelefono(ObjectReturn objReturn) throws Exception {
		TipoTelefonoDAO objTipoTelefonoDAO = new TipoTelefonoDAO(TipoTelefono.class);
		objTipoTelefonoDAO.crearTipoTelefono(objReturn);
		
	}

	public void actualizarTipoTelefono(ObjectReturn objReturn) throws Exception {
		TipoTelefonoDAO objTipoTelefonoDAO = new TipoTelefonoDAO(TipoTelefono.class);
		objTipoTelefonoDAO.actualizarTipoTelefono(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception {
		TipoTelefonoDAO objTipoTelefonoDAO = new TipoTelefonoDAO(TipoTelefono.class);
		objTipoTelefonoDAO.getall(objReturn);
		
	}

	

}
