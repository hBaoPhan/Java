package stt02_PhanHoaiBao_lt4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListDemo2 extends JFrame implements ListSelectionListener{
	
	

	private DefaultListModel modal;
	private JList list;
	private JTextField txtOutput;

	public JListDemo2() {
		setTitle("Simple JList");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnlCenter=new JPanel();
		pnlCenter.setBorder(BorderFactory.createTitledBorder("Simple JList"));
		add(pnlCenter,BorderLayout.CENTER);
		
		modal=new DefaultListModel();
		modal.addElement("Entry 0");
		modal.addElement("Entry 1");
		modal.addElement("Entry 2");
		modal.addElement("Entry 3");
		modal.addElement("Entry 4");
		list=new JList(modal);
		list.setVisibleRowCount(3);
		
		
		JScrollPane srcList=new JScrollPane(list);
		pnlCenter.add(srcList);
		
		JPanel pnlSouth=new JPanel();
		add(pnlSouth,BorderLayout.SOUTH);
		pnlSouth.setBorder(BorderFactory.createTitledBorder("List Selection"));
		
		
		JLabel lblText=new JLabel("List selection");
		
		txtOutput=new JTextField(10);
		pnlSouth.add(lblText);
		pnlSouth.add(txtOutput);
		
		list.addListSelectionListener(this);
		
	}

	public static void main(String[] args) {
		new JListDemo2().setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		txtOutput.setText(list.getSelectedValue().toString());
		
	}





}
