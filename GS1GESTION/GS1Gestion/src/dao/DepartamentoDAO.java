package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import Utilidades.Constantes;
import model.Departamento;
import model.ObjectReturn;
import persist.JPAEntity;

public class DepartamentoDAO extends JPAEntity<Departamento> {

	@PersistenceContext(unitName = "GS1Gestion")
	private EntityManager em;

	public DepartamentoDAO(Class<Departamento> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	public void crearDepartamento(ObjectReturn objReturn) throws Exception {
		Departamento objDepartamento = new Departamento();
		try {
			objDepartamento = (Departamento) objReturn.getData();
			super.create(objDepartamento);
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GS1Gestion");
		em = factory.createEntityManager();
		return em;
	}

	public void getall(ObjectReturn objReturn) throws Exception {
		String sorting = (String) objReturn.getData();
		String query="";
		try {
			if (sorting ==null) {
				query="SELECT d FROM Departamento d ORDER BY d.idDepartamentos ASC";
				objReturn.setData(super.findAllSorting(query));
			}else {
				query="SELECT d FROM Departamento d ORDER BY d." + sorting;
				objReturn.setData(super.count());
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

	public void actualizarDepartamento(ObjectReturn objReturn) throws Exception  {
		Departamento objDepartamento = new Departamento();
		try {
			objDepartamento = (Departamento) objReturn.getData();
			super.edit(objDepartamento);
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
}
