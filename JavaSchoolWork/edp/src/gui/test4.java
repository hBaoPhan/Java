package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test4 extends JFrame implements ActionListener {
	
	
	
	public static void main(String[] args) {
		new test4().setVisible(true);
	}

	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnLogin;
	private JButton btnExit;

	public test4()  {
		// setup jframe
				setTitle("Demo");
				setSize(300, 150);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
				
//				setResizable(false);
//				setLocationRelativeTo(null);

				JPanel p = new JPanel(new BorderLayout());
//				p.setLayout(new GridLayout(3,2));
//				p.setLayout(new BoxLayout(p,));
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
				p.add(b, BorderLayout.NORTH);
				//dang ky lang nghe sk
				btnLogin.addActionListener(this);
				btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnExit))
			System.exit(0);
		if(o.equals(btnLogin)) {
			String pass = txtPass.getText();
			if(pass.equals("abc"))
				JOptionPane.showMessageDialog(this, "đúng pass");
			else {
				JOptionPane.showMessageDialog(this, "sai pass");
				txtPass.selectAll();
				txtPass.requestFocus();
			}
		}
	}
}
