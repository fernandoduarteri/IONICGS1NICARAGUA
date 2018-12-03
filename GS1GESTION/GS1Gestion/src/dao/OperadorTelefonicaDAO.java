package dao;

import persist.JPAEntity;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.ObjectReturn;
import model.OperadorTelefonica;

public class OperadorTelefonicaDAO extends JPAEntity<OperadorTelefonica> {

	public OperadorTelefonicaDAO(Class<OperadorTelefonica> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearOperador(ObjectReturn objReturn) throws Exception {
		OperadorTelefonica objOperadorTelefonica = new OperadorTelefonica();
		try {
			objOperadorTelefonica = (OperadorTelefonica) objReturn.getData();
			super.create(objOperadorTelefonica);
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

	public void actualizarOperador(ObjectReturn objReturn) throws Exception{
		OperadorTelefonica objOperadorTelefonica = new OperadorTelefonica();
		try {
			objOperadorTelefonica = (OperadorTelefonica) objReturn.getData();
			super.edit(objOperadorTelefonica);
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
				query="SELECT o FROM OperadorTelefonica o ORDER BY o.idOperadorTelefonica ASC";
				objReturn.setData(super.findAllSorting(query));
			}else {
				query="SELECT o FROM OperadorTelefonica o ORDER BY o." + sorting;
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

}
