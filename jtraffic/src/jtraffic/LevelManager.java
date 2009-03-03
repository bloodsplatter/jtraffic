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
 */
public class LevelManager {
    private static boolean initialized = false;
    private static ArrayList<Level> levels;
    private static String appDir = System.getProperty("user.dir");
    private static final String fileName = "levels.dat";

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

    public static void Save() throws Exception
    {
        if (!initialized)
            throw new Exception("Class is not initialized");

        File bestand = new File(appDir + "\\" + fileName);
        FileOutputStream fos = new FileOutputStream(bestand);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(oos);
        oos.close();
        fos.close();
    }
}
