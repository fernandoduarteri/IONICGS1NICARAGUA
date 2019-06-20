package services;

import dao.AfiliadoEstandarDAO;
import model.AfiliadoEstandare;
import model.ObjectReturn;

public class AfiliadoEstandarServices {

	public void crearafilaidoestandar(ObjectReturn objReturn) throws Exception{
		AfiliadoEstandarDAO objAfiliadoEstandarDAO = new AfiliadoEstandarDAO(AfiliadoEstandare.class);
		objAfiliadoEstandarDAO.crearAfiliadoEstandar(objReturn);
		
	}

	public void actualizarafilaidoestandar(ObjectReturn objReturn) throws Exception{
		AfiliadoEstandarDAO objAfiliadoEstandarDAO = new AfiliadoEstandarDAO(AfiliadoEstandare.class);
		objAfiliadoEstandarDAO.actualizarAfiliadoEstandar(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		AfiliadoEstandarDAO objAfiliadoEstandarDAO = new AfiliadoEstandarDAO(AfiliadoEstandare.class);
		objAfiliadoEstandarDAO.getall(objReturn);
		
	}

}
