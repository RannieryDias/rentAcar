package GUI;

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
//import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.factories.FormFactory;
//import com.jgoodies.forms.layout.RowSpec;
//import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField telefoneField;
	private JTextField celularField;
	private JTextField cepField;
	private JTextField cidadeField;
	private JTextField estadoField;
	private JFormattedTextField celularField_1;
	private JFormattedTextField telefoneField_1;
	private JFormattedTextField cepField_1;

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
		setTitle("Cadastrar Usu\u00E1rio - rentAcar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(139, 152, 71, 20);
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");
		comboBox.setMaximumRowCount(2);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(78, 47, 57, 14);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(78, 98, 24, 14);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(78, 155, 57, 14);
		
		nomeField = new JTextField();
		nomeField.setBounds(139, 44, 111, 20);
		nomeField.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Estado");
		lblEndereo.setBounds(78, 275, 57, 14);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setBounds(78, 208, 57, 14);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(392, 47, 24, 14);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(241, 390, 89, 23);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(392, 390, 75, 23);
		
		JLabel lblTelefone = new JLabel("Telefone(fixo)");
		lblTelefone.setBounds(348, 155, 68, 14);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(378, 98, 33, 14);
		
		emailField = new JTextField();
		emailField.setBounds(436, 44, 124, 20);
		emailField.setColumns(10);
		
		
		MaskFormatter mascara_telefone;
		try {
			mascara_telefone = new MaskFormatter("(##)####-####");
			mascara_telefone.setValidCharacters("0123456789");
			telefoneField_1 = new JFormattedTextField(mascara_telefone);
			telefoneField_1.setBounds(436, 92, 124, 20);
			telefoneField_1.setColumns(10);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}   
		
		MaskFormatter mascara_celular;
		try {
			mascara_celular = new MaskFormatter("(##)####-####");
			mascara_celular.setValidCharacters("0123456789");
			celularField_1 = new JFormattedTextField(mascara_celular);
			celularField_1.setBounds(438, 152, 122, 20);
			celularField_1.setColumns(10);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		} 
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(359, 208, 57, 14);
		
		MaskFormatter mascara_cep;
		try {
			mascara_cep = new MaskFormatter("#####-###");
			mascara_cep.setValidCharacters("0123456789");
			cepField_1 = new JFormattedTextField(mascara_cep);
			cepField_1.setBounds(139, 205, 111, 20);
			cepField_1.setColumns(10);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}   
		
		
		cidadeField = new JTextField();
		cidadeField.setBounds(436, 205, 124, 20);
		cidadeField.setColumns(10);
		
		estadoField = new JTextField();
		estadoField.setBounds(139, 272, 111, 20);
		estadoField.setColumns(10);
		
		MaskFormatter mascara_cpf;
		try {
			mascara_cpf = new MaskFormatter("#########-##");
			mascara_cpf.setValidCharacters("0123456789");
			JFormattedTextField cpfField = new JFormattedTextField(mascara_cpf);
			cpfField.setBounds(139, 95, 111, 20);
			contentPane.setLayout(null);
			contentPane.add(comboBox);
			contentPane.add(lblNome);
			contentPane.add(lblCpf);
			contentPane.add(lblSexo);
			contentPane.add(nomeField);
			contentPane.add(lblEndereo);
			contentPane.add(lblCEP);
			contentPane.add(lblEmail);
			contentPane.add(btnCadastrar);
			contentPane.add(btnCancelar);
			contentPane.add(lblTelefone);
			contentPane.add(lblCelular);
			contentPane.add(emailField);
			contentPane.add(telefoneField_1);
			contentPane.add(celularField_1);
			contentPane.add(lblCidade);
			contentPane.add(cepField_1);
			contentPane.add(cidadeField);
			contentPane.add(estadoField);
			contentPane.add(cpfField);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}   
        
	}
}
