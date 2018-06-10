package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaqueteTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ObtenerCostoDePaquete() {
		Paquete unPaquete = new Paquete();
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		Hotel unHotel = new Hotel();
		AlgoTrip at = new AlgoTrip();
		
		unHotel.agregarPrecioPorNoche(250);
		ciudad1.inicializarCiudad("NYC", "Nueva Yotk", "Estados Unidos", 50.05, 50.05);
		ciudad2.inicializarCiudad("MUN", "Munich", "Alemania", 0, 0);
		unPaquete.agregarNombre("Viajecito");
		unPaquete.agregarVueloEnViaje(ciudad1, ciudad2, at.convertirStrigADate("1999-01-01"));
		unPaquete.agregarVueloEnViaje(ciudad2, ciudad1, at.convertirStrigADate("1999-01-10"));
		unPaquete.agregarEstadiaEnViaje(unHotel, at.convertirStrigADate("1999-01-11"), at.convertirStrigADate("1999-01-15"));
		
		double costoEsperado =  (2 * 7299.90 * 1.5 * 1.05) * 0.9 + (4 * 250) * 0.8;
	
		assertEquals(costoEsperado, unPaquete.obtenerCostoDelViaje(), DELTA);
	}
}
