package fiuba.algo3.tp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Viaje {
	protected String nombreViaje;
	protected double costoViaje;
	protected int duracionDelViaje;
	protected Date fechaPartida;
	protected Date fechaVuelta;
	protected Collection<Vuelo> vuelos;
	protected Collection<Estadia> estadias;
	protected Collection<Adicional> adicionales;
	private Collection<Paquete> paquetes;
	
	public Viaje() {
		this.nombreViaje = "Indefinido";
		this.costoViaje = 0;
		this.duracionDelViaje = 0;
		this.fechaPartida = null;
		this.fechaVuelta = null;
		this.vuelos = new ArrayList<Vuelo>();
		this.estadias = new ArrayList<Estadia>();
		this.paquetes = new ArrayList<Paquete>();
		this.adicionales = new ArrayList<Adicional>();
	}
	
	public void agregarNombre(String unNombre) {
		this.nombreViaje = unNombre;
	}
	
	public String devolverNombre() {
		return this.nombreViaje;
	}
	
	public double obtenerCostoDelViaje() {
		double costoBasico = 0;
		double costoParcial = 0;
		double costoVuelos = 0;
		double costoEstadias = 0;
		double costoPaquetes = 0;
		
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
		
		
		for(Paquete paqueteActual: paquetes) {
			costoPaquetes += paqueteActual.obtenerCostoDelViaje();
		}
		
		this.costoViaje = costoVuelos + costoEstadias + costoPaquetes;
		this.costoViaje = (double)Math.round(this.costoViaje * 100.0)/100.0;
		
		return this.costoViaje;
	}
	
	public double calcularCostoAdicionalesParaVuelo(Vuelo vueloActual , double costoBasico){
		double costoParcial = 0;
		double costoModificado = 0;
		
		for(Adicional adicionalActual: adicionales) {
			costoParcial = costoBasico;
			costoParcial = adicionalActual.modificarCosto(vueloActual, costoBasico);
			costoModificado += costoParcial;
		}
		return costoModificado;
	}
	
	public double calcularCostoAdicionalesParaEstadia(Estadia estadiaActual , double costoBasico){
		double costoParcial = 0;
		double costoModificado = 0;
		
		for(Adicional adicionalActual: adicionales) {
			costoParcial = costoBasico;
			costoParcial = adicionalActual.modificarCosto(estadiaActual, costoBasico);
			costoModificado += costoParcial;
		}
		return costoModificado;
	}
	
	public int obtenerDuracionEnDiasDelViaje() {
		
		if(!vuelos.isEmpty() || !estadias.isEmpty() || !paquetes.isEmpty()) {
			this.duracionDelViaje = ((int)((this.fechaVuelta.getTime()-this.fechaPartida.getTime())/86400000))+1;
		}
		
		return this.duracionDelViaje;
	}

	public void agregarVueloEnViaje(Ciudad ciudadPartida, Ciudad ciudadDestino, Date fechaDePartida) {
		
		Vuelo unVuelo = new Vuelo();
		
		this.modificarFechaDeViaje(fechaDePartida);
		
		unVuelo.crearNuevoVuelo(ciudadPartida, ciudadDestino);	
		this.vuelos.add(unVuelo);
		
	}
	
	public void agregarEstadiaEnViaje(Hotel unHotel, Date fechaEntrada, Date fechaSalida) {
		Estadia unaEstadia = new Estadia();
		this.modificarFechaDeViaje(fechaEntrada);
		this.modificarFechaDeViaje(fechaSalida);
		
		unaEstadia.crearNuevaEstadia(unHotel , fechaEntrada, fechaSalida);
		
		this.estadias.add(unaEstadia);
	}
	
	private void modificarFechaDeViaje(Date fechaDeVuelo) {
		if(this.fechaPartida == null && this.fechaVuelta == null) {
			this.fechaPartida = fechaDeVuelo;
			this.fechaVuelta = fechaDeVuelo;
		}
		
		if(this.fechaPartida.after(fechaDeVuelo)) {
			this.fechaPartida = fechaDeVuelo;
		}
		else if(this.fechaVuelta.before(fechaDeVuelo)) {
			this.fechaVuelta = fechaDeVuelo;
		}
	}

	public void agregarAsistenciaAlViajero() {
		AsistenciaAlViajero asistenciaViajero = new AsistenciaAlViajero();
		
		this.adicionales.add(asistenciaViajero);
	}

	public void agregarComidaEspecialAbordo() {
		ComidaEspecialABordo comidaEspecial = new ComidaEspecialABordo();
		
		this.adicionales.add(comidaEspecial);	
	}

	public void agregarPaquete(Paquete unPaquete) {
		this.paquetes.add(unPaquete);
		this.modificarFechaDeViaje(unPaquete.fechaPartida);
		this.modificarFechaDeViaje(unPaquete.fechaVuelta);
	}
}
