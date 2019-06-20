package services;

import dao.ItemTrazableDAO;
import model.ItemsTrazable;
import model.ObjectReturn;

public class ItemsTrazableServices {

	public void crearitemtrazable(ObjectReturn objReturn) {
		ItemTrazableDAO objDepartamentoDAO = new ItemTrazableDAO(ItemsTrazable.class);
		objDepartamentoDAO.crearItemTrazable(objReturn);
		
	}

	public void actualizaritemtrazable(ObjectReturn objReturn) {
		ItemTrazableDAO objDepartamentoDAO = new ItemTrazableDAO(ItemsTrazable.class);
		objDepartamentoDAO.actualizarItemTrazable(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) {
		ItemTrazableDAO objDepartamentoDAO = new ItemTrazableDAO(ItemsTrazable.class);
		objDepartamentoDAO.getall(objReturn);
		
	}

}
