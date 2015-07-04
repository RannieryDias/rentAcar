package Dados;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;









import Exceptions.*;
import Negocio.bean.Cliente;
import Negocio.bean.Estacao;

public class RepositorioEstacao
{
	private List<Estacao> estacoes;
	private final String NomeArquivo = "Estacoes.dat";
	private File arquivoEstacoes;

	public RepositorioEstacao() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
		try
		{
		  this.estacoes = new ArrayList<Estacao>();
		  this.arquivoEstacoes = new File(this.NomeArquivo);
		  this.arquivoEstacoes.createNewFile();
		  if (this.arquivoEstacoes.length() != 0) 
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
	  FileInputStream InputEstacao = null;
	  ObjectInputStream OutputEstacao = null;
	  try 
	  {
		  InputEstacao = new FileInputStream(arquivoEstacoes);
		  OutputEstacao = new ObjectInputStream(InputEstacao);
		  while (true) 
		  {
			try 
			{
				@SuppressWarnings("unchecked")
				ArrayList<Estacao> estacoes = (ArrayList<Estacao>) OutputEstacao.readObject();
				for ( Estacao e : estacoes)
					this.cadastrarEstacao(e);
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
			InputEstacao.close();
			OutputEstacao.close();
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
		FileOutputStream FOutputEstacao = null;
		ObjectOutputStream OOutputEstacao = null;
		try 
		{
			FOutputEstacao = new FileOutputStream(arquivoEstacoes);
			OOutputEstacao = new ObjectOutputStream(FOutputEstacao);
			OOutputEstacao.writeObject(estacoes);
			OOutputEstacao.reset();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();		
		} 
		finally 
		{
			try 
			{
				FOutputEstacao.close();
				OOutputEstacao.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void cadastrarEstacao(Estacao e)
	{
       this.estacoes.add(e);
       this.SalvarArquivo();
	}
	private int ProcurarIndice(String NomeEstacao)
	{
		int indice = -1;

		for (int i = 0; i < this.estacoes.size(); i++) {
			if (NomeEstacao.equals(this.estacoes.get(i).getCod())) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public Estacao ProcurarEstacao(String Nome)
	{
		Estacao e = null;

		for (int i = 0; i < this.estacoes.size(); i++) {
			if (this.estacoes.get(i).getNomeEstacao().equals(Nome)) {
				 e = estacoes.get(i);
			}
			
		}
		return e; 
	}
	private int ProcurarIndice(int id)
	{
		int indice = -1;

		for (int i = 0; i < this.estacoes.size(); i++) {
			if (this.estacoes.get(i).getCod() == id) {
				indice = i;
			}
			// tratar um exceção do tipo se o obj não foi encontrada
		}
		return indice; // Retorna -1 se não encontrou
	}
	public Estacao procurar(int id) throws EstacaoNaoExisteException
	{
		int indice = this.ProcurarIndice(id);
		if (indice == -1) throw new EstacaoNaoExisteException(id);
		return this.estacoes.get(indice);
	}
	public void removerEstacao(int id) throws EstacaoNaoExisteException 
	{
		int indice = this.ProcurarIndice(id);
		if (indice != -1) {
			this.estacoes.remove(indice);
			this.SalvarArquivo();
		} 
		else throw new EstacaoNaoExisteException(id);
		
	}
	
	
	public boolean existe(int id) 
	{
		int indice = this.ProcurarIndice(id);

		if (indice != -1)
			return true;
		else
			return false;
	}
	public Estacao retornarEstacao(int id)
	{
		Estacao e = null;
		if(existe(id) == true)
		{
		   e = estacoes.get(id);
		}
		  
		return e;
		 
	}
	
	public void alterarEstacao(Estacao estacao) throws RepositorioException,EstacaoNaoExisteException 
	{
       int indice = this.ProcurarIndice(estacao.getCod());
       if (indice == -1)
	   throw new EstacaoNaoExisteException(estacao.getCod());
       this.estacoes.set(indice, estacao);
       this.SalvarArquivo();
    }
	public List<Estacao> ListarEstacoes() throws EstacoesNaoExistemException 
	{
		if(this.estacoes.isEmpty())
		{
			throw new EstacoesNaoExistemException();
		}	
		else
		{
			return this.estacoes;	
		}
		
	}

}
