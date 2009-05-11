
package TrafficSwing;

import java.awt.*;
import java.awt.event.*;
import RushHour.*;
import TrafficSwing.views.*;
import javax.swing.*;

/**
 * The main Swing Application
 * @author bloodsplatter
 * @version 2009.05.11
 */
public class Application extends JFrame {
    protected static Application app;

    /**
     * Constructor
     */
    public Application()
    {
        super("TrafficSwing");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.getContentPane().add(new HighScoreView());
        pack();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        { }
        app = new Application();
        app.setVisible(true);
    }

    /**
     * Sluit het huidige view
     */
    public void sluitHuidigView()
    {
        super.getContentPane().removeAll();
    }
}
