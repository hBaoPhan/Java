package stt02_PhanHoaiBao_Lt3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoxLayoutDemo extends JFrame implements ActionListener{
	
	private JTextField TextUser;
	private JTextField TextPass;
	private JButton LoginBtn;
	private JButton ExitBtn;

	public BoxLayoutDemo() {
		
		setTitle("BoxLayoutDemo");
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel=new JPanel(new BorderLayout());
		add(panel);
		
		Box b=Box.createVerticalBox();
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		Box b3=Box.createHorizontalBox();
		
		JLabel LabelUser = new JLabel("User name:");
		TextUser=new JTextField();
		JLabel LabelPass = new JLabel("Password:");
		TextPass = new JTextField();
		LoginBtn = new JButton("Login");
		ExitBtn = new JButton("Exit");
		
		b1.add(LabelUser);
		b1.add(TextUser);
		b2.add(LabelPass);
		b2.add(TextPass);
		b3.add(LoginBtn);
		b3.add(ExitBtn);
		
		b.add(Box.createVerticalStrut(15));
		b.add(b1);
		b.add(Box.createVerticalStrut(15));
		b.add(b2);
		b.add(Box.createVerticalStrut(15));
		b.add(b3);
		panel.add(b,BorderLayout.NORTH);
		
		LoginBtn.addActionListener(this);
		ExitBtn.addActionListener(this);
		
		
	}

	public static void main(String[] args) {
		new BoxLayoutDemo().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o.equals(ExitBtn))
			System.exit(0);
		if(o.equals(LoginBtn)) {
			String pass=TextPass.getText();
			if(pass.equals("aaa"))
				JOptionPane.showMessageDialog(this, "đúng pass");
			else {
				JOptionPane.showMessageDialog(this, "sai pass");
			}
				
		}
			
			
		
	}

}
