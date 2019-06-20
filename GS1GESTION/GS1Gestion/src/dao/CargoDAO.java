package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Cargo;
import model.ObjectReturn;
import persist.JPAEntity;

public class CargoDAO extends JPAEntity<Cargo> {

	public CargoDAO(Class<Cargo> entityClass) {
		super(entityClass);
	}

	public void crearCargoo(ObjectReturn objReturn) throws Exception {
		Cargo objCargo = new Cargo();
		try {
			objCargo = (Cargo) objReturn.getData();
			super.create(objCargo);
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

	public void actualizarCargoo(ObjectReturn objReturn) throws Exception {
		Cargo objCargo = new Cargo();
		try {
			objCargo = (Cargo) objReturn.getData();
			super.edit(objCargo);
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
				query = "SELECT c FROM Cargo c ORDER BY c.idCargos ASC";
			} else {
				query = "SELECT c FROM Cargo c ORDER BY c." + sorting;
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
