package dados;

import Negocio.bean.Estacao;

public interface InterfaceRepositorioEstacao
{
  public void cadastrarEstacao(Estacao e);
  public Estacao procurar(String nomeEstacao);
  public void removerEstacao(String nomeEstacao);
}
