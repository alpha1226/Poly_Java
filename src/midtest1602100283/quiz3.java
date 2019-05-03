package midtest1602100283;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class quiz3 {
	public static void main(String[] args) {
		myQuiz3 mq2 = new myQuiz3();
		mq2.display();
	}	
}





class myQuiz3 extends JFrame implements ActionListener {
    JButton jb[] = null;
    Font myfont;
    Color myColor;
    JPanel jp,jp2,jp3;
    JButton reset,check;
    Image original;
    BufferedImage img[];
    JLabel jl,jl2;
    JLabel jlTime,jlMove;
    long beforeTime = System.currentTimeMillis();
    int row=5, col=5;
    int width,height;
    long afterTime;
    
    
    
    
    
    myQuiz3() {
        jb = new JButton[25];
        jp = new JPanel(new GridLayout(5,5));
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
            jb[i].setFont(myfont);
            jb[i].addActionListener(this);
            jb[i].setBackground(myColor);
            jb[i].setForeground(Color.blue);
            jp.add(jb[i]);
        }
        jb[24].setText("");
        reset = new JButton("reset");
        reset.setFont(myfont);
        reset.addActionListener(this);
        reset.setBackground(Color.BLUE);
        reset.setForeground(myColor); jp3.add(reset);
        check = new JButton("check");
        check.setFont(myfont);
        check.addActionListener(this); jp3.add(check);
        
        

    }
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
    			} else {
    				jb[i].setText(String.valueOf(rannum[i]));
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
    	
    	
    	
    	
    	

//---------------------------------------------------------------
//중앙 구현부
    	for(int i=6;i<=8;i++) {
    		if(jb[i].getText().equals("")) {
    			if(e.getSource()==jb[i+1]) {
        			jb[i].setText(jb[i+1].getText());
        			jb[i+1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-1]) {
        			jb[i].setText(jb[i-1].getText());
        			jb[i-1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-5]) {
        			jb[i].setText(jb[i-5].getText());
        			jb[i-5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+5]) {
        			jb[i].setText(jb[i+5].getText());
        			jb[i+5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    	}
    	
    	for(int i=11;i<=13;i++) {
    		if(jb[i].getText().equals("")) {
    			if(e.getSource()==jb[i+1]) {
        			jb[i].setText(jb[i+1].getText());
        			jb[i+1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-1]) {
        			jb[i].setText(jb[i-1].getText());
        			jb[i-1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-5]) {
        			jb[i].setText(jb[i-5].getText());
        			jb[i-5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+5]) {
        			jb[i].setText(jb[i+5].getText());
        			jb[i+5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    	}
    	
    	for(int i=16;i<=18;i++) {
    		if(jb[i].getText().equals("")) {
    			if(e.getSource()==jb[i+1]) {
        			jb[i].setText(jb[i+1].getText());
        			jb[i+1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-1]) {
        			jb[i].setText(jb[i-1].getText());
        			jb[i-1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-5]) {
        			jb[i].setText(jb[i-5].getText());
        			jb[i-5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+5]) {
        			jb[i].setText(jb[i+5].getText());
        			jb[i+5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    	}
//중앙구현부
//---------------------------------------------------------------------------
    	
    	
    	
    	
//오른쪽 위 구석
    	
    	if(jb[4].getText().equals("")) {
    		if(e.getSource()==jb[3]) {
    			jb[4].setText(jb[3].getText());
    			jb[3].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[9]) {
    			jb[4].setText(jb[9].getText());
    			jb[9].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
//---------------------------------------------------------------------------

    	
//오른쪽 부분

    	for(int i=9;i<20;i=i+5) {
    		if(jb[i].getText().equals("")) {
        		if(e.getSource()==jb[i-1]) {
        			jb[i].setText(jb[i-1].getText());
        			jb[i-1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-5]) {
        			jb[i].setText(jb[i-5].getText());
        			jb[i-5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+5]) {
        			jb[i].setText(jb[i+5].getText());
        			jb[i+5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    	}
//---------------------------------------------------------------------------

    	
//위쪽
    	for(int i=1;i<4;i++) {
    		if(jb[i].getText().equals("")) {
        		if(e.getSource()==jb[i-1]) {
        			jb[i].setText(jb[i-1].getText());
        			jb[i-1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+1]) {
        			jb[i].setText(jb[i+1].getText());
        			jb[i+1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+5]) {
        			jb[i].setText(jb[i+5].getText());
        			jb[i+5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    	}
//---------------------------------------------------------------------------
    	
//왼쪽 위
    	if(jb[0].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    			jb[0].setText(jb[1].getText());
    			jb[1].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[5]) {
    			jb[0].setText(jb[5].getText());
    			jb[5].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
//---------------------------------------------------------------------------
    	
    	
    	
    	
    	
//왼쪽벽	
    	for(int i=5;i<17;i=i+5) {
    		if(jb[i].getText().equals("")) {
        		if(e.getSource()==jb[i+5]) {
        			jb[i].setText(jb[i+5].getText());
        			jb[i+5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+1]) {
        			jb[i].setText(jb[i+1].getText());
        			jb[i+1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-5]) {
        			jb[i].setText(jb[i-5].getText());
        			jb[i-5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    		
    	}
//--------------------------------------------------------------------------
    	
    	
//왼쪽 밑
    	if(jb[20].getText().equals("")) {
    		if(e.getSource()==jb[21]) {
    			jb[20].setText(jb[21].getText());
    			jb[21].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[15]) {
    			jb[20].setText(jb[15].getText());
    			jb[15].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
//---------------------------------------------------------------------------
    	
    	
//밑부분
    	for(int i=21;i<24;i++) {
    		if(jb[i].getText().equals("")) {
        		if(e.getSource()==jb[i-1]) {
        			jb[i].setText(jb[i-1].getText());
        			jb[i-1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i+1]) {
        			jb[i].setText(jb[i+1].getText());
        			jb[i+1].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        		if(e.getSource()==jb[i-5]) {
        			jb[i].setText(jb[i-5].getText());
        			jb[i-5].setText("");
        			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        		}
        	}
    		
    	}
//--------------------------------------------------------------------------
    	
//오른쪽밑
    	if(jb[24].getText().equals("")) {
    		if(e.getSource()==jb[23]) {
    			jb[24].setText(jb[23].getText());
    			jb[23].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[20]) {
    			jb[25].setText(jb[20].getText());
    			jb[20].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
//---------------------------------------------------------------------------
    	
    	
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