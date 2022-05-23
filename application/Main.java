package application;

import controller.Local;

public class Main {
	public static void main(String[] args) {
		Local.inicializar();
		Local.getDatos();
		new Juego();
	}
}
