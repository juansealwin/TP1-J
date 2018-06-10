package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class EstadiaTest {

	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ObtenerDiasDeEstadia() {
		Estadia unaEstadia = new Estadia();
		AlgoTrip at = new AlgoTrip();
		unaEstadia.crearNuevaEstadia(null, at.convertirStrigADate("2018-02-13"), at.convertirStrigADate("2018-02-24"));
		
		int diasEsperados = 11;
		
		assertEquals(diasEsperados, unaEstadia.obtenerDuracionDeEstadia());
	}
	
	@Test
	public void test02ObtenerCostoDeEstadia() {
		Estadia unaEstadia = new Estadia();
		AlgoTrip at = new AlgoTrip();
		Hotel unHotel = new Hotel();
		unHotel.agregarPrecioPorNoche(500);
		unaEstadia.crearNuevaEstadia(unHotel, at.convertirStrigADate("2018-02-13"), at.convertirStrigADate("2018-02-24"));

		double costoEsperado = 5500;
		
		assertEquals(costoEsperado, unaEstadia.obtenerCosto(), DELTA);
	}
}
