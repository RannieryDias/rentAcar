package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class DesktopAdmin extends JFrame {

	private JPanel contentPane;


	public DesktopAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadatrar = new JMenuItem("Cadastrar Admin");
		mnCadastrar.add(mntmCadatrar);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mnCadastrar.add(mntmCadastrarCliente);
		
		JMenu mnAlugar = new JMenu("Aluguel");
		menuBar.add(mnAlugar);
		
		JMenuItem mntmAlugarCarro = new JMenuItem("Alugar Carro");
		mnAlugar.add(mntmAlugarCarro);
		
		JMenuItem mntmDevoluoDeCarro = new JMenuItem("Devolu\u00E7\u00E3o de Carro");
		mnAlugar.add(mntmDevoluoDeCarro);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
	}
}
