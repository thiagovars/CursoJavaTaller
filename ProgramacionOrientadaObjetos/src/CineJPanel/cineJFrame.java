package CineJPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class cineJFrame extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar barra = new JMenuBar();

		JMenu archivo = new JMenu("File");
		
		JMenuItem select = new JMenuItem("Select");
		JMenuItem edit   = new JMenuItem("Edit");
		JMenuItem insert = new JMenuItem("Insert");
		JMenuItem delete = new JMenuItem("Delete");
		
		
		archivo.add(select);
		archivo.add(edit);
		archivo.add(insert);
		archivo.add(delete);		 
		
		barra.add(archivo);
		
		setJMenuBar(barra);
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				SelectScreen SelectVentana = new SelectScreen();
				SelectVentana.setVisible(true);
			}
		});
		
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertScreen insertVentana = new InsertScreen();
				insertVentana.setVisible(true);
			}
		});
	}
}
