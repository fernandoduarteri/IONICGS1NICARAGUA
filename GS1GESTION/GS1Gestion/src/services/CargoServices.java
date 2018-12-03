package services;

import dao.CargoDAO;
import model.Cargo;
import model.ObjectReturn;

public class CargoServices {

	public void crearcargo(ObjectReturn objReturn) throws Exception {
		CargoDAO objCargoDAO = new CargoDAO(Cargo.class);
		objCargoDAO.crearCargoo(objReturn);
		
	}

	public void actualizarcargo(ObjectReturn objReturn) throws Exception {
		CargoDAO objCargoDAO = new CargoDAO(Cargo.class);
		objCargoDAO.actualizarCargoo(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception {
		CargoDAO objCargoDAO = new CargoDAO(Cargo.class);
		objCargoDAO.getall(objReturn);
		
	}

}
