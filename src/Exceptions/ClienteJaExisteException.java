package Exceptions;

public class ClienteJaExisteException  extends Exception{
	public ClienteJaExisteException(String cpf) {
		super("O cliente com o CPF \"" + cpf + "\" j� foi cadastrado.");
	}

}
