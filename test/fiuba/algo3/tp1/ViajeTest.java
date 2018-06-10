package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ViajeTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01NuevoViajeVacio() {
		Viaje unViaje = new Viaje();
		unViaje.agregarNombre("Un nombre");
		
		assertEquals(0, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(0, unViaje.obtenerDuracionEnDiasDelViaje());
	}
	
	@Test
	public void test02ViajeConVueloNacional() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		AlgoTrip at = new AlgoTrip();
		
		ciudad1.inicializarCiudad("AAA", "nombreCiudad1", "nombrePais", 50.05, 50.05);
		ciudad2.inicializarCiudad("BBB", "nombreCiudad2", "nombrePais", -50.05, -50.05);
		unViaje.agregarNombre("Viaje Nacional");
		unViaje.agregarVueloEnViaje(ciudad1, ciudad2, at.convertirStrigADate("1999-01-01"));
		double costoEsperado = 14599.79;
		
		assertEquals(costoEsperado , unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(1, unViaje.obtenerDuracionEnDiasDelViaje());
	}
	
	@Test
	public void test03ViajeConVueloInternacional() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		AlgoTrip at = new AlgoTrip();
		
		ciudad1.inicializarCiudad("AAA", "nombreCiudad1", "nombrePais", 50.00, 50.00);
		ciudad2.inicializarCiudad("BBB", "nombreCiudad2", "nombrePais2", 0, 0);
		unViaje.agregarNombre("Viaje Internacional");
		unViaje.agregarVueloEnViaje(ciudad1, ciudad2, at.convertirStrigADate("1999-01-01"));
		
		double costoEsperado = 7293.88 * 1.5 * 1.05;
		
		assertEquals(costoEsperado, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(1, unViaje.obtenerDuracionEnDiasDelViaje());
		
	}
	
	@Test
	public void test04ViajeConTresVuelos() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		Ciudad ciudad3 = new Ciudad();
		AlgoTrip at = new AlgoTrip();
		
		ciudad1.inicializarCiudad("VAN", "Vancouver", "Candá", 50.05, 50.05);
		ciudad2.inicializarCiudad("DUB", "Dublin", "Irlanda", 0, 0);
		ciudad3.inicializarCiudad("OTW", "Ottawa", "Canadá", 75, 40);
		unViaje.agregarNombre("Viaje Norte");
		unViaje.agregarVueloEnViaje(ciudad1, ciudad2, at.convertirStrigADate("1999-01-01"));
		unViaje.agregarVueloEnViaje(ciudad2, ciudad3, at.convertirStrigADate("1999-01-05"));
		unViaje.agregarVueloEnViaje(ciudad3, ciudad1, at.convertirStrigADate("1999-01-15"));
		
		double costoEsperado = 18848.44 * 1.5 * 1.05;
	
		assertEquals(costoEsperado, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(15, unViaje.obtenerDuracionEnDiasDelViaje());
		
	}
	
	@Test
	public void test05ViajeConEstadias() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		Hotel unHotel = new Hotel();
		AlgoTrip at = new AlgoTrip();
		
		unHotel.agregarPrecioPorNoche(250);
		ciudad1.inicializarCiudad("VAN", "Vancouver", "Candá", 50.05, 50.05);
		ciudad2.inicializarCiudad("DUB", "Dublin", "Irlanda", 0, 0);
		unViaje.agregarNombre("Viaje Norte");
		unViaje.agregarVueloEnViaje(ciudad1, ciudad2, at.convertirStrigADate("1999-01-01"));
		unViaje.agregarVueloEnViaje(ciudad2, ciudad1, at.convertirStrigADate("1999-01-10"));
		unViaje.agregarEstadiaEnViaje(unHotel, at.convertirStrigADate("1999-01-11"), at.convertirStrigADate("1999-01-15"));
		
		double costoEsperado =  2 * 7299.90 * 1.5 * 1.05 + 4 * 250;
	
		assertEquals(costoEsperado, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(15, unViaje.obtenerDuracionEnDiasDelViaje());
	}
	
	@Test
	public void test06ViajeConAsistenciaAlViajero() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		Hotel unHotel = new Hotel();
		AlgoTrip at = new AlgoTrip();
		
		unHotel.agregarPrecioPorNoche(250);
		ciudad1.inicializarCiudad("VAN", "Vancouver", "Candá", 50.05, 50.05);
		ciudad2.inicializarCiudad("DUB", "Dublin", "Irlanda", 0, 0);
		unViaje.agregarNombre("Viaje Norte");
		unViaje.agregarVueloEnViaje(ciudad2, ciudad1, at.convertirStrigADate("1999-01-10"));
		unViaje.agregarEstadiaEnViaje(unHotel, at.convertirStrigADate("1999-01-11"), at.convertirStrigADate("1999-01-15"));
		unViaje.agregarAsistenciaAlViajero();
		double costoEsperado = 7299.90 * 1.5 * 1.05 * 1.1 + 4 * 250 + 4 * 30;
	
		assertEquals(costoEsperado, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(6, unViaje.obtenerDuracionEnDiasDelViaje());
		
	}
	
	@Test
	public void test07ViajeConComidaEspecial() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		Hotel unHotel = new Hotel();
		AlgoTrip at = new AlgoTrip();
		
		unHotel.agregarPrecioPorNoche(250);
		ciudad1.inicializarCiudad("VAN", "Vancouver", "Candá", 50.05, 50.05);
		ciudad2.inicializarCiudad("DUB", "Dublin", "Irlanda", 0, 0);
		unViaje.agregarNombre("Viaje Norte");
		unViaje.agregarVueloEnViaje(ciudad2, ciudad1, at.convertirStrigADate("1999-01-10"));
		unViaje.agregarEstadiaEnViaje(unHotel, at.convertirStrigADate("1999-01-11"), at.convertirStrigADate("1999-01-15"));
		unViaje.agregarComidaEspecialAbordo();
		double costoEsperado = 7299.90 * 1.5 * 1.05 + 4 * 250 + 100;
	
		assertEquals(costoEsperado, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(6, unViaje.obtenerDuracionEnDiasDelViaje());
		
	}
	
	@Test
	public void test08ViajeConPaquete() {
		Viaje unViaje = new Viaje();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		Hotel unHotel = new Hotel();
		Paquete unPaquete = new Paquete();
		AlgoTrip at = new AlgoTrip();
		
		unHotel.agregarPrecioPorNoche(250);
		ciudad1.inicializarCiudad("VAN", "Vancouver", "Candá", 50.05, 50.05);
		ciudad2.inicializarCiudad("DUB", "Dublin", "Irlanda", 0, 0);
		unPaquete.agregarNombre("Viaje Norte");
		unPaquete.agregarVueloEnViaje(ciudad2, ciudad1, at.convertirStrigADate("1999-01-10"));
		unPaquete.agregarEstadiaEnViaje(unHotel, at.convertirStrigADate("1999-01-11"), at.convertirStrigADate("1999-01-15"));
		unPaquete.agregarComidaEspecialAbordo();
		unViaje.agregarPaquete(unPaquete);
		double costoEsperado = ((7299.90 * 1.5 * 1.05 + 100) * 0.9) + (4 * 250 * 0.8) ;
	
		assertEquals(costoEsperado, unViaje.obtenerCostoDelViaje(), DELTA);
		assertEquals(6, unViaje.obtenerDuracionEnDiasDelViaje());
	}
}
