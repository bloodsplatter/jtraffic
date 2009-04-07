/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RushHour;

import RushHour.HighScoreRecord;
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
        String expResult = "|   5|Testlevel|Jonas|";
        String result = instance.toString();
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Exception: " + e.toString()+ "\nReturn value:"+result);
        }
        
    }

}