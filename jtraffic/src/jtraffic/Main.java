/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jtraffic;
import RushHour.*;
import java.io.IOException;

/**
 *
 * @author bloodsplatter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
        Level lvl = new Level();

        Speelveld splvld = new Speelveld();
        splvld.setBreedte(8);
        splvld.setHoogte(6);
        lvl.setVeld(splvld);



        Vrachtwagen vrt2 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt2.setX(5);
        vrt2.setY(3);
        vrt2.setKleur('X');
        lvl.voegVoertuigToe(vrt2);

        Vrachtwagen vrt3 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt3.setX(0);
        vrt3.setY(1);
        vrt3.setKleur('A');
        lvl.voegVoertuigToe(vrt3);

        Vrachtwagen vrt1 = new Vrachtwagen(Orientatie.Verticaal);
        vrt1.setX(0);
        vrt1.setY(2);
        vrt1.setKleur('B');
        lvl.voegVoertuigToe(vrt1);

        Auto vrt4 = new Auto(Orientatie.Horizontaal);
        vrt4.setX(0);
        vrt4.setY(0);
        vrt4.setKleur('C');
        lvl.voegVoertuigToe(vrt4);

        Auto vrt5 = new Auto(Orientatie.Horizontaal);
        vrt5.setX(2);
        vrt5.setY(0);
        vrt5.setKleur('D');
        lvl.voegVoertuigToe(vrt5);

        Vrachtwagen vrt6 = new Vrachtwagen(Orientatie.Verticaal);
        vrt6.setX(3);
        vrt6.setY(1);
        vrt6.setKleur('E');
        lvl.voegVoertuigToe(vrt6);
        
        System.out.println(lvl.toString());
        System.in.read();
        System.out.println(lvl.toString());
        Ai ai = new Ai(lvl);
        ai.run();
        
    }
}
