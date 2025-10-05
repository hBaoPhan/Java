package stt02_PhanHoaiBao_lt4;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JTextFieldDemo extends JFrame implements ActionListener {

	private JTextField txtInput;
	private JLabel lblResult;

	public JTextFieldDemo() {
		setTitle("Chuyển đổi đơn vị");
		setSize(400, 80);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 2));

		JLabel lblInput = new JLabel("Nhập vào số milimet:");
		JLabel lblOutput = new JLabel("Số centimet tương ứng:");
		lblResult = new JLabel("...");
		txtInput = new JTextField(10);
		add(lblInput);
		add(txtInput);
		add(lblOutput);
		add(lblResult);

		txtInput.addActionListener(this);

	}

	public static void main(String[] args) {
		new JTextFieldDemo().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Double cm, mm;
		mm = Double.parseDouble(txtInput.getText());
		lblResult.setText(Double.toString(mm / 10));

	}

}
