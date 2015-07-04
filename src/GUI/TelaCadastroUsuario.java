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
import java.awt.Font;


public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField telefoneField;
	private JTextField celularField;
	private JTextField cepField;
	private JTextField estadoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroUsuario() {
		setResizable(false);
		setTitle("Cadastrar Usu\u00E1rio - rentAcar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(219, 47, 57, 14);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(226, 98, 24, 14);
		
		nomeField = new JTextField();
		nomeField.setBounds(356, 44, 111, 20);
		nomeField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Estado");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEndereo.setBounds(219, 164, 57, 14);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(241, 390, 89, 23);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(392, 390, 75, 23);
		
		
		MaskFormatter mascara_telefone;
		try {
			mascara_telefone = new MaskFormatter("(##)####-####");
			mascara_telefone.setValidCharacters("0123456789");
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}   
		
		MaskFormatter mascara_celular;
		try {
			mascara_celular = new MaskFormatter("(##)####-####");
			mascara_celular.setValidCharacters("0123456789");
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}
		
		MaskFormatter mascara_cep;
		try {
			mascara_cep = new MaskFormatter("#####-###");
			mascara_cep.setValidCharacters("0123456789");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}
		
		estadoField = new JTextField();
		estadoField.setBounds(356, 161, 111, 20);
		estadoField.setColumns(10);
		
		MaskFormatter mascara_cpf;
		try {
			mascara_cpf = new MaskFormatter("#########-##");
			mascara_cpf.setValidCharacters("0123456789");
			JFormattedTextField cpfField = new JFormattedTextField(mascara_cpf);
			cpfField.setBounds(356, 95, 111, 20);
			contentPane.setLayout(null);
			contentPane.add(lblNome);
			contentPane.add(lblCpf);
			contentPane.add(nomeField);
			contentPane.add(lblEndereo);
			contentPane.add(btnCadastrar);
			contentPane.add(btnCancelar);
			contentPane.add(estadoField);
			contentPane.add(cpfField);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}   
        
	}
}
