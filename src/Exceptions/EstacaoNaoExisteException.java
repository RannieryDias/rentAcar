package Exceptions;

public class EstacaoNaoExisteException extends Exception {

	public EstacaoNaoExisteException(int id) 
	{
		super("A esta�ao com o" + id + " n�o existe.");
	}
}
