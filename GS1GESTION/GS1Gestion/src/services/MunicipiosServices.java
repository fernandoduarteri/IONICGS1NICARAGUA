package services;


import dao.MunicipioDAO;
import model.Municipio;
import model.ObjectReturn;

public class MunicipiosServices {

	public void crearmunicipio(ObjectReturn objReturn) throws Exception{
		MunicipioDAO objMunicipioDAO = new MunicipioDAO(Municipio.class);
		objMunicipioDAO.crearMunicipio(objReturn);
		
	}

	public void actualizarmunicipio(ObjectReturn objReturn) throws Exception{
		MunicipioDAO objMunicipioDAO = new MunicipioDAO(Municipio.class);
		objMunicipioDAO.actualizarMunicipio(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		MunicipioDAO objMunicipioDAO = new MunicipioDAO(Municipio.class);
		objMunicipioDAO.getall(objReturn);
		
	}

}
