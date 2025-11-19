package boletin2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertirPalabras {
	public static void main(String[] args) {
        String rutaArchivoEntrada = "C:\\Users\\jl.manzano\\palabras.txt";
        String rutaArchivoSalida = "C:\\\\Users\\\\jl.manzano\\\\palabras_convertidas.txt";
        
        convertirArchivo(rutaArchivoEntrada, rutaArchivoSalida);
	}
	
	public static void convertirArchivo(String rutaEntrada, String rutaSalida) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaEntrada))) {
        	String texto = br.readLine();
            
        	String[] palabras = separarPalabras(texto);
            
            escribirArchivoSalida(rutaSalida, palabras);
            
            System.out.println("El archivo ha sido convertido correctamente.");


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
