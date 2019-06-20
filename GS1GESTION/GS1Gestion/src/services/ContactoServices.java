package services;

import dao.ContactoDAO;
import model.Contacto;
import model.ObjectReturn;

public class ContactoServices {

	public void crearcontacto(ObjectReturn objReturn) throws Exception {
		ContactoDAO objContactoDAO = new ContactoDAO(Contacto.class);
		objContactoDAO.crearContacto(objReturn);
		
	}

	public void actualizarcontacto(ObjectReturn objReturn) throws Exception{
		ContactoDAO objContactoDAO = new ContactoDAO(Contacto.class);
		objContactoDAO.actualizarContacto(objReturn);
		
	}

	public void getall(ObjectReturn objReturn)throws Exception {
		ContactoDAO objContactoDAO = new ContactoDAO(Contacto.class);
		objContactoDAO.getall(objReturn);
		
	}

	public void getWhere(ObjectReturn objReturn) throws Exception{
		ContactoDAO objContactoDAO = new ContactoDAO(Contacto.class);
		objContactoDAO.getWhere(objReturn);
		
	}

}
