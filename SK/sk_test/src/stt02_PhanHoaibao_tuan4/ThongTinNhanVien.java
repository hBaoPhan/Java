package stt02_PhanHoaibao_tuan4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ThongTinNhanVien extends JFrame implements ActionListener,MouseListener{
	
	private static final String FILEPATH = "src/stt02_PhanHoaibao_tuan4/NhanVien.txt";
	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JCheckBox chkNu;
	private JTextField txtLuong;
	private DefaultTableModel modelNhanVien;
	private JTable tableNhanVien;
	private JTextField txtNhapma;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private NhanVien_Collection listNV;


	public ThongTinNhanVien(){
		setSize(650, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnlNorth=new JPanel();
		pnlNorth.setLayout(new BorderLayout());
		add(pnlNorth,BorderLayout.NORTH);
		JLabel lblHeader=new JLabel("THÔNG TIN NHÂN VIÊN",JLabel.CENTER);
		lblHeader.setFont(new Font("Time New Roman",Font.BOLD,20));
		lblHeader.setForeground(Color.BLUE);
		pnlNorth.add(lblHeader,BorderLayout.NORTH);
		
		JLabel lblMa=new JLabel("Mã Nhân viên: ");
		txtMa=new JTextField();
		JLabel lblHo=new JLabel("Họ: ");
		txtHo =new JTextField();
		JLabel lblTen=new JLabel("Tên nhân viên: ");
		txtTen=new JTextField();
		JLabel lblTuoi=new JLabel("Tuổi: ");
		txtTuoi=new JTextField();
		JLabel lblNu=new JLabel("Nữ");
		chkNu=new JCheckBox();
		JLabel lblLuong=new JLabel("Lương:");
		txtLuong=new JTextField();
		
		lblHo.setPreferredSize(lblMa.getPreferredSize());
		lblTen.setPreferredSize(lblMa.getPreferredSize());
		lblTuoi.setPreferredSize(lblMa.getPreferredSize());
		lblLuong.setPreferredSize(lblMa.getPreferredSize());
		lblTen.setPreferredSize(lblMa.getPreferredSize());
	
		Box b=Box.createVerticalBox();
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		Box b3=Box.createHorizontalBox();
		Box b4=Box.createHorizontalBox();
		pnlNorth.add(b,BorderLayout.CENTER);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		
		b1.add(lblMa);
		b1.add(txtMa);
		
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);
		
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblNu);
		b3.add(chkNu);
		
		b4.add(lblLuong);
		b4.add(txtLuong);
		
		
		String[] header= {"Mã NV","Họ","Tên","Phái","Tuổi","Tiền Lương"};
		modelNhanVien=new DefaultTableModel(header,0);
		tableNhanVien=new JTable(modelNhanVien);
		JScrollPane scrTable=new JScrollPane(tableNhanVien);
		add(scrTable,BorderLayout.CENTER);
		
		//Đọc file
		listNV=new NhanVien_Collection();
		LuuTru luuTru=new LuuTru();
		try {
			listNV=(NhanVien_Collection) luuTru.DocFile(FILEPATH);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy file");
		}
		docDuLieuTuListVaoModel();
		
		JPanel pnlSouth=new JPanel();
		add(pnlSouth,BorderLayout.SOUTH);
		JLabel lblNhapMa=new JLabel("Nhập mã cần tìm");
		txtNhapma=new JTextField(10);
		btnTim=new JButton("Tìm");
		btnThem=new JButton("Thêm");
		btnXoaTrang=new JButton("Xóa Trắng");
		btnXoa=new JButton("Xóa");
		btnLuu=new JButton("Lưu");
		
		pnlSouth.add(lblNhapMa);
		pnlSouth.add(txtNhapma);
		pnlSouth.add(btnTim);
		pnlSouth.add(btnThem);
		pnlSouth.add(btnXoaTrang);
		pnlSouth.add(btnXoa);
		pnlSouth.add(btnLuu);
		
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		
	}

	public static void main(String[] args) {
		new ThongTinNhanVien().setVisible(true);

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=tableNhanVien.getSelectedRow();
		txtMa.setText(tableNhanVien.getValueAt(row, 0).toString());
		txtHo.setText(tableNhanVien.getValueAt(row, 1).toString());
		txtTen.setText(tableNhanVien.getValueAt(row, 2).toString());
		if(tableNhanVien.getValueAt(row, 3).toString().equalsIgnoreCase("nữ"))
			chkNu.setSelected(true);
		else
			chkNu.setSelected(false);
		txtTuoi.setText(tableNhanVien.getValueAt(row, 4).toString());
		txtLuong.setText(tableNhanVien.getValueAt(row, 5).toString());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThem)) {
			String ma=txtMa.getText();
			String ho=txtHo.getText();
			String ten=txtTen.getText();
			int tuoi=Integer.parseInt(txtTuoi.getText());
			boolean phai=chkNu.isSelected();
			double luong=Double.parseDouble(txtLuong.getText());
			
			NhanVien nv=new NhanVien(ma, ho, ten, phai,tuoi, luong);
		
			if(!listNV.themNhanVien(nv))
				JOptionPane.showMessageDialog(this, "Trùng");
			else
				modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),nv.getPhai() ? "nữ":"nam",nv.getTuoi(),nv.getLuong()});
			
			
		}
		if(o.equals(btnXoa)) {
			int row=tableNhanVien.getSelectedRow();
			modelNhanVien.removeRow(row);
			NhanVien nv=listNV.getElementAt(row);
			listNV.xoaNhanVien(nv.getMaNV());
			
			
		}
		if(o.equals(btnXoaTrang)) {
			txtMa.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			chkNu.setSelected(false);
			txtLuong.setText("");
			
		}
		if(o.equals(btnTim)) {
			timTheoMaNV();
		}
		if(o.equals(btnLuu)) {
			LuuTru luuTru=new LuuTru();
			try {
				luuTru.LuuFile(listNV, FILEPATH);
				JOptionPane.showMessageDialog(this, "Lưu Thành công");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public void docDuLieuTuListVaoModel() {
		for (int i = 0; i < listNV.getSize(); i++) {
			NhanVien nv=listNV.getElementAt(i);
			modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),nv.getPhai() ? "nữ":"nam",nv.getTuoi(),nv.getLuong()});
			
		}
	}
	private void timTheoMaNV() {
		String ma=txtNhapma.getText();
		if(ma!=null && ma.trim().length()>0) {
			NhanVien nv=listNV.timKiem(ma);
			if(nv!=null) {
				modelNhanVien.getDataVector().removeAllElements();
				modelNhanVien.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),nv.getPhai() ? "nữ":"nam",nv.getTuoi(),nv.getLuong()});
			}
			else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
				return;
			}	
		}
		else {
			modelNhanVien.getDataVector().removeAllElements();
			docDuLieuTuListVaoModel();
		}
			
	}
	

}
