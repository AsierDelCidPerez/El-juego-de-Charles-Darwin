package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import application.Main;

import javax.swing.JLabel;

public class MapaGame extends JFrame {

	class EventRelated {
		private Evento e;
		private Coordenadas j;
		private boolean visitado = false;
		public EventRelated (Evento e, Coordenadas j) {
			this.e = e;
			this.j = j;
		}

		public void visitar() {
			visitado = true;
		}
		
		public boolean estaVisitado() {
			return visitado;
		}
		
		public Evento getEvento() {
			return e;
		}

		public Coordenadas getCoordenadas() {
			return j;
		}
		
	}
	
	
	private JPanel contentPane;
	
	private int xUnit, yUnit = 0;
	
	private int[] limitesMapas = {720, 360};
	
	private Coordenadas coordenadasPlayer;

	private ArrayList<EventRelated> eventosRelacionados = new ArrayList<EventRelated>();
	
	private URL[] mapas = {
			Main.class.getResource("charles_house.png"),
			Main.class.getResource("bosqueMapa.png"),
			Main.class.getResource("esclavos.png")
	};
	
	private Game juego;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					MapaGame frame = new MapaGame(new int[][] {
						{3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2},
						{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
						{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
					}, new Evento[] {
							() -> {
								juego.agregar(Historia.part8());
							},
							() -> {
								juego.agregar(Historia.part8());
							}
					}, 0);
					*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 El mapa del juego debe ser obligatoriamente de 720px de ancho y 360px de alto.
	 El mapa del juego tendrá mediciones de 720x360 repartidas en un 2:1, por lo que cada cuadro será de 40x40.
	 El frame del jugador debe ser 40x40 la unida primaria.
	 */
	public MapaGame(int[][] datos, Evento[] eventos, int mapa, Game juego) {
		this.juego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 410);
		contentPane = new JPanel();
		// Rellenamos la lista de eventos relacionados
		ArrayList<Coordenadas> eventosPosicion = Coordenadas.detectar(2, datos);
		for(int i=0;i<eventosPosicion.size();i++) {
			eventosRelacionados.add(new EventRelated(eventos[i], eventosPosicion.get(i)));
		}
		
		eventosRelacionados.forEach(e -> System.out.println("("+e.getCoordenadas().getX() + ", " + e.getCoordenadas().getY() + ") -> " + e.getEvento()));
		
		xUnit = 720 / datos[0].length;
		yUnit = 360 / datos.length;
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel player = new JLabel("");
		player.setIcon(new ImageIcon(MapaGame.class.getResource("/application/charles_player.png")));
		Coordenadas personaje = Coordenadas.detectar(3, datos).get(0);
		coordenadasPlayer = personaje;
		player.setBounds(10, 0, 40, 40);
		System.out.println(coordenadasPlayer.getX() + " " +  coordenadasPlayer.getY());
		
		player.setLocation(personaje.getX(), personaje.getY());
		contentPane.add(player);
		
		JLabel mapa_1 = new JLabel("");
		mapa_1.setIcon(new ImageIcon(mapas[mapa]));
		mapa_1.setBounds(0, 0, 720, 360);
		contentPane.add(mapa_1);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 39) {
					moverDerecha();
				}else if(e.getKeyCode() == 37) {
					moverIzquierda();
				}else if(e.getKeyCode() == 38) {
					moverArriba();
				}else if(e.getKeyCode() == 40) {
					moverAbajo();
				}
			}

			private void moverAbajo() {
				int nuevaCoordenadaY = personaje.getY()+yUnit;
				if(nuevaCoordenadaY <= limitesMapas[1] && nuevaCoordenadaY >= 0) {
					int nuevoLugar = Coordenadas.getValueByCoordenadas(new Coordenadas(personaje.getX()/xUnit, nuevaCoordenadaY/yUnit), datos);
					if(nuevoLugar == 0 || nuevoLugar == 3) {
						player.setLocation(player.getX(), nuevaCoordenadaY);
						coordenadasPlayer.incrementarCoordenadas(0, yUnit);
					}else if(nuevoLugar == 1) {
						Toolkit.getDefaultToolkit().beep();
					}else if(nuevoLugar == 2) {
						player.setLocation(player.getX(), nuevaCoordenadaY);
						coordenadasPlayer.incrementarCoordenadas(0, yUnit);
						eventoDisparado(coordenadasPlayer);
					}
					System.out.println(coordenadasPlayer.getX() + " " + coordenadasPlayer.getY());
				}else {
					Toolkit.getDefaultToolkit().beep();
				}
			}

