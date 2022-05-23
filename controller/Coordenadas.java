package controller;

import java.util.ArrayList;

public class Coordenadas {
	private int x, y = 0;
	public Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static ArrayList<Coordenadas> detectar(int special, int[][] datos) {
		/*
		 Special indica el valor a encontrar en el array de datos
		 */
		ArrayList<Coordenadas> misCoordenadas = new ArrayList<Coordenadas>();
		for(int i=0;i<datos.length;i++) {
			for (int j=0;j<datos[0].length;j++) {
				if(datos[i][j] == special) misCoordenadas.add(new Coordenadas(j, i));
			}
		}
		return misCoordenadas;
	}
	
	public static int getValueByCoordenadas(Coordenadas x, int[][] datos) {
		return datos[x.getY()][x.getX()];
	}
	
	public void incrementarCoordenadas(int x, int y) {
		this.x+=x;
		this.y+=y;
	}
	
	public int getX () {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Coordenadas) {
			Coordenadas otra = (Coordenadas) obj;
			if(x == otra.x && y == otra.y) return true; 
		}
		return false;
	}
	
}
