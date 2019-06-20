package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.ItemsTrazable;
import model.ObjectReturn;
import persist.JPAEntity;

public class ItemTrazableDAO extends JPAEntity<ItemsTrazable>{

	public ItemTrazableDAO(Class<ItemsTrazable> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearItemTrazable(ObjectReturn objReturn) {
		ItemsTrazable objItemsTrazable = new ItemsTrazable();
		try {
			objItemsTrazable = (ItemsTrazable) objReturn.getData();
			super.create(objItemsTrazable);
			objReturn.setMensaje("Exito");
			objReturn.setExito(Constantes.FLAG_EXITO_EXITO);
			objReturn.setTotal(1);
		} catch (Exception e) {
			objReturn.setData("");
			objReturn.setMensaje(e.getMessage());
			objReturn.setExito(Constantes.FLAG_EXITO_FALLA);
			objReturn.setTotal(0);
		}
		
	}

	public void actualizarItemTrazable(ObjectReturn objReturn) {
		ItemsTrazable objItemsTrazable = new ItemsTrazable();
		try {
			objItemsTrazable = (ItemsTrazable) objReturn.getData();
			super.edit(objItemsTrazable);
			objReturn.setMensaje("Exito");
			objReturn.setExito(Constantes.FLAG_EXITO_EXITO);
			objReturn.setTotal(1);
		} catch (Exception e) {
			objReturn.setData("");
			objReturn.setMensaje(e.getMessage());
			objReturn.setExito(Constantes.FLAG_EXITO_FALLA);
			objReturn.setTotal(0);
		}
		
	}

	public void getall(ObjectReturn objReturn) {
		String sorting = (String) objReturn.getData();
		String query="";
		try {
			if (sorting ==null) {
				query="SELECT i FROM ItemsTrazable i ORDER BY i.idItemsTrazables ASC";
				
			}else {
				query="SELECT i FROM ItemsTrazable i ORDER BY i." + sorting;
			}
			objReturn.setData(super.findAllSorting(query));
			objReturn.setMensaje("Exito");
			objReturn.setExito(Constantes.FLAG_EXITO_EXITO);
			objReturn.setTotal(super.count());
		} catch (Exception e) {
			objReturn.setData("");
			objReturn.setMensaje(e.getMessage());
			objReturn.setExito(Constantes.FLAG_EXITO_FALLA);
			objReturn.setTotal(0);
		}
		
	}

}
