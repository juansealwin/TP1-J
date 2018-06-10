package fiuba.algo3.tp1.excepciones;

public class PrecioNegativoError extends Exception{
	
	public static final long serialVersionUID = 700L;
	
	public PrecioNegativoError(String msj) {
		
		super(msj);
		
	}
}
