package drcasa;

public class Autoinmune implements Enfermedad {
	protected int celulasAmenazadas;
	
	public Autoinmune(int celulasAmenazadas) {
		this.celulasAmenazadas = celulasAmenazadas;
	}
	
	public boolean esAgresiva(Persona persona) {
		if (persona.getCantidadTiempoEnfermo().get(this).intValue()>30) {
			return true;
		}
		return false;
	}

	public void setCelulasAmenazadas(int celulasAmenazadas) {
		this.celulasAmenazadas = celulasAmenazadas;
	}
	
	public int getCelulasAmenazadas() {
		return celulasAmenazadas;
	}
	
	public void producirEfecto(Persona persona) {
		destruirCelulas(persona);		
	}	
	private void destruirCelulas(Persona persona) {
		persona.setCelulas(persona.getCelulas()-this.celulasAmenazadas);		
	}
}
