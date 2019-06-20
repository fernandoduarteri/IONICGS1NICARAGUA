package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Estandares;
import model.ObjectReturn;
import persist.JPAEntity;


public class EstandaresDAO extends JPAEntity<Estandares>{

	public EstandaresDAO(Class<Estandares> entityClass) {
		super(entityClass);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearEstandares(ObjectReturn objReturn) throws Exception{
		Estandares objEstandares = new Estandares();
		try {
			objEstandares = (Estandares) objReturn.getData();
			super.create(objEstandares);
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

	public void actualizarEstandares(ObjectReturn objReturn) throws Exception{
		Estandares objEstandares = new Estandares();
		try {
			objEstandares = (Estandares) objReturn.getData();
			super.edit(objEstandares);
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
		String query="";
		try {
			if (sorting ==null) {
				query="SELECT e FROM Estandares e ORDER BY e.idEstandares ASC";
				
			}else {
				query="SELECT e FROM Estandares e ORDER BY e." + sorting;
			}
			objReturn.setData(super.findAllSorting(query));
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

}
