package regExp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RegExpTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtLop;
	private JTextField txtEmail;
	private JTextField txtBienSo;
	private JTextField txtMSSV;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoa;

	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;

	// private SachTableModel tableModel;
	private DefaultTableModel tableModel;
	private JButton btnLoc;

	public RegExpTest() {
		setTitle("bai thuc hanh");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Pháº§n North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("Lớp "));
		pnlNorth.add(lblTuaSach = new JLabel("Email "));
		pnlNorth.add(lblTacGia = new JLabel("Biển số: "));
		pnlNorth.add(lblNamXB = new JLabel("Mssv: "));
		pnlNorth.add(lblNhaXB = new JLabel("Nhà  xuất bản "));
		pnlNorth.add(lblSoTrang = new JLabel("Số trang: "));
		pnlNorth.add(lblDonGia = new JLabel("Đơn giá: "));
		pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

		pnlNorth.add(txtLop = new JTextField());
		pnlNorth.add(txtEmail = new JTextField());
		pnlNorth.add(txtBienSo = new JTextField());
		pnlNorth.add(txtMSSV = new JTextField());
		pnlNorth.add(txtNhaXB = new JTextField());
		pnlNorth.add(txtSoTrang = new JTextField());
		pnlNorth.add(txtDonGia = new JTextField());
		pnlNorth.add(txtISBN = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaSach.setBounds(20, 20, w1, h);
		txtLop.setBounds(120, 20, 200, h);

		lblTuaSach.setBounds(20, 45, w1, h);
		txtEmail.setBounds(120, 45, w2, h);
		lblTacGia.setBounds(450, 45, w1, h);
		txtBienSo.setBounds(570, 45, w2, h);

		lblNamXB.setBounds(20, 70, w1, h);
		txtMSSV.setBounds(120, 70, w2, h);
		lblNhaXB.setBounds(450, 70, w1, h);
		txtNhaXB.setBounds(570, 70, w2, h);

		lblSoTrang.setBounds(20, 95, w1, h);
		txtSoTrang.setBounds(120, 95, w2, h);
		lblDonGia.setBounds(450, 95, w1, h);
		txtDonGia.setBounds(570, 95, w2, h);

		lblISBN.setBounds(20, 120, 220, h);
		txtISBN.setBounds(240, 120, 180, h);
		txtMess.setBounds(20, 145, 550, 20);

		// Pháº§n Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Them"));

		pnlCenter.add(btnXoaRong = new JButton("Làm rỗng"));

		// Pháº§n South
		JScrollPane scroll;
		String[] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sach cac quyen sach"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		btnThem.addActionListener(this);

		btnXoaRong.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(validData()) {
				String ma = txtLop.getText().trim();
				String tuaSach = txtEmail.getText().trim();
				String tacGia = txtBienSo.getText().trim();
				String isbn = txtISBN.getText().trim();
				String nam =txtMSSV.getText().trim();
				String nhaXB=txtNhaXB.getText().trim();
				String gia =txtDonGia.getText().trim();
				String soTrang=txtSoTrang.getText().trim();
				tableModel.addRow(new Object[] {ma,tuaSach,tacGia,nam,nhaXB,soTrang,gia,isbn});
			}

		}
		if (o.equals(btnXoaRong)) {
		}
	}

	public boolean validData() {
		String ma = txtLop.getText().trim();
		String email = txtEmail.getText().trim();
		String bienSo = txtBienSo.getText().trim();
		String mssv=txtMSSV.getText().trim();
		Double gia;
		String isbn = txtISBN.getText().trim();
		int soTrang;
		String nhaXB=txtNhaXB.getText().trim();

		if (!(ma.length() > 0 && ma.matches("DH(KHMT|KTPM|HTTT|CNTT|KHDL){1}\\d{2}[A-F](TT|_KSTN|_TCTA)*"))) {
			JOptionPane.showMessageDialog(this, "Phải đúng lớp danh nghĩa");
			txtLop.requestFocus();
			txtLop.selectAll();
			return false;

		} else if (!(email.length() > 0 && email.matches("[\\d\\w._\\-\\+]+\\@gmail\\.com"))) {
			JOptionPane.showMessageDialog(this, "Phải đúng dạng email");
			txtEmail.requestFocus();
			txtEmail.selectAll();
			return false;
		}else if (!(mssv.matches("23\\d{6}"))) {
				JOptionPane.showMessageDialog(this, "MSSV phải bắt đầu bằng 23 và theo sau là 6 chữ số");
				txtMSSV.requestFocus();
				txtMSSV.selectAll();
				return false;
		
		} else if (!(bienSo.length() > 0 && bienSo.matches("\\d{2}\\-(\\w{2}|\\w\\d|MD1){1}\\d{3}\\.\\d{2}"))) {
			JOptionPane.showMessageDialog(this, "Phải đúng biển số");
			txtBienSo.requestFocus();
			txtBienSo.selectAll();
			return false;
		}else if (!(nhaXB.length() > 0 && nhaXB.matches("[\\w ']+"))) {
			JOptionPane.showMessageDialog(this, "Nhà xuất bản Không được chứa số và các ký tự đặc biệt ngoại trừ '");
			txtNhaXB.requestFocus();
			txtNhaXB.selectAll();
			return false;
		}
		
		
		try {
			soTrang = Integer.parseInt(txtSoTrang.getText().trim());
			if (soTrang < 0) {
				JOptionPane.showMessageDialog(this, "Số trang phải lớn hơn 0");
				txtSoTrang.requestFocus();
				txtSoTrang.selectAll();
				return false;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Số trang phải là số");
			txtSoTrang.requestFocus();
			txtSoTrang.selectAll();
			return false;
		}
		try {
			gia = Double.parseDouble(txtDonGia.getText().trim());
			if (gia < 0) {
				JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0");
				txtDonGia.requestFocus();
				txtDonGia.selectAll();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Giá phải là số");
			txtDonGia.requestFocus();
			txtDonGia.selectAll();
			return false;
		}
		if (!(isbn.length() > 0 && isbn.matches("\\d+(-\\d+){3,4}"))) {
			JOptionPane.showMessageDialog(this, "ISBN phải có dạng X-X-X-X (hoặc X-X-X-X-X) ");
			txtISBN.requestFocus();
			txtISBN.selectAll();
			return false;
		}
		return true;

	}
	public static void main(String[] args) {
		new RegExpTest().setVisible(true);
	}
}

