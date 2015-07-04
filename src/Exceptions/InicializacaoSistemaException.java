package exceptions;

public class InicializacaoSistemaException extends Exception {

	private static final long serialVersionUID = 1L;

	public InicializacaoSistemaException() {
		super("Erro no reposit�rio. O sistema n�o pode ser iniciado.");
	}
}