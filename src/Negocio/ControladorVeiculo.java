package Negocio;


import Dados.RepositorioEstacao;
import Dados.RepositorioVeiculo;
import Exceptions.EstacaoNaoExisteException;
import Exceptions.VeiculoJaExisteException;
import Exceptions.VeiculoNaoExisteException;
import Negocio.bean.Estacao;
import Negocio.bean.Veiculo;



public class ControladorVeiculo
{
	
	private ControladorEstacao estacao;
	private RepositorioVeiculo repositorio;
	private RepositorioEstacao repositorioE;
	private static int idVeiculo = 1;
	
	public ControladorVeiculo() throws ClassNotFoundException, VeiculoNaoExisteException
	{
		this.repositorio = new RepositorioVeiculo();
		
	}
	public void cadastrar(Veiculo veiculo,int CodEstacao) throws VeiculoNaoExisteException, VeiculoJaExisteException, EstacaoNaoExisteException
	{
		boolean indice = this.existe(veiculo.getPlaca());
		if (indice == false && veiculo != null) 
		{
			if(this.estacao.existe(CodEstacao))
			{
			  repositorio.cadastrar(veiculo);	
			  estacao.procurar(CodEstacao).cadastrar(veiculo);
			  veiculo.setEstacaoatual(CodEstacao);
			  veiculo.setId(ControladorVeiculo.idVeiculo);
			  ControladorVeiculo.idVeiculo ++;
			}
			else
				throw new EstacaoNaoExisteException(CodEstacao);
		} 
		else throw new VeiculoJaExisteException();
	}
	public Veiculo procurar(String placa) throws VeiculoNaoExisteException, EstacaoNaoExisteException
	{
       return this.repositorio.procurar(placa);
	}
	public void removercarro(String placa) throws VeiculoNaoExisteException, EstacaoNaoExisteException
	{
		Veiculo veiculo = repositorio.procurar(placa);
		Estacao estacao = repositorioE.procurar(veiculo.getEstacaoatual());
		estacao.removerVeiculo(veiculo.getPlaca());
		this.repositorio.removerCarro(placa);
	}
	public boolean existe(String placa) throws VeiculoNaoExisteException {
		return this.repositorio.existe(placa);
	}
}
