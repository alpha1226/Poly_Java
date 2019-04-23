import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pizza {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mypizza mp1 = new Mypizza();
		mp1.display();
	}
}


class Mypizza extends JFrame{
	
	JPanel jp1,jp2,jp3;
	JLabel lb1,lb2;
	JButton btn1,btn2,btn3;
	JTextField tf1;

	public Mypizza() {
		jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp3 = new JPanel();
		jp3.setLayout(new GridLayout(2,1));
		lb1 = new JLabel();
		
		lb1.setText("피자를 선택해주세요");
		jp1.add(lb1);
		
		btn1 = new JButton();
		btn1.setText("콤포피자");jp2.add(btn1);
		btn2 = new JButton();
		btn2.setText("포테이토 피자");jp2.add(btn2);
		btn3 = new JButton();
		btn3.setText("불고기피자");jp2.add(btn3);
		lb2 = new JLabel();
		lb2.setText("개수"); jp2.add(lb2);
		tf1 = new JTextField("20",5); jp2.add(tf1);
		tf1.setHorizontalAlignment(JTextField.RIGHT);
		
		
		jp3.add(jp1);
		jp3.add(jp2);
		add(jp3);
	}

	
	void display() {
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(500,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("거리 변환기");
	}
}
