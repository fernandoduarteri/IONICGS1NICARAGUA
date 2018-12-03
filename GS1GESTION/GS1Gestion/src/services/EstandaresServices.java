package services;


import dao.EstandaresDAO;
import model.Estandares;
import model.ObjectReturn;

public class EstandaresServices {

	 public void crearEstandar(ObjectReturn objReturn) throws Exception {
		 EstandaresDAO objEstandaresDAO = new EstandaresDAO(Estandares.class);
		 objEstandaresDAO.crearEstandares(objReturn);
		
	}

	public void actualizarEstandares(ObjectReturn objReturn) throws Exception {
		EstandaresDAO objEstandaresDAO = new EstandaresDAO(Estandares.class);
		 objEstandaresDAO.actualizarEstandares(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception {
		EstandaresDAO objEstandaresDAO = new EstandaresDAO(Estandares.class);
		 objEstandaresDAO.getall(objReturn);
		
	}

}
