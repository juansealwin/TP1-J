package fiuba.algo3.tp1;

public class AsistenciaAlViajero extends Adicional{

	public AsistenciaAlViajero(){
	
	}
	
	@Override
	public double modificarCosto(Vuelo unVuelo, double costoViaje) {
		return (costoViaje * 0.1);
	}
	
	@Override
	public double modificarCosto(Estadia estadia, double costoViaje) {
		return (estadia.obtenerDuracionDeEstadia() * 30);
	}
	
}
