package inicio;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
    static Scanner sc = new Scanner(System.in);

    // Crear tablas
    public static void crearTablas(Connection con) {
        System.out.println("\n¿Deseas crear todas las tablas o una tabla concreta?");
        System.out.println("1. Crear todas las tablas");
        System.out.println("2. Crear una tabla concreta");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            crearTodasLasTablas(con);
        } else if (opcion == 2) {
            System.out.println("\n¿Qué tabla deseas crear?");
            System.out.println("1. Pacientes");
            System.out.println("2. Medicamentos");
            System.out.println("3. Receta");
            System.out.print("Elige una opción: ");
            int tabla = sc.nextInt();
            sc.nextLine();

            if (tabla == 1) {
                CRUDPaciente.crearTablaPacientes(con);
            } else if (tabla == 2) {
                CRUDMedicamento.crearTablaMedicamentos(con);
            } else if (tabla == 3) {
                CRUDReceta.crearTablaReceta(con);
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void crearTodasLasTablas(Connection con) {
        CRUDPaciente.crearTablaPacientes(con);
        CRUDMedicamento.crearTablaMedicamentos(con);
        CRUDReceta.crearTablaReceta(con);
    }

    // Insertar datos
    public static void insertarDatos(Connection con) {
        System.out.println("\n¿En qué tabla deseas insertar datos?");
        System.out.println("1. Pacientes");
        System.out.println("2. Medicamentos");
        System.out.println("3. Receta");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            CRUDPaciente.insertarPaciente(con);
        } else if (opcion == 2) {
            CRUDMedicamento.insertarMedicamento(con);
        } else if (opcion == 3) {
            CRUDReceta.insertarReceta(con);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Modificar datos
    public static void modificarDatos(Connection con) {
        System.out.println("\n¿En qué tabla deseas modificar datos?");
        System.out.println("1. Pacientes");
        System.out.println("2. Medicamentos");
        System.out.println("3. Receta");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            CRUDPaciente.modificarPaciente(con);
        } else if (opcion == 2) {
            CRUDMedicamento.modificarMedicamento(con);
        } else if (opcion == 3) {
            CRUDReceta.modificarReceta(con);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Listar datos
    public static void listarDatos(Connection con) {
        System.out.println("\n¿En qué tabla deseas listar los datos?");
        System.out.println("1. Pacientes");
        System.out.println("2. Medicamentos");
        System.out.println("3. Receta");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            CRUDPaciente.listarDatos(con);
        } else if (opcion == 2) {
            CRUDMedicamento.listarDatos(con);
        } else if (opcion == 3) {
            CRUDReceta.listarDatos(con);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Eliminar datos
    public static void eliminarDatos(Connection con) {
        System.out.println("\n¿De qué tabla deseas eliminar un registro?");
        System.out.println("1. Pacientes");
        System.out.println("2. Medicamentos");
        System.out.println("3. Receta");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            CRUDPaciente.eliminarPaciente(con);
        } else if (opcion == 2) {
            CRUDMedicamento.eliminarMedicamento(con);
        } else if (opcion == 3) {
            CRUDReceta.eliminarReceta(con);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    // Eliminar tablas
    public static void eliminarTablas(Connection con) {
        System.out.println("\n¿Deseas eliminar todas las tablas o solo una?");
        System.out.println("1. Eliminar todas las tablas");
        System.out.println("2. Eliminar una tabla específica");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            eliminarTodasLasTablas(con);
        } else if (opcion == 2) {
            borrarTabla(con);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void eliminarTodasLasTablas(Connection con) {
        String sql = "DROP TABLE IF EXISTS Receta, Medicamentos, Pacientes";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            System.out.println("\nTodas las tablas han sido eliminadas.");
        } catch (SQLException e) {
            System.out.println("\nError al eliminar las tablas: " + e.getMessage());
        }
    }

    public static void borrarTabla(Connection con) {
        System.out.println("\n¿En qué tabla deseas eliminar los datos?");
        System.out.println("1. Pacientes");
        System.out.println("2. Medicamentos");
        System.out.println("3. Receta");
        System.out.print("Elige una opción: ");
        int subopcion = sc.nextInt();
        sc.nextLine();
        String tabla = "";
        if (subopcion == 1) {
            tabla = "Pacientes";
        } else if (subopcion == 2) {
            tabla = "Medicamentos";
        } else if (subopcion == 3) {
            tabla = "Receta";
        } else {
            System.out.println("\nOpción no válida.");
            return;
        }

        System.out.print("\n¿Estás seguro de que quieres eliminar la tabla " + tabla + "? (S/N): ");
        String confirmacion = sc.nextLine();
        if ("S".equalsIgnoreCase(confirmacion)) {
            String sql = "DROP TABLE " + tabla;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.executeUpdate();
                System.out.println("\nTabla " + tabla + " eliminada correctamente.");
            } catch (SQLException e) {
                System.out.println("\nError al eliminar la tabla: " + e.getMessage());
            }
        } else {
            System.out.println("\nOperación cancelada.");
        }
    }
}
