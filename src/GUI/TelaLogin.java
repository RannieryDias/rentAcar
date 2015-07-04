package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldSenha;


	public TelaLogin() {
		setResizable(false);
		setTitle("Login - rentAcar ");
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
		
		JComboBox comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setMaximumRowCount(3);
		comboBoxUsuario.addItem("Novo Cliente");
		comboBoxUsuario.addItem("Cliente");
		comboBoxUsuario.addItem("Administrador");
		comboBoxUsuario.setBounds(290, 231, 119, 20);
		contentPane.add(comboBoxUsuario);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textFieldUsuario.getText();
				@SuppressWarnings("deprecation")
				String senha = textFieldSenha.getText();
				int tipo = comboBoxUsuario.getSelectedIndex();
				login(usuario,senha, tipo);
			}
		});
		btnLogin.setBounds(210, 302, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(394, 302, 89, 23);
		contentPane.add(btnCancelar);
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void login(String usuario, String senha, int tipo){
		String adm = "Admin";
		String pass = "admin";
		if(tipo == 0){
			TelaCadastroUsuario cadUser = new TelaCadastroUsuario();
			cadUser.show();
		}else if(usuario.equals(adm) && senha.equals(pass) && tipo == 1){
			
			dispose();
		}else if(usuario.equals(adm) && senha.equals(pass) && tipo == 2){
			
			DesktopAdmin adminDesktop = new DesktopAdmin();
			adminDesktop.show();
			dispose();
		}
		else{
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta!");
		}
	}
}

