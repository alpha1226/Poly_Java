package midtest1602100283;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz2 {
	public static void main(String[] args) {
		myQuiz2 mq2 = new myQuiz2();
		mq2.display();
	}	
}

class myQuiz2 extends JFrame implements ActionListener {
    JButton jb[] = null;
    Font myfont;
    Color myColor;
    JPanel jp,jp2,jp3;
    JButton reset,check;
    Image original;
    BufferedImage img[];
    JLabel jl,jl2;
    JLabel jlTime,jlMove;
    
    
    
    
    myQuiz2() {
        jb = new JButton[9];
        jp = new JPanel(new GridLayout(3,3,5,5));
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
        jb[8].setText("");
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
        setSize(300, 300);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource()==reset) {
    	    int[] num= {0,1,2,3,4,5,6,7,8};
    		int[] rannum=shuffle(num);
    		
    		for(int i=0;i<9;i++) {
    			if(rannum[i]==0) {
    				jb[i].setText("");
    			} else {
    				jb[i].setText(String.valueOf(rannum[i]));
    			}
    		}
    	}
    	
    	if(e.getSource()==check) {
    		int sum=0;
    		for(int i=0;i<9;i++) {
    			if(jb[i].getText().equals(String.valueOf(i+1))) {
    				sum=sum+1;
    				System.out.println(i+1+"성공");
    			}
    		}
    		if(sum==8) {
    			System.out.println("성공");
    		}
    	}
    	
    	if(jb[0].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    			jb[0].setText(jb[1].getText());
    			jb[1].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[3]) {
    			jb[0].setText(jb[3].getText());
    			jb[3].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	if(jb[1].getText().equals("")) {
    		if(e.getSource()==jb[0]) {
    			jb[1].setText(jb[0].getText());
    			jb[0].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[2]) {
    			jb[1].setText(jb[2].getText());
    			jb[2].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[4]) {
    			jb[1].setText(jb[4].getText());
    			jb[4].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	if(jb[2].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    			jb[2].setText(jb[1].getText());
    			jb[1].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[5]) {
    			jb[2].setText(jb[5].getText());
    			jb[5].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	if(jb[3].getText().equals("")) {
    		if(e.getSource()==jb[0]) {
    	    	jb[3].setText(jb[0].getText());
    	    	jb[0].setText("");
    	    	jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        	}
    		if(e.getSource()==jb[4]) {
    			jb[3].setText(jb[4].getText());
    			jb[4].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[6]) {
    			jb[3].setText(jb[6].getText());
    			jb[6].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	if(jb[4].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    	    	jb[4].setText(jb[1].getText());
    	    	jb[1].setText("");
    	    	jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        	}
    		if(e.getSource()==jb[3]) {
    			jb[4].setText(jb[3].getText());
    			jb[3].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[5]) {
    			jb[4].setText(jb[5].getText());
    			jb[5].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[7]) {
    			jb[4].setText(jb[7].getText());
    			jb[7].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	if(jb[5].getText().equals("")) {
    		if(e.getSource()==jb[2]) {
    	    	jb[5].setText(jb[2].getText());
    	    	jb[2].setText("");
    	    	jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        	}
    		if(e.getSource()==jb[4]) {
    			jb[5].setText(jb[4].getText());
    			jb[4].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[8]) {
    			jb[5].setText(jb[8].getText());
    			jb[8].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	
    	if(jb[6].getText().equals("")) {
    		if(e.getSource()==jb[3]) {
    	    	jb[6].setText(jb[3].getText());
    	    	jb[3].setText("");
    	    	jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        	}
    		if(e.getSource()==jb[7]) {
    			jb[6].setText(jb[7].getText());
    			jb[7].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}
    	
    	if(jb[7].getText().equals("")) {
    		if(e.getSource()==jb[4]) {
    	    	jb[7].setText(jb[4].getText());
    	    	jb[4].setText("");
    	    	jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        	}
    		if(e.getSource()==jb[6]) {
    			jb[7].setText(jb[6].getText());
    			jb[6].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    		if(e.getSource()==jb[8]) {
    			jb[7].setText(jb[8].getText());
    			jb[8].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
    		}
    	}

    	if(jb[8].getText().equals("")) {
    		if(e.getSource()==jb[5]) {
    	    	jb[8].setText(jb[5].getText());
    	    	jb[5].setText("");
    	    	jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
        	}
    		if(e.getSource()==jb[7]) {
    			jb[8].setText(jb[7].getText());
    			jb[7].setText("");
    			jlMove.setText(String.valueOf(Integer.parseInt(jlMove.getText())+1));
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