import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.Position;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

public class randomlocation {
	public static void main(String[] args) {
		MyRandomlocation myRan = new MyRandomlocation();
		myRan.display();
	}
}

class MyRandomlocation extends JFrame {
	
	JLabel jl;
	int positionX, positionY;
	
	
	
	
	MyRandomlocation(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int x = (int)screenSize.getWidth();
		int y = (int)screenSize.getHeight();
		Dimension dim=new Dimension(x/2,y/2);
		setPreferredSize(dim); pack();
		
		
		
		//int rNum= (int)Math.random();
		
		
		setSize(x/2,y/2);
		
		
		//jl=new JLabel("¿¡");
		
		
		for(int num=1;num<=100;num++) {
			jl=new JLabel(String.valueOf(num));
			jl.setSize(75,15);
			//positionX = (int)(Math.random()*(x/2));
			//positionY = (int)(Math.random()*(y/2));
			jl.setLocation((int)(Math.random()*(x/2)),(int)(Math.random()*(y/2)));
			add(jl);
		}
	}
	

	
	
	
	
	void display() {
		setLayout(null);
		setResizable(false);
		//setSize(1920,1080);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("∑£¥˝πËƒ°");
	}
	
}
