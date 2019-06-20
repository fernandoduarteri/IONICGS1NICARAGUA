package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Departamento;
import model.Municipio;
import model.ObjectReturn;
import persist.JPAEntity;

public class MunicipioDAO extends JPAEntity<Municipio> {

	public MunicipioDAO(Class<Municipio> entityClass) {
		super(entityClass);
	}

	public void crearMunicipio(ObjectReturn objReturn) throws Exception {
		Municipio objMunicipio = new Municipio();
		try {
			objMunicipio = (Municipio) objReturn.getData();
			super.create(objMunicipio);
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
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizarMunicipio(ObjectReturn objReturn) throws Exception {
		Municipio objMunicipio = new Municipio();
		try {
			objMunicipio = (Municipio) objReturn.getData();
			super.edit(objMunicipio);
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
				query = "SELECT m FROM Municipio m ORDER BY m.idMunicipios ASC";
			} else {
				query = "SELECT m FROM Municipio m ORDER BY m." + sorting;
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

	public void getWhere(ObjectReturn objReturn) throws Exception{
		Integer where = (Integer) objReturn.getData();
		String query = "";
		try {
			query = "SELECT m FROM Municipio m WHERE m.departamento.idDepartamentos=" + where;
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
