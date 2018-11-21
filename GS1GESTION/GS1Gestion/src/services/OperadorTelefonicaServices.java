package services;

import dao.OperadorTelefonicaDAO;
import model.ObjectReturn;
import model.OperadorTelefonica;

public class OperadorTelefonicaServices {

	public void crearOperadorTelefonica(ObjectReturn objReturn) throws Exception {
		OperadorTelefonicaDAO objOperadorTelefonicaDAO = new OperadorTelefonicaDAO(OperadorTelefonica.class);
		objOperadorTelefonicaDAO.crearOperador(objReturn);
		
	}

	public void actualizardepartamento(ObjectReturn objReturn) throws Exception {
		OperadorTelefonicaDAO objOperadorTelefonicaDAO = new OperadorTelefonicaDAO(OperadorTelefonica.class);
		objOperadorTelefonicaDAO.actualizarOperador(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception {
		OperadorTelefonicaDAO objOperadorTelefonicaDAO = new OperadorTelefonicaDAO(OperadorTelefonica.class);
		objOperadorTelefonicaDAO.getall(objReturn);
		
	}

}
