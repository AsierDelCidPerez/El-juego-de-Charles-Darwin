package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Desktop;

public class Fin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fin frame = new Fin();
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
	public Fin() {
		JFrame miFarme = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fin del juego");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(271, 28, 228, 63);
		contentPane.add(lblNewLabel);
		
		Local.addPoints(1000);
		Local.resetearNiveles();
		
		new Alerta(2, "Has obtenido 1.000D$ por haber finalizado el juego. ¡Gracias por haber completado el juego! Espero que te haya gustado.", "Obtención de puntos");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnNewButton.setText("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton.setBounds(312, 235, 151, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("El motor de las mayores proezas es la aptitud que aporta la actitud");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(131, 86, 540, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("<html><body style=\"text-align: center\">Charles Darwin ha perseguido sus sue\u00F1os de ser un naturalista toda su vida y finalmente la actitud que mostraba hacia esta destreza lo hico convertirse en la persona que hoy conocemos.</body></html>");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(21, 124, 707, 101);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnRealizarCuestionario = new JButton("Realizar cuestionario");
		btnRealizarCuestionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://forms.office.com/r/7z0GziyCVh"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRealizarCuestionario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRealizarCuestionario.setBackground(Color.WHITE);
		btnRealizarCuestionario.setBounds(312, 297, 151, 40);
		contentPane.add(btnRealizarCuestionario);
		setVisible(true);
	}
}
