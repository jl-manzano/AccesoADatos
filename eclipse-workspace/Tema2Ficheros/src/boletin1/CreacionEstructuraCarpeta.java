package boletin1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CreacionEstructuraCarpeta {
	public static void main(String[] args) {
		String rutaBase = "C:\\Users\\jl.manzano\\Carpeta personal\\";
		String archivo = "C:\\Users\\jl.manzano\\carpetas.txt";
		String rutaCompleta;
		File directorio;
		boolean exito = false;

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				linea = linea.trim();

				rutaCompleta = rutaBase + linea;
				directorio = new File(rutaCompleta);

				if (!directorio.exists()) {
					exito = directorio.mkdirs();
					if (exito) {
						System.out.println("Directorio creado: " + rutaCompleta);
					} else {
						System.out.println("No se pudo crear el directorio: " + rutaCompleta);
					}
				} else {
					System.out.println("El directorio ya existe: " + rutaCompleta);
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
