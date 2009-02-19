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
        splvld.setBreedte(6);
        splvld.setHoogte(5);
        lvl.setVeld(splvld);



        Vrachtwagen vrt2 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt2.setX(3);
        vrt2.setY(2);
        lvl.voegVoertuigToe(vrt2);

        Vrachtwagen vrt3 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt3.setX(0);
        vrt3.setY(1);
        lvl.voegVoertuigToe(vrt3);

        Vrachtwagen vrt1 = new Vrachtwagen(Orientatie.Verticaal);
        vrt1.setX(0);
        vrt1.setY(2);
        lvl.voegVoertuigToe(vrt1);

        Auto vrt4 = new Auto(Orientatie.Horizontaal);
        vrt4.setX(0);
        vrt4.setY(0);
        lvl.voegVoertuigToe(vrt4);

        Auto vrt5 = new Auto(Orientatie.Horizontaal);
        vrt5.setX(2);
        vrt5.setY(0);
        lvl.voegVoertuigToe(vrt5);
        
        lvl.Print();
        Ai ai = new Ai(lvl);
        ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
                ai.run();
        lvl.Print();
        
    }
}
