package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.MainController;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JMenu mnNewMenu;
	
	private MainController mainController;
	public JMenuItem ItemSalida;
	public JMenuItem ItemLavado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView() {
		this.initComponents();
		this.mainController = new MainController(this);
		
		this.ItemSalida.addActionListener(this.mainController);
		this.ItemLavado.addActionListener(this.mainController);
	}
	
	private void initComponents() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu ItemOpciones = new JMenu("OPCIONES");
		menuBar.add(ItemOpciones);
		
		ItemSalida = new JMenuItem("SALIR");
		ItemOpciones.add(ItemSalida);
		
		mnNewMenu = new JMenu("FUNCIONES");
		menuBar.add(mnNewMenu);
		
		ItemLavado = new JMenuItem("LAVADO");
		mnNewMenu.add(ItemLavado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
