package exceptions;

public class VeiculoAlugadoException extends Exception
{
	public VeiculoAlugadoException(String placa) {
		super("O Veiculo de placa " + placa + " já foi alugado.");
	}
	
}
