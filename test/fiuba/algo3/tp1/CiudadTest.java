package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;

public class CiudadTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void Test01AgregarCiudad() {
		Ciudad unaCiudad = new Ciudad();
		
		unaCiudad.inicializarCiudad("BOG", "Bogota", "Colombia", 15.25, 15.25);
		
		Assert.assertNotNull(unaCiudad);
	}

	@Test
	public void Test02CalcularDistanciaEntreCiudades() {
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		
		ciudad1.inicializarCiudad("BOG", "Bogota", "Colombia", 15.25, 15.25);
		ciudad2.inicializarCiudad("COL", "Colonia", "Uruguay", 19.45, -45.20);
		
		double distanciaEsperada = 6401.64;
		
		assertEquals(distanciaEsperada, ciudad1.calcularDistanciaA(ciudad2), DELTA);
	}
	
	@Test
	public void Test03MismoPaisQue() {
		Ciudad ciudad1 = new Ciudad();
		Ciudad ciudad2 = new Ciudad();
		
		ciudad1.inicializarCiudad("BOG", "Bogota", "Colombia", 15.25, 15.25);
		ciudad2.inicializarCiudad("COL", "Colonia", "Uruguay", 19.45, -45.20);
		
		double tarifa = 1.5*1.05;
		
		assertEquals(ciudad1.tipoDeTarifa(ciudad2), tarifa, DELTA);
	}
	
}
