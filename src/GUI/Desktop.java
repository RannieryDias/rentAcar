package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.ListModel;

import Exceptions.ClienteJaCadastradoException;
import Exceptions.ClienteJaExisteException;
import Exceptions.InicializacaoSistemaException;
import Exceptions.RepositorioException;
import Exceptions.VeiculoNaoExisteException;
import Exceptions.VeiculosAlugadosException;
import Negocio.Fachada;
import Negocio.InterfaceFachada;
import Negocio.bean.Veiculo;
import javax.swing.JTextField;

public class Desktop extends JFrame {

	private JList listaAluguel;
	private static String[] veiculos = null; 
	private JPanel contentPane;
	//private static InterfaceFachada fachada;
	//testando
	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the frame.
	 */
	public Desktop() 
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
		
		JMenu mnAlugar = new JMenu("Aluguel");
		menuBar.add(mnAlugar);
		
		JDesktopPane desktopPane = new JDesktopPane();
		//contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		 listaAluguel = new JList(); 
		 listaAluguel.setBounds(177, 52, 99, 120);
		 desktopPane.add(listaAluguel);
		
		JMenuItem mntmAlugarCarro = new JMenuItem("Alugar Carro");
		mntmAlugarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				DefaultListModel lista = new DefaultListModel();
				try
				{
				 List<Veiculo> veiculos = Fachada.getInstance().listarVeiculosDisponiveis();
				 for(int i = 0; i < veiculos.size(); i++)
				 {
					lista.addElement(veiculos.get(i).getMarca());
				 }
				 listaAluguel = new JList();
				 listaAluguel.setModel(lista);
				 desktopPane.add(listaAluguel);
				 listaAluguel.setVisible(true);
				}
				catch(VeiculosAlugadosException | InicializacaoSistemaException | VeiculoNaoExisteException | RepositorioException | ClienteJaExisteException v)
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
	
}
