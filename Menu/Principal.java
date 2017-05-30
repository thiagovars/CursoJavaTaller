package Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// 1. Primero se crea la barra.
		JMenuBar barra = new JMenuBar();
		
		// 2. Luego se crean los menus.
		JMenu archivo = new JMenu("Archivo");
		JMenu ayuda = new JMenu("Ayuda");
		
		// 3. y se crean los elementos de menu. 
		JMenuItem abrir = new JMenuItem("Abrir");
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem Acercade = new JMenuItem("Acerca de..");
		
		// 4. Despues se añaden los elementos de menu a su correspondiente menu.
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(salir);		 
		ayuda.add(Acercade);
		
		// 5. y por ultimo se añaden los menus a la barra.
		barra.add(archivo);
		barra.add(ayuda);
		
		
		// 6. Luego se añade la barra al applet.
		setJMenuBar(barra);
		
		// 7. Configuro el submenu Acerca de.. para abrir otra ventana
		Acercade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				AcerdaDe Otraventana = new AcerdaDe();
				Otraventana.setVisible(true);
			}
		});		
		
	}

}
