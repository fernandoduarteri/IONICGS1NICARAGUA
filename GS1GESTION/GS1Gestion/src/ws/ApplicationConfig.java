package ws;

import java.util.Set;

@javax.ws.rs.ApplicationPath("gs1gestion")
public class ApplicationConfig extends javax.ws.rs.core.Application {
	
	 @Override
	    public Set<Class<?>> getClasses() {
	        Set<Class<?>> resources = new java.util.HashSet<>();
	        addRestResourceClasses(resources);
	        return resources;
	    }

	    /**
	     * Do not modify addRestResourceClasses() method.
	     * It is automatically populated with
	     * all resources defined in the project.
	     * If required, comment out calling this method in getClasses().
	     */
	    private void addRestResourceClasses(Set<Class<?>> resources) {
	        resources.add(ws.DepartamentoWS.class);
	        
	    }

}
