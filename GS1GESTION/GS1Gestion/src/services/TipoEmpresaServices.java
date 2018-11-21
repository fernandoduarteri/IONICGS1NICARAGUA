package services;

import dao.TipoEmpresaDAO;
import model.ObjectReturn;
import model.TipoEmpresa;

public class TipoEmpresaServices {

	public void crearTipoEmpresa(ObjectReturn objReturn) throws Exception {
		TipoEmpresaDAO objTipoEmpresaDAO = new TipoEmpresaDAO(TipoEmpresa.class);
		objTipoEmpresaDAO.crearTipoEmpresa(objReturn);
		
	}

	public void actualizarTipoEmpresa(ObjectReturn objReturn) throws Exception{
		TipoEmpresaDAO objTipoEmpresaDAO = new TipoEmpresaDAO(TipoEmpresa.class);
		objTipoEmpresaDAO.actualizarTipoEmpresa(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		TipoEmpresaDAO objTipoEmpresaDAO = new TipoEmpresaDAO(TipoEmpresa.class);
		objTipoEmpresaDAO.getall(objReturn);
		
	}

}
