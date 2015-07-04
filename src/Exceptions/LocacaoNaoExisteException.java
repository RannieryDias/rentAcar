package exceptions;

public class LocacaoNaoExisteException extends Exception
{
	public LocacaoNaoExisteException(int IdLocacao) 
	{
		super("A locação Nº : " + IdLocacao + " não existe");
	}

}
