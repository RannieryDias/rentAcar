package Exceptions;

public class EstacoesNaoExistemException extends Exception
{
	public EstacoesNaoExistemException()
	{
		super("Não exitem estacoes cadastradas");
	}

}
