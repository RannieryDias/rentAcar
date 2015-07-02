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

import Exceptions.ClienteJaExisteException;
import Exceptions.EstacaoNaoExisteException;
import Exceptions.VeiculoNaoExisteException;
import Negocio.bean.Estacao;
import Negocio.bean.Locacao;
import Negocio.bean.Veiculo;

public class RepositorioVeiculo  implements InterfaceRepositorioVeiculo
{
	private List<Veiculo> veiculos;
	private final String NomeArquivo = "Carros.dat";
	private File arquivoVeiculos;

	
	public RepositorioVeiculo() throws ClassNotFoundException, VeiculoNaoExisteException
	{
		try
		{
		  this.veiculos = new ArrayList<Veiculo>();
		  this.arquivoVeiculos = new File(this.NomeArquivo);
		  this.arquivoVeiculos.createNewFile();
		  if (this.arquivoVeiculos.length() != 0) 
	      {
		    this.lerArquivo();
		  }
	     }
	     catch (IOException e)
	     {
		   e.getMessage();
	     }
	}
    private void lerArquivo() throws ClassNotFoundException, VeiculoNaoExisteException
    {
	  FileInputStream InputVeiculo = null;
	  ObjectInputStream OutputVeiculo = null;
	  try 
	  {
		  InputVeiculo = new FileInputStream(arquivoVeiculos);
		  OutputVeiculo = new ObjectInputStream(InputVeiculo);
		  while (true) 
		  {
			try 
			{
				@SuppressWarnings("unchecked")
				ArrayList<Veiculo> veiculos = (ArrayList<Veiculo>) OutputVeiculo.readObject();
				for ( Veiculo v : veiculos)
					this.cadastrar(v);
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
		 //throw new RepositorioException("Erro na leitura do arquivo "+ this.NomeArquivo + ".");
	  } 
	  catch (ClassNotFoundException e) 
	  {
		 e.printStackTrace();
		 //throw new RepositorioException("Erro na leitura do objeto. Objeto "+ (new RepositorioCliente()).getClass()+ " não encontrado.");
	  } 
	  finally 
	  {
		 try 
		 {
			InputVeiculo.close();
			OutputVeiculo.close();
		 } 
		 catch (IOException e) 
		 {
			e.printStackTrace();
			//throw new RepositorioException("Erro no fechamento do arquivo "+ this.NomeArquivo + ".");
		 }
	  }
	}
    private void SalvarArquivo()  
	{
		FileOutputStream FOutputVeiculo = null;
		ObjectOutputStream OOutputVeiculo = null;
		try 
		{
			FOutputVeiculo = new FileOutputStream(arquivoVeiculos);
			OOutputVeiculo = new ObjectOutputStream(FOutputVeiculo);
			OOutputVeiculo.writeObject(veiculos);
			OOutputVeiculo.reset();
		} catch (IOException e) 
		{
			e.printStackTrace();		
		} 
		finally 
		{
			try 
			{
				FOutputVeiculo.close();
				OOutputVeiculo.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void cadastrar(Veiculo v)
	{
		this.veiculos.add(v);
	}
	private int ProcurarIndice(String Placa)
	{

		int indice = -1;

		for (int i = 0; i < this.veiculos.size(); i++) {
			if (Placa.equals(this.veiculos.get(i).getPlaca())) 
			{
				indice = i;
			}
			// tratar um exceção do tipo se o obj não foi encontrada
		}
		return indice;
	}
	public Veiculo procurar(String placa) throws VeiculoNaoExisteException
	{
		int indice = this.ProcurarIndice(placa);
		if (indice == -1) throw new VeiculoNaoExisteException(placa);
		return this.veiculos.get(indice);

	}
	public void removerCarro(String placa) throws VeiculoNaoExisteException 
	{
		int indice = this.ProcurarIndice(placa);
		if (indice != -1) {
			this.veiculos.remove(indice);
			this.SalvarArquivo();
		} 
		else throw new VeiculoNaoExisteException(placa);

    }
	public boolean existe(String placa) throws VeiculoNaoExisteException {
		boolean existe = false;
		int indice = this.ProcurarIndice(placa);

		if (indice != -1)
			return existe = true;
		return existe;
	}
}

