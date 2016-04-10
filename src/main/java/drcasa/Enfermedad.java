package drcasa;

public interface Enfermedad {

	public boolean esAgresiva(Persona persona);

	public void setCelulasAmenazadas(int i);
	
	public int getCelulasAmenazadas();
	
	public void producirEfecto(Persona persona);
}
