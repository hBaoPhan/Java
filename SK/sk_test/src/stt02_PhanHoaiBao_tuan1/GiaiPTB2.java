package stt02_PhanHoaiBao_tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GiaiPTB2 extends JFrame implements ActionListener {

	private Font fo;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKq;
	private JButton btnGiai;
	private JButton btnXoaRong;
	private JButton btnThoat;

	public GiaiPTB2() {
		setTitle("Giải phương trình bậc 2");
		setSize(450, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel pNorth = new JPanel();
		add(pNorth, BorderLayout.NORTH);
		pNorth.setBackground(Color.cyan);

		JLabel lblHead = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		pNorth.add(lblHead);
		fo = new Font("Time New Roman", fo.BOLD, 20);
		lblHead.setFont(fo);

		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);

		JLabel lblA = new JLabel("Nhập a:");
		JLabel lblB = new JLabel("Nhập b:");
		JLabel lblC = new JLabel("Nhập c:");
		JLabel lblKq = new JLabel("Kết quả");
		txtA = new JTextField(20);
		txtB = new JTextField(20);
		txtC = new JTextField(20);
		txtKq = new JTextField(20);
		txtKq.setEditable(false);

		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		pCenter.add(b);
		b.add(Box.createVerticalStrut(10));
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);
		b1.add(lblA);
		b1.add(Box.createHorizontalStrut(30));
		b1.add(txtA);
		b2.add(lblB);
		b2.add(Box.createHorizontalStrut(30));
		b2.add(txtB);
		b3.add(lblC);
		b3.add(Box.createHorizontalStrut(30));
		b3.add(txtC);
		b4.add(lblKq);
		b4.add(Box.createHorizontalStrut(30));
		b4.add(txtKq);

		JPanel pSouth = new JPanel();
		pSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		add(pSouth, BorderLayout.SOUTH);

		btnGiai = new JButton("Giải");
		btnXoaRong = new JButton("Xóa rỗng");
		btnThoat = new JButton("Thoát");

		pSouth.add(btnGiai);
		pSouth.add(btnXoaRong);
		pSouth.add(btnThoat);

		btnGiai.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);

	}

	public static void main(String[] args) {
		new GiaiPTB2().setVisible(true);
		;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int a, b, c, delta = 0;
		double kq = 0, x1 = 0, x2;
//		DecimalFormat fmt=new DecimalFormat("0.#");
		Object o = e.getSource();
		if (o.equals(btnGiai)) {
			a = Integer.parseInt(txtA.getText());
			b = Integer.parseInt(txtB.getText());
			c = Integer.parseInt(txtC.getText());
			if (a == 0) {
				if (b == 0) {
					if (c == 0) {
						txtKq.setText("Phương trình vô số nghiệm");
					} else
						txtKq.setText("Phương trình vô nghiệm");
				} else
					kq = -1.0 * c / b;
				txtKq.setText(Double.toString(kq));
			} else
				delta = b * b - 4 * a * c;
			if (delta < 0)
				txtKq.setText("Phương trình vô nghiệm");
			else if (delta == 0) {
				x1 = x2 = 1.0 * b / (2 * a);
				txtKq.setText(Double.toString(x1));
			} else {
				x1 = (-1.0 * b + Math.sqrt(delta)) / (2 * a);
				x2 = (-1.0 * b - Math.sqrt(delta)) / (2 * a);
				txtKq.setText("x1=" + Double.toString(x1) + " x2=" + Double.toString(x2));
			}
		}
		if (o.equals(btnThoat)) {
			System.exit(0);
		}
		if (o.equals(btnXoaRong))
			txtA.setText("");
		txtB.setText("");
		txtC.setText("");

	}

}
