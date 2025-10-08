package stt02_PhanHoaiBao_tuan5;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMa;
	private JTextField txtTua;
	private JTextField txtTacGia;
	private JTextField txtNam;
	private JTextField txtNhaXuatBan;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtBookNum;
	private JComboBox<String> cbTim;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private DefaultTableModel model;
	private JTable tableSach;
	private DsSach dsSach;

	public GiaoDien() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Quản Lý sách");

		JPanel pnlNorth = new JPanel();
		add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();

		JLabel lblMa = new JLabel("Mã sách:");
		txtMa = new JTextField(10);
		JLabel lblTua = new JLabel("Tựa sách:");
		txtTua = new JTextField(10);
		JLabel lblTacGia = new JLabel("Tác giả:");
		txtTacGia = new JTextField(10);
		JLabel lblNam = new JLabel("Năm xuất bản:");
		txtNam = new JTextField(10);
		JLabel lblNhaXuatBan = new JLabel("Nhà xuất bản:");
		txtNhaXuatBan = new JTextField(10);
		JLabel lblSoTrang = new JLabel("Số Trang:");
		txtSoTrang = new JTextField(10);
		JLabel lblDonGia = new JLabel("Đơn giá:");
		txtDonGia = new JTextField(10);
		JLabel lblBookNum = new JLabel("International Standard Book Number:");
		txtBookNum = new JTextField(10);

		b.add(b1);
		b1.add(lblMa);
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtMa);

		b.add(b2);
		b2.add(lblTua);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTua);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTacGia);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(txtTacGia);

		b.add(b3);
		b3.add(lblNam);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNam);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNhaXuatBan);
		b3.add(Box.createHorizontalStrut(20));
		b3.add(txtNhaXuatBan);

		b.add(b4);
		b4.add(lblSoTrang);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtSoTrang);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblDonGia);
		b4.add(Box.createHorizontalStrut(20));
		b4.add(txtDonGia);

		b.add(b5);
		b5.add(lblBookNum);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(txtBookNum);

		pnlNorth.add(b);

		lblMa.setPreferredSize(lblNam.getPreferredSize());
		lblTua.setPreferredSize(lblNam.getPreferredSize());
		lblSoTrang.setPreferredSize(lblNam.getPreferredSize());
		lblTacGia.setPreferredSize(lblNhaXuatBan.getPreferredSize());
		lblDonGia.setPreferredSize(lblNhaXuatBan.getPreferredSize());

		JPanel pnlCenter = new JPanel(new BorderLayout());
		add(pnlCenter, BorderLayout.CENTER);

		JPanel pnlCenterNorth = new JPanel();
		pnlCenter.add(pnlCenterNorth, BorderLayout.NORTH);

		btnThem = new JButton("Thêm");
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnLuu = new JButton("Lưu");
		JLabel lblTim = new JLabel("Tìm theo mã sách:");
		cbTim = new JComboBox<String>();
		cbTim.addItem("A001");

		pnlCenterNorth.add(btnThem);
		pnlCenterNorth.add(btnXoaRong);
		pnlCenterNorth.add(btnXoa);
		pnlCenterNorth.add(btnSua);
		pnlCenterNorth.add(btnLuu);
		pnlCenterNorth.add(lblTim);
		pnlCenterNorth.add(cbTim);

		dsSach = new DsSach();
		dsSach.napDuLieuTuFile();

		String[] header = { "MaSach", "TuaSach", "TacGia", "NamXuatBan", "NhaXuatBan", "SoTrang", "DonGia", "ISBN" };
		model = new DefaultTableModel(header, 0);
		updateTable();

		tableSach = new JTable(model);
		JScrollPane scrCenter = new JScrollPane(tableSach);

		pnlCenter.add(scrCenter, BorderLayout.CENTER);
		scrCenter.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		tableSach.addMouseListener(this);

	}

	public static void main(String[] args) {
		new GiaoDien().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				Sach sach = textToObject();
				if (dsSach.them(sach)) {

					updateTable();
					System.out.println(dsSach.toString());
				} else {
					JOptionPane.showMessageDialog(this, "Trùng mã");
				}
			}
		} else if (o.equals(btnLuu)) {
//			LuuTru.ghiXuongFile(dsSach);
		} else if (o.equals(btnXoaRong)) {
			txtMa.setText("");

		} else if (o.equals(btnSua)) {
			if (validData()) {
				Sach sachNew = textToObject();
				if (dsSach.updateSach(sachNew)) {
					updateTable();
					txtMa.setEditable(true);
					tableSach.clearSelection();

				}
			}

		} else if (o.equals(btnXoa)) {
			int row = tableSach.getSelectedRow();
			if (dsSach.xoa(row)) {
				JOptionPane.showMessageDialog(this, "Xóa thành công");
				updateTable();
				System.out.println(dsSach.toString());
				tableSach.clearSelection();
			}
			
		}

	}

	public void updateTable() {
		model.getDataVector().removeAllElements();
		for (int i = 0; i < dsSach.getSize(); i++) {

			Sach sach = dsSach.getElemAt(i);
			model.addRow(new Object[] { sach.getMaSach(), sach.getTuaSach(), sach.getTacGia(), sach.getNamXuatBan(),
					sach.getNhaXuatBan(), sach.getSoTrang(), sach.getDonGia(), sach.getIsbn() });

		}
	}

	public Sach textToObject() {
		String maSach = txtMa.getText();
		String tuaSach = txtTua.getText();
		String tacGia = txtTacGia.getText();
		int namXB = Integer.parseInt(txtNam.getText());
		int soTrang = Integer.parseInt(txtSoTrang.getText());
		double donGia = Double.parseDouble(txtDonGia.getText());
		String isbn = txtBookNum.getText();
		return new Sach(maSach, tuaSach, tacGia, namXB, tacGia, soTrang, donGia, isbn);

	}

	public boolean validData() {
		String maSach = txtMa.getText();
		String tuaSach = txtTua.getText();
		String tacGia = txtTacGia.getText();
		int namXB;
		int soTrang;
		double donGia;
		String isbn = txtBookNum.getText();
		if (maSach.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để rỗng");
			txtMa.selectAll();
			txtMa.requestFocus();
			return false;
		}
		if (tuaSach.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để rỗng");
			txtTua.selectAll();
			txtTua.requestFocus();
			return false;
		}
		if (tacGia.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để rỗng");
			txtTacGia.selectAll();
			txtTacGia.requestFocus();
			return false;
		}
		try {
			namXB = Integer.parseInt(txtNam.getText());
			if (namXB < 0) {
				JOptionPane.showMessageDialog(this, "Không được nhập số âm");
				txtNam.selectAll();
				txtNam.requestFocus();
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Phải nhập số");
			txtNam.selectAll();
			txtNam.requestFocus();

		}
		try {
			donGia = Double.parseDouble(txtDonGia.getText());
			if (donGia < 0) {
				JOptionPane.showMessageDialog(this, "Không được nhập số âm");
				txtDonGia.selectAll();
				txtDonGia.requestFocus();
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Phải nhập số");
			txtDonGia.selectAll();
			txtDonGia.requestFocus();

		}
		try {
			soTrang = Integer.parseInt(txtSoTrang.getText());
			if (soTrang < 0) {
				JOptionPane.showMessageDialog(this, "Không được nhập số âm");
				txtSoTrang.selectAll();
				txtSoTrang.requestFocus();
				return false;
			}
		} catch (NumberFormatException e) {
			txtSoTrang.selectAll();
			txtSoTrang.requestFocus();
			JOptionPane.showMessageDialog(this, "Phải nhập số");

		}
		if (isbn.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để rỗng");
			txtTacGia.selectAll();
			txtTacGia.requestFocus();
			return false;
		}
		return true;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableSach.getSelectedRow();
		txtMa.setText(tableSach.getValueAt(row, 0).toString());
		txtTua.setText(tableSach.getValueAt(row, 1).toString());
		txtTacGia.setText(tableSach.getValueAt(row, 2).toString());
		txtNam.setText(tableSach.getValueAt(row, 3).toString());
		txtNhaXuatBan.setText(tableSach.getValueAt(row, 4).toString());
		txtSoTrang.setText(tableSach.getValueAt(row, 5).toString());
		txtDonGia.setText(tableSach.getValueAt(row, 6).toString());
		txtBookNum.setText(tableSach.getValueAt(row, 7).toString());
		txtMa.setEditable(false);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
