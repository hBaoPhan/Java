package stt02_PhanHoaiBao_Lt3;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame {
	

	public BorderLayoutDemo() {
		setTitle("Demo Layout");
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new JButton("North"),BorderLayout.NORTH);
		add(new JButton("South"),BorderLayout.SOUTH);
		add(new JButton("West"),BorderLayout.WEST);
		add(new JButton("East"),BorderLayout.EAST);
		add(new JButton("Center"),BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new BorderLayoutDemo().setVisible(true);

	}

}
