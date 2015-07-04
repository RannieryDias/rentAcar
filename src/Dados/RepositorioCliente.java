package dados;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Negocio.bean.Cliente;
import exceptions.ClienteJaExisteException;
import exceptions.ClienteNaoExisteException;
import exceptions.ClientesNaoCadastradosException;
import exceptions.RepositorioException;



public class RepositorioCliente implements InterfaceRepositorioCliente
{
	private List<Cliente> clientes;
	private final String NomeArquivo = "clientes.dat";
	private File arquivoClientes;

	public RepositorioCliente() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
		try
		{
	      this.clientes = new ArrayList<Cliente>();
		  this.arquivoClientes = new File(this.NomeArquivo);
		  this.arquivoClientes.createNewFile();
		  if (this.arquivoClientes.length() != 0) 
			  {
			   this.lerArquivo();
			  }
			  }
		catch (IOException e)
		{
			e.getMessage();
		}
	}

	private void lerArquivo() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
		FileInputStream InputCliente = null;
		ObjectInputStream OutputCliente = null;
		try {
			InputCliente = new FileInputStream(arquivoClientes);
			OutputCliente = new ObjectInputStream(InputCliente);
			while (true) 
			{
				try 
				{
					@SuppressWarnings("unchecked")
					ArrayList<Cliente> cliente = (ArrayList<Cliente>) OutputCliente.readObject();
					for (Cliente a : cliente)
						this.cadastrarCliente(a);
				} 
				catch (EOFException e) 
				{
					break;
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			throw new RepositorioException("Erro na leitura do arquivo "+ this.NomeArquivo + ".");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			throw new RepositorioException("Erro na leitura do objeto. Objeto "+ (new RepositorioCliente()).getClass()+ " não encontrado.");
		} 
		finally 
		{
			try 
			{
				InputCliente.close();
				OutputCliente.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				throw new RepositorioException("Erro no fechamento do arquivo "+ this.NomeArquivo + ".");
			}
		}
	}
	
	private void SalvarArquivo()  
	{
		FileOutputStream FOutputCliente = null;
		ObjectOutputStream OOutputCliente = null;
		try 
		{
			FOutputCliente = new FileOutputStream(arquivoClientes);
			OOutputCliente = new ObjectOutputStream(FOutputCliente);
			OOutputCliente.writeObject(clientes);
			OOutputCliente.reset();
		} catch (IOException e) 
		{
			e.printStackTrace();		
		} 
		finally 
		{
			try 
			{
				FOutputCliente.close();
				OOutputCliente.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void cadastrarCliente(Cliente c)
	{
		this.clientes.add(c);
	}
	private int ProcurarIndice(String CPF)
	{
		int indice = -1;

		for (int i = 0; i < this.clientes.size(); i++) 
		{
			if (this.clientes.get(i).getCpf().equals(CPF)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public Cliente procurarCliente(String CPF) throws ClienteNaoExisteException  
	{
			int indice = this.ProcurarIndice(CPF);
			if (indice == -1)throw new ClienteNaoExisteException(CPF);
			return this.clientes.get(indice);
	}
	public void removerCliente(String CPF) throws ClienteNaoExisteException
	{
        this.clientes.remove(ProcurarIndice(CPF));
	}
	public boolean existe(String cpf) 
	{
		int indice = this.ProcurarIndice(cpf);
		if (indice != -1) return true;
		else return false;
	}
	public void alterarCliente()
	{
		
	}
	public List<Cliente> ListarClientes() throws ClientesNaoCadastradosException
	{
		if(this.clientes.isEmpty())
		{
			throw new ClientesNaoCadastradosException();
		}	
		else
		{
			return this.clientes;	
		}
		
	}
	public void alterarCliente(Cliente cliente) throws RepositorioException,ClienteNaoExisteException 
	{
       int indice = this.ProcurarIndice(cliente.getCpf());
       if (indice == -1)
	   throw new ClienteNaoExisteException(cliente.getCpf());
       this.clientes.set(indice, cliente);
       this.SalvarArquivo();
     }

	
}
