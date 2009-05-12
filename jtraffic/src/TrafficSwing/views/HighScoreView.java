package TrafficSwing.views;

import javax.swing.*;
import RushHour.*;
import TrafficSwing.Application;
import java.awt.*;
import java.awt.event.*;

/**
 * De viewklasse voor de high scores
 * @author bloodsplatter
 * @version 2009.05.12
 */
public class HighScoreView extends SideView {
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
        super(new BorderLayout());
        frame.setTitle("High Scores");
        initTable();

        bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        okButton = new JButton("OK");
        bottomPane.add(okButton);

        super.add(bottomPane,BorderLayout.SOUTH);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    protected void initTable()
    {
        hstm = new HighScoresTableModel();
        tabel = new JTable(hstm);
        tabel.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabel);
        super.add(scrollPane,BorderLayout.CENTER);
    }

    @Override
    public boolean kanSluiten() {
        return super.kanSluiten();
    }
}
