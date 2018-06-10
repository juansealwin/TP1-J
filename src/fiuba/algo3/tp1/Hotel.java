package fiuba.algo3.tp1;

public class Hotel {
	private String nombreHotel;
	private double costoPorNoche;
	
	public Hotel() {
		this.nombreHotel = "Indefinido";
		this.costoPorNoche = 0;
		}

	public void agregarNombre(String unNombre) {
		this.nombreHotel = unNombre;	
	}

	public void agregarPrecioPorNoche(int unPrecio) {
		this.costoPorNoche = unPrecio;
	}
	
	public String devolverNombre() {
		return this.nombreHotel;
	}

	public double obtenerPrecioPorNoche() {
		return this.costoPorNoche;
	}
	
}
