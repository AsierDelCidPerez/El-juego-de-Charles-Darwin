package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Main;
import application.PanelPrincipal;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Tienda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda(PanelPrincipal i) {
		setTitle("Tienda del juego");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 551, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bronzeLabel = new JLabel("");
		bronzeLabel.setIcon(new ImageIcon(Main.class.getResource("bronze.png")));
		bronzeLabel.setBounds(43, 67, 69, 100);
		contentPane.add(bronzeLabel);
		
		JLabel silverLabel = new JLabel("");
		silverLabel.setIcon(new ImageIcon(Main.class.getResource("silver.png")));
		silverLabel.setBounds(223, 67, 69, 100);
		contentPane.add(silverLabel);
		
		JLabel goldLabel = new JLabel("");
		goldLabel.setIcon(new ImageIcon(Main.class.getResource("gold.png")));
		goldLabel.setBounds(412, 67, 69, 100);
		contentPane.add(goldLabel);
		
		JButton bronze = new JButton("1.000D$");
		bronze.setBackground(Color.WHITE);
		bronze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bronze.setBounds(21, 166, 110, 21);
		contentPane.add(bronze);
		
		JButton silver = new JButton("10.000D$");
		silver.setBackground(Color.WHITE);
		silver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		silver.setBounds(207, 166, 102, 21);
		contentPane.add(silver);
		
		JButton gold = new JButton("100.000D$");
		gold.setBackground(Color.WHITE);
		gold.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gold.setBounds(389, 166, 112, 21);
		contentPane.add(gold);
		
			
		JLabel lblNewLabel = new JLabel("Tienda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(213, 10, 79, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tus puntos: 0D$");
		lblNewLabel_1.setText("Tus puntos: " + Local.getPoints() + "D$");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(184, 262, 248, 31);
		contentPane.add(lblNewLabel_1);
		gold.addActionListener(e -> {
			if(Local.getPoints() >= 100000) {
				if(Local.hasMedalla(2)) {
					new Alerta(1, "Ya has adquirido anteriormente esta insignia, por lo que no se puede completar la compra", "Insignia ya adquirida");
				}else {
					Local.getMedalla(2);
					new Alerta(2, "Se ha adquirido exitósamente la insignia", "Adquisición exitosa");
					Local.addPoints(-100000);
					actualizarMoney(lblNewLabel_1);
					i.revisarMedalla();
				}
			}else {
				new Alerta(1, "No se ha podido adquirir la insignia ya que no tienes fondos suficientes", "Compra fallida");
			}
		});
		
		silver.addActionListener(e -> {
			if(Local.getPoints() >= 10000) {
				if(Local.hasMedalla(1)) {
					new Alerta(1, "Ya has adquirido anteriormente esta insignia, por lo que no se puede completar la compra", "Insignia ya adquirida");
				}else {
					Local.getMedalla(1);
					new Alerta(2, "Se ha adquirido exitósamente la insignia", "Adquisición exitosa");
					Local.addPoints(-10000);
					actualizarMoney(lblNewLabel_1);
					i.revisarMedalla();
				}
			}else {
				new Alerta(1, "No se ha podido adquirir la insignia ya que no tienes fondos suficientes", "Compra fallida");
			}
		});
		
		bronze.addActionListener(e -> {
			if(Local.getPoints() >= 1000) {
				if(Local.hasMedalla(0)) {
					new Alerta(1, "Ya has adquirido anteriormente esta insignia, por lo que no se puede completar la compra", "Insignia ya adquirida");
				}else {
					Local.getMedalla(0);
					new Alerta(2, "Se ha adquirido exitósamente la insignia", "Adquisición exitosa");
					Local.addPoints(-1000);
					actualizarMoney(lblNewLabel_1);
					i.revisarMedalla();
				}
			}else {
				new Alerta(1, "No se ha podido adquirir la insignia ya que no tienes fondos suficientes", "Compra fallida");
			}
		});
		setVisible(true);
		
	}
	
	private void actualizarMoney(JLabel i) {
		i.setText("Tus puntos: " + Local.getPoints() + "D$");
	}

}
