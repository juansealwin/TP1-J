package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AsistenciaAlViajeroTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ModificarCostoDeVuelo() {
		AsistenciaAlViajero asist = new AsistenciaAlViajero();
		Vuelo unVuelo = new Vuelo();
		double costoViaje = 10;
		double valorAgregado = 1;
		
		assertEquals(valorAgregado, asist.modificarCosto(unVuelo, costoViaje), DELTA);	
	}
	
	@Test
	public void test02ModificarCostoDeEstadia() {
		AsistenciaAlViajero asist = new AsistenciaAlViajero();
		double costoViaje = 10;
		double valorAgregado = 120;
		Estadia estadia = new Estadia();
		AlgoTrip at = new AlgoTrip();
		estadia.crearNuevaEstadia(null, at.convertirStrigADate("1999-01-01"), at.convertirStrigADate("1999-01-05"));
		
		assertEquals(valorAgregado, asist.modificarCosto(estadia, costoViaje), DELTA);	
	}
}
