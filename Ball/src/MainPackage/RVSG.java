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
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class RVSG extends JFrame implements KeyListener
{
    Ball b1;
        RVSG() 
	{
            b1 = new Ball(50, 'R', 50, 50);
            addKeyListener(this);
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
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RVSG.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
	}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            //System.out.println("W pressed");
            b1.ypos -= 5;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            //System.out.println("A pressed");
            b1.xpos -= 5;
        }
        if(e.getKeyCode() == KeyEvent.VK_S)
        {
            //System.out.println("S pressed");
            b1.ypos += 5;
        }
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            //System.out.println("D pressed");
            b1.xpos += 5;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
