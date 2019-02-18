package General;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JFrame with buttons and JPanel canvas
 * Moving mouse over canvas will draw things
 * May include timer to update Canvas data and call repaint (if there are objects
 * moving automatically)
 */
public class GUI extends JFrame implements ActionListener, MouseMotionListener, KeyListener
{
    //declare instance variables
    //including declarations of Canvas, JPanels, JButtons, etc.
    JPanel pane;
    Canvas canvas;




    final int TIMER_DELAY = 25;
    Timer t;




    //constructor creates all user interface objects and places them,
    //using appropriate layoutmanagers
    public GUI(){

        pane = new JPanel(new BorderLayout());
        canvas = new Canvas();
        pane.add(canvas, BorderLayout.CENTER);


        addMouseMotionListener(this);
        add(canvas);
        this.addKeyListener(this);
        t = new Timer(TIMER_DELAY ,this);
        t.setActionCommand("timerFired");
        t.start();

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    //along with any other needed methods, write actionPerformed, and mouseMoved and mouseDragged methods
    //some will call update and repaint on the Canvas object

    @Override
    public void mouseDragged(MouseEvent e) {


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("timerFired"))
        {

            canvas.update();
            canvas.repaint();
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.equals(KeyEvent.VK_K)){


        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
