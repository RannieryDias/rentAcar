package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagLayout;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import exceptions.AdministradorJaExistenteException;
import exceptions.AdministradorNaoExisteException;
import exceptions.ClienteJaExisteException;
import exceptions.RepositorioException;
import exceptions.VeiculoNaoExisteException;

import java.awt.Font;


public class TelaCadastroAdm extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField telefoneField;
	private JTextField celularField;
	private JTextField cepField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JTextField usuarioField;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 * @throws VeiculoNaoExisteException 
	 * @throws RepositorioException 
	 * @throws ClienteJaExisteException 
	 * @throws ClassNotFoundException 
	 */
	
	public TelaCadastroAdm() throws ParseException, ClassNotFoundException, ClienteJaExisteException, RepositorioException, VeiculoNaoExisteException {
		setResizable(false);
		setTitle("Cadastrar Administrador - rentAcar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(241, 95, 35, 14);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(252, 139, 24, 14);

		nomeField = new JTextField();
		nomeField.setBounds(322, 92, 153, 20);
		nomeField.setColumns(10);
		
	
		
		MaskFormatter mascara_cpf;
		mascara_cpf = new MaskFormatter("#########-##");
		mascara_cpf.setValidCharacters("0123456789");
		JFormattedTextField cpfField = new JFormattedTextField(mascara_cpf);
		cpfField.setBounds(322, 137, 153, 20);
		contentPane.add(cpfField);
		String cpf = cpfField.getText().replace("-", "") ;


		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsurio.setBounds(230, 188, 46, 14);
		contentPane.add(lblUsurio);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(322, 185, 153, 20);
		contentPane.add(usuarioField);
		usuarioField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(241, 237, 45, 14);
		contentPane.add(lblSenha);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(322, 235, 153, 20);
		contentPane.add(passwordField1);
		@SuppressWarnings("deprecation")
		String senha1 = passwordField1.getText();
		
		JLabel lblRepitaASenha = new JLabel("Repita a senha");
		lblRepitaASenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepitaASenha.setBounds(197, 286, 89, 14);
		contentPane.add(lblRepitaASenha);
		
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(322, 283, 153, 20);
		contentPane.add(passwordField2);
		@SuppressWarnings("deprecation")
		String senha2 = passwordField2.getText();
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		Negocio.bean.Administrador adm = new Negocio.bean.Administrador();
		Negocio.Fachada adm1 = new Negocio.Fachada();
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					adm.setNome(nomeField.getText());
					adm.setCpf(cpf);
					adm.setLogin(usuarioField.getText());
					if(senha1.equals(senha2)){
						adm.setSenha(senha1);
						
					}else{
						JOptionPane.showMessageDialog(null, "Os campos de senha não podem ser diferentes, por favor tente novamente!");
					}
					try {
						adm1.cadastrarAdministrador(adm);
					} catch (RepositorioException
							| AdministradorJaExistenteException
							| AdministradorNaoExisteException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso");
					dispose();
			}
		});
		btnCadastrar.setBounds(241, 390, 89, 23);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(392, 390, 75, 23);
		
		
		contentPane.setLayout(null);
		contentPane.add(lblNome);
		contentPane.add(lblCpf);
		contentPane.add(nomeField);
		contentPane.add(btnCadastrar);
		contentPane.add(btnCancelar);

	}

	
}
