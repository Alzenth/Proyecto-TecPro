package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import clases.Intermediario;
import conexion.ConexionBD;
import constructores.Carrito;

public class ArrayCarrito {
	ConexionBD db = new ConexionBD();

public void AgregarCarrito() {
	try {
		Connection cnx=db.conectar();
		CallableStatement csta=cnx.prepareCall("{Call SP_Agregar_Carrito_Por_Cliente(?)}");
		csta.setString(1, Intermediario.dniClienteActual);

		csta.executeUpdate();
	} catch (Exception e) {
		System.out.println("ERROR" +e);
		}
	}

public String ObtenerIDCarrito(String dni) {
	String idCarrito = null;
	try {
		Connection cnx=db.conectar();
		CallableStatement csta=cnx.prepareCall("{Call SP_Obtener_ID_Carrito(?)}");
		csta.setString(1, Intermediario.dniClienteActual);
		ResultSet rs = csta.executeQuery();
		
		if (rs.next()) idCarrito = rs.getString("ID_CARRITO");

	} catch (Exception e) {
		System.out.println("ERROR" +e);
	}
	return idCarrito;
}
}