			private void moverArriba() {
				int nuevaCoordenadaY = personaje.getY()-yUnit;
				if(nuevaCoordenadaY <= limitesMapas[1] && nuevaCoordenadaY >= 0) {
					int nuevoLugar = Coordenadas.getValueByCoordenadas(new Coordenadas(personaje.getX()/xUnit, nuevaCoordenadaY/yUnit), datos);
					if(nuevoLugar == 0 || nuevoLugar == 3) {
						player.setLocation(player.getX(), nuevaCoordenadaY);
						coordenadasPlayer.incrementarCoordenadas(0, -yUnit);
					}else if(nuevoLugar == 1) {
						Toolkit.getDefaultToolkit().beep();
					}else if(nuevoLugar == 2) {
						player.setLocation(player.getX(), nuevaCoordenadaY);
						coordenadasPlayer.incrementarCoordenadas(0, -yUnit);
						eventoDisparado(coordenadasPlayer);
					}
					System.out.println(coordenadasPlayer.getX() + " " + coordenadasPlayer.getY());
				}else {
					Toolkit.getDefaultToolkit().beep();
				}
			}

			private void moverIzquierda() {
				int nuevaCoordenadaX = personaje.getX()-xUnit;
				if(nuevaCoordenadaX <= limitesMapas[0] && nuevaCoordenadaX >= 0) {
					int nuevoLugar = Coordenadas.getValueByCoordenadas(new Coordenadas(nuevaCoordenadaX/xUnit, player.getY()/yUnit), datos);
					if(nuevoLugar == 0 || nuevoLugar == 3) {
						player.setLocation(nuevaCoordenadaX, player.getY());
						coordenadasPlayer.incrementarCoordenadas(-xUnit, 0);
					}else if(nuevoLugar == 1) {
						Toolkit.getDefaultToolkit().beep();
					}else if(nuevoLugar == 2) {
						player.setLocation(nuevaCoordenadaX, player.getY());
						coordenadasPlayer.incrementarCoordenadas(-xUnit, 0);
						eventoDisparado(coordenadasPlayer);
					}
					System.out.println(coordenadasPlayer.getX() + " " + coordenadasPlayer.getY());
				}else {
					Toolkit.getDefaultToolkit().beep();
				}
			}

			private void moverDerecha() {
				int nuevaCoordenadaX = personaje.getX()+xUnit;
				if(nuevaCoordenadaX <= limitesMapas[0] && nuevaCoordenadaX >= 0) {
					int nuevoLugar = Coordenadas.getValueByCoordenadas(new Coordenadas(nuevaCoordenadaX/xUnit, player.getY()/yUnit), datos);
					if(nuevoLugar == 0 || nuevoLugar == 3) {
						player.setLocation(nuevaCoordenadaX, player.getY());
						coordenadasPlayer.incrementarCoordenadas(xUnit, 0);
					}else if(nuevoLugar == 1) {
						Toolkit.getDefaultToolkit().beep();
					}else if(nuevoLugar == 2) {
						player.setLocation(nuevaCoordenadaX, player.getY());
						coordenadasPlayer.incrementarCoordenadas(xUnit, 0);
						eventoDisparado(coordenadasPlayer);
					}
					System.out.println(coordenadasPlayer.getX() + " " + coordenadasPlayer.getY());
				}
			}
			
			private void eventoDisparado(Coordenadas coordenadasEvento) {
				
				for(EventRelated eventoRelacionado : eventosRelacionados) {
					System.out.println("Fijo: (" + eventoRelacionado.getCoordenadas().getX() + ", " + eventoRelacionado.getCoordenadas().getY() + ")");
					if(eventoRelacionado.getCoordenadas().equals(new Coordenadas(coordenadasEvento.getX()/xUnit, coordenadasEvento.getY()/yUnit)) && !eventoRelacionado.estaVisitado()) {
						eventoRelacionado.getEvento().act();
						eventoRelacionado.visitar();
					}
				}
				
				System.out.println("Evento en: (" + coordenadasEvento.getX()/xUnit + ", " + coordenadasEvento.getY()/yUnit + ")");
			}
			
		});
		
	}
	
	
	
	
	public MapaGame(Evento evento, int mapa, Game juego, long miTiempo, Coordenadas coordenadasPersonaje) {
		this.juego = juego;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 410);
		contentPane = new JPanel();
		// Rellenamos la lista de eventos relacionados
		
		eventosRelacionados.forEach(e -> System.out.println("("+e.getCoordenadas().getX() + ", " + e.getCoordenadas().getY() + ") -> " + e.getEvento()));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel player = new JLabel("");
		player.setIcon(new ImageIcon(MapaGame.class.getResource("/application/charles_player.png")));
		player.setLocation(coordenadasPersonaje.getX()*xUnit, coordenadasPersonaje.getY()*yUnit);
		
		JLabel mapa_1 = new JLabel("");
		mapa_1.setIcon(new ImageIcon(mapas[mapa]));
		mapa_1.setBounds(0, 0, 720, 360);
		contentPane.add(mapa_1);
		contentPane.add(player);
		
		tiempo = new Timer((int) miTiempo, e -> {
			desataTiempo(evento);
		});
		tiempo.start();
		
		setVisible(false);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		});
		
	}
	
	private void desataTiempo (Evento evento) {
		evento.act();
		tiempo.stop();
	}
	private Timer tiempo; 
}
