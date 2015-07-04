package exceptions;

public class LocacaoNaoExisteException extends Exception
{
	public LocacaoNaoExisteException(int IdLocacao) 
	{
		super("A loca��o N� : " + IdLocacao + " n�o existe");
	}

}
