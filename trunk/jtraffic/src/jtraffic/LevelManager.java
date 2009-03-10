package jtraffic;

import RushHour.Level;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Beheert de levels
 * @author bloodsplatter
 * @version 2009.03.03
 */
public class LevelManager {
    private static boolean initialized = false;
    private static ArrayList<Level> levels;
    private static String appDir = System.getProperty("user.dir");
    private static final String fileName = "levels.dat";

    /**
     * Laad de level lijst of maakt een lege lijst aan
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void Initialize() throws IOException, ClassNotFoundException
    {
        if (!initialized)
        {
            File bestand = new File(appDir + "\\" + fileName);
            if (!bestand.exists())
            {
                bestand.createNewFile();
                levels = new ArrayList<Level>(3);
                FileOutputStream fos = new FileOutputStream(bestand);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(levels);
                oos.close();
                fos.close();
                initialized = true;
            }
            else
            {
                FileInputStream fis = new FileInputStream(bestand);
                ObjectInputStream ois = new ObjectInputStream(fis);
                levels = (ArrayList<Level>)ois.readObject();
                ois.close();
                fis.close();
                initialized = true;
            }
        }
    }

    /**
     * Sla de levellijst op
     * @throws java.lang.Exception gooit een exception als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void opslaan() throws Exception
    {
        if (!initialized)
            throw new Exception("Klasse is niet geïnitialiseerd");

        File bestand = new File(appDir + "\\" + fileName);
        FileOutputStream fos = new FileOutputStream(bestand);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(oos);
        oos.close();
        fos.close();
    }

    /**
     * Voeg een level toe aan de lijst
     * @param level de level die toegevoegd moet worden
     * @throws java.lang.Exception gooit een exception als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void voegLevelToe(Level level) throws Exception
    {
        if (!initialized)
           throw new Exception("Klasse is niet geïnitialiseerd");

        levels.add(level);
    }

    /**
     * Verwijderd de opgegeven level
     * @param level de level om te verwijderen
     * @throws java.lang.Exception een foutmelding wordt opgegooid als<br/>de klasse nog niet geïnitialiseerd is
     */
    public static void verwijderLevel(Level level) throws Exception
    {
        if (!initialized)
           throw new Exception("Klasse is niet geïnitialiseerd");

        levels.remove(level);
    }
}
