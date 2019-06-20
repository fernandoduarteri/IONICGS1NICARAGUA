package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Cargo;
import model.ObjectReturn;
import model.TipoIdentificacion;
import persist.JPAEntity;

public class TipoIdentificacionDAO extends JPAEntity<TipoIdentificacion>{

	public TipoIdentificacionDAO(Class<TipoIdentificacion> entityClass) {
		super(entityClass);
	}

	public void crearTipoIdentificacion(ObjectReturn objReturn) throws Exception{
		TipoIdentificacion objTipoIdentificacion = new TipoIdentificacion();
		try {
			objTipoIdentificacion = (TipoIdentificacion) objReturn.getData();
			super.create(objTipoIdentificacion);
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

	@Override
	protected EntityManager getEntityManager()  {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarTipoIdentificacion(ObjectReturn objReturn) throws Exception{
		TipoIdentificacion objTipoIdentificacion = new TipoIdentificacion();
		try {
			objTipoIdentificacion = (TipoIdentificacion) objReturn.getData();
			super.edit(objTipoIdentificacion);
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
		String query = "";
		try {
			if (sorting == null) {
				query = "SELECT t FROM TipoIdentificacion t ORDER BY t.idTipoIdentificacion ASC";
			} else {
				query = "SELECT t FROM TipoIdentificacion t ORDER BY t." + sorting;
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
