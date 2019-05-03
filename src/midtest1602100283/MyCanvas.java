package midtest1602100283;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyCanvas {
	public static void main(String[] args) {
		MyDrawFrame md = new MyDrawFrame();
		md.display();
	}
}



class IMakeCanvas extends Canvas{
	int x=0;
	int y=0;
	int i=1;
	public void paint(Graphics g) {
		if(x==0&&y==0) {g.setColor(Color.white);} else {g.setColor(Color.black);}
		g.fillRect(x, y, 5, 5);
		
	}
	public void update(Graphics g) {
		paint(g);
	}
	
	
}

class MyDrawFrame extends JFrame{
	IMakeCanvas k;
	JButton jbtn;
	JButton btn;
	
	MyDrawFrame() {
		
		k= new IMakeCanvas(); 
		k.setSize(300,300);
		k.setBackground(Color.white);
		k.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				k.x=e.getX();
				k.y=e.getY();
				k.repaint();
			}
		});
		add(k);
		
		jbtn = new JButton("삭제"); add(jbtn);
		jbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				k.removeNotify(); k.x=0; k.y=0; add(k);
			}
		});
		
		
		btn = new JButton("Close");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		}); add(btn);
		
		k.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar()=='a') {
					k.x-=10;
				} else if(e.getKeyChar()=='d') {
					k.x+=10;
				} else if(e.getKeyChar()=='w') {
					k.y-=10;
				} else if(e.getKeyChar()=='s') {
					k.y+=10; 
				}
				k.repaint();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	void display() {
		setTitle("1602100283구영우");
		setLayout(new FlowLayout());
		setSize(350,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}