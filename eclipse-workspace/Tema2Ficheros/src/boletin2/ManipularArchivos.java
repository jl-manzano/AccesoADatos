package boletin2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ManipularArchivos {

    public static void main(String[] args) {

        String archivoLectura = "C:\\Users\\jl.manzano\\lectura.txt";  
        String archivoEscritura = "C:\\Users\\jl.manzano\\escritura.txt";  
        String letrasConNumero = "C:\\Users\\jl.manzano\\letrasConNumero.txt";  

        try {

            File archivoLecturaFile = new File(archivoLectura);
            if (!archivoLecturaFile.exists()) {
                System.out.println("El archivo de lectura no existe. Se creará.");
                crearArchivo(archivoLectura);
            }

            escribirArchivoAleatorio(archivoLectura, archivoEscritura);
            escribirLetrasConNumero(archivoLectura, letrasConNumero);

        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        }
    }

    // método para crear el archivo de lectura y escribir las letras 'a', 'b', 'c', 'd', 'e'
    static void crearArchivo(String archivo) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rw")) {
            raf.setLength(0); // limpiamos el archivo de escritura antes de escribir
            raf.writeBytes("abcde");
            System.out.println("Archivo de lectura creado con las letras 'a', 'b', 'c', 'd', 'e'.");
        }
    }

    // método para escribir 5 veces la letra 'a' en otro archivo (escritura aleatoria)
    static void escribirArchivoAleatorio(String archivoLectura, String archivoEscritura) throws IOException {
        try (RandomAccessFile rafLectura = new RandomAccessFile(archivoLectura, "r");
             RandomAccessFile rafEscritura = new RandomAccessFile(archivoEscritura, "rw")) {

            rafLectura.seek(0);  // nos movemos al inicio del archivo de lectura
            rafEscritura.setLength(0);  // limpiamos el archivo de escritura antes de escribir

            if (rafLectura.length() < 1) {
                System.out.println("El archivo de lectura está vacío.");
                return;
            }

            // escribimos la letra 'a' 5 veces en el archivo de escritura
            for (int i = 0; i < 5; i++) {
                rafLectura.seek(0);  // nos movemos al inicio del archivo de lectura
                rafEscritura.writeByte(rafLectura.readByte());  // leemos la letra y la escribimos
            }
        }
    }

    // método para escribir las letras del archivo de lectura con un número al lado en orden inverso
    static void escribirLetrasConNumero(String archivoLectura, String archivoEscritura) throws IOException {
        try (RandomAccessFile rafLectura = new RandomAccessFile(archivoLectura, "r");
             FileWriter wr = new FileWriter(archivoEscritura)) {

            int length = (int) rafLectura.length();
            int num;
            char[] letras = new char[length];

            // leemos cada byte del archivo de lectura y lo convertimos a un char
            for (int i = 0; i < length; i++) {
                letras[i] = (char) rafLectura.readByte();  // leemos el byte y lo convertimos a char
            }

            // inicializar num desde el total de letras
            num = length;
            
            // escribimos las letras en orden inverso con el número correspondiente
            for (int i = length - 1; i >= 0; i--) {
                wr.write(letras[i] + "" + num + "\n"); 
                num--;
            }
        }
    }
}
