package stt02_PhanHoaiBao_lt4;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JCheckBoxDemo extends JFrame implements ItemListener {

	private JCheckBox chkBold;
	private JCheckBox chkItalic;
	private JTextField txtInput;

	public JCheckBoxDemo() {
		setTitle("JCheckBox Demo");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));

		JPanel pnlAbove = new JPanel();
		add(pnlAbove);
		txtInput = new JTextField("Watch the font style change",18);
		txtInput.setFont(new Font("Serif",Font.PLAIN,13));
		pnlAbove.add(txtInput);

		JPanel pnlBelow = new JPanel();
		add(pnlBelow);
		chkBold = new JCheckBox("Bold");
		chkItalic = new JCheckBox("Italic");
		pnlBelow.add(chkBold);
		pnlBelow.add(chkItalic);
		
		chkBold.addItemListener(this);
		chkItalic.addItemListener(this);
		
		
	}

	public static void main(String[] args) {
		new JCheckBoxDemo().setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f=txtInput.getFont();
		Object o=e.getItem();
		if(o.equals(chkBold)) {
			txtInput.setFont(new Font(f.getName(),f.getStyle()^Font.BOLD,f.getSize()));
		}
		if(o.equals(chkItalic)) {
			txtInput.setFont(new Font(f.getName(),f.getStyle()^Font.ITALIC,f.getSize()));
		}
		
	}

}
