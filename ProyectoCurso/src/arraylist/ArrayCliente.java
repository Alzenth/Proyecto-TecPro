package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import conexion.ConexionBD;
import constructores.Cliente;


public class ArrayCliente {
	
	ConexionBD db = new ConexionBD();
	public void Insertar(Cliente pro) throws SQLException {
		try {
			Connection cnx=db.conectar();
			CallableStatement csta=cnx.prepareCall("{CALL Sp_Agregar_Cliente(?,?,?,?,?,?)}");
			
			csta.setString(1,pro.getNombres());
			csta.setString(2,pro.getApellidos());
			csta.setString(3,pro.getDni());
			csta.setString(4, pro.getContraseña()); 
			csta.setString(5,pro.getCorreo());
			csta.setString(6,pro.getNumero());
			
			csta.executeUpdate();
			
		} catch (SQLException e) {
			
			throw e; 
		}
	}
}