
package TrafficSwing;

import java.awt.*;
import java.awt.event.*;
import RushHour.*;
import TrafficSwing.views.*;
import javax.swing.*;
import java.util.*;

/**
 * The main Swing Application
 * @author bloodsplatter
 * @version 2009.05.12
 */
public class Application extends JFrame {
    protected static Application _instance;
    protected JMenuBar mainMenuBar;

    /**
     * Constructor
     */
    protected Application()
    {
        super("TrafficSwing");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenuBar();
        super.getContentPane().add(Application.DEFAULT_PANEL());
        super.setSize(800,600);
    }

    protected void initMenuBar()
    {
        mainMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Bestand");
        mainMenuBar.add(fileMenu);


        fileMenu.add(new JPopupMenu.Separator());
        JMenuItem closeItem = new JMenuItem("Afsluiten...");
        closeItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JMenuItem highScores = new JMenuItem("High Scores");
        mainMenuBar.add(highScores);
        highScores.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new HighScoreView();
            }
        });

        super.setJMenuBar(mainMenuBar);
    }

    protected static JPanel DEFAULT_PANEL()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("Selecteer een optie om te beginnen."));
        return panel;
    }

    protected static void createInstance()
    {
        if (_instance == null)
            _instance = new Application();
    }

    /**
     *
     * @return de Application instance
     */
    public static Application getInstance()
    {
        if (_instance == null)
            createInstance();

        return _instance;
    }
}
