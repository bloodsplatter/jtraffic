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
     * Test of printLevel method, of class LevelController.
     */
    @Test
    public void testPrintLevel() {
    }

    /**
     * Test of gebruikersInteractie method, of class LevelController.
     */
    @Test
    public void testGebruikersInteractie() {
    }

}