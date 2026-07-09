package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Intermediario;
import conexion.ConexionBD;
import constructores.Detalle_Carrito;
import constructores.Producto;

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
	public ArrayList<Detalle_Carrito> Mostrar_En_Carrito(){ //Lista los productos en VCarrito
		ArrayList<Detalle_Carrito> listado = new ArrayList<>();
		
	    Connection cnx = null;
	    CallableStatement csta = null;
	    ResultSet rs = null;
	    
		try {
			cnx = db.conectar();
			csta = cnx.prepareCall("{CALL SP_Mostrar_Producto_a_Detalle(?)}");
			csta.setString(1, Intermediario.idCarritoActual);
			
			rs = csta.executeQuery();
			
			while(rs.next()) {
				Detalle_Carrito d = new Detalle_Carrito(
						rs.getString("ID_DETALLE_CARRITO"), 
						rs.getString("NOMBRE"), 
						rs.getInt("CANTIDAD"), 
						rs.getDouble("PRECIO_UNITARIO"), 
						rs.getDouble("SUBTOTAL")
						);
				listado.add(d);
			}
			
		} catch (Exception e) {
			System.out.println("ERROR" +e);
		} 
		finally {
			try {
				if (rs != null) rs.close();
				if (csta != null) csta.close();
				if (cnx != null) cnx.close();

			} catch (Exception e) {
	            e.printStackTrace();
			}
		}
		return listado;
	}

}
