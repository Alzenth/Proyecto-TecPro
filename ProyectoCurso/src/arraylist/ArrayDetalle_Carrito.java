package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;

import conexion.ConexionBD;

public class ArrayDetalle_Carrito {
	ConexionBD db = new ConexionBD();
	public void Agregar_a_Carrito(String id_detalle_carrito, int id_carrito, String id_producto, int cantidad) {
		try {
			Connection cnx=db.conectar();
			CallableStatement csta=cnx.prepareCall("{CALL Sp_Agregar_Producto_a_Carrito(?,?,?,?)}");
			
			
		} catch (Exception e) {
			
		}
	}

}
