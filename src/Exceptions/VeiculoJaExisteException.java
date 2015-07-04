package exceptions;

public class VeiculoJaExisteException extends Exception
{
	public VeiculoJaExisteException() {
		super("O veiculo ja existe");
	}
}
