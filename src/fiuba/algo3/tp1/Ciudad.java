package fiuba.algo3.tp1;

public class Ciudad {

	private String codigoDeCiudad;
	private String nombreCiudad;
	private String nombreDePais;
	private double latitud;
	private double longitud;
	

	public Ciudad() {
		this.codigoDeCiudad = "Indefinido";
		this.nombreCiudad = "Indefinido";
		this.nombreDePais = "Indefinido";
		this.latitud = 0;
		this.longitud = 0;
	}
	
	public void inicializarCiudad(String codDeCiudad, String nomCiudad, String nomDePais, double latitudCiudad, double longitudCiudad) {
		this.codigoDeCiudad = codDeCiudad;
		this.nombreCiudad = nomCiudad;
		this.nombreDePais = nomDePais;
		this.latitud = latitudCiudad;
		this.longitud = longitudCiudad;
	}
	
	public double calcularDistanciaA (Ciudad ciudadDestino) {
		double radioTerrestre = 6371.00;
		double latitudInicial = Math.toRadians(this.latitud);
		double longitudInicial = Math.toRadians(this.longitud);
		double latitudFinal = Math.toRadians(ciudadDestino.latitud);
		double longitudFinal = Math.toRadians(ciudadDestino.longitud);
		
		double distanciaEntreCiudades = 0;
		
		distanciaEntreCiudades =  2 * radioTerrestre * 
                Math.asin(Math.sqrt(
                Math.pow(Math.sin((latitudFinal - latitudInicial) / 2), 2)
                + (Math.cos(latitudInicial) * Math.cos(latitudFinal) *
                Math.pow(Math.sin((longitudFinal - longitudInicial) / 2), 2))));

		
		return distanciaEntreCiudades;
	}

	public String devolverNombre() {
		return this.nombreCiudad;
	}

	public String devolverCodigo() {
		return this.codigoDeCiudad;
	}

	public double tipoDeTarifa(Ciudad ciudadDeDestino) {
		double tarifaVuelo = 1;
		
		if(this.nombreDePais != ciudadDeDestino.nombreDePais) {
			tarifaVuelo = 1*1.5*1.05;
		}
		
		return tarifaVuelo;
	}

}
