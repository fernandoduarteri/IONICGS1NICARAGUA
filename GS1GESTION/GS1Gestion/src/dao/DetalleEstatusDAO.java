package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.DetalleEstatus;
import model.ObjectReturn;
import persist.JPAEntity;


public class DetalleEstatusDAO extends JPAEntity<DetalleEstatus> {

	public DetalleEstatusDAO(Class<DetalleEstatus> entityClass) {
		super(entityClass);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearDetalleEstatus(ObjectReturn objReturn) throws Exception{
		DetalleEstatus objDetalleEstatus = new DetalleEstatus();
		try {
			objDetalleEstatus = (DetalleEstatus) objReturn.getData();
			super.create(objDetalleEstatus);
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

	public void actualizarDetalleEstatus(ObjectReturn objReturn) throws Exception{
		DetalleEstatus objDetalleEstatus = new DetalleEstatus();
		try {
			objDetalleEstatus = (DetalleEstatus) objReturn.getData();
			super.edit(objDetalleEstatus);
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

	public void getall(ObjectReturn objReturn) throws Exception{
		String sorting = (String) objReturn.getData();
		String query="";
		try {
			if (sorting ==null) {
				query="SELECT d FROM DetalleEstatus d ORDER BY d.idDetalleEstatus ASC";
				
			}else {
				query="SELECT d FROM DetalleEstatus d ORDER BY d." + sorting;
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
