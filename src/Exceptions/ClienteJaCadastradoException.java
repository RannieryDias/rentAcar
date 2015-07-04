package Exceptions;

public class ClienteJaCadastradoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ClienteJaCadastradoException(String cpf) {
		super("O cliente com o CPF \"" + cpf + "\" já foi cadastrado.");
	}
}
