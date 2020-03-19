package died.proyecto01.problema02;

/**
 * Clas
 * 
 * e que representa un jugador de futbol
 * @author marti
 *
 */
public class Jugador {
	
	private String nombre;
	private byte numeroCamiseta;
	private Posicion posicion;
	
	private int minutos;
	private byte partidos;
	
	private Integer goles;
	private int asistencia;
	
	private int quites;
	private int despejes;
	private int pasesTotales;
	private int pasesExitosos;
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", numeroCamiseta=" + numeroCamiseta + ", posicion=" + posicion
				+ ", salario=" + salario + ", ratingJugador()=" + ratingJugador() + "]";
	}



	private int penalesAtajados;
	private int tirosAtajados;
	private int golesRecibidos;
	
	private double salario;
		
	public Jugador() {
		super();
	}



	/**
	 * metodo para calcular el rating de un jugador
	 *  Si es arquero se toma un 90% de su puntuación como arquero y un 10% de su puntuación como defensor.
		Si es defensor se toma un 80% de su puntuación como defensor y un 20% de su puntuación como medicampista.
		Si es mediocampista se toma un 80% de su puntuación como mediocampista y un 10% de su puntuación como defensor y otro 10% como delantero.
		Si es delantero se toma un 90% de su puntuación como delantero y un 10% de su puntuación como mediocampista.

	 * @return
	 */
	public double ratingJugador() {
		double rating = 0.0;
		switch(this.posicion) {
			case ARQUERO:
				rating = 0.9*this.ratingArquero() + 0.1 * this.ratingDefensor();
				break;
			case DEFENSOR:
				rating = 0.8*this.ratingDefensor() + 0.2 * this.ratingMediocampista();
				break;
			case MEDIOCAMPISTA:
				rating = 0.8*this.ratingMediocampista() + 0.1 * this.ratingDefensor() +0.1 * ratingDelantero();
				break;
			case DELANTERO:
				rating = 0.9*this.ratingDelantero() + 0.1 * this.ratingMediocampista();
				break;
		}
		return rating;
	}
		
	
	
	/**
	 * El rating de arquero es una suma ponderada de
	 * 1- cantidad de tiros atajados por minuto jugado, con un máximo de 0.4
	 * 2- cantidad de goles recibidps por partido jugado, con un máximo de 0.3
	 * se toma como máximo un promedio de 3 goles por partido, 
	 * y en ese caso contribuye 0 al rating
	 * 3- cantidad de penales atajados, con un máximo de 0.3
	 * 
	 * @return
	 */
	private double ratingArquero() {
		// TODO que retorna el cociente entre un int y un byte?
		double atajado = Math.min(this.tirosAtajados/this.minutos, 0.4);
		double promedioGol = 1- (Math.min(this.golesRecibidos/this.partidos, 3)/3);
		double goles =   Math.min(promedioGol, 0.3);
		double penales = Math.min(this.penalesAtajados/10, 0.3);
		return atajado + goles + penales;
	}
		

	private double ratingDefensor() {
		double quites= Math.min(this.quites/this.minutos, 0.4);
		double despejes= Math.min(this.despejes/this.minutos, 0.4);
		double pases = Math.min((this.pasesExitosos/this.pasesTotales)/8, 0.1);
		double goles =   Math.min(this.goles/20, 0.1);
		return quites+despejes+pases+goles;
	}

	
	private double ratingMediocampista() {
		double asistencias= Math.min(this.asistencia/10, 0.2);
		double quites= Math.min(this.quites/this.minutos, 0.3);
		double pases = Math.min((this.pasesExitosos/this.pasesTotales)/3, 0.3);
		double goles =   Math.min(this.goles/50, 0.2);
		return asistencias + quites + pases + goles;
	}

	
	private double ratingDelantero() {
		double asistencias= Math.min(this.asistencia/10, 0.2);
		double quites= Math.min(this.quites/this.minutos, 0.1);
		double pases = Math.min((this.pasesExitosos/this.pasesTotales)/8, 0.1);
		double goles =   Math.min(this.goles/50, 0.6);
		return asistencias + quites + pases + goles;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public byte getNumeroCamiseta() {
		return numeroCamiseta;
	}



	public void setNumeroCamiseta(byte numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}



	public Posicion getPosicion() {
		return posicion;
	}



	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}



	public int getMinutos() {
		return minutos;
	}



	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}



	public int getPartidos() {
		return partidos;
	}



	public void setPartidos(byte partidos) {
		this.partidos = partidos;
	}



	public Integer getGoles() {
		return goles;
	}



	public void setGoles(Integer goles) {
		this.goles = goles;
	}



	public int getAsistencia() {
		return asistencia;
	}



	public void setAsistencia(int asistencia) {
		this.asistencia = asistencia;
	}



	public int getQuites() {
		return quites;
	}



	public void setQuites(int quites) {
		this.quites = quites;
	}



	public int getDespejes() {
		return despejes;
	}



	public void setDespejes(int despejes) {
		this.despejes = despejes;
	}



	public int getPasesTotales() {
		return pasesTotales;
	}



	public void setPasesTotales(int pasesTotales) {
		this.pasesTotales = pasesTotales;
	}



	public int getPasesExitosos() {
		return pasesExitosos;
	}



	public void setPasesExitosos(int pasesExitosos) {
		this.pasesExitosos = pasesExitosos;
	}



	public int getPenalesAtajados() {
		return penalesAtajados;
	}



	public void setPenalesAtajados(int penalesAtajados) {
		this.penalesAtajados = penalesAtajados;
	}



	public int getTirosAtajados() {
		return tirosAtajados;
	}



	public void setTirosAtajados(int tirosAtajados) {
		this.tirosAtajados = tirosAtajados;
	}



	public int getGolesRecibidos() {
		return golesRecibidos;
	}



	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}


	
	
}
