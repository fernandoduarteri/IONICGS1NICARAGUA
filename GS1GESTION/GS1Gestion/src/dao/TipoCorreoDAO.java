package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Departamento;
import model.ObjectReturn;
import model.TipoCorreo;
import persist.JPAEntity;

public class TipoCorreoDAO extends JPAEntity<TipoCorreo> {

	public TipoCorreoDAO(Class<TipoCorreo> entityClass) {
		super(entityClass);
	}

	public void crearTipoCorreo(ObjectReturn objReturn) {
		TipoCorreo objTipoCorreo = new TipoCorreo();
		try {
			objTipoCorreo = (TipoCorreo) objReturn.getData();
			super.create(objTipoCorreo);
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

	public void actualizarTipoCorreo(ObjectReturn objReturn) {
		TipoCorreo objTipoCorreo = new TipoCorreo();
		try {
			objTipoCorreo = (TipoCorreo) objReturn.getData();
			super.edit(objTipoCorreo);
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
				query="SELECT t FROM TipoCorreo t ORDER BY t.idTipoCorreo ASC";
				objReturn.setData(super.findAllSorting(query));
			}else {
				query="SELECT t FROM TipoCorreo t ORDER BY t." + sorting;
				objReturn.setData(super.findAllSorting(query));
			}
			objReturn.setMensaje("Exito");
			objReturn.setExito(Constantes.FLAG_EXITO_EXITO);
			objReturn.setTotal(super.findAll().size());
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
