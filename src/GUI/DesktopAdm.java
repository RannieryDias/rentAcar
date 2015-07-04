package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.ListModel;

import Exceptions.ClienteJaCadastradoException;
import Exceptions.ClienteJaExisteException;
import Exceptions.ClientesNaoCadastradosException;
import Exceptions.EstacaoJaExisteException;
import Exceptions.EstacaoNaoExisteException;
import Exceptions.EstacoesNaoExistemException;
import Exceptions.InicializacaoSistemaException;
import Exceptions.RepositorioException;
import Exceptions.VeiculoJaExisteException;
import Exceptions.VeiculoNaoExisteException;
import Exceptions.VeiculosAlugadosException;
import Negocio.Fachada;
import Negocio.InterfaceFachada;
import Negocio.bean.Cliente;
import Negocio.bean.Veiculo;
import Negocio.bean.Estacao;

import javax.swing.JTextField;

public class DesktopAdm extends JFrame
{

	private JList listaEstacoes;
	private JList listaAluguel;
	private static String[] veiculos = null; 
	private JPanel contentPane;
	//private static InterfaceFachada fachada;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public DesktopAdm() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Minha Conta");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadatrar = new JMenuItem("Alterar Senha");
		mnCadastrar.add(mntmCadatrar);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Pendencias");
		mnCadastrar.add(mntmCadastrarCliente);
		
		JMenu mnAlugar = new JMenu("Clientes");
		menuBar.add(mnAlugar);
		
		JMenu Veiculos = new JMenu("Veiculos");
		menuBar.add(Veiculos);
		
		JMenu estacoes = new JMenu("Estacoes");
		menuBar.add(estacoes);
		
