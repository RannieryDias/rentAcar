package exceptions;

public class AdministradorNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public AdministradorNaoExisteException(String cpf)
	{
		super("O Administrador com o CPF \"" + cpf + "\" n�o foi cadastrado.");
	}
}
