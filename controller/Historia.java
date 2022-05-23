package controller;

import javax.swing.JPanel;

public class Historia {
	
	private static Game juego;
	private static MapaGame miMapa;
	private static MapaGame[] misMapas = {
			new MapaGame(new int[][] {
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
						juego.agregar(Historia.partSpecial1());
					}
			}, 0, juego),
			
			new MapaGame(new int[][] {
				{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
				{1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
				{1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
				{0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 2},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			}, new Evento[] {
				() -> {
					part11();
				},
				() -> {
					partSpecial2();
				}
			}, 1, juego)
			
	};
	
	public static JPanel parte1 (Game juego) {
		Local.nivelSuperado(1);
		Historia.juego = juego;
		return new Escena(0, "¡Charles Darwin abre los ojos por primera vez! Probablemente no sea consciente de la revolución científica que provocará, probablemente tampoco sea consciente navegará en globo alrededor del mundo o que escribirá el libro de cambiará el mundo. Afortundamente tampoco es consciente de que no todos le entenderán. Esta es su historia en forma de videojuego.", "", () -> {
			juego.agregar(parte2());
		});
	}
	public static JPanel parte2 () {
		Local.nivelSuperado(2);
		return new Escena(1, "El doctor Darwin (padre de Charles Darwin) quiere lo mejor para sus hijos y quieres dar a sus hijos: Charles y Erasmus una gran educación. El doctor Darwin quiere que Charles siga la tradición familiar y estudie Medicina en la Universidad de Edimburgo.", "", () -> {
			juego.agregar(parte3());
		});
	}
	public static JPanel parte3 () {
		Local.nivelSuperado(3);
		return new Escena(0, "Charles tiene 16 años y encuentra aburridas las clases de Medicina. No soporta las cirugías, especialmente a niños y sin anestesia (aún no es de uso común). Charles prefiere ciencias naturales: geología, zoologia, botánica, ...", "", () -> {
			juego.agregar(parte4());
		});
	}
	public static JPanel parte4 () {
		Local.nivelSuperado(4);
		return new Escena(2, "El doctor Darwin idea un plan de emergencias y tiene pensado que Charles se haga clérigo, con una buena casa parroquial en el campo. Irá al Christ's College en la Universidad de Cambridge, donde estudió su hermano (Erasmus). A Charles no le guusta para nada sus estudios en Cambridge, Darwin encuentra clases que le interesan más especialmente a la del profesor de botánica John Stevens Henslow. Darwin se ve a si mismo como un naturalista.", "", () -> {
			juego.agregar(parte5());
		});
	}
	
	public static void setGame(Game juego) {
		Historia.juego = juego;
	}
	
	public static JPanel parte5 () {
		Local.nivelSuperado(5);
		return new Escena(2, "¡Uff! Que interesante ha sido la visita geológica a Gales, ojalá volver pronto... ¡Ring Ring! Uy creo que acaba de llamar el cartero, es mejor que le abra la puerta.", "", () -> {
			juego.setVisible(false);
			new Alerta(0, "Para moverte por el mapa debes usar la flecha del teclado. La flecha izquierda te permite moverte hacia la izquierda, la flecha derecha hacia la derecha, la flecha hacia abajo, hacia abajo y la flecha hacia arriba hacia arriba. El mapa del juego está desarrollado en 2D. Cuando te encuentres en el mapa te aparecerá un cuadrado amarillo, ese será el objetivo donde has de llegar. Te pueden aparecer rombos amarillos que te permitirán sumergirte más en la vida de Darwin y obtener mas DarwPoints.", "El mapa");
			misMapas[0].setVisible(true);
		});
	}
	
	public static  JPanel part8() {
		Local.nivelSuperado(6);
		juego.setVisible(true);
		misMapas[0].setVisible(false);
		return new Escena(4, "¡Has recibido una carta del Profesor Henslow! La carta dice así: Me han pedido que recomiende a un naturalista para acompañar al capitán FitzRoy, contratado por el gobierno para estudiar las costas de Sudamérica. He informado que considero que usted es es la persona más cualificada para llevar a cabo tal azaña. Lo digo no en suposición de que sea un naturalista consumado, pero sí ampliamente cualificado para coleccionar observar y registrar cualquier cosa digna de ser apuntada en la Historia Nacional.", "", () -> {
			juego.agregar(part9());
		}); 
	}
	public static  JPanel partSpecial1() {
		juego.setVisible(true);
		misMapas[0].setVisible(false);
		return new Escena(3, "¡Ah mira este es William Darwin! Mi primo.", "", () -> {
			if(Local.isPrimerSpecialEvent()) {
				new Alerta(2, "Por acceder a un evento adicional has obtenido 250 DarwPoints.", "Obtención de DarwPoints");
				new Alerta(0, "Los DarwPoints son puntos del juego que te permitirán comprar insignias en la tienda y demostrar así cuanto sabes sobre Charles Darwin.", "¿Qué son los DarwPoints?");
				Local.addPoints(250);
			}
			misMapas[0].setVisible(true);
			juego.setVisible(false);
			Local.checkPrimerSpecialEvent();
		}); 
	}
	
	public static  JPanel part9() {
		Local.nivelSuperado(7);
		juego.setVisible(true);
		misMapas[0].setVisible(false);
		return new Escena(0, "Voy a aceptar tal azaña. Yo le contesté lo siguiente: <<Apreciado señor en lo que respecta directamente a mí, hubiesa cierta y gustosamente aceptado la oportunidad que tan amablemente me ha ofrecido. Pero mi padre, aunque no me lo ha prohibido terminalmente, manifiesta tan fuerte parecer en contra del viaje que no podría estar cómodo ignorándolo.>>. Gracias a mi tío Jos pude convencer a mi padre de que me diese su aprobación.", "", () -> {
			juego.agregar(part10());
		}); 
	}
	
	public static  JPanel part10() {
		Local.nivelSuperado(8);
		juego.setVisible(true);
		misMapas[0].setVisible(false);
		return new Escena(5, "El viaje en Beagle ha comenzado. Cuando desembarcamos en Río de Janeiro comienzo las expediciones.", "", () -> {
			juego.setVisible(false);
			misMapas[1].setVisible(true);
		}); 
	}
	
	public static void part11() {
		Local.nivelSuperado(9);
		misMapas[1].setVisible(false);
		juego.setVisible(true);
		juego.agregar(new Escena(7, "Aquí fue mi primer encontronazo directo con la esclavitud. Los soldados brasileños tienden emboscada a esclavos fugitivos. Hace hervir la sangre y estremecer el corazón, que nosotros los ingleses y nuestros descendientes de Estados Unidos, con su grito fanfarrón de libertad, seamos tan culpables...", "", () -> {
			part12();
		}));
	}
	
	public static void partSpecial2() {
		misMapas[1].setVisible(false);
		if(Local.isSegundoSpecialEvent()) {
			new Alerta(2, "Por acceder a un evento adicional has obtenido 250 DarwPoints.", "Obtención de DarwPoints");
			Local.addPoints(250);
		}
		Local.checkSegundoSpecialEvent();
		juego.setVisible(true);
		juego.agregar(new Escena(6, "Durante el trayecto estuve investigando varias cosas como esta mariposa tan bonita (Morpho Azul), colibrís, loros verdes, orquídeas, insectos palo, lagartijas y muchísimo más.", "", () -> {
			juego.setVisible(false);
			misMapas[1].setVisible(true);
		}));
	}
	
	public static void part12() {
		Local.nivelSuperado(10);
		juego.agregar(new Escena(8, "Durante la expedición del Beagle conocí al general Rosas, contratado para exterminar a los indios por el Gobierno argentino. Yo no puedo hacer nada. También descubrí una nueva avestruz (la avestruz Petise) a la que le puse mi nombre: Rhea Darwini. Posteriormente fuimos a las islas Galápagos, su nombre significa 'tortugas gigantes'.", "", () -> {
			part13();
		}));
	}
	
	public static void part13() {
		Local.nivelSuperado(11);
		juego.agregar(new Escena(5, "De regreso a casa, pude conocer a mi ídolo, Lyell de quien habría leído sus libros durante el viaje en Beagle. Además mis libros fueron muy bien recibidos por la comunidad y fui invitado a unirsme a las sociedades científicas y clubes más prestigiosos.", "", () -> {
			part14();
		}));
	}
	
	public static void part14() {
		Local.nivelSuperado(12);
		juego.agregar(new Escena(0, "Darwin consigió mucho prestigio en la sociedad científica, sin embargo observó que si quería ser naturalista de primera debía tomar la decisión de realizar más trabajos de investigación. De esta forma decidió tomar esa decisión y en 1858 recibió un manuscrito de Wallace, un botánico que recolectaba especies en el archipiélago de Malasia , el cual exponía conclusiones muy parecidas a las obtenidas en las investigaciones. Lyell y Hooker idearon un plan para establecer prioridad a Darwin.", "", () -> {
			part15();
		}));
	}
	
	public static void part15() {
		Local.nivelSuperado(13);
		juego.agregar(new Escena(9, "Mi teoría fue atacada por el obispo de Oxford, Samuel Wilbeforce, instruido por Richard Owen. El obispo le preguntó a Huxley si el descendía de un mono por parte de su abuelo o abuela.", "", () -> {
			part16();
		}));
	}
	public static void part16() {
		juego.agregar(new Escena(10, "Finalmente Charles Darwin muere en la Abadía de Westminster el 19 de abril de 1882", "", () -> {
			part17();
		}));
	}
	
	public static void part17() {
		juego.setVisible(false);
		new Fin();
	}
	
}
