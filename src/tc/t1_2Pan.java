package tc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class t1_2Pan {
	
	public static void main(String[] args) {
		t1_2Pan mp = new t1_2Pan();
		//mp.display();
	}

	
	
	class ConvertLength extends JFrame{
		JPanel p1, p2;
		JLabel inch, cm;
		JTextField tf1, tf2;
		JButton btn;
		
		ConvertLength(){
			p1 = new JPanel(new GridLayout(1,2));
			p1.setBackground(Color.GRAY);
			
			inch = new JLabel("길이를 입력 Cm");
			cm = new JLabel("길이를 입력 Inch");
			inch.setForeground(Color.white);
			tf1=new JTextField(10);
			tf2=new JTextField(10);
			p1.add(inch);p1.add(tf1);
			p2.add(inch);p2.add(tf2);
			add(p1);
			add(p2);
		}
		
	}
	
	
	/*void display() {
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(280,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("거리 변환기");
	}*/

		
	
}
