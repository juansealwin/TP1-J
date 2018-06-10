package fiuba.algo3.tp1;

import org.junit.Test;

import fiuba.algo3.tp1.excepciones.*;

public class ExcepcionesTest {
	
	@Test(expected = CoordenadaInvalidaError.class)
	public void test01CoordenadaInvalidaError() throws CoordenadaInvalidaError{
		AlgoTrip at = new AlgoTrip();

		at.verificarCoordenadas(90.25, -45.35);
		//Funcion interna en agregarCiudad
		//Latitud Inválida 90.25
	}
	
	@Test(expected = FechaInvalidaError.class)
	public void test02FechaInvalidaError() throws FechaInvalidaError{
		AlgoTrip at = new AlgoTrip();

		//Se puede ver que la fecha de entrada es posterior a la de salida, cosa que es imposible
		at.verificarFechas(at.convertirStrigADate("2018-05-05"), at.convertirStrigADate("1980-01-01"));
		//Funcion interna en agregarEstadia
	}	
	
	@Test(expected = InexistenteError.class)
	public void test03InexistenteError() throws InexistenteError{
		AlgoTrip at = new AlgoTrip();

		at.agregarCiudad("AAA", "nombreCiudad", "nombreDePais", 0, 0);
		at.buscarCiudadPorCodigo("BBB");
		//Como en AlgoTrip no se cargo ninguna ciudad con ese código, lanza una excepción
	}
	
	@Test(expected = PrecioNegativoError.class)
	public void test04PrecioNegativoError() throws PrecioNegativoError{
		AlgoTrip at = new AlgoTrip();

		at.verificarPrecio(-100);
		//Lanza una excepción ya que no puede existir un precio negativo
		//Funcion interna dentro de agregarHotel
	}
}