		JMenuItem CadastrarEstacoes = new JMenuItem("Cadastrar Estacao");
		CadastrarEstacoes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
		       cadastrarestacao();
		    }    
		});
		estacoes.add(CadastrarEstacoes);
		
		JMenuItem removerEstacoes = new JMenuItem("Remover Estacao");
		CadastrarEstacoes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				listaEstacoes = new JList(); 
				listaEstacoes.setBounds(177, 52, 99, 120);
				DefaultListModel lista = new DefaultListModel();
				List<Estacao> estacoes;
				try
				{
					try
					{
				      estacoes = Fachada.getInstance().ListarEstacoes();
				      for(int i = 0; i < estacoes.size(); i++)
				 	 {
				 		lista.addElement(estacoes.get(i).getNomeEstacao());
				 	 }
					}
					catch(EstacoesNaoExistemException e)
					{
						JOptionPane.showMessageDialog(null, e.getMessage() );
					}
				 
				 listaEstacoes = new JList();
				 listaEstacoes.setModel(lista);
				}
				catch(InicializacaoSistemaException | VeiculoNaoExisteException | RepositorioException | ClienteJaExisteException v)
				{
					JOptionPane.showMessageDialog(null, v.getMessage());
				}
		       Object[] campos = {listaEstacoes};
		       
		       int i = JOptionPane.showConfirmDialog(null,campos,"Deletar",JOptionPane.OK_CANCEL_OPTION);
		       
		       if(i == 0)
		       {
		          
		       	  try
		       	  {
		   			 try
		   			 {
		   				 lista.getElementAt(TEXT_CURSOR)
		   				Fachada.getInstance().procurarEstacao();
		   			} 
		   			 catch (VeiculoNaoExisteException
		   					| VeiculoJaExisteException
		   					| EstacaoNaoExisteException
		   					| InicializacaoSistemaException
		   					| RepositorioException e) {
		   				
		   				JOptionPane.showMessageDialog(null, e.getMessage());
		   			}
		   			 JOptionPane.showMessageDialog(null, "cadastrado");
		   		  }
		       	 catch (ClienteJaExisteException e) 
		       	 {
		   			JOptionPane.showMessageDialog(null, e.getMessage());
		   		 }
		           
		      }
		    }    
		});
		estacoes.add(CadastrarEstacoes);
		
		JMenuItem CadastrarVeiculo = new JMenuItem("Cadastrar");
		CadastrarVeiculo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
		         	cadasrtrarveiculo();
			}    
		});
		Veiculos.add(CadastrarVeiculo);
		
		JDesktopPane desktopPane = new JDesktopPane();
		//contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		 listaAluguel = new JList(); 
		 listaAluguel.setBounds(177, 52, 99, 120);
		 desktopPane.add(listaAluguel);
		
		JMenuItem mntmAlugarCarro = new JMenuItem("Listar Clientes");
		mntmAlugarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DefaultListModel lista = new DefaultListModel();
				try
				{
				 List<Cliente> clientes = Fachada.getInstance().exibirClientes();
				 for(int i = 0; i < clientes.size(); i++)
				 {
					lista.addElement(clientes.get(i).getNome());
				 }
				 listaAluguel = new JList();
				 listaAluguel.setModel(lista);
				 desktopPane.add(listaAluguel);
				 listaAluguel.setVisible(true);
				}
				catch(ClientesNaoCadastradosException | InicializacaoSistemaException | VeiculoNaoExisteException | RepositorioException | ClienteJaExisteException v)
				{
					JOptionPane.showMessageDialog(null, v.getMessage());
				}
				 
			}
		});
		mnAlugar.add(mntmAlugarCarro);	
		
		
		
		JMenuItem mntmDevoluoDeCarro = new JMenuItem("Devolu\u00E7\u00E3o de Carro");
		mnAlugar.add(mntmDevoluoDeCarro);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
}
		
		
		
	public void cadastrarestacao()
	{
		JTextField Nome = new JTextField();
		JTextField capacidade = new JTextField();
		JTextField Endereco = new JTextField();
		
        Object[] campos = {"Nome:",Nome,"Capacidade:",capacidade,"Endereço :",Endereco};
        
        int i = JOptionPane.showConfirmDialog(null,campos,"Cadastrar",JOptionPane.OK_CANCEL_OPTION);
        
        if(i == 0)
        {
           
           int capacidad = Integer.parseInt(capacidade.getText());
           Estacao estacao = new Estacao(Nome.getText(),capacidad,Endereco.getText());
        	  try
        	  {
				 try
				 {
					Fachada.getInstance().cadastrarEstacao(estacao, capacidad);
					
				 } 
				 catch (VeiculoNaoExisteException
						| EstacaoNaoExisteException
						| InicializacaoSistemaException
						| RepositorioException | EstacaoJaExisteException e)
				 {
					
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				 JOptionPane.showMessageDialog(null, "Estação " + Nome + "Capacidade" + capacidade);
			  }
        	 catch (ClienteJaExisteException e) 
        	 {
				JOptionPane.showMessageDialog(null, e.getMessage());
			 }
        }
           	
	}
	
public void Listarestacao()
{
	
}	

public void cadasrtrarveiculo()
{
    listaEstacoes = new JList(); 
	listaEstacoes.setBounds(177, 52, 99, 120);
	DefaultListModel lista = new DefaultListModel();
	List<Estacao> estacoes;
	try
	{
		try
		{
	      estacoes = Fachada.getInstance().ListarEstacoes();
	      for(int i = 0; i < estacoes.size(); i++)
	 	 {
	 		lista.addElement(estacoes.get(i).getNomeEstacao());
	 	 }
		}
		catch(EstacoesNaoExistemException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage() );
		}
	 
	 listaEstacoes = new JList();
	 listaEstacoes.setModel(lista);
	}
	catch(InicializacaoSistemaException | VeiculoNaoExisteException | RepositorioException | ClienteJaExisteException v)
	{
		JOptionPane.showMessageDialog(null, v.getMessage());
	}
	JTextField Modelo = new JTextField();
	JTextField Marca = new JTextField();
	JTextField cor = new JTextField();
	JTextField motor = new JTextField();
	JTextField Placa = new JTextField();
	JTextField diaria = new JTextField();
	JTextField estacao = new JTextField();
	
	
	try 
	{
		Placa = new JFormattedTextField(new MaskFormatter("###-####"));
	
	}
	catch (ParseException e) 
	{
		JOptionPane.showMessageDialog(null,e.getMessage());
	}
	
    Object[] campos = {"Marca:",Modelo,"Modelo:",Marca,"cor:",cor,"Motor: ",motor,"Placa: ", Placa,"Valor Diário: ",diaria,"Estação :",estacao,listaEstacoes};
    
    int i = JOptionPane.showConfirmDialog(null,campos,"Cadastrar",JOptionPane.OK_CANCEL_OPTION);
    
    if(i == 0)
    {
       String valors = estacao.getText();
       int valor = Integer.parseInt(motor.getText());
       int estacao1 = Integer.parseInt(valors);
       Veiculo veiculo = new Veiculo(Placa.getText(),Modelo.getText(),cor.getText(),motor.getText(),valor,estacao1);
    	  try
    	  {
			 try
			 {
				Fachada.getInstance().cadastrarVeiculo(veiculo, estacao1);
			} 
			 catch (VeiculoNaoExisteException
					| VeiculoJaExisteException
					| EstacaoNaoExisteException
					| InicializacaoSistemaException
					| RepositorioException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			 JOptionPane.showMessageDialog(null, "cadastrado");
		  }
    	 catch (ClienteJaExisteException e) 
    	 {
			JOptionPane.showMessageDialog(null, e.getMessage());
		 }
        
   }
}
}
	


