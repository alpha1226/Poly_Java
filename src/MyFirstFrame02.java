import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFirstFrame02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buttons btns = new Buttons();
		btns.display();
	}

}

class Buttons extends JFrame{
	JButton btn[];
	Buttons(){
		btn = new JButton[10];
		for(int i = 0; i<10; i++) {
		
			btn[i] = new JButton(""+i);
			add(btn[i]);
		}
		
		
	}
	
	void display() {
		setLayout(new GridLayout(0,3,10,10));
		setSize(300,300);
		setVisible(true);
		setTitle("내가만든 버튼들");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}