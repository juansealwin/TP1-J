package fiuba.algo3.tp1;

import java.util.Date;

public class Estadia {
	
	private double costoEstadia;
	private Hotel hotelEstadia;
	private Date fechaDeEntrada;
	private Date fechaDeSalida;
	
	public Estadia() {
		this.costoEstadia = 0;
		this.hotelEstadia = null;
		this.fechaDeEntrada = null;
		this.fechaDeSalida = null;	
	}
	
	public void crearNuevaEstadia(Hotel unHotel, Date fechaEntrada, Date fechaSalida) {
		this.hotelEstadia = unHotel;
		this.fechaDeEntrada = fechaEntrada;
		this.fechaDeSalida = fechaSalida;
	}
	
	public double obtenerCosto() {
		int diasEstadia =(int) ((this.fechaDeSalida.getTime()-this.fechaDeEntrada.getTime())/86400000);
		
		this.costoEstadia = diasEstadia * (hotelEstadia.obtenerPrecioPorNoche());
		
		return this.costoEstadia;
	}

	public int obtenerDuracionDeEstadia() {
		return ((int)((this.fechaDeSalida.getTime()-this.fechaDeEntrada.getTime())/86400000));
	}
}
