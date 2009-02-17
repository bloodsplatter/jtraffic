/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtraffic;
import RushHour.*;

/**
 *
 * @author bloodsplatter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Level lvl = new Level();

        Speelveld splvld = new Speelveld();
        splvld.setBreedte(7);
        splvld.setHoogte(7);
        lvl.setVeld(splvld);



        Vrachtwagen vrt2 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt2.setX(4);
        vrt2.setY(3);
        lvl.voegVoertuigToe(vrt2);

        Auto vrt1 = new Auto(Orientatie.Verticaal);
        vrt1.setX(0);
        vrt1.setY(2);
        lvl.voegVoertuigToe(vrt1);

        lvl.Print();
        Ai ai = new Ai(lvl);
        ai.run();
        lvl.Print();
    }
}
