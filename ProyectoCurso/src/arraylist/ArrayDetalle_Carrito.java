package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;

import clases.Intermediario;
import conexion.ConexionBD;

public class ArrayDetalle_Carrito {
	ConexionBD db = new ConexionBD();
	public void Agregar_Detalle_a_Carrito(String id_carrito, String id_producto, int cantidad) {
		try {
			Connection cnx=db.conectar();
			CallableStatement csta=cnx.prepareCall("{CALL Sp_Agregar_Producto_a_DetalleCarrito(?,?,?)}");
			
			csta.setString(1, Intermediario.idCarritoActual);
			csta.setString(2, id_producto);
			csta.setInt(3, cantidad);

			csta.executeUpdate();
		} catch (Exception e) {
			
		}
	}

}
