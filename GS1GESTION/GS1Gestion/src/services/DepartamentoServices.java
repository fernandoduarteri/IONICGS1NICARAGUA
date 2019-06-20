package services;

import dao.DepartamentoDAO;
import model.Departamento;
import model.ObjectReturn;

public class DepartamentoServices {
	
	public void creardepartamento(ObjectReturn objReturn) throws Exception {
		DepartamentoDAO objDepartamentoDAO = new DepartamentoDAO(Departamento.class);
		objDepartamentoDAO.crearDepartamento(objReturn);
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		DepartamentoDAO objDepartamentoDAO = new DepartamentoDAO(Departamento.class);
		objDepartamentoDAO.getall(objReturn);
		
	}

	public void actualizardepartamento(ObjectReturn objReturn) throws Exception {
		DepartamentoDAO objDepartamentoDAO = new DepartamentoDAO(Departamento.class);
		objDepartamentoDAO.actualizarDepartamento(objReturn);
		
	}
	
	public void getone(ObjectReturn objReturn) throws Exception {
		DepartamentoDAO objDepartamentoDAO = new DepartamentoDAO(Departamento.class);
		objDepartamentoDAO.getone(objReturn);
		
	}

}
