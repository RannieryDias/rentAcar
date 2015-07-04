package exceptions;

public class EstacaoJaExisteException extends Exception
{
   public EstacaoJaExisteException()
   {
	   super("A Estação ja está cadastrada");
   }
}
