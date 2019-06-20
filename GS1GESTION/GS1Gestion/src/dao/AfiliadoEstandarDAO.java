package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.AfiliadoEstandare;
import model.Departamento;
import model.ObjectReturn;
import persist.JPAEntity;

public class AfiliadoEstandarDAO extends JPAEntity<AfiliadoEstandare>{

	public AfiliadoEstandarDAO(Class<AfiliadoEstandare> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearAfiliadoEstandar(ObjectReturn objReturn) {
		AfiliadoEstandare objAfiliadoEstandare = new AfiliadoEstandare();
		try {
			objAfiliadoEstandare = (AfiliadoEstandare) objReturn.getData();
			super.create(objAfiliadoEstandare);
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

	public void actualizarAfiliadoEstandar(ObjectReturn objReturn) {
		AfiliadoEstandare objAfiliadoEstandare = new AfiliadoEstandare();
		try {
			objAfiliadoEstandare = (AfiliadoEstandare) objReturn.getData();
			super.edit(objAfiliadoEstandare);
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
				query="SELECT a FROM AfiliadoEstandare a ORDER BY a.afiliado.idAfiliado ASC";
			}else {
				query="SELECT a FROM AfiliadoEstandare a ORDER BY a." + sorting;
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

}
