package boletin1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearArchivosHTML {
    
    public static void main(String[] args) {
        String rutaBase = "C:\\Users\\jl.manzano\\Carpeta personal";
        File directorioBase = new File(rutaBase);
        String nombreAutor = "José Luis";

        if (directorioBase.exists() && directorioBase.isDirectory()) {
            recorrerCarpetas(directorioBase, nombreAutor);
            System.out.println("La ruta base es válida: " + directorioBase.getAbsolutePath());

        } else {
            System.out.println("La ruta base no existe o no es un directorio válido.");
        }
    }

    public static void recorrerCarpetas(File directorio, String autor) {
        crearArchivoHTML(directorio, autor);
        
        File[] archivos = directorio.listFiles();
              
        if (archivos != null) {
            for (File archivo : archivos) {
            	if (archivo.isDirectory()) {
            		recorrerCarpetas(archivo, autor);
            	}
            }
        }
    }

    public static void crearArchivoHTML(File carpeta, String autor) {
        String nombreCarpeta = carpeta.getName();
        String rutaCarpeta = carpeta.getAbsolutePath();
        
        String contenidoHTML = "<html>\n" +
                               "   <head>\n" +
                               "      <title>" + nombreCarpeta + "</title>\n" +
                               "   </head>\n" +
                               "   <body>\n" +
                               "      <h1>" + rutaCarpeta + "</h1>\n" +
                               "      <h3>Autor: " + autor + "</h3>\n" +
                               "   </body>\n" +
                               "</html>";
        
        File archivoHTML = new File(carpeta, "index.html");

        try (FileWriter wr = new FileWriter(archivoHTML)) {
            wr.write(contenidoHTML);
            System.out.println("Archivo HTML creado en: " + archivoHTML.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al crear el archivo HTML en: " + archivoHTML.getAbsolutePath());
            e.printStackTrace();
        }
    }
}
