package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.ObjectReturn;
import model.TipoEmpresa;
import persist.JPAEntity;

public class TipoEmpresaDAO extends JPAEntity<TipoEmpresa>{

	public TipoEmpresaDAO(Class<TipoEmpresa> entityClass) {
		super(entityClass);
	}

	public void crearTipoEmpresa(ObjectReturn objReturn) throws Exception{
		TipoEmpresa objTipoEmpresa = new TipoEmpresa();
		try {
			objTipoEmpresa = (TipoEmpresa) objReturn.getData();
			super.create(objTipoEmpresa);
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

	public void actualizarTipoEmpresa(ObjectReturn objReturn) throws Exception{
		TipoEmpresa objTipoEmpresa = new TipoEmpresa();
		try {
			objTipoEmpresa = (TipoEmpresa) objReturn.getData();
			super.edit(objTipoEmpresa);
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
				query="SELECT t FROM TipoEmpresa t ORDER BY t.idTipoEmpresa ASC";
				
			}else {
				query="SELECT t FROM TipoEmpresa t ORDER BY t." + sorting;
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
