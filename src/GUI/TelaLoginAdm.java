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

public class TelaLoginAdm extends JFrame {

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
	public TelaLoginAdm() 
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
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsurio.setBounds(194, 132, 46, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(194, 179, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(268, 129, 159, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setBounds(268, 178, 159, 20);
		contentPane.add(textFieldSenha);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() 
		{
			    public void actionPerformed(ActionEvent arg0) 
			    {
				/*String usuario = textFieldUsuario.getText();
				@SuppressWarnings("deprecation")
				String senha = textFieldSenha.getText();*/
				DesktopAdm JDesktop = new DesktopAdm();
				JDesktop.show();
				dispose();
				//login(usuario,senha);
			}
		});
		btnLogin.setBounds(208, 251, 89, 23);
		contentPane.add(btnLogin);
		
		JButton CriarConta = new JButton("Criar Conta");
		CriarConta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				TelaCadastro();
			}
		});
		CriarConta.setBounds(326, 251, 127, 23);
		contentPane.add(CriarConta);
	}
	
	@SuppressWarnings("deprecation")
	public void login(String usuario, String senha)
	{
		
		
		Desktop JDesktop = new Desktop();
		
		JOptionPane.showMessageDialog(null, "Passou");
		
		JDesktop.show();
		dispose();
		/*if(validaLogin(usuario,senha) == true)
		{
			Desktop JDesktop = new Desktop();
			
			JOptionPane.showMessageDialog(null, "Passou");
			
			JDesktop.show();
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Usu�rio ou senha incorreta!");
		}*/
	}
	public boolean validaLogin(String cpf, String senha)
	{
		
		boolean resultado = false;
		try 
		{
			if(cpf.equals(fachada.procurarCliente(cpf).getCpf()) && senha.equals(fachada.procurarCliente(cpf).getSenha()))
			{
				resultado = true;
			}
		} 
		catch (ClienteNaoExisteException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return resultado;
	}
	public void TelaCadastro()
	{
		JTextField Nome = new JTextField();
		JTextField CPF = new JTextField();
		JTextField Senha = new JTextField();
		JTextField confirmaSenha = new JTextField();
		
		try 
		{
			confirmaSenha = new JPasswordField();
			Senha = new JPasswordField();
			CPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		
		}
		catch (ParseException e) 
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
        Object[] campos = {"Nome:",Nome,"CPF:",CPF,"Senha:",Senha,"Redigite a Senha:",confirmaSenha};
        
        int i = JOptionPane.showConfirmDialog(null,campos,"Cadastrar",JOptionPane.OK_CANCEL_OPTION);
        
        if(i == 0)
        {
        	if(Senha.getText().equals(confirmaSenha.getText()) && Senha.getText().length() < 4)
        	{
        	  Cliente cliente = new Cliente(Nome.getText(),CPF.getText(),Senha.getText());
        	  try
        	  {
				 fachada.cadastrarCliente(cliente);
				 JOptionPane.showMessageDialog(null, "cadastrado");
			  }
        	 catch (ClienteJaExisteException e) 
        	 {
				JOptionPane.showMessageDialog(null, e.getMessage());
			 }
            }
           else
           {
        	  JOptionPane.showMessageDialog(null, "Senha inv�lida");
           }	
	     }
  }     
}
	

