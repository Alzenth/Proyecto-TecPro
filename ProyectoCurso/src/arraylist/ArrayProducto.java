package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.ConexionBD;
import constructores.Producto;



public class ArrayProducto {
	ConexionBD db = new ConexionBD();
public ArrayList<Producto> Agregar_Producto(){
		ArrayList<Producto> lista = new ArrayList<Producto>();
	try {
		
		CallableStatement csta = db.conectar().prepareCall("CALL SP_Listar_Productos()"); 
		ResultSet ra = csta.executeQuery();
		Producto pro;
		while (ra.next()) {
			pro = new Producto(
					ra.getString(1), 
                    ra.getString(2), 
                    ra.getString(3), 
                    ra.getString(4), 
                    ra.getInt(5),
                    ra.getDouble(6),
                    ra.getDate(7), 
                    ra.getDate(8));
			lista.add(pro);
		}
		
	} catch (Exception e) {
		System.out.println("Error al listar: " + e);
	}
	return lista;
}

public void Insertar(Producto pro) {
	try {
		Connection cnx=db.conectar();
		CallableStatement csta=cnx.prepareCall("{CALL SP_Agregar_Producto(?,?,?,?,?,?,?,?)}");
		csta.setString(1,pro.getId_prod());
		csta.setString(2,pro.getNombre_prod());
		csta.setString(3,pro.getCategoria_prod());
		csta.setString(4,pro.getDescripcion_prod());
		csta.setInt(5, pro.getStock_prod()); 
		csta.setDouble(6,pro.getPrecio_prod());
		csta.setDate(7,pro.getFechaP_prod());
		csta.setDate(8,pro.getFechaV_prod());
		
		
		csta.executeUpdate();
		System.out.println("Producto insertado en BD correctamente.");
	} catch (Exception e) {
		System.out.println("ERROR" +e);
	}
}	
	
	

}
