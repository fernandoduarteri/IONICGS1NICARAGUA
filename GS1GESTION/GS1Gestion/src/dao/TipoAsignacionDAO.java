package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.ObjectReturn;
import model.TipoAsignacion;
import persist.JPAEntity;

public class TipoAsignacionDAO extends JPAEntity<TipoAsignacion> {

	public TipoAsignacionDAO(Class<TipoAsignacion> entityClass) {
		super(entityClass);
	}

	public void crearTipoAsignacion(ObjectReturn objReturn) throws Exception {
		TipoAsignacion objTipoAsignacion = new TipoAsignacion();
		try {
			objTipoAsignacion = (TipoAsignacion) objReturn.getData();
			super.create(objTipoAsignacion);
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

	public void actualizarTipoAsignacion(ObjectReturn objReturn) throws Exception {
		TipoAsignacion objTipoAsignacion = new TipoAsignacion();
		try {
			objTipoAsignacion = (TipoAsignacion) objReturn.getData();
			super.edit(objTipoAsignacion);
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

	public void getall(ObjectReturn objReturn) throws Exception {
		String sorting = (String) objReturn.getData();
		String query = "";
		try {
			if (sorting == null) {
				query = "SELECT t FROM TipoAsignacion t ORDER BY t.idTipoAsignacion ASC";
				
			} else {
				query = "SELECT t FROM TipoAsignacion t ORDER BY t." + sorting;
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

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
