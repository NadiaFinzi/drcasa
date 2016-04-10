package drcasa;

import java.util.HashMap;
import java.util.Map;

public class Persona {
	private int celulas;
	private double temperatura;
	private Map <String, Enfermedad> enfermedades = new HashMap<String, Enfermedad> ();
	private Map <Enfermedad, Integer> cantidadTiempoEnfermo = new HashMap<Enfermedad, Integer> ();
	
	public Persona() {
		this.celulas = 0;
		this.temperatura = 0;
	}	
	public Persona(int celulas, int temperatura) {
		this.celulas = celulas;
		this.temperatura = temperatura;
	}
	
	public void contraer (String nombreEnfermedad, Enfermedad enfermedad) {
		if (enfermedad instanceof Infecciosa) {
			temperatura += ((Infecciosa) enfermedad).getCelulasAmenazadas()/1000;
		}
		if (enfermedad instanceof Autoinmune) {
			celulas = celulas - ((Autoinmune) enfermedad).getCelulasAmenazadas();			
		}
		enfermedades.put(nombreEnfermedad, enfermedad);
		cantidadTiempoEnfermo.put(enfermedad, new Integer(0));
	}
	
	public void setCelulas(int celulas) {
		this.celulas = celulas;
	}
	public int getCelulas() {
		return celulas;
	}
	public Map<String, Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	public Enfermedad getEnfermedad(String nombreEnfermedad) {
		return enfermedades.get(nombreEnfermedad);
	}
	public void pasarTiempo(int dias) {		
		for(int i = 0; i < dias; i++) {
			for(Enfermedad enfermedad : enfermedades.values()) {			
				enfermedad.producirEfecto(this);
			}			
		}
	}
	public Map<Enfermedad, Integer> getCantidadTiempoEnfermo() {
		return cantidadTiempoEnfermo;
	}
	
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public boolean estaEnComa() {
		if (this.getTemperatura() > 45 || this.getCelulas() < 1000000) {
			return true;
		}
		return false;
	}
	
	
}
