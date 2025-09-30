import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class Calculator extends JFrame {
    
    Color lightGray=new Color(212,212,210);
    Color darkGray=new Color(80,80,80);
    Color orange=new Color(255,159,10);
    Color black=new Color(28,28,28);
    
    JLabel label=new JLabel("0");
    JPanel panel=new JPanel();

    public Calculator(){{
        setSize(400,600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");

        label.setBackground(black);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial",Font.PLAIN,70));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setText("0");
        label.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(label);
        add(panel,BorderLayout.NORTH);






    }
    



    
}
}