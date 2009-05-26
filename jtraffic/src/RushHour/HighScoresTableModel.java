
package RushHour;

import java.util.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

/**
 * Het JTable model voor de view
 * @author bloodsplatter
 * @version 2009.05.11
 */
public class HighScoresTableModel implements TableModel {
    /**
     * De namen van de kolommen
     */
    protected final String[] columnNames = {"Aantal stappen","Spelernaam","Levelnaam"};

    /**
     * Constructor
     */
    public HighScoresTableModel()
    {
        
    }

    public int getRowCount() {
        return HighScores.getInstance().aantalHighScoreRecords();
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex >= 0 && columnIndex < columnNames.length)
            return columnNames[columnIndex];
        else
            return "";
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex)
        {
            case 0:
                return new Integer(0).getClass();
            default:
                return "".getClass();
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && columnIndex >= 0 && columnIndex < columnNames.length && rowIndex < HighScores.getInstance().aantalHighScoreRecords())
        {
            switch (columnIndex)
            {
                case 0:
                    return HighScores.getInstance().highScoreRecordOpPlaats(rowIndex).getSteps();
                case 1:
                    return HighScores.getInstance().highScoreRecordOpPlaats(rowIndex).getSpelernaam();
                case 2:
                    return HighScores.getInstance().highScoreRecordOpPlaats(rowIndex).getLevelnaam();
                default:
                    return 0;
            }
        } else
            return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        return;
    }

    public void addTableModelListener(TableModelListener l) {
        
    }

    public void removeTableModelListener(TableModelListener l) {
        
    }

}
