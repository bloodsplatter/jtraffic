package TrafficSwing;

import java.awt.*;
import java.awt.event.*;
import RushHour.*;
import TrafficSwing.views.*;
import java.io.IOException;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * The main Swing Application
 * @author bloodsplatter
 * @version 2009.05.15
 */
public class Application extends JFrame {

    /**
     *
     */
    protected static Application _instance = null;
    /**
     *
     */
    protected JMenuBar mainMenuBar;
    /**
     *
     */
    protected HighScoreView hsv;

    /**
     * Constructor
     */
    protected Application() {
        super("TrafficSwing");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initMenuBar();
        super.getContentPane().add(DEFAULT_PANEL());
        hsv = new HighScoreView();
        debug();
        super.setPreferredSize(new Dimension(800, 600));
        pack();

        super.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                Container c = getContentPane();
                if (c instanceof LevelView) {
                    if (((LevelView) c).sluit()) {
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    } else {
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }

                }
                try {
                    HighScores.getInstance().opslaan();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Application.getInstance(), "Er is een fout opgetreden bij het opslaan van de highscores.\n" + ex.getLocalizedMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
                }
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    /**
     *
     */
    protected void debug() {
        Level lvl = new Level();
        Auto beginAuto = new Auto(0, 2, Kleur.Rood);
        beginAuto.setOrientatie(Orientatie.Horizontaal);
        Auto tweedeAuto = new Auto(2, 0, Kleur.Blauw);
        tweedeAuto.setOrientatie(Orientatie.Verticaal);
        Vrachtwagen vw = new Vrachtwagen(Orientatie.Verticaal);
        vw.setPositie(3, 1);
        vw.setKleur(Kleur.DonkerGroen);
        lvl.voegVoertuigToe(beginAuto);
        lvl.voegVoertuigToe(vw);
        lvl.voegVoertuigToe(tweedeAuto);
        LevelManager.getInstance().voegLevelToe(lvl);
    }

    /**
     *
     */
    protected void initMenuBar() {
        mainMenuBar = new JMenuBar();

    }

    /**
     *
     * @return
     */
    protected JPanel DEFAULT_PANEL() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel menuPanel = new JPanel(new GridLayout(3, 0));

        JButton newGame = new JButton("Nieuw Spel");
        newGame.setFont(new Font("Arial", Font.BOLD, 36));
        newGame.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String[] levelNames = new String[LevelManager.getInstance().aantalLevels()];
                Level[] levels = LevelManager.getInstance().toArray();

                if (levels.length <= 0) {
                    JOptionPane.showMessageDialog(Application.getInstance(), "Er zijn geen levels geladen.", "Fout", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (int i = 0; i < levels.length; i++) {
                    levelNames[i] = levels[i].getNaam();
                }

                String selectedLevel = null;

                selectedLevel = (String) JOptionPane.showInputDialog(Application.getInstance(), "Kies een level", "Levelselectie", JOptionPane.INFORMATION_MESSAGE, null, levelNames, levelNames[0]);
                if (selectedLevel == null || selectedLevel.equals(""))
                    return;

                for (Level level : levels) {
                    if (level.getNaam().equals(selectedLevel));
                    {
                        setView(new LevelView(level));
                        // Simulate ai ?
                        
                        break;
                    }
                }
            }
        });
        menuPanel.add(newGame);

        JButton highScores = new JButton("High Scores");
        highScores.setFont(new Font("Arial", Font.BOLD, 36));
        highScores.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Application.getInstance().toonHighScores();
            }
        });
        menuPanel.add(highScores);


        // AI experimenteel add on
        JButton SimulateAi = new JButton("AI Simulatie");
        SimulateAi.setFont(new Font("Arial", Font.BOLD, 36));
        SimulateAi.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String[] levelNames = new String[LevelManager.getInstance().aantalLevels()];
                Level[] levels = LevelManager.getInstance().toArray();

                if (levels.length <= 0) {
                    JOptionPane.showMessageDialog(Application.getInstance(), "Er zijn geen levels geladen.", "Fout", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (int i = 0; i < levels.length; i++) {
                    levelNames[i] = levels[i].getNaam();
                }

                String selectedLevel = null;

                selectedLevel = (String) JOptionPane.showInputDialog(Application.getInstance(), "Kies een level", "Levelselectie", JOptionPane.INFORMATION_MESSAGE, null, levelNames, levelNames[0]);
                if (selectedLevel == null || selectedLevel.equals(""))
                    return;

                for (Level level : levels) {
                    if (level.getNaam().equals(selectedLevel));
                    {
                        LevelView gamevw = new LevelView(level);
                        setView(gamevw);
                        //gamevw.updateUI();

                        Ai simulateai = new Ai(gamevw);

                        new Thread(simulateai).start();

                        break;
                    }
                }
            }
        });
        menuPanel.add(SimulateAi);
        
        panel.add(menuPanel, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creëert een instance als deze nog niet bestaat
     */
    protected static void createInstance() {
        if (_instance == null) {
            _instance = new Application();
        }
    }

    /**
     * Geeft de huidige level
     * @return geeft de huidige level terug
     * @exception UnsupportedOperationException
     */
    public Level getHuidigeLevel() throws UnsupportedOperationException {
        if (super.getContentPane() instanceof LevelView) {
            return ((LevelView) super.getContentPane()).getLevel();
        } else {
            throw new UnsupportedOperationException("Er draait nu geen level");
        }
    }

    /**
     * De Application instance opvragen
     * @return de Application instance
     */
    public static Application getInstance() {
        if (_instance == null) {
            createInstance();
        }

        return _instance;
    }

    /**
     * Stel een view in
     * @param view de view om te tonen
     */
    public void setView(View view) {
        Component cp = super.getContentPane();
        if (cp instanceof View) {

            View v = (View) cp;
            if (view.sluit()) {
                getContentPane().removeAll();
                super.setContentPane(view);
                view.updateUI();
                pack();
            } else {
                JOptionPane.showMessageDialog(this, "Deze optie is nu niet beschikbaar.", "Fout!", JOptionPane.ERROR_MESSAGE);
            }
        } else if (cp instanceof JPanel) {
            super.setContentPane(view);
            view.updateUI();
            if (view instanceof LevelView) {
                super.setPreferredSize(calculateSize(new Dimension(LevelView.BORD_BREEDTE, LevelView.BORD_HOOGTE)));
                super.setMinimumSize(super.getPreferredSize());
            }

            pack();
        }
    }

    /**
     * Toon het standaard panel
     */
    public void setDefaultPanel() {
        if (getContentPane() instanceof View) {
            View v = (View) getContentPane();
            if (v.sluit()) {
                getContentPane().removeAll();
                setContentPane(DEFAULT_PANEL());
            } else {
                JOptionPane.showMessageDialog(this, "Kan hoofdmenu nu niet tonen.", "Fout", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setContentPane(DEFAULT_PANEL());
        }

        super.setPreferredSize(new Dimension(800, 600));
        pack();
    }

    /**
     * Toont het HighScoreView
     */
    public void toonHighScores() {
        if (!hsv.isVisible()) {
            hsv.setVisible(true);
        }
    }

    private Dimension calculateSize(Dimension d) {
        super.setPreferredSize(d);
        int extrah = super.getContentPane().getSize().height - d.width;
        int extraw = super.getContentPane().getSize().width - d.width;
        d.height += extrah;
        d.width += extraw + 10;
        return d;
    }
}
