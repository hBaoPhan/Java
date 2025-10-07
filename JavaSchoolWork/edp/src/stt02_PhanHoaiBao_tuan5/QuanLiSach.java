package stt02_PhanHoaiBao_tuan5;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QuanLiSach extends JFrame {
	
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

	public QuanLiSach() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Quản Lý sách");
		
		JPanel pnlNorth=new JPanel();
		add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		Box b=Box.createVerticalBox();
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		Box b3=Box.createHorizontalBox();
		Box b4=Box.createHorizontalBox();
		Box b5=Box.createHorizontalBox();

		JLabel lblMa=new JLabel("Mã sách:");
		txtMa=new JTextField(10);
		JLabel lblTua=new JLabel("Tựa sách:");
		txtTua=new JTextField(10);
		JLabel lblTacGia=new JLabel("Tác giả:");
		txtTacGia=new JTextField(10);
		JLabel lblNam=new JLabel("Năm xuất bản:");
		txtNam=new JTextField(10);
		JLabel lblNhaXuatBan=new JLabel("Nhà xuất bản:");
		txtNhaXuatBan=new JTextField(10);
		JLabel lblSoTrang=new JLabel("Số Trang:");
		txtSoTrang=new JTextField(10);
		JLabel lblDonGia=new JLabel("Đơn giá:");
		txtDonGia=new JTextField(10);
		JLabel lblBookNum=new JLabel("International Standard Book Number:");
		txtBookNum=new JTextField(10);
		
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
		
		JPanel pnlCenter=new JPanel(new BorderLayout());
		add(pnlCenter,BorderLayout.CENTER);
		
		JPanel pnlCenterNorth=new JPanel();
		pnlCenter.add(pnlCenterNorth,BorderLayout.NORTH);
		
		btnThem=new JButton("Thêm");
		btnXoaRong=new JButton("Xóa rỗng");
		btnXoa=new JButton("Xóa");
		btnSua =new JButton("Sửa");
		btnLuu=new JButton("Lưu");
		JLabel lblTim=new JLabel("Tìm theo mã sách:");
		cbTim=new JComboBox<String>();
		cbTim.addItem("A001");
		
		pnlCenterNorth.add(btnThem);
		pnlCenterNorth.add(btnXoaRong);
		pnlCenterNorth.add(btnXoa);
		pnlCenterNorth.add(btnSua);
		pnlCenterNorth.add(btnLuu);
		pnlCenterNorth.add(lblTim);
		pnlCenterNorth.add(cbTim);
		
		
		String[] header= {"MaSach","TuaSach","TacGia","NamXuatBan","NhaXuatBan","SoTrang","DonGia","ISBN"};
		model=new DefaultTableModel(header,0);
		
		tableSach=new JTable(model);
		JScrollPane scrCenter=new JScrollPane(tableSach);
		
		pnlCenter.add(scrCenter,BorderLayout.CENTER);
		scrCenter.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		
	
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new QuanLiSach().setVisible(true);

	}

}
