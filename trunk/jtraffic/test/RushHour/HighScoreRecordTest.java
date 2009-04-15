/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RushHour;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bloodsplatter
 */
public class HighScoreRecordTest {

    public HighScoreRecordTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of toString method, of class HighScoreRecord.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        HighScoreRecord instance = new HighScoreRecord(5, "Testlevel", "Jonas");
        String expResult = "   5 Testlevel Jonas";
        String result = instance.toString();
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Exception: " + e.toString()+ "\nReturn value:"+result);
        }
        
    }

    /**
     * Test of compareTo method, of class HighScoreRecord.
     */
    @Test
    public void testCompareTo()
    {
        System.out.println("compareTo");
        ArrayList<HighScoreRecord> highScores = new ArrayList<HighScoreRecord>(2);
        HighScoreRecord instance = new HighScoreRecord(5, "Testlevel", "Jonas");
        HighScoreRecord secondInstance = new HighScoreRecord(10, "Testlevel", "Jonas");
        highScores.add(instance);
        highScores.add(secondInstance);

        Collections.sort(highScores);
        HighScoreRecord compareTo = highScores.get(0);
        try {
            assertEquals(compareTo,instance);
        } catch (Exception e)
        {
            fail("Exception: " + e.toString() + "\nReturn value:\n"+compareTo.toString());
        }
    }
}