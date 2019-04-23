import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.*;

public class EventTest1 {

	public static void main(String[] args) {
		MyEventTest1 me = new MyEventTest1();
		me.display();
	}
	
}

class MyEventTest1 extends JFrame implements ActionListener{
	JButton close, yellow, pink, clear;
	JPanel jp;
	JTextArea ta;
	JTextField tf;
	JCheckBox ch[];
	JRadioButton rbt[];
	ButtonGroup gr;
	String fruit[] = {"바나나","포도","토마토","수박","참외"};
	JComboBox<String> combo;
	
	MyEventTest1(){
		close = new JButton("exit");
		add(close);
		yellow = new JButton("yellow");
		add(yellow);
		pink = new JButton("pink");
		add(pink);
		clear = new JButton("clear");
		add(clear);
		ta = new JTextArea(10,40);
		tf = new JTextField(40);
		tf.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				ta.append("mouseMoved 실행\n");
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				ta.append("mouseDragged 실행\n");
			}
		});
		tf.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				ta.append("mouseWheelMoved 실행\n");
			}
		});
		tf.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ta.append("mouseReleased 실행\n");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				ta.append("mousePressed 실행\n");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				ta.append("mouseExited 실행\n");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				ta.append("mouseEntered 실행\n");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ta.append("mouseClicked 실행 X:"+e.getX()+"   Y: "+e.getY()+"\n");
			}
		});
		tf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				ta.append("포커스를 잃었습니다\n");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				ta.append("포커스를 얻었습니다\n");
			}
		});
		ta.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				ta.append(e.getKeyChar()+"입력\n");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				ta.append(e.getKeyChar()+"떼었음\n");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		ch = new JCheckBox[5];
		for(int i=0;i<ch.length;i++) {
			ch[i]=new JCheckBox((i+1)+"번");
		}
		
		jp = new JPanel();
		jp.setBackground(Color.BLACK);
		jp.add(close);
		jp.add(pink);
		jp.add(yellow);
		jp.add(clear);
		jp.add(ta);
		jp.add(tf);
		jp.add(ch[0]); jp.add(ch[1]); jp.add(ch[2]); jp.add(ch[3]); jp.add(ch[4]);
		
		
		pink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp.setBackground(Color.PINK);
			}
		});
		
		yellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp.setBackground(Color.YELLOW);
			}
		});
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jp.setBackground(Color.BLACK);
				//System.exit(0);
			}
		});
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.setText("");
			}
		});
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Text;
				Text = tf.getText();
				ta.append(Text+'\n');
				tf.setText("");
				
			}
		});
		
		ch[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ch[0].isSelected()==true) ta.append(ch[0].getText());
			}
		});

		ch[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ch[1].isSelected()==true) ta.append(ch[1].getText());
			}
		});

		ch[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ch[2].isSelected()==true) ta.append(ch[2].getText());
			}
		});

		ch[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ch[3].isSelected()==true) ta.append(ch[3].getText());
			}
		});

		ch[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ch[4].isSelected()==true) ta.append(ch[4].getText());
			}
		});

		
		gr = new ButtonGroup();
		rbt = new JRadioButton[3];
		for(int i=0;i<rbt.length;i++) {
			gr.add(rbt[i]);
		}
		
		for(int i=0; i<rbt.length;i++) {
			//if(a.getSource()==gender[i]) {
				
			}
		}
		

		
		


	
	void display() {
		//setLayout(new FlowLayout());
		add(jp);
		setSize(500,500);
		setVisible(true);
		setTitle("내가만든버튼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
