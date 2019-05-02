package midtest1602100283;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Quiz {
	public static void main(String[] args) {
		myQuiz mq = new myQuiz();
		mq.display();
	}	
}

class myQuiz extends JFrame implements ActionListener {
    JButton jb[] = null;
    Font myfont;
    Color myColor;
    JPanel jp;
    JButton reset;
    Image original;
    BufferedImage img[];

    
    
    
    
    myQuiz() {
        jb = new JButton[9];
        jp = new JPanel(new GridLayout(3,3,5,5));

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
        reset.setForeground(myColor);

    }
    void display() {
        setLayout(new BorderLayout(5,5));
        add(jp,BorderLayout.CENTER);
        add(reset,BorderLayout.SOUTH);
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
    	
    	if(jb[0].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    			jb[0].setText(jb[1].getText());
    			jb[1].setText("");
    		}
    		if(e.getSource()==jb[3]) {
    			jb[0].setText(jb[3].getText());
    			jb[3].setText("");
    		}
    	}
    	
    	if(jb[1].getText().equals("")) {
    		if(e.getSource()==jb[0]) {
    			jb[1].setText(jb[0].getText());
    			jb[0].setText("");
    		}
    		if(e.getSource()==jb[2]) {
    			jb[1].setText(jb[2].getText());
    			jb[2].setText("");
    		}
    		if(e.getSource()==jb[4]) {
    			jb[1].setText(jb[4].getText());
    			jb[4].setText("");
    		}
    	}
    	
    	if(jb[2].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    			jb[2].setText(jb[1].getText());
    			jb[1].setText("");
    		}
    		if(e.getSource()==jb[5]) {
    			jb[2].setText(jb[5].getText());
    			jb[5].setText("");
    		}
    	}
    	
    	if(jb[3].getText().equals("")) {
    		if(e.getSource()==jb[0]) {
    	    	jb[3].setText(jb[0].getText());
    	    	jb[0].setText("");
        	}
    		if(e.getSource()==jb[4]) {
    			jb[3].setText(jb[4].getText());
    			jb[4].setText("");
    		}
    		if(e.getSource()==jb[6]) {
    			jb[3].setText(jb[6].getText());
    			jb[6].setText("");
    		}
    	}
    	
    	if(jb[4].getText().equals("")) {
    		if(e.getSource()==jb[1]) {
    	    	jb[4].setText(jb[1].getText());
    	    	jb[1].setText("");
        	}
    		if(e.getSource()==jb[3]) {
    			jb[4].setText(jb[3].getText());
    			jb[3].setText("");
    		}
    		if(e.getSource()==jb[5]) {
    			jb[4].setText(jb[5].getText());
    			jb[5].setText("");
    		}
    		if(e.getSource()==jb[7]) {
    			jb[4].setText(jb[7].getText());
    			jb[7].setText("");
    		}
    	}
    	
    	if(jb[5].getText().equals("")) {
    		if(e.getSource()==jb[2]) {
    	    	jb[5].setText(jb[2].getText());
    	    	jb[2].setText("");
        	}
    		if(e.getSource()==jb[4]) {
    			jb[5].setText(jb[4].getText());
    			jb[4].setText("");
    		}
    		if(e.getSource()==jb[8]) {
    			jb[5].setText(jb[8].getText());
    			jb[8].setText("");
    		}
    	}
    	
    	
    	if(jb[6].getText().equals("")) {
    		if(e.getSource()==jb[3]) {
    	    	jb[6].setText(jb[3].getText());
    	    	jb[3].setText("");
        	}
    		if(e.getSource()==jb[7]) {
    			jb[6].setText(jb[7].getText());
    			jb[7].setText("");
    		}
    	}
    	
    	if(jb[7].getText().equals("")) {
    		if(e.getSource()==jb[4]) {
    	    	jb[7].setText(jb[4].getText());
    	    	jb[4].setText("");
        	}
    		if(e.getSource()==jb[6]) {
    			jb[7].setText(jb[6].getText());
    			jb[6].setText("");
    		}
    		if(e.getSource()==jb[8]) {
    			jb[7].setText(jb[8].getText());
    			jb[8].setText("");
    		}
    	}

    	if(jb[8].getText().equals("")) {
    		if(e.getSource()==jb[5]) {
    	    	jb[8].setText(jb[5].getText());
    	    	jb[5].setText("");
        	}
    		if(e.getSource()==jb[7]) {
    			jb[8].setText(jb[7].getText());
    			jb[7].setText("");
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