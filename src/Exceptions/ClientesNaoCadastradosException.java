package Exceptions;

public class ClientesNaoCadastradosException extends Exception
{
	public ClientesNaoCadastradosException()
	{
		super("N�o h� Clientes Cadastrados");
	}

}
