package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Continuar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Continuar frame = new Continuar();
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
	public Continuar() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 687, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Continuar juego");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JFrame continuar = this;
		JButton uno = new JButton("Parte 1");
		Game miJuego = new Game();
		Historia.setGame(miJuego);
		
		uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.parte1(miJuego);
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_uno = new GridBagConstraints();
		gbc_uno.insets = new Insets(0, 0, 5, 5);
		gbc_uno.gridx = 0;
		gbc_uno.gridy = 0;
		panel.add(uno, gbc_uno);
		
		JButton dos = new JButton("Parte 2");
		GridBagConstraints gbc_dos = new GridBagConstraints();
		dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.agregar(Historia.parte2());
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		gbc_dos.insets = new Insets(0, 0, 5, 5);
		gbc_dos.gridx = 1;
		gbc_dos.gridy = 0;
		panel.add(dos, gbc_dos);
		
		JButton tres = new JButton("Parte 3");
		GridBagConstraints gbc_tres = new GridBagConstraints();
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.agregar(Historia.parte3());
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		gbc_tres.insets = new Insets(0, 0, 5, 5);
		gbc_tres.gridx = 2;
		gbc_tres.gridy = 0;
		panel.add(tres, gbc_tres);
		
		JButton cuatro = new JButton("Parte 4");
		cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.agregar(Historia.parte4());
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_cuatro = new GridBagConstraints();
		gbc_cuatro.insets = new Insets(0, 0, 5, 5);
		gbc_cuatro.gridx = 3;
		gbc_cuatro.gridy = 0;
		panel.add(cuatro, gbc_cuatro);
		
		JButton cinco = new JButton("Parte 5");
		cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.agregar(Historia.parte5());
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_cinco = new GridBagConstraints();
		gbc_cinco.insets = new Insets(0, 0, 5, 5);
		gbc_cinco.gridx = 4;
		gbc_cinco.gridy = 0;
		panel.add(cinco, gbc_cinco);
		
		JButton seis = new JButton("Parte 6");
		seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.agregar(Historia.part8());
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_seis = new GridBagConstraints();
		gbc_seis.insets = new Insets(0, 0, 5, 5);
		gbc_seis.gridx = 5;
		gbc_seis.gridy = 0;
		panel.add(seis, gbc_seis);
		
		JButton siete = new JButton("Parte 7");
		siete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miJuego.agregar(Historia.part9());
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_siete = new GridBagConstraints();
		gbc_siete.anchor = GridBagConstraints.NORTHEAST;
		gbc_siete.insets = new Insets(0, 0, 5, 0);
		gbc_siete.gridx = 6;
		gbc_siete.gridy = 0;
		panel.add(siete, gbc_siete);
		
		JButton ocho = new JButton("Parte 8");
		ocho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part10();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_ocho = new GridBagConstraints();
		gbc_ocho.insets = new Insets(0, 0, 5, 5);
		gbc_ocho.gridx = 0;
		gbc_ocho.gridy = 1;
		panel.add(ocho, gbc_ocho);
		
		JButton nueve = new JButton("Parte 9");
		nueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part11();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_nueve = new GridBagConstraints();
		gbc_nueve.anchor = GridBagConstraints.NORTHEAST;
		gbc_nueve.insets = new Insets(0, 0, 5, 5);
		gbc_nueve.gridx = 1;
		gbc_nueve.gridy = 1;
		panel.add(nueve, gbc_nueve);
		
		JButton diez = new JButton("Parte 10");
		diez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part12();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_diez = new GridBagConstraints();
		gbc_diez.insets = new Insets(0, 0, 5, 5);
		gbc_diez.gridx = 2;
		gbc_diez.gridy = 1;
		panel.add(diez, gbc_diez);
		
		JButton once = new JButton("Parte 11");
		once.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part13();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_once = new GridBagConstraints();
		gbc_once.insets = new Insets(0, 0, 5, 5);
		gbc_once.gridx = 3;
		gbc_once.gridy = 1;
		panel.add(once, gbc_once);
		
		JButton doce = new JButton("Parte 12");
		doce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part14();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_doce = new GridBagConstraints();
		gbc_doce.insets = new Insets(0, 0, 5, 5);
		gbc_doce.gridx = 4;
		gbc_doce.gridy = 1;
		panel.add(doce, gbc_doce);
		
		JButton trece = new JButton("Parte 13");
		trece.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part15();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_trece = new GridBagConstraints();
		gbc_trece.insets = new Insets(0, 0, 5, 5);
		gbc_trece.gridx = 5;
		gbc_trece.gridy = 1;
		panel.add(trece, gbc_trece);
		
		JButton catorce = new JButton("Parte 14");
		catorce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part16();
				continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_catorce = new GridBagConstraints();
		gbc_catorce.insets = new Insets(0, 0, 5, 0);
		gbc_catorce.gridx = 6;
		gbc_catorce.gridy = 1;
		panel.add(catorce, gbc_catorce);
		
		JButton quince = new JButton("Parte 15");
		quince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Historia.part17();continuar.setVisible(false);
				miJuego.setVisible(true);
			}
		});
		GridBagConstraints gbc_quince = new GridBagConstraints();
		gbc_quince.insets = new Insets(0, 0, 5, 5);
		gbc_quince.gridx = 3;
		gbc_quince.gridy = 2;
		panel.add(quince, gbc_quince);
		
		JButton[] botones = {
				uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez, once, doce, trece, catorce, quince
		};
		
		ArrayList<Integer> niveles = Local.getNiveles();
		int maximo = 0;
		for(int i=0;i<niveles.size();i++) {
			if(niveles.get(i) == 0) {
				botones[i].setEnabled(false);
			}
		}
		setVisible(true);
	}

}
