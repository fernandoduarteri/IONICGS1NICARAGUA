package services;

import dao.DetalleEstatusDAO;
import model.DetalleEstatus;
import model.ObjectReturn;

public class DetalleEstatusServices {

	public void creardetalleestatus(ObjectReturn objReturn) throws Exception {
		DetalleEstatusDAO objDetalleEstatusDAO = new DetalleEstatusDAO(DetalleEstatus.class);
		objDetalleEstatusDAO.crearDetalleEstatus(objReturn);

	}

	public void actualizardetalleestatus(ObjectReturn objReturn) throws Exception {
		DetalleEstatusDAO objDetalleEstatusDAO = new DetalleEstatusDAO(DetalleEstatus.class);
		objDetalleEstatusDAO.actualizarDetalleEstatus(objReturn);

	}

	public void getall(ObjectReturn objReturn) throws Exception {
		DetalleEstatusDAO objDetalleEstatusDAO = new DetalleEstatusDAO(DetalleEstatus.class);
		objDetalleEstatusDAO.getall(objReturn);

	}

}
