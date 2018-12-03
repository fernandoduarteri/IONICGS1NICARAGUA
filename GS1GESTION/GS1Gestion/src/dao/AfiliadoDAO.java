package dao;

import javax.persistence.EntityManager;

import Utilidades.Constantes;
import model.Afiliado;
import model.Departamento;
import model.ObjectReturn;
import persist.JPAEntity;


public class AfiliadoDAO extends JPAEntity<Afiliado>{

	public AfiliadoDAO(Class<Afiliado> entityClass) {
		super(entityClass);
	}

	public void crearAfiliado(ObjectReturn objReturn) throws Exception{
		Afiliado objAfiliado = new Afiliado();
		try {
			objAfiliado = (Afiliado) objReturn.getData();
			super.create(objAfiliado);
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

	public void actualizarAfiliado(ObjectReturn objReturn) throws Exception{
		Afiliado objAfiliado = new Afiliado();
		try {
			objAfiliado = (Afiliado) objReturn.getData();
			super.edit(objAfiliado);
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
				query="SELECT a FROM Afiliado a ORDER BY a.idAfiliado ASC";
				objReturn.setData(super.findAllSorting(query));
			}else {
				query="SELECT a FROM Afiliado a ORDER BY a." + sorting;
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
