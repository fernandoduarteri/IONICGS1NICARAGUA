package services;

import dao.AfiliadoDAO;
import model.Afiliado;
import model.ObjectReturn;

public class AfiliadoServices {

	public void crearafiliado(ObjectReturn objReturn) throws Exception{
		AfiliadoDAO objAfiliadoDAO = new AfiliadoDAO(Afiliado.class);
		objAfiliadoDAO.crearAfiliado(objReturn);
		
	}

	public void actualizarafiliado(ObjectReturn objReturn) throws Exception{
		AfiliadoDAO objAfiliadoDAO = new AfiliadoDAO(Afiliado.class);
		objAfiliadoDAO.actualizarAfiliado(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		AfiliadoDAO objAfiliadoDAO = new AfiliadoDAO(Afiliado.class);
		objAfiliadoDAO.getall(objReturn);
		
	}

}
