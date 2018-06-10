package fiuba.algo3.tp1;

public class Vuelo {
	private Ciudad ciudadDePartida;
	private Ciudad ciudadDeDestino;
	
	public Vuelo() {
		this.ciudadDePartida = null;
		this.ciudadDeDestino = null;
	}

	public void crearNuevoVuelo(Ciudad ciudadPartida, Ciudad ciudadDestino) {
		this.ciudadDePartida = ciudadPartida;
		this.ciudadDeDestino = ciudadDestino;	
	}

	public double obtenerCosto() {
		
		double distanciaDeVuelo = ciudadDePartida.calcularDistanciaA(ciudadDeDestino);;
		double tarifaDeVuelo = ciudadDePartida.tipoDeTarifa(ciudadDeDestino);
		
		return tarifaDeVuelo*distanciaDeVuelo;
			
	}


}
