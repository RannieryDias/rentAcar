package dados;

import java.util.List;

import Negocio.bean.Cliente;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClientesNaoCadastradosException;

public interface InterfaceRepositorioCliente 
{
	public void cadastrarCliente(Cliente c)throws ClienteJaExisteException;
	public Cliente procurarCliente(String CPF)  throws ClienteNaoExisteException;
	public void removerCliente(String CPF) throws ClienteNaoExisteException;
	public List<Cliente> ListarClientes() throws ClientesNaoCadastradosException;

}
