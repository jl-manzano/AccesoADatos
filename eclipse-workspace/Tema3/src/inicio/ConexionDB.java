package inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class ConexionDB {
    public final static String conexion = "jdbc:mysql://dns11036.phdns11.es:3306/ad2526_joseluis_manzano";
    public final static String usuario = "ad2526_joseluis_manzano";

    public static Connection conectar() {
        String password = "";

        // Crear un campo para ingresar la contraseña de manera segura
        JPasswordField passwordField = new JPasswordField(20);
        int option = JOptionPane.showConfirmDialog(null, passwordField, "Introduce la contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario presiona OK
        if (option == JOptionPane.OK_OPTION) {
            password = new String(passwordField.getPassword()); // Obtener la contraseña del campo de texto
        }

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

    public static void main(String[] args) {
        // Probar la conexión
        conectar();
    }
}
