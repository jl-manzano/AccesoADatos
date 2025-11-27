package inicio;

import java.sql.*;
import java.util.Scanner;

public class CRUDMedicamento {

    public static void crearTablaMedicamentos(Connection con) {
        String sql = "CREATE TABLE Medicamentos (" +
                "idMedicamento int AUTO_INCREMENT Primary Key, " +
                "composicion varchar(45)" +
                ")";
        try (Statement st = con.createStatement()) {
            st.executeUpdate(sql);
            System.out.println("\nTabla Medicamentos creada con éxito.");
        } catch (SQLException e) {
            System.out.println("\nError al crear la tabla Medicamentos: " + e.getMessage());
        }
    }

    public static void insertarMedicamento(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce la composición del medicamento: ");
        String composicion = sc.nextLine();
        String sql = "INSERT INTO Medicamentos (composicion) VALUES (?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, composicion);
            ps.executeUpdate();
            System.out.println("\nMedicamento insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al insertar medicamento: " + e.getMessage());
        }
    }

    public static void modificarMedicamento(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce el ID del medicamento a modificar: ");
        int idMedicamento = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce la nueva composición del medicamento: ");
        String composicion = sc.nextLine();
        String sql = "UPDATE Medicamentos SET composicion = ? WHERE idMedicamento = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, composicion);
            ps.setInt(2, idMedicamento);
            ps.executeUpdate();
            System.out.println("\nMedicamento modificado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al modificar medicamento: " + e.getMessage());
        }
    }

    public static void listarDatos(Connection con) {
        String sql = "SELECT * FROM Medicamentos";
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idMedicamento"));
                System.out.println("Composición: " + rs.getString("composicion"));
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            System.out.println("\nError al listar los medicamentos: " + e.getMessage());
        }
    }

    public static void eliminarMedicamento(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIntroduce el ID del medicamento a eliminar: ");
        int idMedicamento = sc.nextInt();
        String sql = "DELETE FROM Medicamentos WHERE idMedicamento = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMedicamento);
            ps.executeUpdate();
            System.out.println("\nMedicamento eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("\nError al eliminar medicamento: " + e.getMessage());
        }
    }
}
