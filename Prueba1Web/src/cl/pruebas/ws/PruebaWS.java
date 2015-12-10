package cl.pruebas.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cl.prueba.ejb.PrimerEJB;

@WebService
public class PruebaWS {

	@EJB
	private PrimerEJB oEjb;
	
	@WebMethod
	public boolean login(
			@WebParam(name="nombre")
			String sNombre, String sPassword){
		return oEjb.login(sNombre, sPassword);
	}
}
