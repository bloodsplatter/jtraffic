package TrafficSwing.views;

import javax.swing.*;
import RushHour.*;
import TrafficSwing.Application;
import java.awt.*;
import java.awt.event.*;

/**
 * De viewklasse voor de high scores
 * @author bloodsplatter
 * @version 2009.05.11
 */
public class HighScoreView extends JPanel {
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
        initTable();

        bottomPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        okButton = new JButton("OK");
        bottomPane.add(okButton);

        super.add(bottomPane,BorderLayout.SOUTH);
    }

    protected void initTable()
    {
        hstm = new HighScoresTableModel();
        tabel = new JTable(hstm);
        tabel.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabel);
        super.add(scrollPane,BorderLayout.CENTER);
    }
}
