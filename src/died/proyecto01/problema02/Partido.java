package died.proyecto01.problema02;

public class Partido {
	
	Equipo rival;
	int golesFavor;
	int golesRecibidos;
	
	public Partido() {
		super();
	}
	public Partido(Equipo rival, int golesFavor, int golesRecibidos) {
		super();
		this.rival = rival;
		this.golesFavor = golesFavor;
		this.golesRecibidos = golesRecibidos;
	}

	public Equipo getRival() {
		return rival;
	}

	public void setRival(Equipo rival) {
		this.rival = rival;
	}
	
	public int getGolesFavor() {
		return golesFavor;
	}
	
	public void setGolesFavor(int golesFavor) {
		this.golesFavor = golesFavor;
	}
	
	public int getGolesRecibidos() {
		return golesRecibidos;
	}
	
	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
	
}
