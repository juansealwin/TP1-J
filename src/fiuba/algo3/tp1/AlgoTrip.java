package fiuba.algo3.tp1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import fiuba.algo3.tp1.excepciones.CoordenadaInvalidaError;
import fiuba.algo3.tp1.excepciones.FechaInvalidaError;
import fiuba.algo3.tp1.excepciones.InexistenteError;
import fiuba.algo3.tp1.excepciones.PrecioNegativoError;


public class AlgoTrip {
	
	private Collection<Viaje> viajes;
	private Collection<Ciudad> ciudades;
	private Collection<Hotel> hoteles;
	private Collection<Paquete> paquetes;
	
	public AlgoTrip() {
		this.viajes = new ArrayList<Viaje>();
		this.ciudades = new ArrayList<Ciudad>();
		this.hoteles = new ArrayList<Hotel>();
		this.paquetes = new ArrayList<Paquete>();
	}
	
	public void crearViaje(String nombreViaje) {
		Viaje unViaje = new Viaje();
		unViaje.agregarNombre(nombreViaje);
		viajes.add(unViaje);
	}
	
	
	public Viaje buscarViajePorNombre (String nombreViaje) throws InexistenteError{
		
		
		for(Viaje viajeActual: viajes) {
			if(viajeActual.devolverNombre() == nombreViaje) {
				return viajeActual;
			}
		}
		throw new InexistenteError("El viaje no existe");
	}
	
	public Ciudad buscarCiudadPorCodigo (String codigoCiudad) throws InexistenteError{
			for(Ciudad ciudadActual: ciudades) {		
				if(codigoCiudad.contentEquals(ciudadActual.devolverCodigo())) {
					return ciudadActual;
				}
			}		
			throw new InexistenteError("La ciudad no existe");
	}
	
	public Paquete buscarPaquetePorNombre (String nombrePaquete) throws InexistenteError{

		for(Paquete paqueteActual: paquetes) {
			if(paqueteActual.devolverNombre() == nombrePaquete) {
				return paqueteActual;
			}
		}
		throw new InexistenteError("El paquete no existe");
	}
	
	public Hotel buscarHotelPorNombre (String nombreHotel) throws InexistenteError{
		
		for(Hotel hotelActual: hoteles) {

			if(hotelActual.devolverNombre() == nombreHotel) {
				return hotelActual;
			}
		}
		throw new InexistenteError("El hotel no existe");
	}
	
