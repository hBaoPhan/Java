package stt02_PhanHoaiBao_tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CongTruNhanChia extends JFrame implements ActionListener {

	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;
	private JTextField txtKq;

	public CongTruNhanChia() {
		setTitle("Công trừ nhân chia");
		setSize(450, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnlNorth = new JPanel();
		add(pnlNorth, BorderLayout.NORTH);

		JLabel lblHead = new JLabel("Cộng Trừ Nhân chia");
		pnlNorth.add(lblHead);
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lblHead.setFont(font);

		JPanel pnlLeft = new JPanel();
		add(pnlLeft, BorderLayout.WEST);
		pnlLeft.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pnlLeft.setBackground(Color.gray);

		pnlLeft.setLayout(new GridLayout(8, 1, 10, 10));
		btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xóa");
		btnThoat = new JButton("Thoát");
		btnGiai.setMnemonic(KeyEvent.VK_G);
		btnXoa.setMnemonic(KeyEvent.VK_X);
		btnThoat.setMnemonic(KeyEvent.VK_T);
		pnlLeft.add(btnGiai);
		pnlLeft.add(btnXoa);
		pnlLeft.add(btnThoat);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(BorderFactory.createTitledBorder("Tính Toán"));

		add(pnlCenter, BorderLayout.CENTER);
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		pnlCenter.add(b);
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);

		JLabel lblA = new JLabel("Nhập A:");
		JLabel lblB = new JLabel("Nhập B:");
		txtA = new JTextField(15);
		txtB = new JTextField(15);
		b1.add(lblA);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(txtA);
		b2.add(lblB);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(txtB);

		JPanel pnlInside = new JPanel();
		pnlInside.setBorder(BorderFactory.createTitledBorder("Phép Toán"));
		pnlInside.setLayout(new GridLayout(2, 2, 30, 30));
		b3.add(pnlInside);

		radCong = new JRadioButton("Cộng");
		radCong.setSelected(true);
		radTru = new JRadioButton("Trừ");
		radNhan = new JRadioButton("Nhân");
		radChia = new JRadioButton("Chia");
		ButtonGroup radGroup = new ButtonGroup();
		radGroup.add(radCong);
		radGroup.add(radTru);
		radGroup.add(radNhan);
		radGroup.add(radChia);
		pnlInside.add(radCong);
		pnlInside.add(radTru);
		pnlInside.add(radNhan);
		pnlInside.add(radChia);

		JLabel lblKq = new JLabel("Kết quả");
		txtKq = new JTextField(15);
		txtKq.setEditable(false);
		b4.add(lblKq);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(txtKq);

		JPanel pnlSouth = new JPanel();
		add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setBackground(Color.pink);
		pnlSouth.setPreferredSize(new Dimension(0, 40));
		JPanel pnlBlue = new JPanel();
		pnlBlue.setBackground(Color.BLUE);
		pnlBlue.setPreferredSize(new Dimension(20, 20));
		JPanel pnlRed = new JPanel();
		pnlRed.setBackground(Color.red);
		pnlRed.setPreferredSize(new Dimension(20, 20));
		JPanel pnlYellow = new JPanel();
		pnlYellow.setBackground(Color.yellow);
		pnlYellow.setPreferredSize(new Dimension(20, 20));
		pnlSouth.add(pnlBlue);
		pnlSouth.add(pnlRed);
		pnlSouth.add(pnlYellow);

		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);

	}

	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);

	}

	public static boolean isInt(String txt) {
		try {
			Integer.parseInt(txt);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			System.exit(0);
		}
		if (o.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtA.requestFocus();
		}
		if (o.equals(btnGiai)) {
			if (!isInt(txtA.getText())) {
				JOptionPane.showMessageDialog(this, "A phải là số nguyên");
				txtA.requestFocus();
			} else if (!isInt(txtB.getText())) {
				JOptionPane.showMessageDialog(this, "B phải là số nguyên");
				txtB.requestFocus();
			} else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				double kq = 0.0;
				if (radCong.isSelected())
					txtKq.setText(Double.toString(a + b));
				else if (radTru.isSelected())
					txtKq.setText(Double.toString(a - b));
				else if (radNhan.isSelected())
					txtKq.setText(Double.toString(a * b));
				else if (radChia.isSelected())
					if (b == 0) {
						JOptionPane.showMessageDialog(this, "b phải khác 0");
						txtB.requestFocus();
					} else
						txtKq.setText(Double.toString(a / b));
			}

		}

	}

}
