package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Local {
	private static File myFile = new File(System.getProperty("user.home") + File.separator + "detalles.cdx");
	public static void inicializar() {
		// myFile.delete();
		if(!myFile.exists())
			try {
				myFile.createNewFile();
				getDatos();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void crearPrimerosDatos () {
		System.out.println("OKKKK");
		try {
			FileWriter salidaAux = new FileWriter(myFile);
			BufferedWriter salida = new BufferedWriter(salidaAux);
			for(int i=0;i<21;i++) {
				salida.write(AdditionalMethods.encriptar("0") + "\n");
			}
			salida.close();
			salidaAux.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> getDatos () {
		FileReader entradaAux;
		try {
			entradaAux = new FileReader(myFile);
			BufferedReader entrada = new BufferedReader(entradaAux);
			String linea = entrada.readLine();
			ArrayList<Integer> lineas = new ArrayList<Integer>();
			int contador = 0;
			while(linea != null) {
				lineas.add(Integer.parseInt(AdditionalMethods.desencriptar(linea)));
				datos[contador] = Integer.parseInt(AdditionalMethods.desencriptar(linea));
				System.out.println(datos[contador]);
				linea = entrada.readLine();
				contador++;
			}
			if(lineas.size() <=1) {
				crearPrimerosDatos();
			}
			lineas.forEach(System.out::println);
			entrada.close();
			entradaAux.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void addPoints(int points) {
		datos[0] += points;
		sincronizarDatos();
	}
	
	public static void nivelSuperado(int nivel) {
		// Los niveles comienzan con 1
		datos[nivel] = 1;
		sincronizarDatos();
	}
	
	public static void resetearNiveles() {
		for(int i=1;i<=15;i++) {
			datos[i] = 0;
		}
		
		datos[datos.length-2] = 0;
		datos[datos.length-1] = 0;

		sincronizarDatos();
	}
	
	public static ArrayList<Integer> getNiveles() {
		ArrayList<Integer> niveles = new ArrayList<Integer>();
		for(int i=1;i<=15;i++) {
			niveles.add(datos[i]);
		}
		return niveles;
	}
	
	public static void getMedalla(int i) {
		/*
		 0 = Bronce
		 1 = Plata
		 2 = Oro
		 */
		
		datos[datos.length-i-3] = 1;
		sincronizarDatos();
	}
	
	public static int getPoints() {
		return datos[0];
	}
	
	public static boolean hasMedalla(int i) {
		if(datos[datos.length-i-3] == 1) return true;
		return false;
	}
	
	private static void sincronizarDatos() {
		try {
			myFile.delete();
			myFile.createNewFile();
			FileWriter salidaAux = new FileWriter(myFile);
			BufferedWriter salida = new BufferedWriter(salidaAux);
			for(int d1 : datos) salida.write(AdditionalMethods.encriptar(Integer.toString(d1)) + "\n");
			salida.close();
			salidaAux.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static boolean isPrimerSpecialEvent() {
		if(datos[datos.length-2] == 0) return true;
		else return false;
	}
	
	public static boolean isSegundoSpecialEvent() {
		if(datos[datos.length-1] == 0) return true;
		else return false;
	}
	
	public static void checkPrimerSpecialEvent() {
		datos[datos.length-2] = 1;
		sincronizarDatos();
	}
	public static void checkSegundoSpecialEvent() {
		datos[datos.length-1] = 1;
		sincronizarDatos();
	}
	
	private static int[] datos = {
		0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	
}
