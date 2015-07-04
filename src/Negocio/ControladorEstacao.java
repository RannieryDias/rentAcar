package Negocio;

import java.util.ArrayList;
import java.util.List;









import Dados.RepositorioEstacao;
import Exceptions.ClienteJaExisteException;
import Exceptions.EstacaoJaExisteException;
import Exceptions.EstacaoNaoExisteException;
import Exceptions.EstacoesNaoExistemException;
import Exceptions.RepositorioException;
import Negocio.bean.Estacao;
import Negocio.bean.Veiculo;

public class ControladorEstacao 
{
	private RepositorioEstacao repositorio;
	private static int idEstacao = 1;

	public ControladorEstacao() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
		this.repositorio = new RepositorioEstacao();
	}
	
	public void cadastrar(Estacao estacao, int capacidade) throws EstacaoJaExisteException, EstacoesNaoExistemException 
	{
		int cod;
		if(this.repositorio.ListarEstacoes().size() == 0)
		{
			cod = 1;
		}	
		else
		{
			cod = this.repositorio.ListarEstacoes().size();	
		}
		
		estacao.setCod(cod);
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
	public Estacao procurar(String s) throws EstacaoNaoExisteException
	{
		return this.repositorio.ProcurarEstacao(s);
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
	public List<Estacao> ListarEstacoes() throws EstacoesNaoExistemException
	{
		return this.repositorio.ListarEstacoes();
		
	}

}
