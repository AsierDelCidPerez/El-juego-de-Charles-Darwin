package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Main;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class Alerta extends JDialog {

	private Alerta miAlerta = this;
	
	private final JPanel contentPanel = new JPanel();

	private URL[] iconos = {
		Main.class.getResource("info.png"),
		Main.class.getResource("error.png"),
		Main.class.getResource("success.png")
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Alerta dialog = new Alerta(0, " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque feugiat maximus sem, sed auctor ante sagittis eu. Duis sollicitudin imperdiet scelerisque. Proin ultricies quam et odio gravida finibus. Phasellus non leo eu dui pellentesque gravida. Aliquam dapibus quam et orci posuere facilisis vitae id metus. Donec sagittis gravida aliquam. Nunc sollicitudin libero eu ipsum aliquam, id vehicula libero molestie. Mauris scelerisque mollis laoreet. Vivamus lacinia tortor quis nisl vulputate mollis. Donec vulputate quam quis est eleifend, sed dignissim ex ultricies. In vitae posuere mauris.\r\n"
					+ "\r\n"
					+ "Pellentesque egestas volutpat leo, et bibendum nisi cursus eget. Ut aliquet malesuada metus vel gravida. Sed eu ornare metus. In lacus risus, pellentesque sed tellus id, egestas vestibulum dolor. Phasellus in placerat nulla, sed tempor urna. Nam arcu orci, sagittis a molestie vitae, lobortis vitae ex. Suspendisse sem dui, volutpat id ipsum convallis, vulputate dictum mauris. Nam eget mauris eu mauris tempus lobortis et vel ligula.\r\n"
					+ "\r\n"
					+ "Aenean vitae sem scelerisque, viverra ex ut, rutrum tortor. Quisque sit amet sodales velit. Nullam nisl mauris, porttitor vitae mauris maximus, imperdiet molestie elit. Vestibulum a nulla et lectus porttitor vehicula venenatis ac massa. Morbi gravida mauris nec libero cursus, sit amet commodo nibh placerat. Fusce mattis urna in mauris accumsan posuere. Pellentesque porta eu mi in luctus. ",
					"Ejemplo");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Alerta(int alertType, String miTexto, String titulo) {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setTitle(titulo);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00A1Alerta!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(164, 10, 141, 32);
		contentPanel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 416, 14);
		contentPanel.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 416, 138);
		contentPanel.add(scrollPane);
		
		ArrayList<String> lineas = Textos.estructuraTexto(miTexto, 8);
		String textoLinear = "";
		for(String d1 : lineas) {
			textoLinear += d1 + "<br>";
		}
		
		textoLinear = "<html><body>" + textoLinear + "</body></html>";
		
		JLabel texto = new JLabel(textoLinear);
		scrollPane.setViewportView(texto);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(iconos[alertType]));
		icono.setBounds(75, 0, 45, 56);
		contentPanel.add(icono);
		
		JLabel icono_1 = new JLabel("");
		icono_1.setBounds(391, 0, 45, 56);
		contentPanel.add(icono_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miAlerta.setVisible(false);
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
			}
		}
		setVisible(true);
	}
}
