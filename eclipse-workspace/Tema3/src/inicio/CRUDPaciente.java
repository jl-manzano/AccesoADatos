package inicio;

import java.sql.*;
import java.util.Scanner;

public class CRUDPaciente {

    public static void crearTablaPacientes(Connection con) {
        String sql = "CREATE TABLE Pacientes (" +
                "idPaciente int AUTO_INCREMENT Primary Key, " +
                "nombre varchar(45), " +
                "apellidos varchar(45), " +
                "NSS varchar(11)" +
                ")";
        try (Statement st = con.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("\nTabla Pacientes creada con éxito.");
        } catch (SQLException e) {
            System.out.println("\nError al crear la tabla Pacientes: " + e.getMessage());
        }
    }

    public static void insertarPaciente(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce el nombre del paciente: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce los apellidos del paciente: ");
        String apellidos = sc.nextLine();
        System.out.print("Introduce el NSS del paciente: ");
        String nss = sc.nextLine();
        String sql = "INSERT INTO Pacientes (nombre, apellidos, NSS) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, nss);
            ps.executeUpdate();
            System.out.println("\nPaciente insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al insertar el paciente: " + e.getMessage());
        }
    }

    public static void modificarPaciente(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce el ID del paciente a modificar: ");
        int idPaciente = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el nuevo nombre del paciente: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce los nuevos apellidos del paciente: ");
        String apellidos = sc.nextLine();
        System.out.print("Introduce el nuevo NSS del paciente: ");
        String nss = sc.nextLine();
        String sql = "UPDATE Pacientes SET nombre = ?, apellidos = ?, NSS = ? WHERE idPaciente = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, nss);
            ps.setInt(4, idPaciente);
            ps.executeUpdate();
            System.out.println("\nPaciente modificado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al modificar el paciente: " + e.getMessage());
        }
    }

    public static void listarDatos(Connection con) {
        String sql = "SELECT * FROM Pacientes";
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idPaciente"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellidos: " + rs.getString("apellidos"));
                System.out.println("NSS: " + rs.getString("NSS"));
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar los pacientes: " + e.getMessage());
        }
    }

    public static void eliminarPaciente(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce el ID del paciente a eliminar: ");
        int idPaciente = sc.nextInt();
        String sql = "DELETE FROM Pacientes WHERE idPaciente = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPaciente);
            ps.executeUpdate();
            System.out.println("\nPaciente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al eliminar el paciente: " + e.getMessage());
        }
    }
}
