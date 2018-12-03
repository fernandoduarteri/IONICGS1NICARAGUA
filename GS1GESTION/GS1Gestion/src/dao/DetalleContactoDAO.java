package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.DetalleContacto;
import model.ObjectReturn;
import persist.JPAEntity;

public class DetalleContactoDAO extends JPAEntity<DetalleContacto>{

	public DetalleContactoDAO(Class<DetalleContacto> entityClass) {
		super(entityClass);
	}

	public void crearDetalleContacto(ObjectReturn objReturn) {
		DetalleContacto objDetalleContacto = new DetalleContacto();
		try {
			objDetalleContacto = (DetalleContacto) objReturn.getData();
			super.create(objDetalleContacto);
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

	public void actualizarDetalleContacto(ObjectReturn objReturn) {
		DetalleContacto objDetalleContacto = new DetalleContacto();
		try {
			objDetalleContacto = (DetalleContacto) objReturn.getData();
			super.edit(objDetalleContacto);
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

	public void getall(ObjectReturn objReturn) {
		String sorting = (String) objReturn.getData();
		String query="";
		try {
			if (sorting ==null) {
				query="SELECT d FROM DetalleContacto d ORDER BY d.idDetalleContacto ASC";
				objReturn.setData(super.findAllSorting(query));
			}else {
				query="SELECT d FROM DetalleContacto d ORDER BY d." + sorting;
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

}
