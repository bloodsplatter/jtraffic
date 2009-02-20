/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RushHour;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bloodsplatter
 */
public class LevelTest {

    public LevelTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getNaam method, of class Level.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        Level instance = new Level();
        String expResult = "";
        String result = instance.getNaam();

        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("getNaam returned:" + result);
        }
    }

    /**
     * Test of setNaam method, of class Level.
     */
    @Test
    public void testSetNaam() {
        System.out.println("setNaam");
        String naam = "";
        Level instance = new Level();
        instance.setNaam(naam);
    }

    /**
     * Test of toString method, of class Level.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Level instance = new Level();
        String expResult = "";
        String result = instance.toString();
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("toString returned " + result);
        }
    }

    /**
     * Test of voertuigOpPlaats method, of class Level.
     */
    @Test
    public void testVoertuigOpPlaats() {
        System.out.println("voertuigOpPlaats");
        int plaats = 0;
        Level instance = new Level();
        Auto expResult = new Auto(0,0);
        instance.voegVoertuigToe(expResult);
        Auto result = (Auto)instance.voertuigOpPlaats(plaats);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Test failed");
        }
    }

    /**
     * Test of voertuigOpPositie method, of class Level.
     */
    @Test
    public void testVoertuigOpPositie() {
        System.out.println("voertuigOpPositie");
        int X = 0;
        int Y = 1;
        Level instance = new Level();
        Auto expResult = new Auto(0,0);
        expResult.setOrientatie(Orientatie.Verticaal);
        instance.voegVoertuigToe(expResult);
        Auto result = (Auto)instance.voertuigOpPositie(X, Y);
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("voertuigOpPositie failed");
        }
    }

}