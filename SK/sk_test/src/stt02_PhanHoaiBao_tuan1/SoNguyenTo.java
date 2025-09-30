package stt02_PhanHoaiBao_tuan1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SoNguyenTo extends JFrame implements ActionListener {

	private JTextField txtInput;
	private JButton btnGen;
	private JTextArea txtOutput;

	public SoNguyenTo() {
		setTitle("Primes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 425);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		add(panel);
		Box b = Box.createVerticalBox();
		panel.add(b);
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		b.add(b1);
		b.add(b2);

		txtInput = new JTextField(20);
		btnGen = new JButton("Generate");
		txtOutput = new JTextArea(20, 40);
		txtOutput.setBorder(BorderFactory.createLineBorder(Color.black));

		b1.add(txtInput);
		b1.add(btnGen);
		b2.add(txtOutput);

		btnGen.addActionListener(this);

	}

	public static void main(String[] args) {
		new SoNguyenTo().setVisible(true);

	}

	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int count = 0, i = 0;
		String s = "";
		String input = txtInput.getText();
		int nums = Integer.parseInt(input);
		while (count < nums) {
			i++;
			if (isPrime(i)) {
				count++;
				s += i + "\n";
			}
		}
		txtOutput.setText(s);
	}

}
