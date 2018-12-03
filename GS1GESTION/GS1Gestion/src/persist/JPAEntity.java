package persist;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Departamento;

public abstract class JPAEntity<T> {

	private Class<T> entityClass;

	public JPAEntity(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	private EntityManager em;

	protected abstract EntityManager getEntityManager();

	public void create(T entity) throws Exception {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GS1Gestion");
			em = factory.createEntityManager();
			EntityTransaction tx;
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();

		}
	}

	public void edit(T entity) throws Exception {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GS1Gestion");
			em = factory.createEntityManager();
			EntityTransaction tx;
			tx = em.getTransaction();
			tx.begin();
			em.merge(entity);
			tx.commit();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();

		}
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAllSorting(String query) throws Exception {
		List<T> getList = new ArrayList<T>();
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GS1Gestion");
			em = factory.createEntityManager();
			EntityTransaction tx;
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Departamento> q = em.createQuery(query, Departamento.class);
			getList = (List<T>) q.getResultList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		return getList;
	}

	public List<T> findAll() throws Exception {
		List<T> getList = new ArrayList<T>();
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("GS1Gestion");
			em = factory.createEntityManager();
			EntityTransaction tx;
			tx = em.getTransaction();
			tx.begin();
//			TypedQuery<Departamento> q = em.createNamedQuery("Departamento.findAll", Departamento.class);
//			getList=(List<T>) getEntityManager().createNamedQuery("Departamento.findAll", Departamento.class).getResultList();
//			javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//			cq.select(cq.from(entityClass));
//			getList=getEntityManager().createQuery(cq).getResultList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			em.close();
		}
		return getList;
	}

	public List<T> findRange(int[] range) {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0] + 1);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	public int count() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

}
