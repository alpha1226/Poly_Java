package midtest1602100283;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class B1602100283 {
	public static void main(String[] args) {
		Menu01 m1 = new Menu01();
		m1.makeMenu();
		m1.display();
	}
}



class Menu01 extends JFrame {
	JMenuBar mb;
	JMenu mFile,mNotice,mAdd;
	JMenuItem miNew,miOpen,miSave,miQuit;
	JMenuItem notice; // dialog상자
	JMenu minfo;
	JMenuItem name,hakbun;
	JMenuItem calc, paint, quiz;
	JDialog dialog;

	JTextArea ta;
	FileDialog open,save;

	JFrame jf;
	
	Menu01(){
		mb = new JMenuBar();
		mFile = new JMenu("File");
		//mFile.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.ALT_MASK));
		mNotice = new JMenu("Notice"); 
		//mNotice.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.ALT_MASK));
		mAdd = new JMenu("Add");
		//mAdd.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.ALT_MASK));
	
		
		
		miNew = new JMenuItem("New");
		miNew.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
		
		miOpen = new JMenuItem("Open");
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		miOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ta.setText("");
				open.setVisible(true);
				String txt = open.getDirectory()+open.getFile();
				String str=null;
				try {
					FileInputStream fis = new FileInputStream(txt);
					while(true) {
						int a = fis.read();
						if(a == -1) break;
						str += (char)a;
					}
				} catch (IOException ie){
					ie.printStackTrace();
				}
				ta.append(str);
			}
		});
		
		
		miSave = new JMenuItem("Save");
		miSave.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		miSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save.setVisible(true);
				String temp = ta.getText();
				char ctemp[] = temp.toCharArray();
				String path = save.getDirectory()+save.getFile();
				try {
					FileOutputStream fos = new FileOutputStream(path);
					DataOutputStream dos = new DataOutputStream(fos);
					for(int i=0;i<ctemp.length;i++){
						dos.write(ctemp[i]);
					}
				}catch(IOException ie){
					ie.printStackTrace();
				}

			}
		});
		
		
		miQuit = new JMenuItem("Quit");
		miQuit.setAccelerator(KeyStroke.getKeyStroke('Q',InputEvent.CTRL_MASK));
		miQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JButton btn = new JButton("닫기");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		
		notice = new JMenuItem("notice");
		notice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog = new JDialog();
				dialog.setSize(400, 300);
				dialog.setTitle("1602100283");
				dialog.setVisible(true);
				dialog.add(btn);
			}
		});
		
		minfo = new JMenu("info");
		
		name = new JMenuItem("구영우");
		hakbun = new JMenuItem("1602100283");
		
		calc = new JMenuItem("calc");
		calc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calc my = new calc();
				my.display();
			}
		});
		
		paint = new JMenuItem("Paint");
		paint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyDrawFrame can = new MyDrawFrame();
				can.display();
			}
		});
		
		quiz = new JMenuItem("Quiz");
		quiz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myQuiz mq = new myQuiz();
				mq.display();
			}
		});
				
		
		open = new FileDialog(this, "1602100283구영우",FileDialog.LOAD);
		save = new FileDialog(this, "1602100283구영우",FileDialog.SAVE);
		
		
		setJMenuBar(mb);
		
		ta = new JTextArea(5,25);
		add(ta);
		
	}
	
	void makeMenu() {
		mb.add(mFile);
		mb.add(mNotice);
		mb.add(mAdd);
		
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miQuit);
		
		mNotice.add(notice);
		mNotice.add(minfo);
		minfo.add(name);
		minfo.add(hakbun);
		
		mAdd.add(calc);
		mAdd.add(paint);
		mAdd.add(quiz);
	}
	

	void display() {
		setResizable(false);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyMenu01");
	}


}



