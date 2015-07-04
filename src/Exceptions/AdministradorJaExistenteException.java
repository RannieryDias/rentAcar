package exceptions;

public class AdministradorJaExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public AdministradorJaExistenteException(String cpf) {
		super("O administrador com o CPF \"" + cpf + "\" já foi cadastrado.");
	}

}
