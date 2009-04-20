/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtraffic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bloodsplatter
 */
public class MenuItemTest {

    public MenuItemTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getNaam method, of class MenuItem.
     */
    @Test
    public void testGetNaam() {
        System.out.println("getNaam");
        MenuItem instance = new MenuItem("Click action",false) {

            @Override
            public void doAction() {
                System.out.println("An action ocurred.");
            }
        };
        String expResult = "Click action";
        String result = instance.getNaam();
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
    }

    /**
     * Test of toString method, of class MenuItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MenuItem instance = new MenuItem("testnaam",false) {

            @Override
            public void doAction() {
                return;
            }
        };
        instance.setNaam("testnaam");
        String expResult = "testnaam";
        String result = instance.toString();
        try {
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("Test failed");
        }
    }

}