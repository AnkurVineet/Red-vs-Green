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
    Ball b1;
    Timer timer;
    int STEP_SIZE = 3;
    boolean leftP1=false,rightP1=false,upP1=false,downP1=false;
        RVSG() 
	{
            b1 = new Ball(60, 'R', 50, 50);
            addKeyListener(this);
            refreshScreen();
	}
        @Override
	public void paint(Graphics g)
	{
                super.paint(g);
                g.setColor(Color.red);
		g.fillOval(b1.xpos, b1.ypos, b1.radius, b1.radius);
	}
	public static void main(String[] args)
	{
		RVSG gamepage = new RVSG();
                gamepage.setTitle("RED V/S GREEN");
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = (int)screenSize.getHeight();
                int width =  (int)screenSize.getWidth();
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
        System.out.println("\t"+upP1);
        System.out.println(leftP1+":"+downP1+":"+rightP1);
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
        {
            //System.out.println("W pressed");
            upP1 = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            //System.out.println("A pressed");
            leftP1 = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            //System.out.println("S pressed");
            downP1 = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            //System.out.println("D pressed");
            rightP1 = true;
        }
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
        {
            upP1 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            leftP1 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            downP1 = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            rightP1 = false;
        }
    }

}
