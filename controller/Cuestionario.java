package controller;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import application.Main;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

public class Cuestionario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuestionario frame = new Cuestionario();
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
	public Cuestionario() {
		setTitle("Realizar cuestionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("qr.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(59, 34, 296, 294);
		contentPane.add(lblNewLabel);
		
		JLabelLink acceder = new JLabelLink();
		acceder.setText("Acceder al cuestionario");
		acceder.setLink("https://forms.office.com/r/7z0GziyCVh");
		contentPane.add(acceder);
		JButton regresar = new JButton("Regresar");
		regresar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		regresar.setBounds(137, 380, 114, 35);
		contentPane.add(regresar);
		setVisible(true);
	}
}


class Pregunta {
	private String enunciado;
	private String[] opcionesIncorrectas;
	private String opcionCorrecta;
	
	public String getEnunciado() {
		return enunciado;
	}



	public String[] getOpcionesIncorrectas() {
		return opcionesIncorrectas;
	}



	public String getOpcionCorrecta() {
		return opcionCorrecta;
	}



	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}



	public void setOpcionesIncorrectas(String[] opcionesIncorrectas) {
		this.opcionesIncorrectas = opcionesIncorrectas;
	}



	public void setOpcionCorrecta(String opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}



	public Pregunta(String enunciado, String[] opcionesIncorrectas, String opcionCorrecta) {
		this.enunciado = enunciado;
		this.opcionesIncorrectas = opcionesIncorrectas;
		this.opcionCorrecta = opcionCorrecta;
	}
	
}


class JLabelLink extends JLabel{

    private String text="";
    private String TextLink=null;
    private URI uri;

    public JLabelLink(){
        super();
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize( new Dimension(34,14) );
        this.setVisible(true);
        //Eventos del raton sobre el JLabel
        addMouseListener(new MouseAdapter() {
            @Override
                public void mouseClicked(MouseEvent e) {
                    Abrir_URL(uri);
                }
            @Override
                public void mouseEntered(MouseEvent e) {
                    setText(text,false);
                }
            @Override
                public void mouseExited(MouseEvent e) {
                    setText(text,true); repaint();
                }
        });

    }

    /**
 * Coloca la dirección web
 */
    public void setLink( String link )
    {        
        try {
            uri = new URI(link);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
 * Coloca el texto que contiene el enlace web
 */
    public void setTextLink( String texto )
    {
        this.TextLink = texto;
    }

    /**
 * Se sobreescribe metodo
 */
    @Override
    public void setText( String value ){                
        setText(  value ,false );
    }

    /**
 * Retorna el texto sin las etiquetas HTML
 */
    public String getTextSinFormato(){
        return text;
    }

    /**
 * Da formato al texto para añadir las etiquetas HTML necesarias
 */
    private void setText(String text, boolean inout){
        //Estilo CSS
        String css = "<style type='text/css'>"
                + ".link {text-decoration: none;font-weight: bold;color:#000000;}"
                + ".link_hover{color:rgb(255,0,0);text-decoration:underline;}"
                + "</style>";

        //estilo css segun el mouse este dentro o fuera
        String clase = (inout)? "link":"link_hover";
        //forma el texto HTML
        String html_text = (TextLink!=null)?text.replace(TextLink, "<span class='"+clase+"' >" +TextLink + "</span>"):text;        
        //coloca al padre
        super.setText("<html>"+ css +"<span>"+ html_text + "<span/></html>");

        this.text = text;
    }

    /**
 * Abre enlace web en el navegador
 */
    private void Abrir_URL(URI uri) {
      if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          try {
             desktop.browse(uri);
          } catch (IOException e) {
             System.err.println("Error: No se pudo abrir el enlace" + e.getMessage() );
          }
      } else {
          System.err.println("Error: Error de compatibilidad en la plataforma actual. No se puede abrir enlaces web.");
      }
    }

}

