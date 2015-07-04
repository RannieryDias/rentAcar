package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Exceptions.ClienteJaExisteException;
import Exceptions.ClienteNaoExisteException;
import Exceptions.InicializacaoSistemaException;
import Exceptions.RepositorioException;
import Exceptions.VeiculoNaoExisteException;
import Negocio.Fachada;
import Negocio.InterfaceFachada;
import Negocio.bean.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class TelaInicial extends JFrame {

	private static InterfaceFachada fachada;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldSenha;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaInicial() 
	{   try {
		fachada = Fachada.getInstance();
	} catch (InicializacaoSistemaException | ClienteJaExisteException
			| RepositorioException | VeiculoNaoExisteException e1) {
		JOptionPane.showMessageDialog(null, e1.getMessage());
	}
		setResizable(false);
		setTitle("rentAcar - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemvindoAoRentacar = new JLabel("Bem-vindo ao rentAcar");
		lblBemvindoAoRentacar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBemvindoAoRentacar.setBounds(268, 36, 159, 30);
		contentPane.add(lblBemvindoAoRentacar);
		
		
		
		
		JButton btnAdm = new JButton("Administrador");
		btnAdm.addActionListener(new ActionListener() 
		{
			    public void actionPerformed(ActionEvent arg0) 
			    {
				
				TelaLoginAdm Adm = new TelaLoginAdm();
				Adm.show();
				dispose();
			}
		});
		btnAdm.setBounds(176, 251, 121, 23);
		contentPane.add(btnAdm);
		
		JButton CriarConta = new JButton("Cliente");
		CriarConta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				TelaLogin Cliente = new TelaLogin();
				Cliente.show();
				dispose();
			}
		});
		CriarConta.setBounds(326, 251, 127, 23);
		contentPane.add(CriarConta);
	}
	
	
	
  }     

	

