package Negocio;

import java.util.Calendar;
import java.util.List;

import Exceptions.AdministradorJaExistenteException;
import Exceptions.AdministradorNaoExisteException;
import Exceptions.AluguelComMultaInexistenteException;
import Exceptions.ClienteJaExisteException;
import Exceptions.ClienteNaoExisteException;
import Exceptions.ClientesNaoCadastradosException;
import Exceptions.EstacaoJaExisteException;
import Exceptions.EstacaoNaoExisteException;
import Exceptions.EstacoesNaoExistemException;
import Exceptions.InicializacaoSistemaException;
import Exceptions.LocacaoNaoExisteException;
import Exceptions.LocacaoPendenteException;
import Exceptions.LocacoesNaoCadastradasException;
import Exceptions.RepositorioException;
import Exceptions.VeiculoAlugadoException;
import Exceptions.VeiculoJaExisteException;
import Exceptions.VeiculoNaoExisteException;
import Exceptions.VeiculosAlugadosException;
import Negocio.bean.Administrador;
import Negocio.bean.Cliente;
import Negocio.bean.Estacao;
import Negocio.bean.Locacao;
import Negocio.bean.Veiculo;


public class Fachada implements InterfaceFachada
{
  private ControladorAdministrador adm;
  private ControladorCliente cliente;
  private ControladorLocacao locacao;
  private ControladorEstacao estacao;
  private ControladorVeiculo veiculo;
 
  public static Fachada instance;

  public static Fachada getInstance() throws InicializacaoSistemaException,ClienteJaExisteException,RepositorioException,VeiculoNaoExisteException
  {
	if (Fachada.instance == null)
	{
		try
		{
			Fachada.instance = new Fachada();
		} 
		catch (ClassNotFoundException | RepositorioException | ClienteJaExisteException e) 
		{
			e.printStackTrace();
			throw new InicializacaoSistemaException();
		}
		catch (VeiculoNaoExisteException e) 
		{
			e.printStackTrace();
		}
	}
	return Fachada.instance;
  }

  public Fachada() throws ClassNotFoundException,ClienteJaExisteException, RepositorioException,VeiculoNaoExisteException
  {
	 this.adm = new ControladorAdministrador();
	 this.cliente = new ControladorCliente();
	 this.locacao = new ControladorLocacao();
	 this.estacao = new ControladorEstacao();
	 this.veiculo = new ControladorVeiculo();
  }

  public void aAlugarVeiculo(String CPF,int CodigoEstacao,String placa,Calendar dataDevolucao) throws VeiculoNaoExisteException, ClienteNaoExisteException, EstacaoNaoExisteException, VeiculoAlugadoException, LocacaoPendenteException, LocacoesNaoCadastradasException
  {
	  this.locacao.AlugarVeiculo(CPF, CodigoEstacao, placa, dataDevolucao);
  }

  public void devolverVeiculo(String CPF,String Placa,int CodigoEstacao) throws LocacaoNaoExisteException, LocacoesNaoCadastradasException
  {
	  this.locacao.devolverVeiculo(CPF, Placa, CodigoEstacao);
  }

  public void cadastrarAdministrador(Administrador adm)throws RepositorioException, AdministradorJaExistenteException,AdministradorNaoExisteException 
  {
	this.adm.cadastrarAdministrador(adm);

  }

  public Administrador procurarAdministrador(String cpf)throws AdministradorNaoExisteException 
  {
	return this.adm.procurar(cpf);

  }

  public void alterarAdministrador(Administrador adm) throws RepositorioException, AdministradorNaoExisteException
  {
	this.adm.alterar(adm);

  }


  public boolean existeAdministrador(String cpf)throws AdministradorNaoExisteException 
  {
	return this.adm.existe(cpf);

  }

  public void excluirAdministrador(String cpf) throws RepositorioException,AdministradorNaoExisteException
  {
	this.adm.excluir(cpf);

  }

  public void cadastrarLocacao(Locacao locacao) throws RepositorioException, LocacoesNaoCadastradasException 
  {
	this.locacao.cadastrar(locacao);
  }

  public void cadastrarLocacao(String cpf, String placa) throws RepositorioException, LocacoesNaoCadastradasException
  {
      this.locacao.cadastrar(cpf, placa);
  }

