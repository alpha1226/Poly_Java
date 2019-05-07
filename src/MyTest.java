import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MyTest {
	public static void main(String[] args) {
		Buttons2 btns = new Buttons2();
		btns.display();
	}
}

class Buttons2 extends JFrame{
	JButton btn[]; //
	
	
	
	Buttons2(){
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
		setTitle("alpha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		

}
	
	
	


