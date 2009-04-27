package RushHour;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Beheerd de high scores
 * @author bloodsplatter
 * @version 2009.04.27
 */
public class HighScores {
    private static HighScores _instance = null;
    private ArrayList<HighScoreRecord> highScores;

    /**
     * Constructor
     */
    private HighScores ()
    {
        this.highScores = new ArrayList<HighScoreRecord>();
        File dat = new File("highscores.dat");
        if (!dat.exists())
        {
            try {
                dat.createNewFile();
            } catch (IOException ioex)
            {
                // TODO could not create empty file
            }
        } else
        {
            try
            {
                FileInputStream fis = new FileInputStream(dat);
                ObjectInputStream ois = new ObjectInputStream(fis);
                highScores = (ArrayList<HighScoreRecord>)ois.readObject();
            } catch (FileNotFoundException fnfe)
            {
                // should not happen
            } catch (IOException ioe)
            {
                // also should not happen
            } catch (ClassNotFoundException cnfe)
            {
                // they fucked up the binary data
            }
        }
    }

    /**
     * Maakt een instance aan
     */
    private synchronized static void createInstance()
    {
        if (_instance == null) _instance = new HighScores();
    }

    /**
     * Geeft een instantie van de klasse
     * @return de instantie van de klasse
     */
    public static HighScores getInstance()
    {
        if (_instance == null)
            createInstance();
        
        return _instance;
    }

    /**
     * Verwijder de highscores uit de lijst
     */
    public void verwijderHighScores()
    {
        highScores.clear();
    }

    /**
     * Voegt een HighScoreRecord toe
     * @param hsr het HighScoreRecord om toe te voegen
     * @see RushHour.HighScoreRecord
     */
    public void voegHighScoreToe(HighScoreRecord hsr)
    {
        if (highScores.size() >= 10)
        {
            Collections.sort(highScores);
            Iterator<HighScoreRecord> itr = highScores.iterator();
            while (itr.hasNext())
            {
                HighScoreRecord tmp = itr.next();
                if (tmp.getSteps() < hsr.getSteps())
                {
                    int index = highScores.indexOf(tmp);
                    highScores.remove(tmp);
                    highScores.add(index, hsr);
                    break;
                }
            }
        } else
        {
            highScores.add(hsr);
        }
    }

    /**
     * Voegt een HighScoreRecord toe op basis van level en spelernaam
     * @param level de level waar de highscore is behaalt
     * @param spelernaam de naam van de speler die de highscore behaalde
     */
    public void voegHighScoreToe(Level level, String spelernaam)
    {
        HighScoreRecord hsr = new HighScoreRecord(level.getAantalStappen(), level.getNaam(), spelernaam);
        this.voegHighScoreToe(hsr);
    }

    /**
     * Maak een array met alle HighScoreRecords
     * @return een array met alle HighScoreRecords
     */
    public HighScoreRecord[] toArray()
    {
        HighScoreRecord[] hsrs = new HighScoreRecord[highScores.size()];
        highScores.toArray(hsrs);
        return hsrs;
    }

    /**
     * Sla de highscores op
     */
    public void opslaan() throws FileNotFoundException, IOException
    {
        File dat = new File("highscores.dat");
        FileOutputStream fos = new FileOutputStream(dat);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(highScores);
        oos.close();
        fos.close();
    }

    /**
     * Geeft het aantal HighScoreRecords
     * @return het aantal HighScoreRecords
     */
    public int aantalHighScoreRecords()
    {
        return highScores.size();
    }
}
