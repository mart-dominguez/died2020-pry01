package died.proyecto01.problema02;

import java.util.ArrayList;

public class Equipo {
	
	public static final int MAX_PARTIDOS = 38;

	private String nombre;
	private ArrayList<Jugador> plantel;
	private Partido[] partidos;
	
	public Equipo(String nombre) {
		this();
		this.nombre =nombre;
	}
	
	public Equipo() {
		super();
//		this.plantel = new ArrayList<Jugador>(); EAGER ANSIOSO
	}
	
	public void registrarPartido(Equipo rival, int fecha,byte golesFavor, byte golesRecibidos) {
	}
	
	public void agregarJugador(Jugador j) {
		if(this.plantel == null) {   // LAZY o PEREZOSO
			this.plantel = new ArrayList<Jugador>();
		}
		this.plantel.add(j);
	}
	
	public void imprimirPlantel() {
		System.out.println(" Plantel del equipo "+ this.nombre);
		for(Jugador unJugador : this.plantel) {
			System.out.println(unJugador.toString());
		}
	}

	public Jugador mejorJugador() {
		Jugador jugadorEncontrado = null;
		double mejorRating = Double.MIN_VALUE;
		for(Jugador unJugador : this.plantel) {
			double ratingActual = unJugador.ratingJugador();
			if(ratingActual>mejorRating) {
				jugadorEncontrado = unJugador;
				mejorRating = ratingActual;
			}
		}
		return jugadorEncontrado;
	}

	public Jugador mejorJugador(Posicion posicion) {
		return null;
	}

	public Jugador masEficiente() {
		return null;
	}

	public int puntos() {
		return 0;
	}
}
