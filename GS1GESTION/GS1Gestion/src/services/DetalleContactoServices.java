package services;


import dao.DetalleContactoDAO;
import model.DetalleContacto;
import model.ObjectReturn;

public class DetalleContactoServices {

	public void creardetallecontacto(ObjectReturn objReturn) throws Exception{
		DetalleContactoDAO objDetalleContactoDAO = new DetalleContactoDAO(DetalleContacto.class);
		objDetalleContactoDAO.crearDetalleContacto(objReturn);
		
	}

	public void actualizardetallecontacto(ObjectReturn objReturn) throws Exception{
		DetalleContactoDAO objDetalleContactoDAO = new DetalleContactoDAO(DetalleContacto.class);
		objDetalleContactoDAO.actualizarDetalleContacto(objReturn);
		
	}

	public void getall(ObjectReturn objReturn) throws Exception{
		DetalleContactoDAO objDetalleContactoDAO = new DetalleContactoDAO(DetalleContacto.class);
		objDetalleContactoDAO.getall(objReturn);
		
	}

}
