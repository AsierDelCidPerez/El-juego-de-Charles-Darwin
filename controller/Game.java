package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game() {
		setTitle("El juego de Charles Darwin");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 933, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		nuevoJuego();
		setContentPane(contentPane);
	}
	
	public  void agregar(JPanel c) {
		actualEscena.setVisible(false);
		actualEscena = c;
		contentPane.add(c);
	}
	
	public void nuevoJuego () {
		actualEscena = Historia.parte1(this);
		contentPane.add(actualEscena);
	}

	private JPanel actualEscena;
}
