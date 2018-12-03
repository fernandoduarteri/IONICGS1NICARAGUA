package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.ObjectReturn;
import model.TipoTelefono;
import persist.JPAEntity;

public class TipoTelefonoDAO extends JPAEntity<TipoTelefono> {

	public TipoTelefonoDAO(Class<TipoTelefono> entityClass) {
		super(entityClass);
	}

	public void crearTipoTelefono(ObjectReturn objReturn) throws Exception{
		TipoTelefono objTipoTelefono = new TipoTelefono();
		try {
			objTipoTelefono = (TipoTelefono) objReturn.getData();
			super.create(objTipoTelefono);
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

	public void actualizarTipoTelefono(ObjectReturn objReturn) throws Exception{
		TipoTelefono objTipoTelefono = new TipoTelefono();
		try {
			objTipoTelefono = (TipoTelefono) objReturn.getData();
			super.edit(objTipoTelefono);
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
				query="SELECT t FROM TipoTelefono t ORDER BY t.idTipoTelefono ASC";
				objReturn.setData(super.findAllSorting(query));
			}else {
				query="SELECT t FROM TipoTelefono t ORDER BY t." + sorting;
				objReturn.setData(super.findAllSorting(query));
			}
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
