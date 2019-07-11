package settingtimer;
//importing library of Timer and TimerTask
import java.util.Timer;
import java.util.TimerTask;

import java.util.Random;
import javax.swing.*;
import java.awt.event.*;

public class SettingTimer implements ActionListener, KeyListener {
    Random rand = new Random();
    //needed variables
    int secondPassed = 0;
    int score = 0;
    int randomWord;
    //words to display to type
    String [] words = {"the", "quick", "brown", "fox", "jump", "high", "over", "the", "lazy", "dog"};
    JFrame f = new JFrame();
    JButton but1 = new JButton("Start");
    JButton but0 = new JButton("Enter");
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel("");
    JLabel lbl3 = new JLabel("" + score);
    JTextField jf1 = new JTextField();
    JLabel me = new JLabel("Enter your name");
    JButton ak = new JButton("Ok");
    JTextField jf2 = new JTextField();
    JLabel lbl4 = new JLabel("noob");
   
    
    //new JFrame
    
    public void nameForm()
    {
        JFrame newF = new JFrame();
        newF.setLayout(null);
        newF.setSize(200, 200);
        newF.setVisible(true);
        newF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        me.setBounds(50, 10, 100, 50);
        jf2.setBounds(50, 60, 100, 30);
        ak.setBounds(50, 100, 100, 30);
   
        newF.add(me);
        newF.add(ak);
        newF.add(jf2);
    }
    //main JFrame
    public void gameForm()
    {
        f.setLayout(null);
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        but0.setBounds(100, 20, 150, 30);
        but1.setBounds(100, 100, 100, 50);
        lbl1.setBounds(250, 150, 100, 50);
        lbl2.setBounds(100, 150, 100, 50);
        lbl3.setBounds(250, 200, 100, 30);
        jf1.setBounds(100, 200, 100, 30);
        lbl4.setBounds(100,250,100,30);
        
        
        f.add(but0);
        f.add(but1);
        f.add(lbl1);
        f.add(lbl2);
        f.add(lbl3);
        f.add(jf1);
        f.add(lbl4);
        
        
        but0.addActionListener(this);
        but1.addActionListener(this);
        jf1.addKeyListener(this);
    }
    //method for resetting the game
    public void reset()
    {
        lbl3.setText("" + score);
        randomWord = rand.nextInt(words.length-1);
        lbl2.setText(words[randomWord]);
        jf1.setText("");  
        if(score == 1){
            lbl4.setText("good");
        }
        else if(score ==3){
            lbl4.setText("nice");
        }
        else if(score ==5){
            lbl4.setText("pro");
        }
        else if(score ==7){
            lbl4.setText("God");
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==but0)
        {
            new SettingTimer().nameForm();
        }
        if (e.getSource()==but1)
        {
            //if the but1 has been pressed, the myTimer and task will be freshly declared
            Timer myTimer = new Timer();
            secondPassed = 0;
            score = 0;
            //method reset has been called
            reset();
            //the cursor of the mouse will be focused on jf1 TextField
            jf1.requestFocus();
            TimerTask task = new TimerTask()
            {
                //this is medthod run
                public void run()
                {
                    secondPassed++;
                    lbl1.setText("" + secondPassed);
                    //this will be the done when time is at 10 seconds
                    if(secondPassed == 10)
                    {
                        JOptionPane.showMessageDialog(but1, "Your score is: " + score);
                        //myTimer will be stop
                        
                        final Timer myTimer = new Timer();
                        myTimer.cancel();
                    }
                }
            };
            //declaring the speed and the task of the timer
            myTimer.scheduleAtFixedRate(task, 1000, 1000);
            //the method run under the task has been called
            task.run();
        }
    }
    
    public void keyPressed(KeyEvent e)
    {
        
    }
    public void keyReleased(KeyEvent e)
    {
        if (e.getSource()==jf1)
        {
            if(jf1.getText().equals(lbl2.getText()))
            {
                score++;
                reset();
            }
        }
    }
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    public static void main(String[] args) {
        new SettingTimer().gameForm();
    }
}
