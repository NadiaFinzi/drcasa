package drcasa;

public class Infecciosa implements Enfermedad{
	protected int celulasAmenazadas;
	
	public Infecciosa() {
		this.celulasAmenazadas = 0;
	}
	public Infecciosa(int celulasAmenazadas) {
		this.celulasAmenazadas = celulasAmenazadas;
	}
	public boolean esAgresiva(Persona persona) {
		
		return porcentajeDeLaPersonaAmenazado(persona) > 0.1;
	}
	public double porcentajeDeLaPersonaAmenazado(Persona persona) {
		return (this.celulasAmenazadas * 100 / persona.getCelulas());
	}
	public int getCelulasAmenazadas() {
		return celulasAmenazadas;
	}
	public void setCelulasAmenazadas(int celulasAmenazadas) {
		this.celulasAmenazadas = celulasAmenazadas;
	}
	private void reproducirse() {
		this.celulasAmenazadas = this.celulasAmenazadas*2;
	}
	public void producirEfecto(Persona persona) {
		reproducirse();
		aumentarTemperatura(persona);
	}
	private void aumentarTemperatura(Persona persona) {
		persona.setTemperatura(persona.getTemperatura()+celulasAmenazadas*0.001);
	}
}
