package stt02_PhanHoaiBao_tuan3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListCheckBox extends JFrame implements ActionListener, ListSelectionListener {

	private JButton btnToDenSoChan;
	private JButton btnToDenSoLe;
	private JButton btnToDenNgTo;
	private JButton btnBoToDen;
	private JButton btnXoaToDen;
	private JButton btnTong;
	private JButton btnPhatSinh;
	private JButton btnNhap;
	private JTextField txtNhap;
	private JCheckBox chkSoAm;
	private DefaultListModel<Integer> model;
	private JList<Integer> list;
	private JButton btnDong;

	public JListCheckBox() {
		setTitle("Thao tác trên Jlist");
		setSize(550, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel pnlNorth = new JPanel();
		add(pnlNorth, BorderLayout.NORTH);
		JLabel lblHead = new JLabel("Thao tác trên JList - Checkbox");
		lblHead.setFont(new Font("Time New Roman", Font.BOLD, 20));
		pnlNorth.add(lblHead);
		lblHead.setForeground(Color.blue);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setLayout(new GridLayout(8, 1, 7, 7));
		add(pnlLeft, BorderLayout.WEST);
		pnlLeft.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pnlLeft.add(btnToDenSoChan = new JButton("Tô đen số chẵn"));
		pnlLeft.add(btnToDenSoLe = new JButton("Tô đen số lẻ"));
		pnlLeft.add(btnToDenNgTo = new JButton("Tô đen số nguyên tố"));
		pnlLeft.add(btnBoToDen = new JButton("Bỏ tô đen"));
		pnlLeft.add(btnXoaToDen = new JButton("Xóa các giá trị đang tô đen"));
		pnlLeft.add(btnTong = new JButton("Tổng giá trị trong JList"));
		pnlLeft.add(btnPhatSinh = new JButton("Phát Sinh số ngẫu nhiên"));

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new BorderLayout());
		add(pnlCenter);
		pnlCenter.setBorder(BorderFactory.createTitledBorder("Nhập thông tin:"));

		JPanel pnlHead = new JPanel();
		btnNhap = new JButton("Nhập");
		txtNhap = new JTextField(10);
		chkSoAm = new JCheckBox("Cho nhập số âm");
		pnlHead.add(btnNhap);
		pnlHead.add(txtNhap);
		pnlHead.add(chkSoAm);
		pnlCenter.add(pnlHead, BorderLayout.NORTH);

		model = new DefaultListModel<Integer>();
		list = new JList<Integer>(model);
		JScrollPane scrList = new JScrollPane(list);
		pnlCenter.add(scrList, BorderLayout.CENTER);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setPreferredSize(new Dimension(400, 40));
		pnlSouth.setBorder(BorderFactory.createLineBorder(Color.gray));
		add(pnlSouth, BorderLayout.SOUTH);
		btnDong = new JButton("Đóng chương trình");
		pnlSouth.add(btnDong);

		btnNhap.addActionListener(this);
		btnToDenSoChan.addActionListener(this);
		;
		btnToDenSoLe.addActionListener(this);
		btnToDenNgTo.addActionListener(this);
		btnBoToDen.addActionListener(this);
		btnXoaToDen.addActionListener(this);
		btnTong.addActionListener(this);
		btnPhatSinh.addActionListener(this);
		list.addListSelectionListener(this);
		btnDong.addActionListener(this);
	}

	public static void main(String[] args) {
		new JListCheckBox().setVisible(true);

	}

	private void nhapSoTuBanPhim() {
		int n;
		try {
			n = Integer.parseInt(txtNhap.getText());
			if (!chkSoAm.isSelected() && n > 0) {
				model.addElement(n);
			} else if (chkSoAm.isSelected()) {
				model.addElement(n);
			} else {
				JOptionPane.showMessageDialog(this, "Không được nhập số âm");
				return;
			}
			txtNhap.setText("");
			txtNhap.requestFocus();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Nhập số");
			txtNhap.setText("");
			txtNhap.requestFocus();
			return;
		}
	}

	private void phatSinhSo() {
		for (int i = 0; i < 50; i++) {
			if (chkSoAm.isSelected())
				model.addElement(new Random().nextInt(100) - 20);
			else
				model.addElement(new Random().nextInt(100));
		}
	}

	private void chonSoChan() {
		list.clearSelection();
		for (int i = 0; i < model.size(); i++) {
			if (model.getElementAt(i) % 2 == 0)
				list.addSelectionInterval(i, i);
		}
	}

	private void chonSoLe() {
		list.clearSelection();
		for (int i = 0; i < model.size(); i++) {
			if (model.getElementAt(i) % 2 != 0)
				list.addSelectionInterval(i, i);
		}
	}

	private boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}

	private void chonSoNguyenTo() {
		list.clearSelection();
		for (int i = 0; i < model.size(); i++) {
			if (isPrime(model.getElementAt(i)))
				list.addSelectionInterval(i, i);

		}

	}

	private void xoaPhanTuToDen() {
		for (Integer a : list.getSelectedValuesList()) {
			model.removeElement(a);
		}
	}

	private int tinhTong() {
		int s = 0;
		for (int i = 0; i < model.size(); i++) {
			s += model.getElementAt(i);
		}
		return s;

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnNhap))
			nhapSoTuBanPhim();
		else if (o.equals(btnPhatSinh))
			phatSinhSo();
		else if (o.equals(btnToDenSoChan))
			chonSoChan();
		else if (o.equals(btnToDenSoLe))
			chonSoLe();
		else if (o.equals(btnBoToDen))
			list.clearSelection();
		else if (o.equals(btnToDenNgTo))
			chonSoNguyenTo();
		else if (o.equals(btnXoaToDen))
			xoaPhanTuToDen();

		else if (o.equals(btnDong))
			System.exit(0);
		else if (o.equals(btnTong))
			JOptionPane.showMessageDialog(this, "Tổng các phần tử: " + tinhTong());

	}

}
