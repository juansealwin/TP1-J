package fiuba.algo3.tp1.excepciones;

public class InexistenteError extends Exception{
	
	public static final long serialVersionUID = 700L;
	
	public InexistenteError(String msj) {
		
		super(msj);
		
	}
}