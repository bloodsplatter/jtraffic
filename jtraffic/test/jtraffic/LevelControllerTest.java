/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtraffic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import RushHour.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bloodsplatter
 */
public class LevelControllerTest {

    private static Level level;
    public LevelControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        level = new Level();
        level.setVeld(new Speelveld(12, 6));
        level.voegVoertuigToe(new Auto(3, 3, 'R'));
        level.voegVoertuigToe(new Vrachtwagen(0, 0, 'G'));
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of verplaatsVoertuig method, of class LevelController.
     */
    @Test
    public void testVerplaatsVoertuig() {
        LevelController lc = new LevelController(level);
        lc.verplaatsVoertuig('R', Beweging.Links);
        if (level.voertuigMetKleur('R').getX() != 2)
            fail(String.format("Positie (%1$d,%2$d)", level.voertuigMetKleur('R').getX(),level.voertuigMetKleur('R').getY()));
    }

    /**
     * Test of gebruikersInteractie method, of class LevelController.
     */
    @Test
    public void testGebruikersInteractie() {
        System.out.print("gebruikersInteractie ");
        Pattern dirPat = Pattern.compile("^[a-z]\\+[udlr]$", Pattern.CASE_INSENSITIVE);
        System.out.println(dirPat.toString());
        Matcher matcher = dirPat.matcher("g+u");

        if (!matcher.find())
            fail("RegEx did not match.");
    }

}