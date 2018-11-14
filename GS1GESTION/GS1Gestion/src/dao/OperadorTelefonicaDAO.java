package dao;

import persist.JPAEntity;

import javax.persistence.EntityManager;

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

}
