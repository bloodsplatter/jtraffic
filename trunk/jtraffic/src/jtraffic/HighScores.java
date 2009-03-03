
package jtraffic;

import RushHour.Level;
import java.util.ArrayList;
import java.io.*;

/**
 * Beheerd de high scores
 * @author bloodsplatter
 */
public class HighScores {
    private static String appDir = System.getProperty("user.dir");
    private static ArrayList<HighScoreRecord> highScoreTable;
    private final static String fileName = "highscores.dat";
    private static boolean initialized = false;

    /**
     * Initialiseerd de High Scores
     * @throws java.io.IOException
     * @throws ClassNotFoundException
     */
    public static void Initialize() throws IOException, ClassNotFoundException
    {
        if (!initialized)
        {
            File bestand = new File(appDir + "\\" + fileName);
            if (!bestand.exists())
            {
                bestand.createNewFile();
                highScoreTable = new ArrayList<HighScoreRecord>(1);
                FileOutputStream fos = new FileOutputStream(bestand);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(highScoreTable);
                oos.close();
                fos.close();
                initialized = true;
            }
            else
            {
                FileInputStream fis = new FileInputStream(bestand);
                ObjectInputStream ois = new ObjectInputStream(fis);
                highScoreTable = (ArrayList<HighScoreRecord>)ois.readObject();
                ois.close();
                fis.close();
                initialized = true;
            }
        }
    }

    
    /**
     * Voegt een high score toe aan de tabel
     * @param hsr de high score om toe te voegen
     * @throws java.lang.Exception
     */
    public static void voegHighScoreToe(HighScoreRecord hsr) throws Exception
    {
        if(!initialized)
            throw new Exception("Class must be initialised first");

        highScoreTable.add(hsr);
    }


    /**
     * Voegt een high score toe aan de tabel
     * @param playerNaam naam van de speler die de score behaalde
     * @param level de level waar de score behaald is
     * @param score de score die behaald is
     * @throws java.lang.Exception
     */
    public static void voegHighScoreToe(String playerNaam, Level level,int score) throws Exception
    {
        HighScoreRecord hsr = new HighScoreRecord(score, level.getNaam(), playerNaam);
        voegHighScoreToe(hsr);
    }


    /**
     * Slaagt de high scores op
     * @throws java.io.IOException
     * @throws java.lang.Exception een exception wordt gegooid als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void opslaan() throws IOException, Exception
    {
        if (!initialized)
            throw new Exception("Class must be initialised first");

        File bestand = new File(appDir + "\\" + fileName);
        FileOutputStream fos = new FileOutputStream(bestand);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(highScoreTable);
        oos.close();
        fos.close();
    }
}
