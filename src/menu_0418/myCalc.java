package menu_0418;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myCalc {
	public static void main(String[] args) {
		calc cl = new calc();
		cl.display();
	}
}

class calc extends JFrame implements ActionListener{
	
	String operator = "+";
	String op1 = "0",op2="0";
	String cal="0";
	JTextField tf;
	JPanel pl;
	JButton btnNum[] = null;
	JButton btnPlus,btnMin,btnMul,btnDiv,btncal,btnClear;
	float i=0,j=0,k=0;
	calc(){
		tf = new JTextField(26);
		tf.setHorizontalAlignment(4);
		add(tf);
		
		pl = new JPanel(new GridLayout(4,4,10,5));
		pl.setSize(400,300);
		
		btnNum=new JButton[10];
		
		for(int i=0;i<10;i++) {
			btnNum[i] = new JButton(""+i);
			btnNum[i].addActionListener(this);
			pl.add(btnNum[i]);
		}
		
		btncal = new JButton("="); pl.add(btncal);
		btncal.addActionListener(this);
		btnClear = new JButton("Clear"); pl.add(btnClear);
		btnClear.addActionListener(this);
		
		btnPlus = new JButton("+"); pl.add(btnPlus);
		btnPlus.addActionListener(this);
		btnMin = new JButton("-"); pl.add(btnMin);
		btnMin.addActionListener(this);
		btnDiv = new JButton("/"); pl.add(btnDiv);
		btnDiv.addActionListener(this);
		btnMul = new JButton("*"); pl.add(btnMul);
		btnMul.addActionListener(this);
		
		
		add(pl);
	}
	
	
	void display() {
		setLayout(new FlowLayout());
		setSize(350,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("내가 만든 계산기");
	}

	String Sum;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int n=0;
		
		
		
		
		
		
		if(e.getSource()==btnClear) {
			tf.setText("");
			op1="0";
			op2="0";
			operator=null;
			
		} else if(e.getSource()==btnPlus) {
			if(n==1) {}else { op1=tf.getText(); n=0; }
			tf.setText(""); 
			i=Float.parseFloat(op1);
			System.out.println(op1);
			System.out.println(i);
			operator="+";
			
		}else if(e.getSource()==btnMin) {
			if(n==1) {}else { op1=tf.getText(); n=0; }
			op1 = tf.getText();
			tf.setText(""); 
			operator="-";
			System.out.println(op1);
		}else if(e.getSource()==btnDiv) {
			if(n==1) {}else { op1=tf.getText(); n=0; }
			op1 = tf.getText();
			tf.setText(""); 
			operator="/";
			System.out.println(op1);
		}else if(e.getSource()==btnMul) {
			if(n==1) {}else { op1=tf.getText(); n=0; }
			op1 = tf.getText();
			tf.setText(""); 
			operator="*";
			System.out.println(op1);
		}else if(e.getSource()==btncal) {
			op2=tf.getText();
			System.out.println(op2);
			i=Float.parseFloat(op1);
			System.out.println(i);
			j=Float.parseFloat(op2);
			System.out.println(j);
			System.out.println(operator);
			k=oper(operator,i,j);
			cal = String.valueOf(k);
			
			tf.setText(cal);
			op1=cal;
			n=1;
		}
		
		
		
		
		for(int z=0;z<10;z++) {
			if(e.getSource()==btnNum[z]) {
				tf.setText(tf.getText()+e.getActionCommand());
			}
		}
		
		
		
	}
	
	public float oper(String oper, float i, float j) {
		k=0;
		if(oper.equals("+")) {
			k = i+j;
		} if(oper.equals("-")) {
			k=i-j;
		} if(oper.equals("*")) {
			k=i*j;
		} if(oper.equals("/")) {
			k=i/j;
		}
		
		return k;
	}
}
