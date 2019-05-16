package midtest1602100283;

import com.sun.org.apache.xpath.internal.operations.Gt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Quiz2 {

	public static void main(String[] args) {
		//
		MyNumQ2 mn = new MyNumQ2();
		mn.display();
	}
}

class MyNumQ2 extends JFrame implements ActionListener {
	JButton ok;
	JTextField t1, t2;
	JLabel l1, l2;
	int row;
	int col;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			if (t1.getText() != "" && t2.getText() != "") {
				row = Integer.parseInt(t1.getText());
				col = Integer.parseInt(t2.getText());
			}

			MyQuiz2 mp = new MyQuiz2(row, col);
			mp.display();
			setVisible(false);
		}

	}

	public MyNumQ2() {
		ok = new JButton("Done");
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		l1 = new JLabel("row");
		l2 = new JLabel("column");
		ok.addActionListener(this);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(ok);
	}

	void display() {
		setVisible(true);
		setLayout(new GridLayout(3, 1));
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이 객체만 닫힌당.
		setSize(400, 400);
		setTitle("Puzzle");
		setLocationRelativeTo(null); // Location Center
	}
}

class MyQuiz2 extends JFrame implements ActionListener {
	JButton btn[];
	JButton imgbtn;
	JPanel imagePanel, panel, fullPanel, bottonPlnel;
	Font myFont;
	Color myColor;
	JButton reset,check;
	int sum;
	int row;
	int col;

	MyQuiz2(int row, int col) {

		this.row = row;
		this.col = col;


		bottonPlnel = new JPanel(new GridLayout(1,2));

		panel = new JPanel();
		panel.setLayout(new GridLayout(col, row, 3, 3));
		fullPanel = new JPanel(new GridLayout(1,2,3,3));
		imagePanel = new JPanel(new FlowLayout());
		imgbtn = new JButton();
		imgbtn.setIcon(new ImageIcon(Class.class.getResource("/SampleImage.jpg")));

		sum = row * col;

		myFont = new Font("굴림체", Font.BOLD, 20);
		myColor = new Color(255, 255, 0);
		btn = new JButton[sum];

		for (int i = 0; i < sum; i++) {
			btn[i] = new JButton(""+(i+1));
			btn[i].setFont(myFont);
			btn[i].addActionListener(this);
			btn[i].setBackground(myColor);
			btn[i].setForeground(Color.BLUE);
			panel.add(btn[i]);
		}
		btn[sum - 1].setText("");


//		/*
//이미지 짜르기---------------------------------------
		try {
			File file = new File("./SampleImage.jpg");
			BufferedImage bi = ImageIO.read(file);
			int imWidth = bi.getWidth();
			int imHeight = bi.getHeight();
			int btnWidth=imWidth/row;
			int btnHeight=imHeight/col;
			int num=0;
			for(int y=0; y<col; y++){
				for(int x=0;x<row;x++){
					BufferedImage SubImgage = bi.getSubimage(x*btnWidth, y*btnHeight, btnWidth, btnHeight);
					if(num<sum-1){btn[num].setIcon(new ImageIcon(SubImgage));}
					num++;
				}
			}


		}catch (Exception e){
			e.printStackTrace();
		}


		//System.out.println("Image cropped successfully: "+outputfile.getPath());


//-----------------------------------------------------------
//        */



		fullPanel.add(panel);
		fullPanel.add(imgbtn);
		add(fullPanel, BorderLayout.CENTER);
		setNumber();	// 시작시 랜덤 배열
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setFont(myFont);
		reset.setBackground(myColor);
		reset.setForeground(Color.BLUE);
		//add(reset, BorderLayout.SOUTH); //안안
		bottonPlnel.add(reset);
		check = new JButton("check");
		check.addActionListener(this);
		//add(check, BorderLayout.SOUTH);
		bottonPlnel.add(check);
		add(bottonPlnel,BorderLayout.SOUTH);

	}
	void setNumber() {	// 숫자 배열 랜덤
		int u[] = MyQuiz2.randomNum(sum);
		for (int i = 0; i < sum; i++) {
			btn[i].setText("" + u[i]);
		}
		btn[sum - 1].setText("");
	}

	void buttonToUp(int i) {
		btn[i].setText(btn[i+col].getText());
		btn[i+col].setText("");
		btn[i].setIcon(btn[i+col].getIcon());
		btn[i+col].setIcon(null);
		//jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	void buttonToDown(int i){
		btn[i].setText(btn[i-col].getText());
		btn[i-col].setText("");
		btn[i].setIcon(btn[i-col].getIcon());
		btn[i-col].setIcon(null);
		//jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	void buttonToRight(int i){
		btn[i].setText(btn[i+1].getText());
		btn[i+1].setText("");
		btn[i].setIcon(btn[i+1].getIcon());
		btn[i+1].setIcon(null);
		//jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	void buttonToLeft(int i){
		btn[i].setText(btn[i-1].getText());
		btn[i-1].setText("");
		btn[i].setIcon(btn[i-1].getIcon());
		btn[i-1].setIcon(null);
		//jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object s = e.getSource();
		if (s == reset) {	// 리셋버튼 클릭시 랜덤 숫자 발생
			setNumber();
		}
		for(int i=0;i<btn.length;i++) {
			if(btn[i].getText().equals("")){
				System.out.println("NUll"+i);
				if(i>=col){
					if(e.getSource()==btn[i-col]) {buttonToDown(i);}
				}
				if(i<btn.length-col){
					if(e.getSource()==btn[i+col]) {buttonToUp(i);}
				}

				if(i%row!=0) if(e.getSource()==btn[i-1]) {buttonToLeft(i);}
				if(i%col!=row -1) if(e.getSource()==btn[i+1]) {buttonToRight(i);}
			}
		}



		if(e.getSource()==check) {
			int sum=0;
			for(int i=0;i<btn.length;i++) {
				if(btn[i].getText().equals(String.valueOf(i+1))) {
					sum=sum+1;
					System.out.println(i+1+"성공");
				}
			}
			if(sum==btn.length-1) {
				System.out.println("성공");
			}
		}

	}

	static int[] randomNum(int sum) {
		Random r = new Random();
		int result[] = new int[sum];
		int x = 0;
		for (int i = 0; i < sum - 1; i++) {
			result[i] = r.nextInt(sum - 1) + 1;
			for (int j = 0; j < i; j++) {
				if (result[i] == result[j]) {
					x = r.nextInt(sum - 1) + 1;
					result[i] = x;
					i--;
					break;
				}
			}
		}
		return result;
	}

	void display() {
		setVisible(true);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이 객체만 닫힌당.
		setSize(1000, 800);
		setTitle("Puzzle");
		setLocationRelativeTo(null); // Location Center
	}
}