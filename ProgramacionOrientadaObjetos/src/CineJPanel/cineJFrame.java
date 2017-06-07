package CineJPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.dnd.Autoscroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;

public class cineJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cineJFrame frame = new cineJFrame();
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
	public cineJFrame() {
		this.setTitle("Editor Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 443);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] column = {"codigo", "nombre", "calificacion"};
		ConexionDAO conn = new ConexionDAO();
		Object[][] peliculas = conn.select_peliculas();
		
		table = new JTable();
		table.setBounds(10, 1, 444, 222);
		table.setModel(new DefaultTableModel(peliculas, column));
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		
		contentPane.add(table);
		
		JMenuBar barra = new JMenuBar();

		JMenu archivo = new JMenu("File");
		
		JMenuItem edit   = new JMenuItem("Edit");
		JMenuItem insert = new JMenuItem("Insert");
		JMenuItem delete = new JMenuItem("Delete");
		JMenuItem exit = new JMenuItem("Exit");
		
		archivo.add(edit);
		archivo.add(insert);
		archivo.add(delete);
		archivo.add(exit);
		
		barra.add(archivo);
		
		setJMenuBar(barra);
		
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertScreen insertVentana = new InsertScreen();
				insertVentana.setVisible(true);
			}
		});

		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
}
