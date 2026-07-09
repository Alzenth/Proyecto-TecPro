package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import conexion.ConexionBD;

public class ArrayDetalle_Venta {
	ConexionBD db = new ConexionBD();
	
public String Procesar_Venta_Final() { 
		
		String idVentaGenerada = null;
		CallableStatement csta = null;
		ResultSet rs = null;
		
		try {
			Connection cnx = db.conectar();
			csta = cnx.prepareCall("{CALL SP_Generar_Venta_Completa(?,?)}");
			
			csta.setString(1, Intermediario.dniClienteActual);
			csta.setString(2, Intermediario.idCarritoActual);
			 

			rs = csta.executeQuery();
			
			if (rs.next()) {
				idVentaGenerada = rs.getString("ID_VENTA_GENERADA");
			}
			
			
			rs.close();
			csta.close();
			
		} catch (Exception e) {
			System.out.println("Error al procesar la venta completa: " + e.getMessage());
		} 
		
		return idVentaGenerada; 
	}
}
