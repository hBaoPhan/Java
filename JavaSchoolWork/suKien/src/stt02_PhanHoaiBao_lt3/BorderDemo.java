package stt02_PhanHoaiBao_lt3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BorderDemo extends JFrame {
	
	public BorderDemo(){
		setTitle("Border Demo");
		setLayout(new GridLayout(4,2,10,10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(800,400);
		
		JPanel firstPanel = new JPanel();
		JLabel lblLine=new JLabel("Line Border");
		firstPanel.add(lblLine);
		firstPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		JPanel secondPanel = new JPanel();
		JLabel lblEtched = new JLabel("Etched Border");
		secondPanel.add(lblEtched);
		secondPanel.setBorder(BorderFactory.createEtchedBorder(Color.gray,Color.black));
		
		JPanel thirdPanel = new JPanel();
		JLabel lblRaisedBevel = new JLabel("Raised Bevel Border");
		thirdPanel.add(lblRaisedBevel);
		thirdPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JPanel forthPanel = new JPanel();
		JLabel lblLoweredBevel=new JLabel("Lowered Bevel Border");
		forthPanel.add(lblLoweredBevel);
		forthPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JPanel fifthPanel = new JPanel();
		JLabel lblTitle=new JLabel("Titled Border");
		fifthPanel.add(lblTitle);
		fifthPanel.setBorder(BorderFactory.createTitledBorder("Title"));
		
		JPanel sixthPanel = new JPanel();
		JLabel lblTitleRight=new JLabel("Titled Border");
		sixthPanel.add(lblTitleRight);
		sixthPanel.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.RIGHT, TitledBorder.DEFAULT_POSITION));
		
		JPanel seventhPanel = new JPanel();
		JLabel lblCompound=new JLabel("Compound Border");
		seventhPanel.add(lblCompound);
		seventhPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.red)));
		
		
		JPanel eighthPanel = new JPanel();
		JLabel lblMatte=new JLabel("Matte Border");
		eighthPanel.add(lblMatte);
		eighthPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 3, Color.black));
		
		
		add(firstPanel);
		add(secondPanel);
		add(thirdPanel);
		add(forthPanel);
		add(fifthPanel);
		add(sixthPanel);
		add(seventhPanel);
		add(eighthPanel);
		

		
	}

	public static void main(String[] args) {
		new BorderDemo().setVisible(true);

	}

}
