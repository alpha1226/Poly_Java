package menu_0418;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MyMenu01 {

	public static void main(String[] args) {
		Menu01 m1 = new Menu01();
		m1.display();
		m1.makeMenu();
	}

}

class Menu01 extends JFrame{
	JMenuBar mb;
	JMenu mFile,mEdit,mHelp;
	JMenuItem miNew,miOpen,miSave,miQuit;
	JMenuItem miCopy, miPaste, miCut;
	JMenuItem miHelp;
	JMenu mOut;
	JMenuItem miPdf, miPrinter;
	JMenu mInfo;
	JMenuItem miVersion, miDer;
	JMenuItem miCal,miCan;
	JTextArea ta;
	FileDialog open,save; //저장하기, 열기 대화상자
	
	Menu01(){
		mb = new JMenuBar();
		mFile = new JMenu("파일");
		mEdit = new JMenu("오픈");
		mHelp = new JMenu("도움말");
		
		miNew = new JMenuItem("새글");
		miNew.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		miNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
		
		miOpen = new JMenuItem("열기");
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		miOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				open.setVisible(true);
			}
		});
		
		miSave = new JMenuItem("저장하기");
		miSave.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		miSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save.setVisible(true);
			}
		});
		
		miQuit = new JMenuItem("나가기");
		miQuit.setAccelerator(KeyStroke.getKeyStroke('Q',InputEvent.CTRL_MASK));
		miQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		miCopy = new JMenuItem("복사");
		miPaste = new JMenuItem("붙여넣기");
		miCut = new JMenuItem("자르기");
		miPaste.setEnabled(false);
		
		
		miHelp = new JMenuItem("도움말");
		miHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myHelp dil = new myHelp();
			}
		});
		
		mOut = new JMenu("출력");
		miPdf = new JMenuItem("PDF출력");
		miPrinter = new JMenuItem("프린터출력");
		
		mInfo = new JMenu("정보");
		miVersion = new JMenuItem("버전정보");
		miDer = new JMenuItem("만든이");
		
		miCal = new JMenuItem("계산기");
		miCal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calc my = new calc();
				my.display();
			}
		});
		miCan = new JMenuItem("그림판");
		miCan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MyDrawFrame md = new MyDrawFrame();
				JButton btn;
				btn = new JButton("Close");
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setVisible(false);
					}
				});
				md.display(); //add(btn);
			}
		});
		
		ta = new JTextArea(5,25);
		
		open = new FileDialog(this, "내가만든 열기",FileDialog.LOAD);
		
		save = new FileDialog(this, "내가만든저장",FileDialog.SAVE);
		
		

		setJMenuBar(mb);
		
		
		add(ta);
		
	}
	
	void makeMenu() {
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mHelp);
		
		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSave);
		mFile.add(miQuit);
		mFile.addSeparator();
		mFile.add(mOut);
		
		mEdit.add(miCopy);
		mEdit.add(miPaste);
		mEdit.add(miCut);
		
		mHelp.add(miHelp);
		mHelp.add(mInfo);
		
		mOut.add(miPdf);
		mOut.add(miPrinter);
		mInfo.add(miVersion);
		mInfo.add(miDer);
		
		mHelp.add(miCal);
		mHelp.add(miCan);
		
	}
	
	
	
	
	
	void display() {
		setResizable(false);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyMenu01");
	}
}

class myHelp extends JDialog{
	JButton btn;
	myHelp(){
		btn = new JButton("close");add(btn);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(200,100);
		setTitle("내가만든대화상자");
	}
}