  public Locacao procurarLocacao(String cpf, String placa) throws  LocacoesNaoCadastradasException
  {
	return this.locacao.procurar(cpf, placa);
  }

  public Locacao procurarLocacaoFinalizada(String cpf, String placa)throws LocacoesNaoCadastradasException 
  {
	return this.locacao.procurarAluguelFinalizado(cpf,placa);
  }

  public Locacao procurarLocacao(Integer id)throws LocacaoNaoExisteException
  {
	 return this.procurarLocacao(id);
  }

  public void alterarLocacao(String cpf, String placa) throws LocacoesNaoCadastradasException, LocacaoNaoExisteException
  {
	this.locacao.AlterarLocacao(cpf, placa);

  }

  public boolean LocacaoExiste(String cpf, String placa) 
  {
	return this.locacao.existe(cpf, placa);

  }

  public void excluirLocacao(String cpf, String placa) throws LocacoesNaoCadastradasException
  {
     this.locacao.excluir(cpf, placa);
  }

  public List<Locacao> exibirALuguelComMulta() throws AluguelComMultaInexistenteException, LocacoesNaoCadastradasException
  {
	return this.locacao.exibirLocacoesComMulta();
  }

  public List<Locacao> exibirLocacoesFinalizadas()throws LocacoesNaoCadastradasException
  {
	return this.locacao.exibirLocacoesFinalizadas();
  }

  public List<Locacao> exibirALuguelAtivo()throws LocacoesNaoCadastradasException 
  {
	return this.locacao.exibirLocacoesAtivas();
  }

  public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException
  {
	  this.cliente.cadastrarCliente(cliente);
  }

  public Cliente procurarCliente(String cpf) throws ClienteNaoExisteException
  {
	return this.cliente.procurar(cpf);
  }

  public void alterarCliente(Cliente cliente) throws RepositorioException,ClienteNaoExisteException 
  {
	this.cliente.alterar(cliente);
  }

  public boolean existeCliente(String cpf)
  {
	return this.cliente.existe(cpf);
  }

  public void excluirCliente(String cpf) throws ClienteNaoExisteException
  {
	this.cliente.excluirCliente(cpf);
  }

  public List<Cliente> exibirClientes() throws ClientesNaoCadastradosException
  {
	return this.cliente.ListarClientes();
  }
  public void cadastrarVeiculo(Veiculo veiculo, int CodigoEstacao)throws VeiculoNaoExisteException, VeiculoJaExisteException, EstacaoNaoExisteException
  {
	  this.veiculo.cadastrar(veiculo, CodigoEstacao);
  }
  public Veiculo ProcurarVeiculo(String placa)throws VeiculoNaoExisteException, EstacaoNaoExisteException
  {
	  return this.veiculo.procurar(placa);
  }
  public List<Veiculo> listarVeiculosDisponiveis() throws VeiculosAlugadosException
  {
	  return this.veiculo.listarVeiculosDisponiveis();
  }
  public void RemoverVeiculo(String placa)throws VeiculoNaoExisteException, EstacaoNaoExisteException
  {
	  this.veiculo.removercarro(placa);
  }
  public boolean existeVeiculo(String placa)throws VeiculoNaoExisteException
  {
	  return this.veiculo.existe(placa);
  }

  public void cadastrarEstacao(Estacao estacao, int capacidade)throws RepositorioException,EstacaoJaExisteException,EstacaoNaoExisteException, EstacoesNaoExistemException 
  {
	this.estacao.cadastrar(estacao, capacidade);
  }

  public Estacao procurarEstacao(int id) throws EstacaoNaoExisteException 
  {
	return this.estacao.procurar(id);
  }
  public Estacao procurarEstacao(String s) throws EstacaoNaoExisteException 
  {
	return this.estacao.procurar(s);
  }

  public void alterarEstacao(Estacao estacao) throws RepositorioException,EstacaoNaoExisteException 
  {
	this.estacao.alterar(estacao);
  }
  public List<Estacao> ListarEstacoes()throws EstacoesNaoExistemException
  {
	  return this.estacao.ListarEstacoes();
  }

  public void excluirEstacao(int id) throws RepositorioException,EstacaoNaoExisteException 
  {
	this.estacao.excluir(id);
  }

}
