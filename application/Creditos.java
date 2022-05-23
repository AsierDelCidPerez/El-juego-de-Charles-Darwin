package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class Creditos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creditos frame = new Creditos();
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
	public Creditos() {
		setResizable(false);
		setTitle("Créditos de la aplicación");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 422, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("El juego de Charles Darwin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(60, 10, 280, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Creado por Asier Del Cid P\u00E9rez");
		lblNewLabel_1.setBounds(10, 53, 388, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IES Garcilaso de la Vega (39300)");
		lblNewLabel_1_1.setBounds(10, 133, 388, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("4\u00BA ESO. Grupo C.");
		lblNewLabel_1_2.setBounds(10, 76, 388, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Departamento de Biolog\u00EDa y Geolog\u00EDa");
		lblNewLabel_1_2_1.setBounds(10, 99, 388, 13);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Torrelavega. Cantabria. Espa\u00F1a.");
		lblNewLabel_1_1_1.setBounds(10, 156, 388, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 122, 388, 13);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mayo de 2022");
		lblNewLabel_1_1_1_1.setBounds(10, 179, 388, 13);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 202, 388, 13);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><body>Este proyecto ha supuesto mucho tiempo invertido en el mismo, por ello se ruega la discrecci\u00F3n en cuanto a los gr\u00E1ficos pues aunque no sean de gran calidad lo que se pretende es dar mayor importancia a la historia del cient\u00EDfico.</body></html>");
		lblNewLabel_2.setBounds(10, 215, 388, 62);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 287, 388, 13);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("<html><body>Este proyecto ha sido realizado mediante el lenguaje de programaci\u00F3n Java. Por ello para su ejecución es necesario tener instalado el JDK (al menos la versión Java SE 9 es la recomendada)</body></html>");
		lblNewLabel_2_1.setBounds(10, 287, 388, 52);
		contentPane.add(lblNewLabel_2_1);
		setVisible(true);
	}
}
