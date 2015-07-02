package GUI;

import javax.swing.JOptionPane;

import Exceptions.ClienteJaExisteException;
import Exceptions.InicializacaoSistemaException;
import Exceptions.RepositorioException;
import Exceptions.VeiculoNaoExisteException;
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
