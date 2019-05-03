import java.awt.Image;
import java.awt.Toolkit;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class MyMission{
	public static void main(String[] args) {
		Mission m1 = new Mission();
		m1.makeMenu();
		m1.display();
	}
}


class Mission extends JFrame {
	
	JMenuBar mb;
	
	JMenu mFile, mEdit, mOper, mView, mHelp;
	JMenuItem miNew, miOpen, miDown, miADown, miPageset, miPrint, miQuit;
	JMenuItem miUndo, miCut, miCopy, miPaste, miDel, miFind, miNFind, miChange, miMove, miAlSel, miDate;
	JMenuItem miNextLine, miGol;
	JMenuItem miState;
	JMenuItem miHelp,miInfo;
	

	JTextField tf;
	
	
	
	Mission(){
		mb = new JMenuBar();
		mFile = new JMenu("파일(F)");
		mEdit = new JMenu("편집(E)");
		mOper = new JMenu("서식(O)");
		mView = new JMenu("보기(V)");
		mHelp = new JMenu("도움말(H)");
		miNew = new JMenuItem("새로만들기");
		miOpen = new JMenuItem("열기");
		miDown = new JMenuItem("저장");
		miADown = new JMenuItem("다른이름으로 저장");
		miPageset = new JMenuItem("페이지설정");
		miPrint = new JMenuItem("인쇄");
		miQuit = new JMenuItem("끝내기");
		miUndo = new JMenuItem("실행취소");
		miCut = new JMenuItem("잘라내기");
		miCopy = new JMenuItem("복사");
		miPaste = new JMenuItem("붙여넣기");
		miDel = new JMenuItem("삭제");
		miFind = new JMenuItem("찾기");
		miNFind = new JMenuItem("다음찾기");
		miChange = new JMenuItem("바꾸기");
		miMove = new JMenuItem("이동");
		miAlSel = new JMenuItem("전체선택");
		miDate = new JMenuItem("시간/날짜");
		miNextLine = new JMenuItem("자동줄바꿈");
		miGol = new JMenuItem("글꼴");
		miState = new JMenuItem("상태표시줄");
		miHelp = new JMenuItem("도움말보기");
		miInfo = new JMenuItem("메모장정보");
		
		setJMenuBar(mb);
		tf = new JTextField();
		add(tf);
	}
	
	
	
	void makeMenu(){
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mOper);
		mb.add(mView);
		mb.add(mHelp);
		
		mFile.setMnemonic(KeyEvent.VK_F);
		mEdit.setMnemonic(KeyEvent.VK_E);
		mOper.setMnemonic(KeyEvent.VK_O);
		mView.setMnemonic(KeyEvent.VK_V);
		mHelp.setMnemonic(KeyEvent.VK_H);
		
		mFile.add(miNew);
		miNew.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		mFile.add(miOpen);
		miOpen.setAccelerator(KeyStroke.getKeyStroke('O',InputEvent.CTRL_MASK));
		mFile.add(miDown);
		miDown.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.CTRL_MASK));
		mFile.add(miADown);
		mFile.addSeparator();
		mFile.add(miPageset);
		mFile.add(miPrint);
		miPrint.setAccelerator(KeyStroke.getKeyStroke('P',InputEvent.CTRL_MASK));
		mFile.addSeparator();
		mFile.add(miQuit);
		miQuit.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
		//miQuit.addActionListener(new ACH());

		miQuit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	
		mEdit.add(miUndo);
		miUndo.setEnabled(false);
		miUndo.setAccelerator(KeyStroke.getKeyStroke('Z',InputEvent.CTRL_MASK));
		mEdit.addSeparator();
		mEdit.add(miCut);
		miCut.setEnabled(false);
		miCut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_MASK));
		mEdit.add(miCopy);
		miCopy.setEnabled(false);
		miCopy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_MASK));
		mEdit.add(miPaste);
		miPaste.setAccelerator(KeyStroke.getKeyStroke('V',InputEvent.CTRL_MASK));
		mEdit.add(miDel);
		miDel.setEnabled(false);
		miDel.setAccelerator(KeyStroke.getKeyStroke('D',InputEvent.BUTTON1_MASK));
		mEdit.addSeparator();
		mEdit.add(miFind);
		miFind.setEnabled(false);
		miFind.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.CTRL_MASK));
		mEdit.add(miNFind);
		miNFind.setEnabled(false);
		miNFind.setAccelerator(KeyStroke.getKeyStroke(114,InputEvent.BUTTON1_MASK));
		mEdit.add(miChange);
		miChange.setAccelerator(KeyStroke.getKeyStroke('H',InputEvent.CTRL_MASK));
		mEdit.add(miMove);
		miMove.setEnabled(false);
		miMove.setAccelerator(KeyStroke.getKeyStroke('G',InputEvent.CTRL_MASK));
		mEdit.addSeparator();
		mEdit.add(miAlSel);
		miAlSel.setAccelerator(KeyStroke.getKeyStroke('A',InputEvent.CTRL_MASK));
		mEdit.add(miDate);
		miDate.setAccelerator(KeyStroke.getKeyStroke(116,InputEvent.BUTTON1_MASK));
		
		mOper.add(miNextLine);
		miNextLine.setAccelerator(KeyStroke.getKeyStroke('W',InputEvent.SHIFT_MASK));
		mOper.add(miGol);
		miGol.setAccelerator(KeyStroke.getKeyStroke('F',InputEvent.SHIFT_MASK));
		
		mView.add(miState);
		miState.setEnabled(false);
		miState.setAccelerator(KeyStroke.getKeyStroke('S',InputEvent.BUTTON1_MASK));
		
		mHelp.add(miHelp);
		miHelp.setAccelerator(KeyStroke.getKeyStroke('H',InputEvent.BUTTON1_MASK));
		mHelp.add(miInfo);
		miInfo.setAccelerator(KeyStroke.getKeyStroke((char)KeyEvent.VK_I));
		
		
		
	}
	
	
	void display() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("Notepad.png");
		        setIconImage(img);
		
		setResizable(false);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyMenu01");
		
		
	}
}