package Exceptions;

public class VeiculoNaoExisteException extends Exception
{
	public VeiculoNaoExisteException(String placa) 
	{
		super("O veiculo de placa " + placa + " não existe.");
	}

}
