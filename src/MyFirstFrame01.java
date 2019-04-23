import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFirstFrame01{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame1 mf = new MyFrame1();

		mf.display();
	
		
/*		JFrame f = new JFrame("내가만든 소제목");

		f.setTitle("두번째창제목");
		
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setResizable(false);*/
		//MyFirstFrame01 mf = new MyFirstFrame01();
		
		
	}
/*	MyFirstFrame01() {
		// TODO Auto-generated constructor stub
		super("title");
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setTitle("title");

	}*/
	

}
class MyFrame1 extends JFrame {
JButton btn;
JButton btn2,btn3,btn4,btn5;

	public MyFrame1() {
		super("제목");
		// TODO Auto-generated constructor stub
		btn = new JButton("1번째");
		btn2 = new JButton("2번째");
		btn3 = new JButton("3번째");
		btn4 = new JButton("4번째");
		btn5 = new JButton("5번째");
		add(btn);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		

		
	}
	void display() {
		setLayout(new FlowLayout());
		/*setLayout(new BorderLayout(5,10));
		add(BorderLayout.EAST,btn);
		add(BorderLayout.WEST,btn2);
		add(BorderLayout.SOUTH,btn3);
		add(BorderLayout.NORTH,btn4);
		add(BorderLayout.CENTER,btn5);*/
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}
