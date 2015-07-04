package Negocio;

import java.util.List;

import Negocio.bean.Cliente;
import dados.RepositorioCliente;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClientesNaoCadastradosException;
import exceptions.RepositorioException;


public class ControladorCliente
{
	private RepositorioCliente repositorio;
	
	
	
	public ControladorCliente() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
		this.repositorio = new RepositorioCliente();
	}
	public void cadastrarCliente(Cliente c) throws ClienteJaExisteException 
	{
	   boolean indice = this.existe(c.getCpf());

	  if (indice == false && c != null) 
	  {
		repositorio.cadastrarCliente(c);
	  } 
	  else
	  {    throw new ClienteJaExisteException(c.getCpf());
	     
	  }	
			
	}
	public boolean existe(String cpf)
	{
		return this.repositorio.existe(cpf);
	}
	public Cliente procurar(String cpf) throws ClienteNaoExisteException
	{
		return this.repositorio.procurarCliente(cpf);
	}
	public void excluirCliente(String cpf) throws ClienteNaoExisteException 
	{
      this.repositorio.removerCliente(cpf);
    }
	public List<Cliente> ListarClientes() throws ClientesNaoCadastradosException
	{
		return this.repositorio.ListarClientes();
	}
	public void alterar(Cliente cliente) throws RepositorioException,ClienteNaoExisteException 
	{
      boolean indice = this.existe(cliente.getCpf());

      if (indice == false && cliente != null)
	  this.repositorio.alterarCliente(cliente);
     }
}
