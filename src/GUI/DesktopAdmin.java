package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import exceptions.ClienteJaExisteException;
import exceptions.RepositorioException;
import exceptions.VeiculoNaoExisteException;

public class DesktopAdmin extends JFrame {

	private JPanel contentPane;


	public DesktopAdmin() {
		setTitle("Menu - rentAcar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 398);
		
		ImageIcon icon = new ImageIcon("RentACar/rentAcar.png"); 
		JLabel label = new JLabel(icon); 
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadastrarAdm = new JMenuItem("Cadastrar Admin");
		mnCadastrar.add(mntmCadastrarAdm);
		mntmCadastrarAdm.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				TelaCadastroAdm adm = null;
				try {
					adm = new TelaCadastroAdm();
				} catch (ParseException | ClassNotFoundException | ClienteJaExisteException | RepositorioException | VeiculoNaoExisteException e1) {
					e1.printStackTrace();
				}
				adm.show();
			}
		});

		
		JMenuItem mntmCadastrarUsuario = new JMenuItem("Cadastrar Usuario");
		mnCadastrar.add(mntmCadastrarUsuario);
		mntmCadastrarUsuario.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				TelaCadastroUsuario adm = new TelaCadastroUsuario();
				adm.show();
			}
		});
		
		JMenu mnAlugar = new JMenu("Aluguel");
		menuBar.add(mnAlugar);
		
		JMenuItem mntmAlugarCarro = new JMenuItem("Alugar Carro");
		mnAlugar.add(mntmAlugarCarro);
		
		JMenuItem mntmDevoluoDeCarro = new JMenuItem("Devolu\u00E7\u00E3o de Carro");
		mnAlugar.add(mntmDevoluoDeCarro);
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmBuscarAdministrador = new JMenuItem("Buscar Administrador");
		mnBuscar.add(mntmBuscarAdministrador);
		mntmBuscarAdministrador.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e){
				TelaBuscarAdm adm = new TelaBuscarAdm();
				adm.show();
			}
		});
		
		JMenuItem mntmBuscarCliente = new JMenuItem("Buscar Cliente");
		mnBuscar.add(mntmBuscarCliente);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(DesktopAdmin.class.getResource("/Imagens/rentAcar.png")));
		lblLogo.setBounds(-62, 0, 513, 328);
		desktopPane.add(lblLogo);
	}
}
