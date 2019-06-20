package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Contacto;
import model.Departamento;
import model.ObjectReturn;
import persist.JPAEntity;

public class ContactoDAO extends JPAEntity<Contacto>{

	public ContactoDAO(Class<Contacto> entityClass) {
		super(entityClass);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearContacto(ObjectReturn objReturn) throws Exception{
		Contacto objContacto = new Contacto();
		try {
			objContacto = (Contacto) objReturn.getData();
			super.create(objContacto);
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

	public void actualizarContacto(ObjectReturn objReturn) throws Exception {
		Contacto objContacto = new Contacto();
		try {
			objContacto = (Contacto) objReturn.getData();
			super.edit(objContacto);
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
				query="SELECT c FROM Contacto c ORDER BY c.idContactos ASC";
			}else {
				query="SELECT c FROM Contacto c ORDER BY c." + sorting;
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

	public void getWhere(ObjectReturn objReturn) throws Exception {
		Integer where = (Integer) objReturn.getData();
		String query = "";
		try {
			query = "SELECT c FROM Contacto c WHERE c.afiliado.idAfiliado=" + where;
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
