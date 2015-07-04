package gui;

import javax.swing.JOptionPane;

import exceptions.ClienteJaExisteException;
import exceptions.InicializacaoSistemaException;
import exceptions.RepositorioException;
import exceptions.VeiculoNaoExisteException;
import Negocio.Fachada;
import Negocio.InterfaceFachada;

public class Main {
	  
	
	public static void main(String[] args) throws ClienteJaExisteException, VeiculoNaoExisteException {
		inicializarSistema();
	}
	

	public static void inicializarSistema() throws ClienteJaExisteException, VeiculoNaoExisteException{
		try{
		TelaLogin telaLogin = new TelaLogin();
		telaLogin.setVisible(true);
		Fachada.getInstance();
		}catch(InicializacaoSistemaException e){
			JOptionPane.showMessageDialog(null, "Erro!");
		}
	}
	
	

}
