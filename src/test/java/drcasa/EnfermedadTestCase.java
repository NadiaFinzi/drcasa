package drcasa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnfermedadTestCase {

	private Persona fede;
	private Infecciosa enfermedad;
	
	
	public void initFede() {
		enfermedad = new Infecciosa();
		fede = new Persona();
		fede.setCelulas(1000);
	}
	
	@Test
	public void enfermedadInfecciosaEsAgresiva() {
		initFede();
		enfermedad.setCelulasAmenazadas(150);
		
		boolean esAgresiva = enfermedad.esAgresiva(fede);
		
		Assert.assertTrue(esAgresiva);
	}
	
	private Persona initLogan(int dias) {
		
		int temperatura_inicial = 36, celulas_inicial = 3000000;
		
		Persona logan = new Persona(temperatura_inicial, celulas_inicial);
		
		Enfermedad malaria = new Infecciosa(500);
		Enfermedad otitis = new Infecciosa(100);
		Enfermedad lupus = new Autoinmune(10000);
		
		logan.contraer("malaria", malaria);
		logan.contraer("otitis", otitis);
		logan.contraer("lupus", lupus);
		logan.getEnfermedad("malaria").producirEfecto(logan);
		logan.pasarTiempo(dias);
		return logan;
	}
	
	@Test
	public void celulasAfectadas1DiaTest() {
		int dias = 1;
		Persona logan = initLogan(dias);
		int cantidadCelulasAfectadas = 0;
		for(Enfermedad enfermedad : logan.getEnfermedades().values()) {
			if(enfermedad.esAgresiva(logan)) {
				cantidadCelulasAfectadas += enfermedad.getCelulasAmenazadas();;
			}			
		}
		Assert.assertTrue(cantidadCelulasAfectadas==0);
	}
	
	@Test
	public void enfermedadMasNosiva1DiaTest() {
		int dias = 1;
		Persona logan = initLogan(dias);
		int maxCelulasAfectadas = 0;
		Enfermedad enfermedadMasNosiva = null;
		int celulasAmenazadasActuales = 0;
		for(Enfermedad enfermedad : logan.getEnfermedades().values()) {
			celulasAmenazadasActuales = enfermedad.getCelulasAmenazadas(); 
			if(celulasAmenazadasActuales > maxCelulasAfectadas) {
				maxCelulasAfectadas = celulasAmenazadasActuales;
				enfermedadMasNosiva = enfermedad;
			}
		}
		Assert.assertTrue(maxCelulasAfectadas==10000 && enfermedadMasNosiva.equals("lupus"));
	}
	
	@Test
	public void enComa1DiaTest() {
		int dias = 1;
		Persona logan = initLogan(dias);
		Assert.assertFalse(logan.estaEnComa());
	}
	
	@Test
	public void celulasAfectadas31DiasTest() {
		int dias = 31;
		Persona logan = initLogan(dias);
		int cantidadCelulasAfectadas = 0;
		for(Enfermedad enfermedad : logan.getEnfermedades().values()) {
			if(enfermedad.esAgresiva(logan)) {
				cantidadCelulasAfectadas += enfermedad.getCelulasAmenazadas();;
			}			
		}
		Assert.assertTrue(cantidadCelulasAfectadas==10000);
	}
	
	@Test
	public void enfermedadMasNosiva31DiasTest() {
		int dias = 31;
		Persona logan = initLogan(dias);
		int maxCelulasAfectadas = 0;
		Enfermedad enfermedadMasNosiva = null;
		int celulasAmenazadasActuales = 0;
		for(Enfermedad enfermedad : logan.getEnfermedades().values()) {
			celulasAmenazadasActuales = enfermedad.getCelulasAmenazadas(); 
			if(celulasAmenazadasActuales > maxCelulasAfectadas) {
				maxCelulasAfectadas = celulasAmenazadasActuales;
				enfermedadMasNosiva = enfermedad;
			}
		}
		//TODO:Cambiar esto
		Assert.assertTrue(maxCelulasAfectadas==10000 && enfermedadMasNosiva.equals("lupus"));
	}
	
	@Test
	public void enComa31DiasTest() {
		int dias = 31;
		Persona logan = initLogan(dias);
		Assert.assertTrue(logan.estaEnComa());
	}
	
}
