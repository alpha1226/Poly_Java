import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelTest01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPanel mp = new MyPanel();
		mp.display();
	}

}

class MyPanel extends JFrame{
	
/*	JPanel p1,p2;
	JButton btn1,btn2,btn3,btn4;*/
//	JButton btn[];
//	JTextField tf;
	
	JButton btn;
	JLabel lb;
	JTextField tf;
	JTextArea ta;
	JCheckBox ch1, ch2;
	JRadioButton r1, r2;
	ButtonGroup bg;
	JList<String> lst;
	String items[]= {"���", "�ٳ���","����","����","�丶��"};
	JComboBox<String> combo;
	
	public MyPanel() {
		btn = new JButton("��ư");add(btn);
		lb = new JLabel("���� ��ĥ �� �����ϴ�.");add(lb);
		tf = new JTextField("�������ٱۻ���",20);add(tf);
		ta = new JTextArea("�����ٱۻ���",10,20);add(ta);
		ch1 = new JCheckBox("�ڹ�");add(ch1);
		ch2 = new JCheckBox("�ȵ���̵�");add(ch2);
		r1 = new JRadioButton("����");add(r1);
		r2 = new JRadioButton("����");add(r2);
		bg = new ButtonGroup(); bg.add(r1);bg.add(r2);
		ta.setLineWrap(true);
		
		lst = new JList<>();
		add(lst);
		combo= new JComboBox<>(items);
		add(combo);
		
		
		
		
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int i= combo.getSelectedIndex();
				String a=combo.getItemAt(i);
				ta.append(a);
			}
		});
		


		
		//		tf = new JTextField();
//		btn = new JButton[10];
//		
//		for(int i = 0; i<10; i++) {
//			//btn[i] = new JButton(String.valueOf(i).toString());
//			btn[i] = new JButton(i+"");
//			add(btn[i]);
//		}
/*		// TODO Auto-generated constructor stub
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setLocation(screenSize.width / 2, screenSize.height / 2);
		Image img = kit.getImage("capture2.jpg");
		setIconImage(img);
		p1 = new JPanel();
		p2 = new JPanel();
		btn1 = new JButton("1��°");
		btn2 = new JButton("2��°");
		btn3 = new JButton("3��°");
		btn4 = new JButton("4��°");
		p1.setBackground(Color.CYAN);
		p2.setBackground(Color.YELLOW);
		
		add(p1);
		add(p2);
		p1.add(btn1);
		p1.add(btn2);
		p2.add(btn3);
		p2.add(btn4);
		
	*/
	}
	void display() {
		setResizable(false);
		setLayout(new FlowLayout());
		setSize(270,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�г����� ��ư�ִ�.");
	}
}
