
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
        splvld.setBreedte(6);
        splvld.setHoogte(6);
        lvl.setVeld(splvld);



        Auto vrt2 = new Auto(Orientatie.Horizontaal);
        vrt2.setX(1);
        vrt2.setY(2);
        vrt2.setKleur('X');
        lvl.voegVoertuigToe(vrt2);

        Auto vrt3 = new Auto(Orientatie.Horizontaal);
        vrt3.setX(0);
        vrt3.setY(0);
        vrt3.setKleur('A');
        lvl.voegVoertuigToe(vrt3);

        Vrachtwagen vrt1 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt1.setX(0);
        vrt1.setY(1);
        vrt1.setKleur('B');
        lvl.voegVoertuigToe(vrt1);

        Auto vrt4 = new Auto(Orientatie.Verticaal);
        vrt4.setX(0);
        vrt4.setY(4);
        vrt4.setKleur('C');
        lvl.voegVoertuigToe(vrt4);

        Auto vrt5 = new Auto(Orientatie.Horizontaal);
        vrt5.setX(4);
        vrt5.setY(4);
        vrt5.setKleur('D');
        lvl.voegVoertuigToe(vrt5);

        Vrachtwagen vrt6 = new Vrachtwagen(Orientatie.Horizontaal);
        vrt6.setX(2);
        vrt6.setY(5);
        vrt6.setKleur('E');
        lvl.voegVoertuigToe(vrt6);

        Vrachtwagen vrt7 = new Vrachtwagen(Orientatie.Verticaal);
        vrt7.setX(3);
        vrt7.setY(1);
        vrt7.setKleur('F');
        lvl.voegVoertuigToe(vrt7);

        Vrachtwagen vrt8 = new Vrachtwagen(Orientatie.Verticaal);
        vrt8.setX(5);
        vrt8.setY(0);
        vrt8.setKleur('G');
        lvl.voegVoertuigToe(vrt8);


        lvl.maakSnapshot();

        System.out.println(lvl.toString());
        System.in.read();
        System.out.println(lvl.toString());
        Ai ai = new Ai(lvl);
        ai.run();

        lvl.reset();
        System.out.println(lvl.toString());
    }
}
