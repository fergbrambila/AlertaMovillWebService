package cl.prueba.ejb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class PrimerEJB
 */
@Stateless
@LocalBean
public class PrimerEJB {
	
	@Resource(mappedName="java:/DSGestionEquipos")
	private DataSource oDataSource;
	
	public boolean login(String sNombre, String sPassword) {
		
		try {
			Connection oConexion = oDataSource.getConnection();
			
			Statement oStatement = oConexion.createStatement();
			oStatement.execute("INSERT INTO casa (identificador,direccion) VALUES ('51', 'aspillaga 746')");
			PreparedStatement oPrepStatement = oConexion.prepareStatement("SELECT COUNT(*) FROM USUARIO WHERE NOMBRE = ?");
			oPrepStatement.setString(1, sNombre);
			oPrepStatement.execute();
			
			CallableStatement oCallStatement = oConexion.prepareCall("{call login (?,?)}");
			oCallStatement.setString(1, sNombre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sNombre.equalsIgnoreCase("miguel");
	}
}
