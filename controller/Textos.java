package controller;

import java.util.ArrayList;

public class Textos {
	public static ArrayList<String> estructuraTexto(String texto, int wordsPerLine) {
		String[] nuevoArraytexto = texto.split(" ");
		ArrayList<String> textoFinal = new ArrayList<String>();
		String textoLinea = "";
		for(int i=0;i<nuevoArraytexto.length;i++) {
			textoLinea += nuevoArraytexto[i] + " ";
			if((i % wordsPerLine == 0 && i != 0) || i+1 == nuevoArraytexto.length) {
				textoFinal.add(textoLinea);
				textoLinea = "";
			}
		}
		return textoFinal;
	}
}
