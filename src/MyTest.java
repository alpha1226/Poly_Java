import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MyTest {
	public static void main(String[] args) {
		Buttons btns = new Buttons();
		btns.display();
	}
}

class Buttons extends JFrame{
	JButton btn[]; //버튼 배열 선언
	
	
	
	Buttons(){
		btn= new JButton[10];
		for(int i=0;i<10;i++) {
			btn[i]=new JButton(""+i);
			add(btn[i]);
		}
	}
	
	void display() {
		setLayout(new GridLayout(0,3));
		setSize(300,300);
		setVisible(true);
		setTitle("내가만든버튼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
}
	
	
	


