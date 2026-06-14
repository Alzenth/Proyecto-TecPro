package conexion; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=MAKEA;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
    
    public Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Falta el driver JDBC: " + e.getMessage());
        }
        return conexion;
    }
}