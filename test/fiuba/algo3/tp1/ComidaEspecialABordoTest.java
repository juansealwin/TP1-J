package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComidaEspecialABordoTest {

	private static final double DELTA = 1e-2;
	
	@Test
	public void test01ModificarCostoDeVuelo() {
		ComidaEspecialABordo comidaEspecial = new ComidaEspecialABordo();
		Vuelo unVuelo = new Vuelo();
		double costoEstadia = 10;
		double valorAgregado = 100;
		
		assertEquals(valorAgregado, comidaEspecial.modificarCosto(unVuelo, costoEstadia), DELTA);	
	}
	
	@Test
	public void test02ModificarCostoDeEstadia() {
		ComidaEspecialABordo comidaEspecial = new ComidaEspecialABordo();
		double costoEstadia = 10;
		double valorAgregado = 0;
		Estadia estadia = new Estadia();
		AlgoTrip at = new AlgoTrip();
		estadia.crearNuevaEstadia(null, at.convertirStrigADate("1999-01-01"), at.convertirStrigADate("1999-01-05"));
		
		assertEquals(valorAgregado, comidaEspecial.modificarCosto(estadia, costoEstadia), DELTA);	
	}
}
