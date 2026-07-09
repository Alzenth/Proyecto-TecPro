package arraylist;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Intermediario;
import conexion.ConexionBD;
import constructores.Producto;



public class ArrayProducto {
	ConexionBD db = new ConexionBD();

public ArrayList<Producto> Listar_Productos_En_Tabla(){
	ArrayList<Producto> listado=new ArrayList<Producto>();
	try {
		CallableStatement csta=db.conectar().prepareCall("{Call SP_Listar_Productos()}");
		ResultSet ra=csta.executeQuery();
		Producto pro;
		while(ra.next()) {
			pro=new Producto(ra.getString(1), 
                    ra.getString(2), 
                    ra.getString(3), 
                    ra.getString(4), 
                    ra.getInt(5),
                    ra.getDouble(6),
                    ra.getDate(7), 
                    ra.getDate(8));
			listado.add(pro);
		}
	} catch (Exception e) {}
	return listado;
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
		csta.setDate(7,pro.getFechaV_prod());
		csta.setString(8, Intermediario.dniAdminActual);
		
		
		csta.executeUpdate();
		
	} catch (Exception e) {
		System.out.println("ERROR" +e);
	}
}

public void Eliminar(String cod) {
	try {
		Connection cnx=db.conectar();
		CallableStatement csta=cnx.prepareCall("{CALL SP_Eliminar_Producto(?)}");
		csta.setString(1, cod);
		csta.executeUpdate();
	} catch (Exception e) {
		System.out.println("ERROR" +e);
	}
}

public void Editar(Producto pro) {
	try {
		Connection cnx =db.conectar();
		CallableStatement csta = cnx.prepareCall("{CALL SP_Editar_Producto(?,?,?,?,?,?,?)}");
		csta.setString(1, pro.getId_prod());
		csta.setString(2, pro.getNombre_prod());
		csta.setString(3, pro.getCategoria_prod());
		csta.setString(4, pro.getDescripcion_prod());
		csta.setInt(5, pro.getStock_prod());
		csta.setDouble(6, pro.getPrecio_prod());
		csta.setDate(7, pro.getFechaV_prod());
		csta.executeUpdate();
		
	} catch (Exception e) {
		System.out.println("ERROR" + e);
	}
}

public ArrayList<Producto> Consultar_Producto(String cod){
	ArrayList<Producto> listado = new ArrayList<Producto>();
	try {
		Connection cnx = db.conectar();
		CallableStatement csta = cnx.prepareCall("{CALL SP_Consultar_Producto(?)}");
		csta.setString(1, cod);
		ResultSet ra = csta.executeQuery();
		Producto pro;
		while(ra.next()) {
			pro = new Producto(ra.getString(1), 
                    ra.getString(2), 
                    ra.getString(3), 
                    ra.getString(4), 
                    ra.getInt(5),
                    ra.getDouble(6),
                    ra.getDate(7), 
                    ra.getDate(8));
			listado.add(pro);
		}
	} catch (Exception e) {
		System.out.println("ERROR" +e);
	}
	return listado;
	
}

public ArrayList<Producto> Listador_Categoria(String cat) {
    ArrayList<Producto> lista = new ArrayList<Producto>();
    try {
        Connection cnx = db.conectar();
        CallableStatement csta = cnx.prepareCall("{CALL SP_BuscaPorCategoria(?)}");
        
        csta.setString(1, cat); 
        
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
                ra.getDate(8)
            );
            lista.add(pro);
        }
    } catch (Exception e) {
        System.out.println("Error al filtrar por categoría: " + e);
    }
    return lista;
}
public ArrayList<Producto> ListarPorCatalogo(String cat) {
    ArrayList<Producto> lista = new ArrayList<Producto>();
    try {
        Connection cnx = db.conectar();
        CallableStatement csta = cnx.prepareCall("{CALL SP_Producto_Catalogo(?)}");
        csta.setString(1, cat); 
        
        ResultSet ra = csta.executeQuery();
        Producto pro;
        
        while (ra.next()) {
            
            pro = new Producto();
            pro.setId_prod(ra.getString("ID_PRODUCTO"));
            pro.setNombre_prod(ra.getString("NOMBRE"));
            pro.setDescripcion_prod(ra.getString("DESCRIPCION"));
            pro.setPrecio_prod(ra.getDouble("PRECIO"));
            pro.setFechaV_prod(ra.getDate("Fecha_Expiracion"));
            
            lista.add(pro);
        }
    } catch (Exception e) {
        System.out.println("Error al cargar catálogo: " + e);
    }
    return lista;
}


}
