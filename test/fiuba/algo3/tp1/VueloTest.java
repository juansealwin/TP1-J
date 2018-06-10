package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VueloTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void Test01ObtenerCostoVuelo() {
		Vuelo unVuelo = new Vuelo();
		Ciudad ciudadArg = new Ciudad();
		Ciudad ciudadBra = new Ciudad();
		ciudadArg.inicializarCiudad("ARG", "Santa Fe", "Argentina", 80, 43.51);
		ciudadBra.inicializarCiudad("BRA", "Buzios", "Brasil", -50.00, -33.05);
		
		double costoEsperado = 23950.65;
		
		unVuelo.crearNuevoVuelo(ciudadArg, ciudadBra);
		assertEquals(costoEsperado , unVuelo.obtenerCosto(), DELTA);
	}
}
