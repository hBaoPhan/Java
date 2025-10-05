package stt02_PhanHoaiBao_lt3;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutDemo extends JFrame {

	public FlowLayoutDemo() {
		setTitle("Demo Layout");
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		for (int i = 0; i < 10; i++) {
			this.add(new JButton("Button"+i));
		}
		
	}
	public static void main(String[] args) {
		new FlowLayoutDemo().setVisible(true);
	}
	

}
