package Graf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField txtVisor;
	private String senal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculadora frame = new calculadora();
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
	public calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblHistorical = new JLabel("0");
		lblHistorical.setBounds(10, 11, 206, 14);
		contentPane.add(lblHistorical);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"7");
			}
		});
		btn7.setBackground(new Color(0, 204, 153));
		btn7.setBounds(10, 134, 41, 41);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"8");
			}
		});
		btn8.setBackground(new Color(0, 204, 153));
		btn8.setBounds(61, 134, 41, 41);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"9");
			}
		});
		btn9.setBackground(new Color(0, 204, 153));
		btn9.setBounds(112, 134, 41, 41);
		contentPane.add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"4");
			}
		});
		btn4.setBackground(new Color(0, 204, 153));
		btn4.setBounds(10, 186, 41, 41);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"5");
			}
		});
		btn5.setBackground(new Color(0, 204, 153));
		btn5.setBounds(61, 186, 41, 41);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"6");
			}
		});
		btn6.setBackground(new Color(0, 204, 153));
		btn6.setBounds(112, 186, 41, 41);
		contentPane.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"1");
			}
		});
		btn1.setBackground(new Color(0, 204, 153));
		btn1.setBounds(10, 238, 41, 41);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"2");
			}
		});
		btn2.setBackground(new Color(0, 204, 153));
		btn2.setBounds(61, 238, 41, 41);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"3");
			}
		});
		btn3.setBackground(new Color(0, 204, 153));
		btn3.setBounds(112, 238, 41, 41);
		contentPane.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText(txtVisor.getText()+"0");
			}
		});
		btn0.setBackground(new Color(0, 204, 153));
		btn0.setBounds(61, 290, 92, 41);
		contentPane.add(btn0);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBackground(new Color(255, 0, 51));
		btnClear.setBounds(112, 82, 41, 41);
		contentPane.add(btnClear);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtVisor.setText("");
				lblHistorical.setText("");
			}
		});
		btnCE.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCE.setForeground(new Color(255, 255, 255));
		btnCE.setBackground(new Color(255, 0, 51));
		btnCE.setBounds(10, 82, 92, 41);
		contentPane.add(btnCE);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senal = "/";
				lblHistorical.setText(txtVisor.getText());
				txtVisor.setText("");
			}
		});
		btnDiv.setForeground(Color.WHITE);
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDiv.setBackground(new Color(255, 0, 51));
		btnDiv.setBounds(163, 82, 53, 41);
		contentPane.add(btnDiv);
		
		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senal = "+";
				lblHistorical.setText(txtVisor.getText());
				txtVisor.setText("");
			}
		});
		btnSuma.setForeground(Color.WHITE);
		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSuma.setBackground(new Color(255, 0, 51));
		btnSuma.setBounds(163, 186, 53, 41);
		contentPane.add(btnSuma);
		
		JButton btnProd = new JButton("*");
		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senal = "*";
				lblHistorical.setText(txtVisor.getText());
				txtVisor.setText("");
			}
		});
		btnProd.setForeground(Color.WHITE);
		btnProd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnProd.setBackground(new Color(255, 0, 51));
		btnProd.setBounds(163, 134, 53, 41);
		contentPane.add(btnProd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senal = "-";
				lblHistorical.setText(txtVisor.getText());
				txtVisor.setText("");
			}
		});
		btnSub.setForeground(Color.WHITE);
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSub.setBackground(new Color(255, 0, 51));
		btnSub.setBounds(163, 238, 53, 41);
		contentPane.add(btnSub);
		
		txtVisor = new JTextField();
		txtVisor.setBackground(SystemColor.window);
		txtVisor.setEditable(false);
		txtVisor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVisor.setBounds(10, 36, 206, 35);
		contentPane.add(txtVisor);
		txtVisor.setColumns(10);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double result = 0;
				switch (senal) {
					case "+": result = Double.parseDouble(lblHistorical.getText()) + Double.parseDouble(txtVisor.getText());
						break;
					case "-": result = Double.parseDouble(lblHistorical.getText()) - Double.parseDouble(txtVisor.getText());
						break;
					case "/": result = Double.parseDouble(lblHistorical.getText()) / Double.parseDouble(txtVisor.getText());
						break;
					case "*": result = Double.parseDouble(lblHistorical.getText()) * Double.parseDouble(txtVisor.getText());
						break;
				}
				txtVisor.setText(Double.toString(Math.ceil(Math.round(result))));
			}
		});
		btnEqual.setBackground(new Color(0, 102, 255));
		btnEqual.setBounds(163, 290, 53, 41);
		contentPane.add(btnEqual);
		
		JButton button = new JButton(".");
		button.setBackground(new Color(0, 204, 153));
		button.setBounds(10, 290, 41, 41);
		contentPane.add(button);
	}
}
