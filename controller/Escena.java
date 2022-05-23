package controller;

import javax.swing.JPanel;

import application.Main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Escena extends JPanel {

	private URL[] imagenes = {
			Main.class.getResource("darwin_peque.jpg"),
			Main.class.getResource("edimburg.jpg"),
			Main.class.getResource("cambridge.jpg"),
			Main.class.getResource("w_darwin.jpg"),
			Main.class.getResource("carta_antigua.jpg"),
			Main.class.getResource("beagle.jpg"),
			Main.class.getResource("mariposa.jpg"),
			Main.class.getResource("esclavos.png"),
			Main.class.getResource("generalRosas.jpg"),
			Main.class.getResource("iglesia.jpg"),
			Main.class.getResource("westminster.jpg")
	};
	
	/**
	 * Create the panel.
	 */
	private String image = "darwin_peque.jpg";
	public Escena (int image, String texto, String fondo_imagen, Evento evento) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(imagenes[image]));
		lblNewLabel.setBounds(10, 10, 802, 287);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 307, 899, 15);
		add(separator);
		ArrayList<String> lineas = Textos.estructuraTexto(texto, 19);
		String miTexto = "";
		for(String d1 : lineas) {
			miTexto += d1 + "<br>";
		}
		
		miTexto = "<html><body>" + miTexto + "</body></html>";
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 802, 109);
		add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		scrollPane.setViewportView(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		
		lblNewLabel_1.setText(miTexto);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("next.png")));
		btnNewButton.setBounds(822, 398, 87, 40);
		add(btnNewButton);
		btnNewButton.addActionListener(e -> {
			evento.act();
		});
	}

}
