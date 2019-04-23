import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class range {
	
	public static void main(String[] args) {
		Myrange mp = new Myrange();
		mp.display();
	}
}
	
class Myrange extends JFrame {
	
	JButton btn;
	JLabel lb;
	JLabel lb2;
	JLabel lb3;
	JTextField tf1;
	JTextField tf2;
	
	JList<String> list;
	String items[]= {"CM","Inch"};
	JComboBox<String> combo;

	
	public Myrange() {
		lb = new JLabel("원하는 거리를 입력하세요.");add(lb);
		lb2 = new JLabel("길이를 입력하세요.(cm)");add(lb2);
		tf1 = new JTextField("",10);add(tf1);
		lb3 = new JLabel("변환된 길이.(Inch)");add(lb3);
		tf2 = new JTextField("",10);add(tf2);

		list = new JList<>();
		add(list);
		combo= new JComboBox<>(items);
		add(combo);
		
		btn = new JButton("로 변환");add(btn);

		
		
		
		
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
				//tf1.setText(a);
				
				if(i==0) {
					
					double d_Num = Integer.parseInt(tf2.getText());
					d_Num=(d_Num*2.54);
					//int Num = (int)(d_Num*2.54);
					tf1.setText(d_Num+"");
					tf2.setText("");
					
				}else if(i==1) {
					double d_Num = Integer.parseInt(tf1.getText());
					d_Num=(d_Num/2.540*100)/100;
					//int Num = (int)(Math.round(d_Num/2.540*100))/100;
					tf2.setText(d_Num+"");
					tf1.setText("");
				}
			}
		});		
		
	}
	void display() {
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(280,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("거리 변환기");
	}
}	



