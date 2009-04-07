package RushHour;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Beheerd de high scores
 * @author bloodsplatter
 * @version 2009.03.03
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
    public static void Initialize() throws IOException, ClassNotFoundException {
        if (!initialized) {
            File bestand = new File(appDir + "\\" + fileName);
            if (!bestand.exists()) {
                bestand.createNewFile();
                highScoreTable = new ArrayList<HighScoreRecord>(1);
                FileOutputStream fos = new FileOutputStream(bestand);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(highScoreTable);
                oos.close();
                fos.close();
                initialized = true;
            } else {
                FileInputStream fis = new FileInputStream(bestand);
                ObjectInputStream ois = new ObjectInputStream(fis);
                highScoreTable = (ArrayList<HighScoreRecord>) ois.readObject();
                ois.close();
                fis.close();
                initialized = true;
            }
        }
    }

    /**
     * Voegt een high score toe aan de tabel
     * @param hsr de high score om toe te voegen
     * @throws java.lang.Exception een foutmelding wordt opgegooid als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void voegHighScoreToe(HighScoreRecord hsr) throws Exception {
        if (!initialized) {
            throw new Exception("Class must be initialised first");
        }

        if (highScoreTable.size() <= 10) {
            highScoreTable.add(hsr);
        } else {
            
            Iterator<HighScoreRecord> hsrIterator = highScoreTable.iterator();
            while (hsrIterator.hasNext()) {
                HighScoreRecord current = hsrIterator.next();
                if (current.getSteps() <= hsr.getSteps()) {
                    highScoreTable.remove(highScoreTable.size() - 1);
                    highScoreTable.add(hsr);
                }
            }
        }
    }

    /**
     * Verwijderd een HighScoreRecord uit de tabel
     * @param hsr de record die verwijderd moet worden
     * @throws java.lang.Exception een foutmelding wordt opgegooid als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void verwijderHighScore(HighScoreRecord hsr) throws Exception {
        if (!initialized) {
            throw new Exception("Class must be initialised first");
        }

        if (highScoreTable.contains(hsr)) {
            highScoreTable.remove(hsr);
        }
    }

    /**
     * Voegt een high score toe aan de tabel
     * @param playerNaam naam van de speler die de score behaalde
     * @param level de level waar de score behaald is
     * @param score de score die behaald is
     * @throws java.lang.Exception een foutmelding wordt opgegooid als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void voegHighScoreToe(String playerNaam, Level level, int score) throws Exception {
        HighScoreRecord hsr = new HighScoreRecord(score, level.getNaam(), playerNaam);
        voegHighScoreToe(hsr);
    }

    /**
     * Slaagt de high scores op
     * @throws java.io.IOException
     * @throws java.lang.Exception een foutmelding wordt opgegooid als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void opslaan() throws IOException, Exception {
        if (!initialized) {
            throw new Exception("Class must be initialised first");
        }

        File bestand = new File(appDir + "\\" + fileName);
        FileOutputStream fos = new FileOutputStream(bestand);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(highScoreTable);
        oos.close();
        fos.close();
    }

    /**
     * Geeft aan of de klasse al geïnitialiseerd is
     * @return true als de klasse geïnitialiseerd is, anders false
     */
    public static boolean isInitialized() {
        return initialized;
    }

    /**
     * Vraagt een record op een plaats op
     * @param plaats de plaats van het record
     * @return null als de klasse nog niet geïnitialiseerd is<br/>of de locatie niet geldig is.<br/>anderes het record
     */
    public static HighScoreRecord highScoreOpNummer(int plaats) {
        if (initialized) {
            if (plaats >= 0 && plaats < highScoreTable.size())
                return highScoreTable.get(plaats);
        }
        return null;
    }

    /**
     * Verwijdert alle highscores
     */
    public static void verwijderAlleHighScores()
    {
        if(initialized)
        {
             highScoreTable = new ArrayList<HighScoreRecord>(10);
        }
    }
}
