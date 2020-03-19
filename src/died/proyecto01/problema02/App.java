package died.proyecto01.problema02;

import java.nio.charset.Charset;
import java.util.Random;

public class App {

	private static Equipo[] superliga;
	
	public static void main(String[] args) {
		generarSuperliga(5);
		for(Equipo e : superliga) {
			e.imprimirPlantel();
			System.out.println("MEJOR JUGADOR");
			System.out.println(e.mejorJugador());
		}
	}
	
	private static void generarSuperliga(int n) {
		superliga = new Equipo[n];
		int i=0;
		while(i<n) {
			superliga[i]=new Equipo("Equipo "+i+" "+randomString(3));
			generarPlantel(superliga[i++]);
		}
	}

	private static void generarPlantel(Equipo e) {
		Random r = new Random();
		for(int i = 0; i<23; i++) {
			Jugador j = new Jugador();
			byte partidosJugados = (byte) (r.nextInt(34) + 1);
			j.setPartidos(partidosJugados);
			j.setMinutos(1+partidosJugados*r.nextInt(90));

			// generar valores aleatorios por puesto
			if(i<3) {
				j.setNombre("Arquero "+i);
				j.setPosicion(Posicion.ARQUERO);				
				j.setGolesRecibidos(r.nextInt(9));
				j.setPenalesAtajados(r.nextInt(15));
				j.setTirosAtajados(r.nextInt());
				j.setPasesExitosos(r.nextInt(33)*partidosJugados);
				j.setPasesTotales(j.getPasesExitosos()+1+r.nextInt(30));
				j.setGoles(0);
			} 
			if( i>=3 && i<10) {
				j.setNombre("Defensa "+i);
				j.setPosicion(Posicion.DEFENSOR);				
				j.setDespejes(r.nextInt(15)*partidosJugados);
				j.setQuites(r.nextInt(15)*partidosJugados);
				j.setPasesExitosos(r.nextInt(15)*partidosJugados);
				j.setPasesTotales(j.getPasesExitosos()+1+r.nextInt(30));
				j.setGoles((int) (r.nextDouble()*partidosJugados));
				j.setAsistencia(r.nextInt(5));
			}

			if( i>=10 && i<18) {
				j.setNombre("Medio "+i);
				j.setPosicion(Posicion.MEDIOCAMPISTA);				
				j.setDespejes(r.nextInt(10)*partidosJugados);
				j.setQuites(r.nextInt(10)*partidosJugados);
				j.setPasesExitosos(r.nextInt(30)*partidosJugados);
				j.setPasesTotales(j.getPasesExitosos()+1+r.nextInt(30));
				j.setGoles((int) (2*r.nextDouble()*partidosJugados));
				j.setAsistencia(r.nextInt(25));				
			}

			if( i>=18 && i<23) {
				j.setNombre("Delantero "+i);
				j.setPosicion(Posicion.DELANTERO);				
				j.setDespejes(r.nextInt(4)*partidosJugados);
				j.setQuites(r.nextInt(8)*partidosJugados);
				j.setPasesExitosos(r.nextInt(20)*partidosJugados);
				j.setPasesTotales(j.getPasesExitosos()+1+r.nextInt(30));
				j.setGoles((int) (3*r.nextDouble()*partidosJugados));
				j.setAsistencia(r.nextInt(18));
			}
			j.setSalario(100000*r.nextDouble());
			j.setNumeroCamiseta((byte)i);
			e.agregarJugador(j);
		}
	}

	
	public static String randomString(int n) {
	    Random r = new Random();
	    String s = "";
	    for(int i =0;i<n;i++) {	    	
		    short caracter = (short) (97 + r.nextInt(122-97));
		    char x = (char) caracter;
		    s +=x;
	    }
	    return s.toUpperCase();
	}
	
}
