import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Temperature {
	public static void main(String[] args) {
		MyTemperature mt = new MyTemperature();
		mt.display();
	}
}


class MyTemperature extends JFrame{
	
	JPanel jpn1, jpn2, jpn3, jpn4;
	JPanel alljpn;
	JButton btn1, btn2;
	JLabel label1, label2, label3;
	JTextField tf1,tf2,tf3;
	
	public MyTemperature() {
		jpn1 = new JPanel();
		jpn1.setLayout(new GridLayout(1,2));
		jpn2 = new JPanel();
		jpn2.setLayout(new GridLayout(1,2));
		jpn3 = new JPanel();
		jpn3.setLayout(new GridLayout(1,2));
		jpn4 = new JPanel();
		jpn4.setLayout(new GridLayout(1,2));
		label1 = new JLabel("섭씨온도");
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2 = new JLabel("화씨온도");
		label2.setHorizontalAlignment(JLabel.CENTER);
		label3 = new JLabel("절대온도");
		label3.setHorizontalAlignment(JLabel.CENTER);
		btn1 = new JButton("초기화");
		btn2 = new JButton("계산");
		tf1 = new JTextField("",1);
		tf1.setHorizontalAlignment(JTextField.CENTER);
		tf2 = new JTextField("",1);
		tf2.setHorizontalAlignment(JTextField.CENTER);
		tf2.setEnabled(false);
		tf3 = new JTextField("",1);
		tf3.setHorizontalAlignment(JTextField.CENTER);
		tf3.setEnabled(false);
		
		tf1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				tf2.setText(Double.toString(((Double.parseDouble(tf1.getText()))*1.8)+32));
				tf3.setText(Double.toString((Double.parseDouble(tf1.getText()))+273.15));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//double d_Num = Double.parseDouble(tf1.getText());
				//tf2.setText(Double.toString((d_Num*1.8)+32));
				//tf3.setText(Double.toString(d_Num+273.15));

				tf2.setText(Double.toString(((Double.parseDouble(tf1.getText()))*1.8)+32));
				tf3.setText(Double.toString((Double.parseDouble(tf1.getText()))+273.15));
			}
		});
		
		
		

		jpn1.add(label1);
		jpn1.add(tf1);
		jpn2.add(label2);
		jpn2.add(tf2);
		jpn3.add(label3);
		jpn3.add(tf3);
		jpn4.add(btn1);
		jpn4.add(btn2);
		
		add(jpn1);
		add(jpn2);
		add(jpn3);
		add(jpn4);
	}
	
	
	
	
	
	void display() {
		setLayout(new GridLayout(4,1));
		setSize(500,250);
		setVisible(true);
		setTitle("온도변환기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}