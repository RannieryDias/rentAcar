package Exceptions;

public class ClienteNaoExisteException extends Exception
{
	public ClienteNaoExisteException(String Cpf)
	{
		super("O cliente do CPF" + Cpf + " não está cadastrado");
	}

}
