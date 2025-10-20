package onGK01;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GiaoDien extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMa;
	private JTextField txtHoTen;
	private JTextField txtTuoi;
	private JTextField txtLuong;
	private JComboBox<String> cbPhongBan;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private DanhSachNhanVien dsNV;

	public GiaoDien() {
		setSize(700, 450);
		setTitle("ABCDDD");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblHeader = new JLabel("THÔNG TIN NHÂN VIÊN", JLabel.CENTER);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 20));
		add(lblHeader, BorderLayout.NORTH);
		JPanel pnlWest = new JPanel();
		add(pnlWest, BorderLayout.WEST);

		JLabel lblMa = new JLabel("Mã nhân viên:");
		txtMa = new JTextField(10);
		JLabel lblHoTen = new JLabel("Tên nhân viên:");
		txtHoTen = new JTextField(10);
		JLabel lblTuoi = new JLabel("Tuổi:");
		txtTuoi = new JTextField(10);
		JLabel lblLuong = new JLabel("Tiền lương:");
		txtLuong = new JTextField(10);
		JLabel lblPhongBan = new JLabel("Phòng Ban");
		cbPhongBan = new JComboBox<String>();
		cbPhongBan.addItem("Ban Giám Đốc");
		cbPhongBan.addItem("Ban IT");
		cbPhongBan.addItem("Ban Nhân Sự");

		txtMa.setToolTipText("Nhập mã nhân viên");
		
		Box b, b1, b2, b3, b4, b5;
		b = Box.createVerticalBox();
		pnlWest.add(b);
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());

		b1.add(lblMa);
		b1.add(txtMa);

		b2.add(lblHoTen);
		b2.add(txtHoTen);

		b3.add(lblTuoi);
		b3.add(txtTuoi);

		b4.add(lblPhongBan);
		b4.add(cbPhongBan);

		b5.add(lblLuong);
		b5.add(txtLuong);

		lblMa.setPreferredSize(lblHoTen.getPreferredSize());
		lblTuoi.setPreferredSize(lblHoTen.getPreferredSize());
		lblLuong.setPreferredSize(lblHoTen.getPreferredSize());
		lblPhongBan.setPreferredSize(lblHoTen.getPreferredSize());

		String[] header = { "Mã NV", "Họ và Tên", "Phòng Ban", "Tuổi", "Tiền lương" };
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		dsNV = new DanhSachNhanVien();
		try {
			dsNV=(DanhSachNhanVien) LuuTru.DocFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateTable();

		JScrollPane scrCenter = new JScrollPane(table);
		add(scrCenter, BorderLayout.CENTER);

		JPanel pnlSouth = new JPanel();
		add(pnlSouth, BorderLayout.SOUTH);

		JLabel lblTim = new JLabel("Nhập mã số cần tìm");
		txtTim = new JTextField(10);
		btnTim = new JButton("Tìm");
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		btnSua = new JButton("Sửa");

		pnlSouth.add(lblTim);
		pnlSouth.add(txtTim);
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnXoaTrang);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnLuu);
		pnlSouth.add(btnSua);

		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);

	}

	public static void main(String[] args) {
		new GiaoDien().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (checkValidData()) {
				NhanVien nv = createObjectFromText();
				if (dsNV.them(nv)) {
					updateTable();

				} else {
					JOptionPane.showMessageDialog(this, "Trùng mã");
				}
			}
		} else if (o.equals(btnTim)) {
			String ma = txtTim.getText().trim();
			table.clearSelection();
			if (dsNV.tim(ma) >= 0) {
				table.setRowSelectionInterval(dsNV.tim(ma), dsNV.tim(ma));
				tableToText();
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
			}

		} else if (o.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtHoTen.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");
			cbPhongBan.setSelectedIndex(0);
			txtMa.setEditable(true);
		} else if (o.equals(btnSua)) {
			if (checkValidData()) {
				NhanVien nv = createObjectFromText();
				if (dsNV.sua(nv)) {
					updateTable();
					txtMa.setText("");
					txtHoTen.setText("");
					txtTuoi.setText("");
					txtLuong.setText("");
					cbPhongBan.setSelectedIndex(0);
					txtMa.setEditable(true);
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để sửa");
				}
			}
		}
		else if(o.equals(btnXoa)) {
			int index=table.getSelectedRow();
			boolean confirm=JOptionPane.showConfirmDialog(this, "Xác nhận xóa?","Xác nhận",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
			if(confirm==true) {
				if(dsNV.xoa(index)) {
					updateTable();
				}
			}
		}
		else if(o.equals(btnLuu)) {
			try {
				LuuTru.LuuFile(dsNV);
				JOptionPane.showMessageDialog(this, "Lưu thành công");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public boolean checkValidData() {
		String ma = txtMa.getText().trim();
		String hoTen = txtHoTen.getText().trim();
		int tuoi;
		double luong;
		if (ma.equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để trống");
			txtMa.requestFocus();
			txtMa.selectAll();
			return false;
		} else if (hoTen.equals("")) {
			JOptionPane.showMessageDialog(this, "Không được để trống");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		}
		try {
			tuoi = Integer.parseInt(txtTuoi.getText().trim().toString());
			if (tuoi < 0) {
				JOptionPane.showMessageDialog(this, "Không được nhập số âm");
				txtTuoi.requestFocus();
				txtTuoi.selectAll();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Phải nhập số");
			txtTuoi.requestFocus();
			txtTuoi.selectAll();
			return false;

		}
		try {
			luong = Double.parseDouble(txtLuong.getText().trim().toString());
			if (luong < 0) {
				JOptionPane.showMessageDialog(this, "Không được nhập số âm");
				txtLuong.requestFocus();
				txtLuong.selectAll();
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Phải nhập số");
			txtLuong.requestFocus();
			txtLuong.selectAll();
			return false;
		}
		return true;

	}

	public NhanVien createObjectFromText() {
		String ma = txtMa.getText();
		String hoTen = txtHoTen.getText();
		double luong = Double.parseDouble(txtLuong.getText().toString());
		int tuoi = Integer.parseInt(txtTuoi.getText().toString());
		String phongBan = cbPhongBan.getSelectedItem().toString();
		return new NhanVien(ma, hoTen, tuoi, phongBan, luong);
	}

	public void updateTable() {
		model.getDataVector().removeAllElements();
		for (int i = 0; i < dsNV.getSize(); i++) {
			NhanVien nv = dsNV.getElemAt(i);
			model.addRow(new Object[] { nv.getMa(), nv.getHoTen(), nv.getPhongBan(), nv.getTuoi(), nv.getTienLuong() });

		}
		model.fireTableDataChanged();
	}

	public void tableToText() {
		int row = table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtHoTen.setText(table.getValueAt(row, 1).toString());
		cbPhongBan.setSelectedItem(table.getValueAt(row, 2));
		txtTuoi.setText(table.getValueAt(row, 3).toString());
		txtLuong.setText(table.getValueAt(row, 4).toString());
		txtMa.setEditable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		tableToText();

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
