package gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnLogin;
	private JButton btnExit;

	public test1() {
		// setup jframe
		setTitle("Demo");
		setSize(300, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);
//		setLocationRelativeTo(null);

		JPanel p = new JPanel();
//		p.setLayout(new GridLayout(3,2));
		add(p);

		JLabel lblUser = new JLabel("User Name: ");
		JLabel lblPass = new JLabel("Pass Word: ");
		txtUser = new JTextField(15);
		txtPass = new JTextField(15);
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");

		Box b, b1, b2, b3;
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		
		b1.add(lblUser);
		b1.add(txtUser);
		b2.add(lblPass);
		b2.add(txtPass);
		b3.add(btnLogin);
		b3.add(btnExit);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		p.add(b);
//
//		p.add(lblUser);
//		p.add(txtUser);
//		p.add(lblPass);
//		p.add(txtPass);
//		p.add(btnLogin);
//		p.add(btnExit);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test().setVisible(true);
	}

}
