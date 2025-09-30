package stt02_PhanHoaiBao_lt4;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPasswordFieldDemo extends JFrame implements ActionListener{
	

	private JPasswordField txtPass;
	private JButton btnOk;
	private JButton btnCancel;

	public JPasswordFieldDemo() {
		setTitle("Công trừ nhân chia");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnlLeft=new JPanel();
		add(pnlLeft,BorderLayout.WEST);
		
		JLabel lblPass=new JLabel("Password:");
		txtPass=new JPasswordField(12);	
		pnlLeft.add(lblPass);
		pnlLeft.add(txtPass);
		
		JPanel pnlRight=new JPanel();
		pnlRight.setLayout(new GridLayout(2,1));
		add(pnlRight,BorderLayout.CENTER);
		
		btnOk=new JButton("OK");
		btnCancel= new JButton("Cancel");
		
		pnlRight.add(btnOk);
		pnlRight.add(btnCancel);
		
		btnOk.addActionListener(this);
		txtPass.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new JPasswordFieldDemo().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnOk) || o.equals(txtPass)) {
			char charPass[]=txtPass.getPassword();
			String strPass=new String(charPass);
			if(strPass.trim().equals("pass")) {
				JOptionPane.showMessageDialog(this, "Đúng mật khẩu");
				System.exit(0);
			}
			else{
				JOptionPane.showMessageDialog(this, "Sai mật khẩu");
				txtPass.requestFocus();
			}
			
		}
		else {
			System.exit(0);
		}
		
	}

}
