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

import Negocio.bean.Locacao;
import exceptions.ClienteJaExisteException;
import exceptions.LocacaoNaoExisteException;
import exceptions.LocacoesNaoCadastradasException;
import exceptions.RepositorioException;

public class RepositorioLocacao implements InterfaceRepositorioLocacao
{
	private List<Locacao> locacoes;
	private final String NomeArquivo = "Locacoes.dat";
	private File arquivoLocacoes;

	public RepositorioLocacao() throws ClassNotFoundException, ClienteJaExisteException, RepositorioException
	{
	  try
	  {
		this.locacoes = new ArrayList<Locacao>();
		this.arquivoLocacoes = new File(this.NomeArquivo);
		this.arquivoLocacoes.createNewFile();
		if (this.arquivoLocacoes.length() != 0) 
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
		FileInputStream InputLocacao = null;
		ObjectInputStream OutputLocacao = null;
		try {
			InputLocacao = new FileInputStream(arquivoLocacoes);
			OutputLocacao = new ObjectInputStream(InputLocacao);
			while (true) 
			{
				try 
				{
					@SuppressWarnings("unchecked")
					ArrayList<Locacao> locacoes = (ArrayList<Locacao>) OutputLocacao.readObject();
					for ( Locacao l : locacoes)
						this.Cadastrar(l);
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
				InputLocacao.close();
				OutputLocacao.close();
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
		FileOutputStream FOutputLocacao = null;
		ObjectOutputStream OOutputLocacao = null;
		try 
		{
			FOutputLocacao = new FileOutputStream(arquivoLocacoes);
			OOutputLocacao = new ObjectOutputStream(FOutputLocacao);
			OOutputLocacao.writeObject(locacoes);
			OOutputLocacao.reset();
		} catch (IOException e) 
		{
			e.printStackTrace();		
		} 
		finally 
		{
			try 
			{
				FOutputLocacao.close();
				OOutputLocacao.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public void Cadastrar(Locacao l)
	{
	   this.locacoes.add(l);
	   this.SalvarArquivo();
		
	}
	
	
	private int ProcurarIndice(int Id)
	{
		int indice = -1;

		for (int i = 0; i < this.locacoes.size(); i++) 
		{
			if (this.locacoes.get(i).getIdLocacao() == Id) 
			{
				indice = i;
			}
			else
			{
				
			}
			// tratar um exceção do tipo se o obj não foi encontrada
		}
		return indice; // Retorna -1 se não encontrou
	}
	private int ProcurarIndice(String CPF,String placa)
	{
		int indice = -1;

		for (int i = 0; i < this.locacoes.size(); i++) 
		{
			if (this.locacoes.get(i).getCliente().getCpf().equals(CPF) && this.locacoes.get(i).getCarro().getPlaca().equals(placa)) 
			{
				indice = i;
			}
			// tratar um exceção do tipo se o obj não foi encontrada
		}
		return indice; 
	}
	private int ProcurarIndiceDevolucao(String cpf,String placa) 
	{
		int indice = -1;

		for (int i = 0; i < this.locacoes.size(); i++) 
		{
			if (this.locacoes.get(i).getAtivado() == true && this.locacoes.get(i).getCliente().getCpf().equals(cpf)	&& this.locacoes.get(i).getEstacaoInicio().getCarro(placa).equals(placa)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	private int ProcurarIndiceLocacaoFinalizada(String CPF, String placa) throws LocacoesNaoCadastradasException 
	{
		List<Locacao> aluguelFinalizado = new ArrayList<Locacao>();
		aluguelFinalizado.addAll(exibirALuguelFinalizado());
		int indice = -1;
		for (int i = 0; i < aluguelFinalizado.size(); i++) 
		{
			if (aluguelFinalizado.get(i).getCliente().getCpf().equals(CPF) && aluguelFinalizado.get(i).getCarro().getPlaca().equals(placa))  
			{
				indice = i;
			}
		}
		return indice;
	}
	private int ProcurarIndiceLocacaoFinalizada(Locacao l) throws LocacoesNaoCadastradasException 
	{
		List<Locacao> aluguelFinalizado = new ArrayList<Locacao>();
		aluguelFinalizado.addAll(exibirALuguelFinalizado());
		int indice = -1;
		for (int i = 0; i < aluguelFinalizado.size(); i++) 
		{
			if (aluguelFinalizado.get(i).equals(l))  
			{
				indice = i;
			}
		}
		return indice;
	}
	public Locacao procurarLocacao(Integer idLocacao ) throws LocacaoNaoExisteException 
	{
		int indice = this.ProcurarIndice(idLocacao);
		if (indice == -1)
			throw new LocacaoNaoExisteException(idLocacao);
		return this.locacoes.get(indice);
	}
	public Locacao procurarLocacao(String Cpf, String placa) throws LocacoesNaoCadastradasException 
	{
		int indice = this.ProcurarIndice(Cpf,placa);
		if (indice == -1)
			throw new LocacoesNaoCadastradasException("A locacao não foi cadastrada");
		return this.locacoes.get(indice);
	}
	public Locacao procurarAluguelDevolucao(String cpf, String placa) 
	{
		int indice = this.ProcurarIndiceDevolucao(cpf, placa);
		if (indice != -1)
			return this.locacoes.get(indice);
		else
			return null;

	}
	public Locacao procurarAluguelFinalizado(Locacao l)throws LocacaoNaoExisteException, LocacoesNaoCadastradasException 
	{
		int indice = this.ProcurarIndiceLocacaoFinalizada(l);
		if (indice != -1)
			return this.locacoes.get(indice);
		else
			throw new LocacaoNaoExisteException(l.getIdLocacao());
	}
	public Locacao procurarAluguelFinalizado(String Cpf , String placa)throws LocacoesNaoCadastradasException 
	{
		int indice = this.ProcurarIndiceLocacaoFinalizada(Cpf,placa);
		if (indice != -1)
			return this.locacoes.get(indice);
		else
			throw new LocacoesNaoCadastradasException("A Locacao Nao Existe");
	}
	public void remover(int id) throws LocacaoNaoExisteException
	{
		int indice = this.ProcurarIndice(id);

		if (indice != -1) 
		{
			this.locacoes.remove(indice);
			this.SalvarArquivo();
		} 
		else
			throw new LocacaoNaoExisteException(id);	
	}
	public void remover(String cpf, String placa) throws LocacoesNaoCadastradasException
	{
		int indice = this.ProcurarIndice(cpf,placa);

		if (indice != -1) 
		{
			this.locacoes.remove(indice);
			this.SalvarArquivo();
		} 
		else
			throw new LocacoesNaoCadastradasException("A locacao não existe");	
	}
	@Override
	public boolean existe(String cpf, String placa) 
	{
		boolean existe = false;
		int indice = this.ProcurarIndice(cpf, placa);

		if (indice != -1)
			return existe = true;
		return existe;
	}
	public boolean existeAluguelDevolucao(String cpf, String placa) {
		boolean existe = false;
		int indice = this.ProcurarIndiceDevolucao(cpf, placa);

		if (indice != -1)
			return existe = true;
		return existe;
	}
	
	@Override
	public List<Locacao> exibirALugueisAtivos() throws LocacoesNaoCadastradasException 
	{
		List<Locacao> aluguelAtivo = new ArrayList<Locacao>();
		
		   for (int i = 0; i < locacoes.size(); i++) 
		   {
			 if (locacoes.get(i).getAtivado() == true) 
			 {
				  aluguelAtivo.add(locacoes.get(i));
			 }
		   }
		   if(aluguelAtivo.isEmpty())
		   {
			   throw new LocacoesNaoCadastradasException("Não existem locacoes Ativas");	
		   }
		   else
		   {   
	         return aluguelAtivo;
		   }
	}

	@Override
	public List<Locacao> exibirALuguelFinalizado() throws LocacoesNaoCadastradasException
	{ 
		List<Locacao> aluguelFinalizado = new ArrayList<Locacao>();
		
		   for (int i = 0; i < locacoes.size(); i++) 
		   {
			  if (locacoes.get(i).getAtivado() == false)
			  {
				aluguelFinalizado.add(locacoes.get(i));
			  }
		   }
		   if(aluguelFinalizado.isEmpty())
		   {
				throw new LocacoesNaoCadastradasException("Não existem locacoes Finalizadas");
		   }
		   else
		    return aluguelFinalizado;
		
	}
	@Override
	public List<Locacao> exibirALuguelComMulta() throws LocacoesNaoCadastradasException
	{
		List<Locacao> alugueisComMulta = new ArrayList<Locacao>();
		for (int i = 0; i < locacoes.size(); i++) 
		{
			if (locacoes.get(i).getMulta() > 0.0) 
			{
				alugueisComMulta.add(locacoes.get(i));
			}
		}
		if(alugueisComMulta.isEmpty())
		{
				throw new LocacoesNaoCadastradasException("Não existem locacoes com Multas");
		}
		else
		 return alugueisComMulta;
	}
	
	public void alterarAluguel(Locacao aluguel) throws LocacaoNaoExisteException, LocacoesNaoCadastradasException  
	{
		
		int indice = this.ProcurarIndiceLocacaoFinalizada(aluguel);
		if (indice != -1) 
		{
			this.locacoes.set(indice, aluguel);
			this.SalvarArquivo();
		} 
		else
		{
			throw new LocacaoNaoExisteException(aluguel.getIdLocacao());
		}
	}
	
}
	


