package Exceptions;

public class ClientesNaoCadastradosException extends Exception
{
	public ClientesNaoCadastradosException()
	{
		super("Não há Clientes Cadastrados");
	}

}
