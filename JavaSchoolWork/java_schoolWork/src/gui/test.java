package gui;

import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test extends JFrame {

	
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnLogin;
	private JButton btnExit;

	public test() {
		//setup jframe
		setTitle("Demo");
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel p = new JPanel();
		add(p);
		
		JLabel lblUser = new JLabel("User Name: ");
		JLabel lblPass = new JLabel("Pass Word: ");
		txtUser = new JTextField(15);
		txtPass = new JTextField(15);
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		p.add(lblUser);
		p.add(txtUser);
		p.add(lblPass);
		p.add(txtPass);
		p.add(btnLogin);
		p.add(btnExit);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test().setVisible(true);
	}

}
