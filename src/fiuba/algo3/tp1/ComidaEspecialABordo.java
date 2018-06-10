package fiuba.algo3.tp1;

public class ComidaEspecialABordo extends Adicional{
	
	public ComidaEspecialABordo() {
	
	}
	
	@Override
	public double modificarCosto(Vuelo unVuelo, double costoEstadia) {
		return (+100);
	}
	
	@Override
	public double modificarCosto(Estadia estadia, double costoEstadia) {
		return 0;
	}

}
