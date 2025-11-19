package inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConexionDB {

	public final static String conexion = "jdbc:mysql://dns11036.phdns11.es:3306/ad2526_joseluis_manzano";
	public final static String usuario = "ad2526_joseluis_manzano";
	static Scanner sc = new Scanner(System.in);
	
	public static Connection conectar() {
        String password = "";
        System.out.print("Introduce la contraseña: ");
        password = sc.next(); 
        
	    Connection con = null;
	    try {
	        con = DriverManager.getConnection(conexion, usuario, password);
			System.out.println("La conexión ha debido ir bien");
	    } catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
	    }
	    return con;
	}
	
	public static void desconectar(Connection con) {
	    try {
	        if (con != null && !con.isClosed()) {
	        	con.close();
	        	System.out.println("Conexión cerrada.");
	        }
	    } catch (SQLException e) {
			System.out.println("Error al establecer la conexión con la base de datos: " + e);
	    }
	}
	
}
