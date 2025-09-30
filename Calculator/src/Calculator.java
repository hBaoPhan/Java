
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.GridBagLayout;

public class Calculator extends JFrame implements ActionListener {
    
    Color lightGray=new Color(212,212,210);
    Color darkGray=new Color(80,80,80);
    Color orange=new Color(255,159,10);
    Color black=new Color(28,28,28);
    
    JLabel label=new JLabel("0");
    JPanel panel=new JPanel();
    JPanel buttonPanel=new JPanel();

    String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};
   
        

    public Calculator(){
        setSize(400,600);
        
        setResizable(false);
        setLocationRelativeTo(null);    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");

        label.setBackground(black);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial",Font.PLAIN,80));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setText("0");
        label.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(label);
        add(panel,BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(5,4));
        buttonPanel.setBackground(black);
        add(buttonPanel);

        for(int i=0;i< buttonValues.length;i++){
            JButton button =new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(black));
            if(Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(lightGray);
                button.setForeground(black);
            }
            else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(orange);
                button.setForeground(Color.white);

            }
            else{
                button.setBackground(darkGray);
                button.setForeground(Color.white);
            }

            buttonPanel.add(button);
            button.addActionListener(this);


        }






    }
    public void actionPerformed(ActionEvent e){
        JButton button= (JButton)e.getSource();
        String buttonValue = button.getText();
        if(Arrays.asList(rightSymbols).contains(buttonValue)){

        }
        else if(Arrays.asList(topSymbols).contains(buttonValue)){
            if(buttonValue=="AC"){

            }
            else if(buttonValue =="+/-"){

            }else if(buttonValue =="%"){
                
            }

        }else{
            if(buttonValue =="."){
                if(!label.getText().contains(buttonValue)){
                    label.setText(label.getText() + buttonValue);
                }
            }
            else if("0123456789".contains(buttonValue)){
                if(label.getText()=="0"){
                    label.setText(buttonValue);
                }
                else{
                    label.setText(label.getText() + buttonValue);
                }
            }
        }

    }
    



    
}
