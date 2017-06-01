package CineJPanel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class SelectScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectScreen frame = new SelectScreen();
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
	public SelectScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 238, 303);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		String[] column = {"codigo", "nombre", "calificacion"};
		ConexionDAO conn = new ConexionDAO();
		Object[][] peliculas = conn.select_peliculas();
		
		
		table = new JTable();
		table.setBounds(10, 11, 444, 340);
		table.setFillsViewportHeight(false);
		table.setModel(new DefaultTableModel(peliculas, column));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		contentPane.add(table.getTableHeader());
		contentPane.add(table);
		
		
		
		
		//DefaultTableModel datos = new DefaultTableModel(peliculas, column);
		//table.setModel(datos);
		

	}
}
