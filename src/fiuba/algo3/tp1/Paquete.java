package fiuba.algo3.tp1;

public class Paquete extends Viaje{
		
	private double descuentoVuelos;
	private double descuentoHoteles;
	
	public Paquete() {
		super();
		this.descuentoVuelos = 0.9;
		this.descuentoHoteles = 0.8;
	}
	
	@Override
	public double obtenerCostoDelViaje() {
		double costoBasico = 0;
		double costoParcial = 0;
		double costoVuelos = 0;
		double costoEstadias = 0;
		
		for(Vuelo vueloActual: vuelos) {
			costoBasico = vueloActual.obtenerCosto(); 
			costoParcial = costoBasico;
			costoParcial += this.calcularCostoAdicionalesParaVuelo(vueloActual, costoBasico);
			costoVuelos += costoParcial;
		}
		
		for(Estadia estadiaActual: estadias) {
			costoBasico = estadiaActual.obtenerCosto(); 
			costoParcial = costoBasico;
			costoParcial += this.calcularCostoAdicionalesParaEstadia(estadiaActual, costoBasico);
			costoEstadias += costoParcial;
		}
		

		this.costoViaje = (costoVuelos * descuentoVuelos) + (costoEstadias * descuentoHoteles);
		
		return this.costoViaje;
	}
}
