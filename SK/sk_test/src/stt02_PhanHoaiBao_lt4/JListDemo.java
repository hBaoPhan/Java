package stt02_PhanHoaiBao_lt4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JListDemo extends JFrame implements ActionListener {
	

	private DefaultListModel<String> model;
	private JList list;
	private JTextField txtInput;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnEdit;

	public JListDemo() {
		setTitle("List Edit Demo");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model=new DefaultListModel();
		list=new JList(model);
		JScrollPane scrLeft=new JScrollPane(list);
		add(scrLeft,BorderLayout.WEST);
		
		JPanel pnlRight=new JPanel();
		add(pnlRight,BorderLayout.CENTER);
		Box b=Box.createVerticalBox();
		Box b1,b2;
		b.add(b1=Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b2=Box.createHorizontalBox());
		pnlRight.add(b);
		
		JLabel lblInput=new JLabel("Input Name:");
		txtInput=new JTextField(10);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblInput);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(txtInput);
		
		b2.add(btnAdd=new JButton("Add item"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(btnRemove=new JButton("Remove item"));
		b2.add(Box.createHorizontalStrut(10));
		b2.add(btnEdit=new JButton("Edit item"));
		
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);
		txtInput.addActionListener(this);
		
				
	}

	public static void main(String[] args) {
		new JListDemo().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
	
		if(o.equals(btnAdd) || o.equals(txtInput)) {
			String name=txtInput.getText().trim();
			if(name.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên!!");
				txtInput.requestFocus();
			}
			else {
				model.addElement(name);
				txtInput.setText("");
				
			}
			
		}
		if(o.equals(btnRemove)) {
			model.removeElement(list.getSelectedValue());	
		}
		else if(o.equals(btnEdit)) {
			txtInput.setText(list.getSelectedValue().toString());
			txtInput.requestFocus();
			model.removeElementAt(list.getSelectedIndex());
		}
	}

}
