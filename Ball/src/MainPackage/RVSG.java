/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author DELL
 */
public class RVSG extends JFrame implements KeyListener
{
    Ball b1,b2;
    Timer timer;
    static int screen_height = 0;
    static int screen_width = 0;
    int STEP_SIZE = 3;
    int BALL_RADIUS = 60;
    boolean leftP1=false,rightP1=false,upP1=false,downP1=false;
    boolean leftP2=false,rightP2=false,upP2=false,downP2=false;
        RVSG() 
	{
            b1 = new Ball(BALL_RADIUS, 'R', 50, 50);
            b2 = new Ball(BALL_RADIUS,'G', 500, 50);
            addKeyListener(this);
            refreshScreen();
	}
        @Override
	public void paint(Graphics g)
	{
                super.paint(g);
                g.setColor(Color.red);
		g.fillOval(b1.xpos, b1.ypos, b1.radius, b1.radius);
                g.setColor(Color.green);
                g.fillOval(b2.xpos,b2.ypos , b2.radius, b2.radius);
	}
	public static void main(String[] args)
	{
		RVSG gamepage = new RVSG();
                gamepage.setTitle("RED V/S GREEN");
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                screen_height = (int)screenSize.getHeight();
                screen_width =  (int)screenSize.getWidth();
		//gamepage.setSize(width,height);
                gamepage.setExtendedState(MAXIMIZED_BOTH);
		gamepage.setVisible(true);
		gamepage.setDefaultCloseOperation(EXIT_ON_CLOSE);
            /*    new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RVSG.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };*/
                
            
	}

   public void refreshScreen() {
    timer = new Timer(0, (ActionEvent e) -> {
        if(leftP1)
            b1.xpos -= STEP_SIZE;
        if(upP1)
            b1.ypos -= STEP_SIZE;
        if(downP1) 
            b1.ypos += STEP_SIZE;
        if(rightP1)
            b1.xpos += STEP_SIZE;
        if(leftP2)
            b2.xpos -= STEP_SIZE;
        if(upP2)
            b2.ypos -= STEP_SIZE;
        if(downP2) 
            b2.ypos += STEP_SIZE;
        if(rightP2)
            b2.xpos += STEP_SIZE;
        if(b1.xpos < 5 ) b1.xpos = 5;
        if(b2.xpos < 5 ) b2.xpos = 5;
        if(b1.ypos < 30 ) b1.ypos = 30;
        if(b2.ypos < 30 ) b2.ypos = 30;
        if(b1.xpos + 50 > screen_width ) b1.xpos = screen_width - 50;
        if(b2.xpos + 50 > screen_width ) b2.xpos = screen_width - 50;
        if(b1.ypos + 90 > screen_height ) b1.ypos = screen_height - 90;
        if(b2.ypos + 90 > screen_height ) b2.ypos = screen_height - 90;
        //System.out.println("\t"+upP1);
        //System.out.println(leftP1+":"+downP1+":"+rightP1);
        repaint();
    });
    timer.setRepeats(true);
    // Aprox. 60 FPS
    timer.setDelay(17);
    timer.start();
  }
    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_W)
            upP1 = true;
        if(e.getKeyCode() == KeyEvent.VK_A)
            leftP1 = true;
        if(e.getKeyCode() == KeyEvent.VK_S)
            downP1 = true;
        if(e.getKeyCode() == KeyEvent.VK_D)
            rightP1 = true;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5)
            upP2 = true;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1)
            leftP2 = true;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2)
            downP2 = true;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3)
            rightP2 = true;
    }

     @Override
    public void keyTyped(KeyEvent e) 
    {
      // repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_W)
            upP1 = false;
        if(e.getKeyCode() == KeyEvent.VK_A)
            leftP1 = false;
        if(e.getKeyCode() == KeyEvent.VK_S)
            downP1 = false;
        if(e.getKeyCode() == KeyEvent.VK_D)
            rightP1 = false;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD5)
            upP2 = false;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD1)
            leftP2 = false;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD2)
            downP2 = false;
        if(e.getKeyCode() == KeyEvent.VK_NUMPAD3)
            rightP2 = false;
    }

}
