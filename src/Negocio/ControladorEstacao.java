package Negocio;

import Negocio.bean.Estacao;
import dados.RepositorioEstacao;
import exceptions.ClienteJaExisteException;
import exceptions.EstacaoJaExisteException;
import exceptions.EstacaoNaoExisteException;
import exceptions.RepositorioException;

public class ControladorEstacao 
{
	private RepositorioEstacao repositorio;
	private static int idEstacao = 1;

	public ControladorEstacao() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
		this.repositorio = new RepositorioEstacao();
	}
	
	public void cadastrar(Estacao estacao, int capacidade) throws EstacaoJaExisteException 
	{
		estacao.setCod(ControladorEstacao.idEstacao);
		estacao.setCapacidade(capacidade);
		boolean resposta = this.existe(estacao.getCod());

		if (resposta == false && estacao != null) 
		{
			repositorio.cadastrarEstacao(estacao);
			ControladorEstacao.idEstacao++;
		}	
		else throw new EstacaoJaExisteException();
	}

	public boolean existe(int id)
	{
		return this.repositorio.existe(id);
	}
	public Estacao procurar(int id) throws EstacaoNaoExisteException
	{
		return this.repositorio.procurar(id);
	}
	public void excluir(int id) throws EstacaoNaoExisteException
	{
      this.repositorio.removerEstacao(id);
    }
	public Estacao retornarEstacao(int id)
	{
		return this.repositorio.retornarEstacao(id);
	}
	public void alterarCapacidade(int capacidade)
	{
	   
	}
	public void alterar(Estacao estacao) throws RepositorioException,EstacaoNaoExisteException
	{
      boolean resposta = this.existe(estacao.getCod());

      if (resposta == false && estacao != null)
	  this.repositorio.alterarEstacao(estacao);
    }
}
