package Execucao;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Exceptions.ClienteJaExisteException;
import Exceptions.ClienteNaoExisteException;
import Exceptions.EstacaoNaoExisteException;
import Exceptions.InicializacaoSistemaException;
import Exceptions.LocacaoPendenteException;
import Exceptions.LocacoesNaoCadastradasException;
import Exceptions.RepositorioException;
import Exceptions.VeiculoAlugadoException;
import Exceptions.VeiculoNaoExisteException;
import Exceptions.VeiculosAlugadosException;
import GUI.TelaCadastroAdm;
import GUI.TelaCadastroUsuario;
import GUI.TelaInicial;
import GUI.TelaLogin;
import GUI.TelaLoginAdm;
import Negocio.Fachada;
import Negocio.bean.Veiculo;

public class Principal
{
	private String CPFUsuario;
    public Scanner s;
	public static void main(String[] args) 
	{
	   try 
	   {
		  Fachada.getInstance();
		  TelaInicial tela = new TelaInicial();
          tela.setVisible(true);
		  
	   } 
	   catch (InicializacaoSistemaException | ClienteJaExisteException| RepositorioException | VeiculoNaoExisteException e) {
		
		 JOptionPane.showMessageDialog(null, e.getMessage());
	    }

	}
	public void menuPrincipal()
	{
		
		System.out.println("O que deseja fazer?");
		System.out.println("Alugar carro (1) \n");
		System.out.println("Devolver carro (2) \n");
		System.out.println("Verificar alugueis (3) \n");
		
		s = new Scanner(System.in);
		int e =s.nextInt();
		switch (e)
		{
		  case 1: telaAlugar();
		}
		
	}
	public void telaAlugar()
	{
	   this.ListarVeiculos();	
	   s = new Scanner(System.in);
	   String Cpf = s.nextLine();
	   int Codigo = s.nextInt();
	   String placa = s.nextLine();
	   int dia = s.nextInt();
	   int mes = s.nextInt();
	   int ano = s.nextInt();
	   alugar(Cpf,Codigo,placa,dia,mes,ano);
	}
	public void alugar(String CPF , int CodigoEstacao, String placa, int dia,int mes,int ano)
	{
		Calendar data = Calendar.getInstance();
	    data.set(ano, mes, dia);
		try 
		{
			Fachada.getInstance().aAlugarVeiculo(CPF, CodigoEstacao, placa, data);
		}
		
		catch (VeiculoNaoExisteException | ClienteNaoExisteException
				| EstacaoNaoExisteException | VeiculoAlugadoException
				| LocacaoPendenteException | LocacoesNaoCadastradasException
				| InicializacaoSistemaException | ClienteJaExisteException
				| RepositorioException e) {
			
		    System.out.println(e.getMessage());
		}
	}
	public  List<Veiculo> ListarVeiculos()
	{
		try
		{
			return Fachada.getInstance().listarVeiculosDisponiveis();
		}
		catch (VeiculosAlugadosException | InicializacaoSistemaException
				| ClienteJaExisteException | RepositorioException
				| VeiculoNaoExisteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
   
}
