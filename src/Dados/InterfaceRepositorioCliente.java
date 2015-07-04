package Dados;

import java.util.List;

import Exceptions.ClienteJaExisteException;
import Exceptions.ClienteNaoExisteException;
import Exceptions.ClientesNaoCadastradosException;
import Negocio.bean.Cliente;

public interface InterfaceRepositorioCliente 
{
	public void cadastrarCliente(Cliente c)throws ClienteJaExisteException;
	public Cliente procurarCliente(String CPF)  throws ClienteNaoExisteException;
	public void removerCliente(String CPF) throws ClienteNaoExisteException;
	public List<Cliente> ListarClientes() throws ClientesNaoCadastradosException;

}
