package midtest1602100283;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quiz3 {
	public static void main(String[] args) {
		myQuiz3 mq2 = new myQuiz3();
		mq2.display();
	}	
}

class myQuiz3 extends JFrame implements ActionListener {
	public  JButton jb[] = null;
	Font myfont;
	Color myColor;
	JPanel jp,jp2,jp3;
	JPanel alljp, photojp;
	JButton reset,check;
	JLabel jl,jl2;
	JLabel jlTime,jlMove;
	long beforeTime = System.currentTimeMillis();
	long afterTime;

	myQuiz3() {
		alljp = new JPanel(new GridLayout(1,2));
		photojp = new JPanel(new FlowLayout()); alljp.add(photojp);
		jb = new JButton[25];
		jp = new JPanel(new GridLayout(5,5)); alljp.add(jp);
        jp2 = new JPanel(new GridLayout(1,4));
        jp3 = new JPanel(new GridLayout(1,2));
        jl = new JLabel("이동횟수"); jl.setText("이동횟수"); jp2.add(jl);
        jlMove = new JLabel("Move"); jlMove.setText("0"); jp2.add(jlMove);
        jl2 = new JLabel("시간"); jl2.setText("시간"); jp2.add(jl2);
        jlTime = new JLabel("Time"); jlTime.setText("0"); jp2.add(jlTime);
        myfont = new Font("굴림체",Font.BOLD,30);
        myColor = new Color(255,255,0);
        for(int i = 0; i < jb.length; i++){
            jb[i] = new JButton(""+(i+1));
            try {
            jb[i].setIcon(new ImageIcon(Class.class.getResource("/Images"+(i+1)+".gif")));
            } catch(Exception e) {
            	System.out.println(e);
            }
            jb[i].setFont(myfont);
            jb[i].addActionListener(this);
            jb[i].setBackground(myColor);
            jb[i].setForeground(Color.blue);
            jp.add(jb[i]);
        }
        jb[24].setText("");
        jb[24].setIcon(null);
        reset = new JButton("reset");
        reset.setFont(myfont);
        reset.addActionListener(this);
        reset.setBackground(Color.BLUE);
        reset.setForeground(myColor); jp3.add(reset);
        check = new JButton("check");
        check.setFont(myfont);
        check.addActionListener(this); jp3.add(check);

    }
//액션퍼폼드 내부 함수 정의
	void buttonToUp(int i) {
		jb[i].setText(jb[i+5].getText());
		jb[i+5].setText("");
		jb[i].setIcon(jb[i+5].getIcon());
		jb[i+5].setIcon(null);
		jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	void buttonToDown(int i){
		jb[i].setText(jb[i-5].getText());
		jb[i-5].setText("");
		jb[i].setIcon(jb[i-5].getIcon());
		jb[i-5].setIcon(null);
		jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	void buttonToRight(int i){
		jb[i].setText(jb[i+1].getText());
		jb[i+1].setText("");
		jb[i].setIcon(jb[i+1].getIcon());
		jb[i+1].setIcon(null);
		jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	void buttonToLeft(int i){
		jb[i].setText(jb[i-1].getText());
		jb[i-1].setText("");
		jb[i].setIcon(jb[i-1].getIcon());
		jb[i-1].setIcon(null);
		jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
	}
	//----------------------------------------------------------------
    void display() {
        setLayout(new BorderLayout(5,5));
        add(jp2,BorderLayout.NORTH);
        add(jp,BorderLayout.CENTER);
        add(jp3,BorderLayout.SOUTH);
        setSize(500, 500);
        setVisible(true);
        setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource()==reset) {
    	    int[] num= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    		int[] rannum=shuffle(num);
    		
    		for(int i=0;i<num.length;i++) {
    			if(rannum[i]==0) {
    				jb[i].setText("");
    				jb[i].setIcon(null);
    			} else {
    				jb[i].setText(String.valueOf(rannum[i]));
    				jb[i].setIcon(new ImageIcon(Class.class.getResource("/Images"+rannum[i]+".gif")));
    			}
    		}
    	}
    	
    	if(e.getSource()==check) {
    		int sum=0;
    		for(int i=0;i<jb.length;i++) {
    			if(jb[i].getText().equals(String.valueOf(i+1))) {
    				sum=sum+1;
    				System.out.println(i+1+"성공");
    			}
    		}
    		if(sum==jb.length-1) {
    			System.out.println("성공");
    			afterTime = System.currentTimeMillis();
    			jlTime.setText(String.valueOf((afterTime - beforeTime)/1000));
    			JOptionPane.showMessageDialog(null, "성공하셧습니다\n이동횟수 : "+jlMove.getText()+"     시간 : "+((afterTime - beforeTime)/1000));
    		}
    	}


		//버튼 구현부
    	for(int i=0;i<jb.length;i++) {
			if(jb[i].getIcon()==null){
				System.out.println("NUll"+i);
				if(i>=5){
					if(e.getSource()==jb[i-5]) {buttonToDown(i);}
				}
				if(i<jb.length-5){
					if(e.getSource()==jb[i+5]) {buttonToUp(i);}
				}

				if(i%5!=0) if(e.getSource()==jb[i-1]) {buttonToLeft(i);}
				if(i%5!=4) if(e.getSource()==jb[i+1]) {buttonToRight(i);}
			}
		}
    }

    public static int[] shuffle(int[] arr){
    	for(int x=0;x<arr.length;x++){
          int i = (int)(Math.random()*arr.length);
          int j = (int)(Math.random()*arr.length);       
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }     
        return arr;
    }
}