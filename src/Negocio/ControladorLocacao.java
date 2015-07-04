package Negocio;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Days;

import Negocio.bean.Cliente;
import Negocio.bean.Estacao;
import Negocio.bean.Locacao;
import Negocio.bean.Veiculo;
import dados.RepositorioLocacao;
import exceptions.AluguelComMultaInexistenteException;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.EstacaoNaoExisteException;
import exceptions.LocacaoNaoExisteException;
import exceptions.LocacaoPendenteException;
import exceptions.LocacoesNaoCadastradasException;
import exceptions.RepositorioException;
import exceptions.VeiculoAlugadoException;
import exceptions.VeiculoNaoExisteException;

public class ControladorLocacao 
{
	private RepositorioLocacao repositorio;
	private ControladorCliente cliente;
	private ControladorEstacao estacao;
	private ControladorVeiculo veiculo;
	private static int idAluguel =1;
	private List<Locacao> listaAlugueis;

	public ControladorLocacao() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
	  this.repositorio = new RepositorioLocacao();
	  this.cliente = new ControladorCliente();
	  this.estacao = new ControladorEstacao();
	}
	public void cadastrar(Locacao l) throws RepositorioException,LocacoesNaoCadastradasException 
	{
		if (l != null)
			repositorio.Cadastrar(l);
		else
			throw new LocacoesNaoCadastradasException("Impossível salvar o aluguel.");
	}
	public void cadastrar(String cpf,String placa) throws RepositorioException,LocacoesNaoCadastradasException 
	{
		Locacao locacao = this.procurar(cpf, placa);
		if (locacao != null)
			repositorio.Cadastrar(locacao);
		else
			throw new LocacoesNaoCadastradasException("Impossível salvar o aluguel.");
	}
	public void AlugarVeiculo(String CPF,int CodigoEstacao,String placa,Calendar dataDevolucao) throws VeiculoNaoExisteException, ClienteNaoExisteException, EstacaoNaoExisteException, VeiculoAlugadoException, LocacaoPendenteException, LocacoesNaoCadastradasException
	{
		if(this.cliente.existe(CPF))
		{
			if(this.estacao.existe(CodigoEstacao))
			{
			  if(this.aluguelPendente(CPF) != true)
			  {
				  if(this.veiculo.existe(placa))
				  {
					  if(this.veiculo.procurar(placa).getAlugado() != true)
					  {
						  Cliente cliente = this.cliente.procurar(CPF);
						  Estacao estacao = this.estacao.procurar(CodigoEstacao);
						  Veiculo veiculo = this.veiculo.procurar(placa);
						  veiculo.setAlugado(true);
						  
						  Locacao locacao = new Locacao(this.idAluguel,Calendar.getInstance(Locale.getDefault()),dataDevolucao,estacao,cliente,veiculo,veiculo.getValorLocacao());
						  repositorio.Cadastrar(locacao);
						  this.idAluguel ++;
					  }
					  else throw new VeiculoAlugadoException(placa);
				  }
				  else throw new VeiculoNaoExisteException(placa);
			  }
			  else throw new LocacaoPendenteException();
			}
			else throw new EstacaoNaoExisteException(CodigoEstacao);
		}
		else throw new ClienteNaoExisteException(CPF);
		
	}
	public void devolverVeiculo(String CPF,String Placa,int CodigoEstacao) throws LocacaoNaoExisteException, LocacoesNaoCadastradasException
	{
		if(this.repositorio.existeAluguelDevolucao(CPF, Placa) == true)
		{
			Locacao devolucaoAluguel = repositorio.procurarAluguelDevolucao(CPF, Placa);
			if(verificaMulta(devolucaoAluguel) == true)
			{
				float valor =calcularMulta(devolucaoAluguel);
				devolucaoAluguel.getCarro().setAlugado(false);
				devolucaoAluguel.setAtivado(false);
				devolucaoAluguel.setDataEntrega(Calendar.getInstance(Locale.getDefault()));
				Locacao PersistenciaLocacao = new Locacao(devolucaoAluguel.getIdLocacao(),devolucaoAluguel.getDataInicio(),devolucaoAluguel.getDataFim(),devolucaoAluguel.getEstacaoInicio(),devolucaoAluguel.getCliente(),devolucaoAluguel.getCarro(),valor,devolucaoAluguel.getDataEntrega());
				this.repositorio.alterarAluguel(PersistenciaLocacao);
			}
			else
			{
			    float valor = calcularAluguel(devolucaoAluguel);
			    devolucaoAluguel.getCarro().setAlugado(false);
			    devolucaoAluguel.setAtivado(false);
			    devolucaoAluguel.setDataEntrega(Calendar.getInstance(Locale.getDefault()));
			    Locacao PersistenciaLocacao = new Locacao(devolucaoAluguel.getIdLocacao(),devolucaoAluguel.getDataInicio(),devolucaoAluguel.getDataFim(),devolucaoAluguel.getEstacaoInicio(),devolucaoAluguel.getCliente(),devolucaoAluguel.getCarro(),valor);
			    this.repositorio.alterarAluguel(PersistenciaLocacao);
			}
		}
	}
	
	public float calcularAluguel(Locacao l)
	{
	  float resultado = 0;
	  
	  DateTime dataInicial = new DateTime(l.getDataInicio().get(Calendar.YEAR),l.getDataInicio().get(Calendar.MONTH),l.getDataInicio().get(Calendar.DATE),10,10,10);
	  DateTime dataFinal = new DateTime(l.getDataFim().get(Calendar.YEAR),l.getDataFim().get(Calendar.MONTH),l.getDataFim().get(Calendar.DATE),10,10,10);
	  
	  int dias = Days.daysBetween(dataInicial, dataFinal).getDays();
	  resultado = l.getValor() * dias;
	  return resultado;
		  
	}
	public float calcularMulta(Locacao l)
	{
		float resultado = calcularAluguel(l);
		DateTime dataInicial = new DateTime(l.getDataFim().get(Calendar.YEAR),l.getDataFim().get(Calendar.MONTH),l.getDataFim().get(Calendar.DATE),10,10,10);
		DateTime dataFinal = new DateTime(l.getDataEntrega().get(Calendar.YEAR),l.getDataEntrega().get(Calendar.MONTH),l.getDataEntrega().get(Calendar.DATE),10,10,10);
		  
		int dias = Days.daysBetween(dataInicial, dataFinal).getDays();
		resultado += l.getMulta() * dias;
		return resultado;
	}
	public List<Locacao> exibirLocacoesAtivas() throws LocacoesNaoCadastradasException 
	{
		return this.repositorio.exibirALugueisAtivos();
	}
	public List<Locacao> exibirLocacoesComMulta() throws AluguelComMultaInexistenteException, LocacoesNaoCadastradasException
	{
		if (this.repositorio.exibirALuguelComMulta().size() > 0)
			return repositorio.exibirALuguelComMulta();
		else
			throw new AluguelComMultaInexistenteException();
	}
	public List<Locacao> exibirLocacoesFinalizadas()throws LocacoesNaoCadastradasException
	{
		if (this.repositorio.exibirALuguelFinalizado().size() > 0) 
		{
			return repositorio.exibirALuguelFinalizado();
		} else
			throw new LocacoesNaoCadastradasException("Não existem locacoes Finalizadas");

	}
	private boolean aluguelPendente(String cpf) throws LocacoesNaoCadastradasException 
	{
		for (int i = 0; i < repositorio.exibirALugueisAtivos().size(); i++) 
		{
			if (repositorio.exibirALugueisAtivos().get(i).getCliente().getCpf().equals(cpf)) return true;
		}
		return false;
    }
	public boolean verificaMulta(Locacao l)
	{
		DateTime dataInicial = new DateTime(l.getDataFim().get(Calendar.YEAR),l.getDataFim().get(Calendar.MONTH),l.getDataFim().get(Calendar.DATE),10,10,10);
		DateTime dataFinal = new DateTime(l.getDataEntrega().get(Calendar.YEAR),l.getDataEntrega().get(Calendar.MONTH),l.getDataEntrega().get(Calendar.DATE),10,10,10);
		
		if(Days.daysBetween(dataInicial, dataFinal).getDays() == 0)
		{
			return false;
		}
		else return true;
		
	}
	public boolean existe(String cpf, String placa) 
	{
		return this.repositorio.existe(cpf, placa);
	}
	public void excluir(String cpf, String placa)throws LocacoesNaoCadastradasException
	{
	    this.repositorio.remover(cpf,placa);
	}
	public Locacao procurar(String cpf, String placa)throws  LocacoesNaoCadastradasException
	{
		if (this.repositorio.procurarLocacao(cpf, placa) != null) 
		{
			return this.repositorio.procurarLocacao(cpf, placa);
		} else
			throw new LocacoesNaoCadastradasException("Locação não existe");
	}
	public Locacao procurar(Integer id)throws LocacaoNaoExisteException
	{
		if (this.repositorio.procurarLocacao(id) != null) 
		{
			return this.repositorio.procurarLocacao(id);
		} else
			throw new LocacaoNaoExisteException(id);
	}
	public Locacao procurarAluguelFinalizado(String CPF,String placa) throws LocacoesNaoCadastradasException 
	{
		return this.repositorio.procurarAluguelFinalizado(CPF,placa);
	}
	public void AlterarLocacao(String Cpf,String placa) throws LocacoesNaoCadastradasException, LocacaoNaoExisteException
	{
		Locacao locacao = this.procurar(Cpf, placa);
		
		if(locacao != null)
		{
			this.repositorio.alterarAluguel(locacao);
		}
		else
		{
			throw new LocacoesNaoCadastradasException("A locacao não existe");
		}
		
	}
}

