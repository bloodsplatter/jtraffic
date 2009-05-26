package RushHour;

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
 * @version 2009.04.27
 */
public class LevelManager {
    private ArrayList<Level> levels;
    private static LevelManager _instance = null;

    /**
     * Constructor
     */
    protected LevelManager()
    {
        this.levels = new ArrayList<Level>();
        File dat = new File("levels.dat");
        if (dat.exists())
        {
            try {
                FileInputStream fis = new FileInputStream(dat);
                ObjectInputStream ois = new ObjectInputStream(fis);
                levels = (ArrayList<Level>)ois.readObject();
                ois.close();
                fis.close();
            } catch (ClassNotFoundException cnfe)
            {
                // they tampered with the data
            } catch (Exception ex)
            {
                // should not happen
            }
        }
    }

    /**
     * Maakt een instance aan
     */
    private static void createInstance()
    {
        if (_instance == null) _instance = new LevelManager();
    }

    /**
     * Geeft de instance van LevelManager
     * @return de LevelManager instance
     */
    public static LevelManager getInstance()
    {
        if (_instance == null)
            createInstance();

        return _instance;
    }

    /**
     * Geeft het aantal levels terug
     * @return het aantal levels
     */
    public int aantalLevels()
    {
        return levels.size();
    }

    /**
     * Geeft een array met de levels
     * @return een array met de levels
     */
    public Level[] toArray()
    {
        Level[] lvls = new Level[levels.size()];
        levels.toArray(lvls);
        return lvls;
    }

    /**
     * Voeg een level toe
     * @param lvl de level om toe te voegen
     */
    public void voegLevelToe(Level lvl)
    {
        if (lvl.getNaam().equals(""))
        {
            lvl.setNaam("Level " + levels.size());
        }
        levels.add(lvl);
    }

    /**
     * Geeft de level op een bepaalde index
     * @param index de index van de level
     * @return null als de index niet bestaat, anders de level op die index
     */
    public Level levelOpIndex(int index)
    {
        if (index >= 0 && index < levels.size())
            return levels.get(index);
        else
            return null;
    }


    /**
     * Sla de levels op
     */
    public void opslaan()
    {
        File dat = new File("levels.dat");
        try
        {
            if (!dat.exists())
                dat.createNewFile();

            FileOutputStream fos = new FileOutputStream(dat);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(levels);
            oos.close();
            fos.close();
        } catch (IOException ioe)
        {
            // kan niet gebeuren
        }
    }
}
