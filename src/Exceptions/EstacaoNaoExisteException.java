package Exceptions;

public class EstacaoNaoExisteException extends Exception {

	public EstacaoNaoExisteException(int id) 
	{
		super("A estaçao com o" + id + " não existe.");
	}
}
