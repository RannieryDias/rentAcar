package exceptions;

public class EstacaoJaExisteException extends Exception
{
   public EstacaoJaExisteException()
   {
	   super("A Esta��o ja est� cadastrada");
   }
}
