package boletin2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class ConvertirPalabrasOrdenadas {
	public static void main(String[] args) {
        String rutaArchivoEntrada = "C:\\Users\\jl.manzano\\palabras.txt";
        String rutaArchivoSalida = "C:\\Users\\jl.manzano\\palabras_ordenadas.txt";
        
        convertirArchivo(rutaArchivoEntrada, rutaArchivoSalida);
	}
	
	public static void convertirArchivo(String rutaEntrada, String rutaSalida) {
        try (RandomAccessFile archivoEntrada = new RandomAccessFile(rutaEntrada, "r")) {
            byte[] contenido = new byte[(int) archivoEntrada.length()];
            archivoEntrada.readFully(contenido);

            // cpnvertir bytes a string
            String texto = new String(contenido);

        	String[] palabras = separarPalabras(texto);

            Arrays.sort(palabras);
            
            escribirArchivoSalida(rutaSalida, palabras);
            
            System.out.println("El archivo ha sido convertido y ordenado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada: " + e.getMessage());
        }

	}
	
	public static String[] separarPalabras(String texto) {
	    String[] palabras = new String[0];
	    int numPalabras;
	    
	    if (texto != null && !texto.isEmpty()) {
	        numPalabras = texto.length() / 5;
	        palabras = new String[numPalabras];

	        for (int i = 0; i < numPalabras; i++) {
	            palabras[i] = texto.substring(i * 5, (i + 1) * 5);
	        }
	    }
	    
	    return palabras;
	}

	
    public static void escribirArchivoSalida(String rutaSalida, String[] palabras) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaSalida))) {
            for (String palabra : palabras) {
                escritor.write(palabra);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de salida: " + e.getMessage());
        }
    }
	
}
