package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Continuar;
import controller.Game;
import controller.Local;
import controller.Tienda;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.SwingConstants;

public class PanelPrincipal extends JFrame {

	private JPanel contentPane;

	private JLabel medalla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
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
	
	private void comenzarJuego(boolean isNuevoJuego) {
		this.setVisible(false);
		new Game().setVisible(true);
	}
	
	
	public void revisarMedalla() {
		if(Local.hasMedalla(2)) {
			medalla.setIcon(new ImageIcon(Main.class.getResource("gold.png")));
		}else if(Local.hasMedalla(1)) {
			medalla.setIcon(new ImageIcon(Main.class.getResource("silver.png")));
		}else if(Local.hasMedalla(0)) {
			medalla.setIcon(new ImageIcon(Main.class.getResource("bronze.png")));
		}else {
			medalla.setIcon(new ImageIcon(Main.class.getResource("charles_player.png")));
		}
	}
	
	public PanelPrincipal() {
		setTitle("El juego de Charles Darwin");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("titulo.png")));
		lblNewLabel.setBounds(20, 10, 589, 69);
		contentPane.add(lblNewLabel);
		
		JButton nuevoJuego = new JButton("");
		nuevoJuego.setBackground(Color.WHITE);
		nuevoJuego.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/application/nuevo_juego.png")));
		nuevoJuego.setBounds(145, 146, 321, 89);
		contentPane.add(nuevoJuego);
		
		JButton continuarJuego = new JButton("");
		continuarJuego.setBackground(Color.WHITE);
		continuarJuego.setIcon(new ImageIcon(Main.class.getResource("continuar_juego.png")));
		continuarJuego.setBounds(145, 245, 321, 89);
		contentPane.add(continuarJuego);
		
		JLabel lblNewLabel_1 = new JLabel("Eliga una opci\u00F3n para comenzar con el juego");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(41, 89, 550, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton credits = new JButton("");
		credits.setBackground(Color.WHITE);
		credits.setIcon(new ImageIcon(Main.class.getResource("author.png")));
		credits.setBounds(524, 277, 85, 57);
		contentPane.add(credits);
		
		JButton shop = new JButton("");
		shop.setIcon(new ImageIcon(Main.class.getResource("shop.png")));
		shop.setBackground(Color.WHITE);
		shop.setBounds(10, 277, 85, 57);
		contentPane.add(shop);
		
		medalla = new JLabel("");
		revisarMedalla();
		shop.addActionListener(e -> new Tienda(this));
		
		medalla.setBounds(10, 133, 85, 102);
		contentPane.add(medalla);
		
		JLabel internet = new JLabel("");
		internet.setBounds(536, 177, 48, 57);
		contentPane.add(internet);
		internet.setCursor(new Cursor(Cursor.HAND_CURSOR));
		internet.setIcon(new ImageIcon(Main.class.getResource("internet.png")));
		internet.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://view.genial.ly/627f638f14f9e20011622192/presentation-charles-darwin"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
		});
		PanelPrincipal miPanel = this;
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Creditos();
			}
		});
		
		continuarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miPanel.setVisible(false);
				new Continuar();
			}
			
		});
		
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Si creas una nueva partida teniendo ya una partida la partida anterior se borrará, ¿Estás seguro?") == 0) {
					Local.resetearNiveles();
					miPanel.setVisible(false);
					comenzarJuego(true);
				}
			}
		});
		setVisible(true);
	}
}
