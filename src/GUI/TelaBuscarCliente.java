package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import exceptions.AdministradorNaoExisteException;
import exceptions.ClienteJaExisteException;
import exceptions.RepositorioException;
import exceptions.VeiculoNaoExisteException;

public class TelaBuscarCliente extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public TelaBuscarCliente() {
		setTitle("Buscar Cliente - rentAcar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF:");
		lblDigiteOCpf.setBounds(25, 26, 62, 14);
		contentPane.add(lblDigiteOCpf);
		
		
		MaskFormatter mascara_cpf;
		try {
			mascara_cpf = new MaskFormatter("#########-##");
			mascara_cpf.setValidCharacters("0123456789");
			JFormattedTextField cpfField = new JFormattedTextField(mascara_cpf);
			cpfField.setBounds(113, 23, 111, 20);
			contentPane.add(cpfField);
			String cpf = cpfField.getText().replace("-", "") ;
			
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Negocio.Fachada fachada = new Negocio.Fachada();
						try{ 
						fachada.procurarAdministrador(cpf);
						JOptionPane.showMessageDialog(cpfField, "achou!");
						}catch (AdministradorNaoExisteException e) {
							JOptionPane.showMessageDialog(null, "Administrador n�o encontrado");
							e.printStackTrace();
						}
					} catch (ClassNotFoundException | ClienteJaExisteException
							| RepositorioException | VeiculoNaoExisteException e) {
						e.printStackTrace(); 
					}
				}
			});
			
			
			btnBuscar.setBounds(240, 22, 89, 23);
			contentPane.add(btnBuscar);
			
			JTextPane textPane = new JTextPane();
			textPane.setBounds(42, 64, 359, 162);
			contentPane.add(textPane);
			
			
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "erro ao montar mascara");
		}   
	}

}