	public Date convertirStrigADate(String fechaString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = sdf.parse(fechaString);
			
		}
		catch (ParseException e) {
            e.printStackTrace();
		}
		return fecha;

	}
	
	public double obtenerCostoDelViaje(String nombreViaje){
		Viaje unViaje = null;
		try {
			unViaje = this.buscarViajePorNombre(nombreViaje);
		} catch (InexistenteError e) {
			e.printStackTrace();
		}
		return unViaje.obtenerCostoDelViaje();	
	}
	
	public int obtenerDuracionEnDiasDelViaje(String nombreViaje) {
		Viaje unViaje = null;
		
		try {	
			unViaje = this.buscarViajePorNombre(nombreViaje);	
		} catch (InexistenteError e) {
			e.printStackTrace();
		}
		return unViaje.obtenerDuracionEnDiasDelViaje();
	}
	
	public void verificarCoordenadas(double latitud, double longitud) throws CoordenadaInvalidaError{
		if(latitud > 85 || latitud < -85) {
			throw new CoordenadaInvalidaError("Latitud Inválida");
		}
		if(longitud > 180 || longitud < -180) {
			throw new CoordenadaInvalidaError("Longitud Inválida");
		}
		return;
	}
	
	public void agregarCiudad(String codigoDeCiudad, String nombreCiudad, String nombreDePais, double latitud, double longitud){		
		Ciudad unaCiudad = new Ciudad();	
		try {
			this.verificarCoordenadas(latitud, longitud);
		} catch (CoordenadaInvalidaError e) {
			e.printStackTrace();
		}
		
		for(Ciudad ciudadActual: ciudades) {
			if(ciudadActual.devolverCodigo() == codigoDeCiudad) {
				ciudadActual.inicializarCiudad(codigoDeCiudad, nombreCiudad, nombreDePais, latitud, longitud);
				return;
			}
		}
		unaCiudad.inicializarCiudad(codigoDeCiudad, nombreCiudad, nombreDePais, latitud, longitud);
		this.ciudades.add(unaCiudad);
		return;
					
	}

	public void agregarVueloEnViaje(String nombreViaje, String codigoCiudadPartida, String codigoCiudadDestino, String fechaDePartida) {

		try {
			Viaje unViaje = this.buscarViajePorNombre(nombreViaje);
			Date fechaPartida = this.convertirStrigADate(fechaDePartida);
			Ciudad ciudadDePartida = this.buscarCiudadPorCodigo(codigoCiudadPartida);
			Ciudad ciudadDeDestino = this.buscarCiudadPorCodigo(codigoCiudadDestino);
			unViaje.agregarVueloEnViaje(ciudadDePartida, ciudadDeDestino, fechaPartida);
			
		} catch (InexistenteError e) {
			e.printStackTrace();
		}

	}
	
	public void verificarPrecio(int precio) throws PrecioNegativoError{
		if(precio < 0) {
			throw new PrecioNegativoError("Precio incorrecto, no puede ser negativo");
		}
		return;
	}
	
	public void agregarHotel(String nombreHotel, String codigoDeCiudad, int precioPorNoche) {
		try {
			this.verificarPrecio(precioPorNoche);
			Hotel unHotel = new Hotel();
			unHotel.agregarNombre(nombreHotel);
			unHotel.agregarPrecioPorNoche(precioPorNoche);
			this.hoteles.add(unHotel);
		} catch (PrecioNegativoError e) {
			e.printStackTrace();
		}
		
	}
	
	public void agregarEstadiaEnViaje(String nombreViaje, String nombreHotel, String fechaEntrada, String fechaSalida){
		

		try {
			Viaje unViaje = buscarViajePorNombre(nombreViaje);		
			Hotel unHotel = buscarHotelPorNombre(nombreHotel);
			Date fechaEnt = this.convertirStrigADate(fechaEntrada);
			Date fechaSal = this.convertirStrigADate(fechaSalida);
			try {
				this.verificarFechas(fechaEnt, fechaSal);
			} catch (FechaInvalidaError e){
				e.printStackTrace();
			}
			unViaje.agregarEstadiaEnViaje(unHotel, fechaEnt, fechaSal);
		
		} catch (InexistenteError e) {
			e.printStackTrace();
		}

	}

	public void agregarAsistenciaAlViajeroAlViaje(String nombreViaje) {
		try {
			Viaje unViaje = buscarViajePorNombre(nombreViaje);
			unViaje.agregarAsistenciaAlViajero();
		} catch (InexistenteError e) {
			e.printStackTrace();
		}
	}

	public void solicitarComidaEspecialAbordoPara(String nombreViaje){
		try {
			Viaje unViaje = buscarViajePorNombre(nombreViaje);
			unViaje.agregarComidaEspecialAbordo();
		} catch (InexistenteError e) {

			e.printStackTrace();
		}
	}

	public void agregarPaquete(String nombrePaquete) {
		Paquete unPaquete = new Paquete();
		unPaquete.agregarNombre(nombrePaquete);
		this.paquetes.add(unPaquete);	
		
	}

	public void agregarVueloEnPaquete(String nombrePaquete, String codigoCiudadPartida, String codigoCiudadDestino, String fechaDePartida){
		try {
			Paquete unPaquete = this.buscarPaquetePorNombre(nombrePaquete);
			Date fechaPartida = new Date();
			Ciudad ciudadPartida = this.buscarCiudadPorCodigo(codigoCiudadPartida);
			Ciudad ciudadDestino = this.buscarCiudadPorCodigo(codigoCiudadDestino);
			
			fechaPartida = this.convertirStrigADate(fechaDePartida);

			unPaquete.agregarVueloEnViaje(ciudadPartida, ciudadDestino, fechaPartida);
		} catch (InexistenteError e) {
			e.printStackTrace();
		}
	
	}

	public void verificarFechas(Date fechaEntrada, Date fechaSalida) throws FechaInvalidaError {
		if(fechaEntrada.after(fechaSalida)) {
			throw new FechaInvalidaError("Fecha inválida error");
		}
	}
	
	public void agregarEstadiaEnPaquete(String nombrePaquete, String nombreHotel, String fechaEntrada, String fechaSalida){
		try {
			Paquete unPaquete = buscarPaquetePorNombre(nombrePaquete);
			Hotel unHotel = buscarHotelPorNombre(nombreHotel);
			Date fechaEnt = this.convertirStrigADate(fechaEntrada);
			Date fechaSal = this.convertirStrigADate(fechaSalida);
			try {
				this.verificarFechas(fechaEnt, fechaSal);
			}catch (FechaInvalidaError e) {	
				e.printStackTrace();
			}		
			unPaquete.agregarEstadiaEnViaje(unHotel, fechaEnt, fechaSal);
		} catch (InexistenteError e) {	
			e.printStackTrace();
		}		
	}

	public void agregarPaqueteEnViaje(String nombreViaje, String nombrePaquete) {
		Paquete unPaquete;
		try {
			unPaquete = buscarPaquetePorNombre(nombrePaquete);
			Viaje unViaje = buscarViajePorNombre(nombreViaje);  
			unViaje.agregarPaquete(unPaquete);
		} catch (InexistenteError e) {
			e.printStackTrace();
		}
		
		
	}
	
}
