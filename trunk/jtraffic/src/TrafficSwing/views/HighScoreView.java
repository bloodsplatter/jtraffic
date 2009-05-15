package TrafficSwing.views;

import javax.swing.*;
import RushHour.*;
import TrafficSwing.Application;
import java.awt.*;
import java.awt.event.*;

/**
 * De viewklasse voor de high scores
 * @author bloodsplatter
 * @version 2009.05.14
 */
public class HighScoreView extends JFrame {
    protected HighScoresTableModel hstm;
    protected JTable tabel;
    protected JScrollPane scrollPane;
    protected JPanel bottomPane;
    protected JButton okButton;

    /**
     * Constructor
     */
    public HighScoreView()
    {
        super("High Scores");
        super.setLayout(new BorderLayout());
        initTable();

        bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            }
        });
        bottomPane.add(okButton);

        super.add(bottomPane,BorderLayout.SOUTH);
        debug();
        super.add(scrollPane,BorderLayout.CENTER);
        super.pack();
        super.setVisible(true);
    }

    /**
     * Adds a debug menu to the menubar
     */
    private void debug()
    {
        JMenuBar menuBar;
        if (super.getJMenuBar() == null)
        {
            menuBar = new JMenuBar();
            super.setJMenuBar(menuBar);
        }
        else
            menuBar = super.getJMenuBar();

        JMenu debugMenu = new JMenu("Debug");
        menuBar.add(debugMenu);
        JMenuItem addHighScore = new JMenuItem("Voeg high score toe");
        debugMenu.add(addHighScore);
        addHighScore.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                voegHighScoreToe();
            }
        });
    }

    protected void initTable()
    {
        hstm = new HighScoresTableModel();
        tabel = new JTable(hstm);
        tabel.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabel);
        super.add(scrollPane,BorderLayout.CENTER);
    }

    public void voegHighScoreToe()
    {
        try {
            //Level lvl = Application.getInstance().getHuidigeLevel();
            String gebruikersnaam = null;
            do {
                gebruikersnaam = JOptionPane.showInputDialog(Application.getInstance(), "Geef uw naam in", "Naam speler", JOptionPane.INFORMATION_MESSAGE);
            } while (gebruikersnaam == null);

            HighScoreRecord hsr = new HighScoreRecord("Testlevel", gebruikersnaam);
            hsr.setSteps(5);
            HighScores.getInstance().voegHighScoreToe(hsr);
            scrollPane.updateUI();
        } catch (UnsupportedOperationException uoe)
        {
            JOptionPane.showMessageDialog(Application.getInstance(), uoe.getMessage(), "Fout", JOptionPane.ERROR_MESSAGE);
        }
    }
}
