
package jtraffic;

import RushHour.Level;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bloodsplatter
 */
public class HighScoresTest {

    public HighScoresTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of Initialize method, of class HighScores.
     */
    @Test
    public void testInitialize() throws Exception {
        System.out.println("Initialize");
        HighScores.Initialize();
        HighScores.verwijderAlleHighScores();
        if(!HighScores.isInitialized())
        {
            fail("Initialization failed");
        }
    }

    /**
     * Test of voegHighScoreToe method, of class HighScores.
     */
    @Test
    public void testVoegHighScoreToe_HighScoreRecord() throws Exception {
        System.out.println("voegHighScoreToe");
        HighScoreRecord hsr = new HighScoreRecord(10, "Testlevel", "Jonas");
        HighScores.Initialize();
        HighScores.verwijderAlleHighScores();
        HighScores.voegHighScoreToe(hsr);
        try {
            assertEquals(hsr, HighScores.highScoreOpNummer(0));
        } catch (Exception e) {
            fail("Test failed.");
        }
    }

    /**
     * Test of verwijderHighScore method, of class HighScores.
     */
    @Test
    public void testVerwijderHighScore() throws Exception {
        System.out.println("verwijderHighScore");
        HighScoreRecord hsr = new HighScoreRecord(10, "Testlevel", "Jonas");
        HighScores.Initialize();
        HighScores.verwijderAlleHighScores();
        HighScores.voegHighScoreToe(hsr);

        try {
            HighScores.verwijderHighScore(hsr);
        } catch (Exception exception) {
            fail("Test failed.");
        }
        
    }

    /**
     * Test of voegHighScoreToe method, of class HighScores.
     */
    @Test
    public void testVoegHighScoreToe_3args() throws Exception {
        System.out.println("voegHighScoreToe");
        HighScores.Initialize();
        HighScores.verwijderAlleHighScores();
        String playerNaam = "Jonas";
        Level level = new Level();
        int score = 5;
        HighScores.voegHighScoreToe(playerNaam, level, score);
        HighScoreRecord hsr = HighScores.highScoreOpNummer(0);
        if (!(hsr.getSpelernaam().equals(playerNaam) && hsr.getSteps() == score))
        {
            fail("Spelernaam: "+hsr.getSpelernaam() + " Score: " + String.valueOf(hsr.getSteps()));
        }
    }

    /**
     * Test of opslaan method, of class HighScores.
     */
    @Test
    public void testOpslaan() throws Exception {
        System.out.println("opslaan");
        HighScores.Initialize();
        HighScores.verwijderAlleHighScores();

        try {
            HighScores.opslaan();
        } catch (Exception exception) {
            fail("Could not save high scores.");
        }
    }
}