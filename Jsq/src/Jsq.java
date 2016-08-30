import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Jsq implements ActionListener{
	JTextField t = new JTextField("0");  // ‰»ÎøÚ
	final String[] f={"7","8","9","/","4","5","6","*","1","2","3","+","0",".","=","-"};
    JButton[] buttons = new JButton[f.length];
	public Jsq() {
	       super();
	       JFrame J = new JFrame("º∆À„∆˜");
			J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			J.setSize(420,500);
			Container c = new Container();			
			J.add(t,BorderLayout.NORTH);
			c.setLayout(new GridLayout(4,9));		    
	      for (int i = 0; i < f.length; i++) {
	           buttons[i] = new JButton(f[i]);
	           c.add(buttons[i]);
	           J.add(c);
	           }
	      for (int i = 0; i < f.length; i++)
	      {
	           buttons[i].addActionListener(this);
	      }
		J.setVisible(true);
	}
    public void actionPerformed(ActionEvent e) {
    	 String label = e.getActionCommand();
    	if ("0123456789.".indexOf(label) > 0)
            handleNumber(label);
    	else 
            handleOperator(label);
    }
    boolean isFirstDigit = true;
    public void handleNumber(String key) {
        if (isFirstDigit)
            t.setText(key);
        else if ((key.equals(".")) && (t.getText().indexOf(".") < 0))
            t.setText(t.getText() + ".");
        else if (!key.equals("."))
            t.setText(t.getText() + key);
        isFirstDigit = false;
     }
    public void handleReset() {
        t.setText("0");
        isFirstDigit = true;
        operator = "=";
     }
     double number = 0.0;
     String operator = "=";
    public void handleOperator(String key) {
        if (operator.equals("+"))
            number += Double.valueOf(t.getText());
        else if (operator.equals("-"))
            number -= Double.valueOf(t.getText());
        else if (operator.equals("*"))
            number *= Double.valueOf(t.getText());
        else if (operator.equals("/"))
            number /= Double.valueOf(t.getText());
        else if (operator.equals("="))
            number = Double.valueOf(t.getText());
        t.setText(String.valueOf(number));
        operator = key;
        isFirstDigit = true;
     }
	   public static void main(String[] args) {
	       new Jsq();
	    }
		
}
