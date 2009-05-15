
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
 * @version 2009.05.13
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

        JMenuItem startItem = new JMenuItem("Nieuw spel");
        fileMenu.add(startItem);
        startItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Simulatie van een simpele lvl voor debug redenen
                Level lvl = new Level();
                Auto auto1 = new Auto(2, 2,Kleur.Geel);
                auto1.setOrientatie(Orientatie.Horizontaal);
                lvl.voegVoertuigToe(auto1);
                LevelView lvllw = new LevelView(lvl);
            }
        });

        fileMenu.add(new JPopupMenu.Separator());

        JMenuItem closeItem = new JMenuItem("Afsluiten...");
        fileMenu.add(closeItem);
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
     * @return geeft de huidige level terug
     * @exception UnsupportedOperationException
     */
    public Level getHuidigeLevel() throws UnsupportedOperationException
    {
        if (super.getContentPane().getComponent(0) instanceof LevelView)
        {
            return ((LevelView)super.getContentPane().getComponent(0)).getLevel();
        }
        else
            throw new UnsupportedOperationException("Er draait nu geen level");
    }

    /**
     * De Application instance opvragen
     * @return de Application instance
     */
    public static Application getInstance()
    {
        if (_instance == null)
            createInstance();

        return _instance;
    }

    public void setView(View view)
    {
        Component cp = super.getContentPane().getComponent(0);
        if (cp instanceof View)
        {

            View v = (View)cp;
            if (view.sluit())
            {
                super.getContentPane().removeAll();
                super.getContentPane().add(view);
            } else
            {
                JOptionPane.showMessageDialog(this, "Deze optie is nu niet beschikbaar.","Fout!",JOptionPane.ERROR_MESSAGE);
            }
        } else
            throw new UnsupportedOperationException("Er is geen view geladen");
    }
}
