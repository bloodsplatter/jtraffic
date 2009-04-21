/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RushHour;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bloodsplatter
 */
public class LevelManagerTest {

    public LevelManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        LevelManager.Initialize();
        LevelManager.verwijderAlleLevels();
        
        // creëer een level als er geen is
        if (LevelManager.aantalLevels() == 0)
        {
            Level level = new Level();
            level.setNaam("Testlevel");
            level.setVeld(new Speelveld(6, 12));
            Auto auto = new Auto(3, 6, 'R');
            Vrachtwagen vrachtwagen = new Vrachtwagen(0, 0, 'G');
            vrachtwagen.setOrientatie(Orientatie.Verticaal);
            level.voegVoertuigToe(auto);
            level.voegVoertuigToe(vrachtwagen);
            LevelManager.voegLevelToe(level);
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        LevelManager.opslaan();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAantalLevels()
    {
        System.out.println(String.format("Aantal levels: %1$d", LevelManager.aantalLevels()));
    }

    @Test
    public void testToArray()
    {
        Level[] levels = LevelManager.toArray();
        for (Level level : levels) {
            System.out.println(level.getNaam());
        }
    }

    
}