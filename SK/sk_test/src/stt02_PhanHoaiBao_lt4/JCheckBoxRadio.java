package stt02_PhanHoaiBao_lt4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class JCheckBoxRadio extends JFrame implements ActionListener,ItemListener{
	

	private JRadioButton radLeft;
	private JRadioButton radRight;
	private JCheckBox chkItalic;
	private JLabel lblText;

	public JCheckBoxRadio() {
		setTitle("JCheckBoxRadiox Demo");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnlNorth=new JPanel();
		add(pnlNorth,BorderLayout.NORTH);
		pnlNorth.add(chkItalic=new JCheckBox("Italic"));
		pnlNorth.add(radLeft=new JRadioButton("Left",true));
		pnlNorth.add(radRight=new JRadioButton("Right"));
		
		ButtonGroup group=new ButtonGroup();
		group.add(radLeft);
		group.add(radRight);
		this.add(lblText=new JLabel("Hello world!"));
		
		chkItalic.addItemListener(this);
		radLeft.addActionListener(this);
		radRight.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new JCheckBoxRadio().setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f=lblText.getFont();
		Object o=e.getItem();
		if(o==chkItalic) {
			lblText.setFont(new Font(f.getName(),f.getStyle()^Font.ITALIC,f.getSize()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(radLeft))
			lblText.setHorizontalAlignment(SwingConstants.LEFT);
		if(o.equals(radRight))
			lblText.setHorizontalAlignment(SwingConstants.RIGHT);
		
	}

}
