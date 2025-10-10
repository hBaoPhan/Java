package onGK;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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


public class GiaoDien extends JFrame implements ActionListener,MouseListener{

	private JTextField txtMa;
	private JTextField txtHoTen;
	private JTextField txtTuoi;
	private JComboBox<String> cbPhai;
	private JTextField txtLuong;
	private DefaultTableModel model;
	private JTextField txtTim;
	private JButton btnThem;
	private JButton btnTim;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private DanhSachNhanVien dsNV;
	private JTable table;
	private JButton btnSua;

	

	public GiaoDien() {
		setSize(700,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnlNorth=new JPanel(new BorderLayout());
		add(pnlNorth,BorderLayout.NORTH);
		
		JLabel lblHeader=new JLabel("THÔNG TIN NHÂN VIÊN",JLabel.CENTER);
		lblHeader.setFont(new Font("Arial", Font.BOLD,20));
		lblHeader.setForeground(Color.BLUE);
		pnlNorth.add(lblHeader,BorderLayout.NORTH);
		
		
		Box b=Box.createVerticalBox();
		pnlNorth.add(b,BorderLayout.CENTER);
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		Box b3=Box.createHorizontalBox();
		Box b4=Box.createHorizontalBox();
		
		JLabel lblMa=new JLabel("Mã nhân viên:");
		txtMa=new JTextField(10);
		JLabel lblHoTen=new JLabel("Họ và tên:");
		txtHoTen=new JTextField(10);
		JLabel lblTuoi=new JLabel("Tuổi:");
		txtTuoi=new JTextField(10);
		JLabel lblLuong=new JLabel("Lương:"); 
		txtLuong=new JTextField(10);
		
		JLabel lblPhai=new JLabel("Phái:");
		cbPhai=new JComboBox<String>();
		cbPhai.addItem("Nam");
		cbPhai.addItem("Nữ");
		
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);
		
		b1.add(lblMa);
		b1.add(txtMa);
		
		b2.add(lblHoTen);
		b2.add(txtHoTen);
		
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(cbPhai);
		
		b4.add(lblLuong);
		b4.add(txtLuong);
		lblHoTen.setPreferredSize(lblMa.getPreferredSize());
		lblTuoi.setPreferredSize(lblMa.getPreferredSize());
		lblLuong.setPreferredSize(lblMa.getPreferredSize());
		
		dsNV=new DanhSachNhanVien();
		String[] Header= {"Mã NV","Họ và Tên","Phái","Tuổi","Tiền Lương"};
		model=new DefaultTableModel(Header,0);
		table=new JTable(model);


		try {
			dsNV=(DanhSachNhanVien) LuuTru.docFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(dsNV);
		updateTable();
		
		
		JScrollPane scrCenter=new JScrollPane(table);
		add(scrCenter,BorderLayout.CENTER);
		
		JLabel lblTim=new JLabel("Nhập mã số cần tìm");
		txtTim=new JTextField(10);
		btnTim=new JButton("Tìm");
		btnThem=new JButton("Thêm");
		btnXoaTrang=new JButton("Xóa trắng");
		btnXoa=new JButton("Xóa");
		btnLuu=new JButton("Lưu");
		
		JPanel pnlSouth=new JPanel();
		add(pnlSouth,BorderLayout.SOUTH);
		pnlSouth.add(lblTim);
		pnlSouth.add(txtTim);
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnXoaTrang);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnLuu);
		pnlSouth.add(btnSua=new JButton("Sửa"));
		
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		btnSua.addActionListener(this);
		
		}

	public static void main(String[] args) {
		new GiaoDien().setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThem)) {
			if(checkValidData()) {
				NhanVien nv=createObjectFromText();
				if(dsNV.them(nv)) {
					updateTable();
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Trùng mã");
				}
				
			}
			
		}else if(o.equals(btnTim)) {
			String ma=txtTim.getText().trim();
			table.clearSelection();
			table.setRowSelectionInterval(dsNV.tim(ma), dsNV.tim(ma));
		}
		else if(o.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtHoTen.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");
			cbPhai.setSelectedItem("Nam");
		}
		else if(o.equals(btnXoa)) {
			int row=table.getSelectedRow();
			if(dsNV.xoa(row)) {
				updateTable();
				model.fireTableDataChanged();

			}
		}
		else if(o.equals(btnLuu)) {
		
			try {
				LuuTru.luuFile(dsNV);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(o.equals(btnSua)) {
			
			if(checkValidData()) {
				NhanVien nv=createObjectFromText();
				if(dsNV.sua(nv)) {
					updateTable();
				}
				else {
					System.out.println("sua");
				}
			}else {
				System.out.println("nah");
			}
			
		}
		
	}
	public boolean checkValidData() {
		String ma=txtMa.getText().trim();
		String hoTen=txtHoTen.getText().trim();
		int tuoi;
		double luong;
		if(ma.equals("")) {
			JOptionPane.showMessageDialog(this, "không được để rỗng");
			txtMa.requestFocus();
			txtMa.selectAll();
			return false;
		}
		if(hoTen.equals("")) {
			JOptionPane.showMessageDialog(this, "không được để rỗng");
			txtHoTen.requestFocus();
			txtHoTen.selectAll();
			return false;
		}
		try {
			tuoi=Integer.parseInt(txtTuoi.getText().trim());
			if(tuoi<0) {
				JOptionPane.showMessageDialog(this, "Phải lớn hơn 0");
				txtTuoi.requestFocus();
				txtTuoi.selectAll();
				return false;
				}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Phải nhập số");
			txtTuoi.requestFocus();
			txtTuoi.selectAll();
		}
		try {
			luong=Double.parseDouble(txtLuong.getText().trim());
			if(luong<0) {
				JOptionPane.showMessageDialog(this, "Phải lớn hơn 0");
				txtLuong.requestFocus();
				txtLuong.selectAll();
				return false;
				}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Phải nhập số");
			txtLuong.requestFocus();
			txtLuong.selectAll();
		}
		return true;
		
	}
	public NhanVien createObjectFromText() {
		String ma=txtMa.getText().trim();
		String hoTen=txtHoTen.getText().trim();
		int tuoi=Integer.parseInt(txtTuoi.getText().trim());
		Double luong=Double.parseDouble(txtLuong.getText().trim());
		String preGT=cbPhai.getSelectedItem().toString();
		boolean gioiTinh;
		if(preGT.equals("Nam"))
			 gioiTinh=true;
		else
			gioiTinh=false;
		return new NhanVien(ma, hoTen, tuoi, luong, gioiTinh);
		
	}
	public void updateTable() {
		model.getDataVector().removeAllElements();
		for (int i = 0; i < dsNV.getSize(); i++) {
			NhanVien nv=dsNV.getElemAt(i);
			model.addRow(new Object[] {nv.getMa(),nv.getHoTen(),nv.isGioiTinh() ? "Nam" :"Nữ",nv.getTuoi(),nv.getLuong()});
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtHoTen.setText(table.getValueAt(row, 1).toString());
		if(table.getValueAt(row, 2).toString().equals("Nam")) {
			cbPhai.setSelectedItem("Nam");
		} else {
			cbPhai.setSelectedItem("Nữ");
		}
		txtTuoi.setText(table.getValueAt(row, 3).toString());
		txtLuong.setText(table.getValueAt(row, 4).toString());
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
