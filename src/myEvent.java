import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class myEvent {
public static void main(String[] args) {EventTest01 et = new EventTest01();et.onView();}}
class EventTest01 extends JFrame implements ActionListener {
	JButton jb,yellow,pink,clear;JPanel jp;JTextArea ta;JTextField tf;JCheckBox ch[];JRadioButton rb[];ButtonGroup bg;JComboBox<String> combo;String fruit[] = {"바나나","포도","토마토","수박","참외"};
	public EventTest01() {
		jp = new JPanel();
		jb = new JButton("버튼");
		yellow = new JButton("yellow");
		pink = new JButton("pink");
		clear = new JButton("clear");ta= new JTextArea(10,40);tf=new JTextField(40);ch = new JCheckBox[5];rb = new JRadioButton[3];bg=new ButtonGroup();combo=new JComboBox<>(fruit);//선언
		jb.addActionListener(this);yellow.addActionListener(this);pink.addActionListener(this);clear.addActionListener(this);tf.addActionListener(this);//액션리스너
		jp.setBackground(Color.CYAN);jp.add(jb);jp.add(yellow);jp.add(pink);jp.add(clear);jp.add(ta);jp.add(tf);for(int i=0;i<ch.length;i++) {ch[i]=new JCheckBox(i+1+"번");jp.add(ch[i]);ch[i].addActionListener(this);}for(int i = 0;i<rb.length;i++) {rb[i] = new JRadioButton(); rb[i].addActionListener(this); bg.add(rb[i]);jp.add(rb[i]);}add(jp);rb[0].setText("male");rb[1].setText("female");rb[2].setText("other");jp.add(combo);combo.addActionListener(this);//추가
	}
	public void onView() {setResizable(false);setSize(500,400);setVisible(true);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}//기본 뷰
	public void actionPerformed(ActionEvent e) {if(e.getSource() == jb) System.exit(0);else if(e.getSource()==yellow)jp.setBackground(Color.yellow);else if(e.getSource()==pink)jp.setBackground(Color.PINK);else if(e.getSource()==clear)ta.setText("");else if(e.getSource()==tf) {ta.append(tf.getText() + '\n');tf.setText("");} for(int i =0;i<ch.length;i++) {if(e.getSource()==ch[i]) {if(ch[i].isSelected()) {ta.append(ch[i].getText()+"선택되었습니다.\n");}else {ta.append(ch[i].getText()+"해제되었습니다.\n");}}} for(int i = 0; i<rb.length;i++) { if(e.getSource()==rb[i]) {ta.append(rb[i].getText()+" 선택\n");}} if(e.getSource()==combo) {ta.append(combo.getSelectedItem().toString()+"\n");}}//익션리스너
}