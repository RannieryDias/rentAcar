package Exceptions;

public class EstacoesNaoExistemException extends Exception
{
	public EstacoesNaoExistemException()
	{
		super("N�o exitem estacoes cadastradas");
	}

}
