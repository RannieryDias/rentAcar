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



public interface InterfaceFachada 
{
	public void aAlugarVeiculo(String CPF,int CodigoEstacao,String placa,Calendar dataDevolucao) throws VeiculoNaoExisteException, ClienteNaoExisteException, EstacaoNaoExisteException, VeiculoAlugadoException, LocacaoPendenteException,LocacoesNaoCadastradasException;
	
	public void devolverVeiculo(String CPF,String Placa,int CodigoEstacao) throws LocacaoNaoExisteException,LocacoesNaoCadastradasException;

	public void cadastrarAdministrador(Administrador adm)throws RepositorioException, AdministradorJaExistenteException,AdministradorNaoExisteException;

	public Administrador procurarAdministrador(String cpf)throws AdministradorNaoExisteException;

	public void alterarAdministrador(Administrador adm)throws RepositorioException, AdministradorNaoExisteException;

	public boolean existeAdministrador(String cpf)throws AdministradorNaoExisteException;

	public void excluirAdministrador(String cpf) throws RepositorioException,AdministradorNaoExisteException;

	public void cadastrarLocacao(Locacao locacao) throws RepositorioException, LocacoesNaoCadastradasException;
	
	public void cadastrarLocacao(String cpf, String placa) throws RepositorioException, LocacoesNaoCadastradasException;
	
	public Locacao procurarLocacao(String cpf, String placa) throws  LocacoesNaoCadastradasException;
	
	public Locacao procurarLocacaoFinalizada(String cpf, String placa)throws LocacoesNaoCadastradasException;
	
	public Locacao procurarLocacao(Integer id)throws LocacaoNaoExisteException;
	
	public void alterarLocacao(String cpf, String placa) throws LocacoesNaoCadastradasException, LocacaoNaoExisteException;
	
	public boolean LocacaoExiste(String cpf, String placa);
	
	public void excluirLocacao(String cpf, String placa) throws LocacoesNaoCadastradasException;
	
	public List<Locacao> exibirALuguelComMulta() throws AluguelComMultaInexistenteException,LocacoesNaoCadastradasException;
	
	public List<Locacao> exibirLocacoesFinalizadas()throws LocacoesNaoCadastradasException;
	
	public List<Locacao> exibirALuguelAtivo()throws LocacoesNaoCadastradasException;
	
	public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException;
	
	public Cliente procurarCliente(String cpf) throws ClienteNaoExisteException;
	
	public void alterarCliente(Cliente cliente) throws RepositorioException,ClienteNaoExisteException;
	
	public boolean existeCliente(String cpf);
	
	public void excluirCliente(String cpf) throws ClienteNaoExisteException;
	
	public List<Cliente> exibirClientes() throws ClientesNaoCadastradosException;
	
	public void cadastrarVeiculo(Veiculo veiculo, int CodigoEstacao)throws VeiculoNaoExisteException, VeiculoJaExisteException, EstacaoNaoExisteException;
	
	public List<Veiculo> listarVeiculosDisponiveis() throws VeiculosAlugadosException;
	
	public Veiculo ProcurarVeiculo(String placa)throws VeiculoNaoExisteException,EstacaoNaoExisteException;
	
	public void RemoverVeiculo(String placa)throws VeiculoNaoExisteException,EstacaoNaoExisteException;
	
	public boolean existeVeiculo(String placa)throws VeiculoNaoExisteException;
	
	public void cadastrarEstacao(Estacao estacao, int capacidade)throws RepositorioException,EstacaoJaExisteException,EstacaoNaoExisteException,EstacoesNaoExistemException;
	
	public Estacao procurarEstacao(int id) throws EstacaoNaoExisteException;
	
	 public Estacao procurarEstacao(String s) throws EstacaoNaoExisteException;
	
	public void alterarEstacao(Estacao estacao) throws RepositorioException,EstacaoNaoExisteException;
	
	public List<Estacao> ListarEstacoes()throws EstacoesNaoExistemException;
	
	public void excluirEstacao(int id) throws RepositorioException,EstacaoNaoExisteException;
}
