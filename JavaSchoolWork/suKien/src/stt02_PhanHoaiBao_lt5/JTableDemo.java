package stt02_PhanHoaiBao_lt5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JTableDemo extends JFrame implements ActionListener,MouseListener{
	

	private DefaultTableModel modelHoTen;
	private JTable tblHoTen;
	private JTextField txtHo;
	private JTextField txtTen;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;

	public JTableDemo() {
		setSize(450,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnlNorth = new JPanel();
		add(pnlNorth,BorderLayout.NORTH);
		JLabel lblHo=new JLabel("Họ:");
		txtHo=new JTextField(11);
		JLabel lblTen=new JLabel("Tên:");
		txtTen=new JTextField(12);
		
		Box b=Box.createVerticalBox();
		pnlNorth.add(b);
		Box b1,b2,b3;
		b.add(Box.createVerticalStrut(10));
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b2=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3=Box.createHorizontalBox());
		b1.add(lblHo);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(txtHo);
		b2.add(lblTen);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(txtTen);
		btnThem=new JButton("Thêm");
		btnSua=new JButton("Sửa");
		btnXoa=new JButton("Xóa");
		b3.add(btnThem);
		b3.add(Box.createHorizontalStrut(5));
		b3.add(btnSua);
		b3.add(Box.createHorizontalStrut(5));
		b3.add(btnXoa);
		
		String[] header={"Họ","Tên"};
		modelHoTen=new DefaultTableModel(header,0);
		
		String[] row1= {"Nguyễn","An"};
		modelHoTen.addRow(row1);
		
		tblHoTen=new JTable(modelHoTen);
		JScrollPane scrMain;
		add(scrMain=new JScrollPane(tblHoTen),BorderLayout.CENTER);
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new JTableDemo().setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThem)) {
			if(txtHo.getText().equals("")||txtTen.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Phải nhập họ av tên");
			}
			else {
				Object[] a=new Object[2];
				a[0]=txtHo.getText();
				a[1]=txtTen.getText();
				modelHoTen.addRow(a);
				txtHo.setText("");
				txtTen.setText("");
			}
		}
		if(o.equals(btnSua)) {
			int row=tblHoTen.getSelectedRow();
			System.out.println(row);
			txtHo.setText(modelHoTen.getValueAt(row, 0).toString());
			txtTen.setText(modelHoTen.getValueAt(row, 1).toString());
			modelHoTen.removeRow(row);
		}
		if(o.equals(btnXoa)) {
			int row=tblHoTen.getSelectedRow();
			modelHoTen.removeRow(row);
		}
			
			
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
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
