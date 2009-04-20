package jtraffic;

import RushHour.Level;
import RushHour.Voertuig;
import RushHour.Beweging;
import RushHour.HighScoreRecord;
import RushHour.HighScores;
import java.util.logging.Logger;
import java.util.regex.*;

/**
 * Een controller voor de speelveld klasse
 * @author bloodsplatter
 * @version 2009.04.20
 */
public class LevelController {

    private Level level;
    private int stappen = 0;
    private final Pattern menuPattern = Pattern.compile("^:\\[mM\\]$");
    private final Pattern colorPattern = Pattern.compile("^\\[a-zA-Z\\]$");
    private final Pattern directionPattern = Pattern.compile("^\\+\\[uUdDlLrR\\]$");

    /**
     * Constructor
     * @param level de level die bij de controller hoort
     */
    public LevelController(Level level) {
        this.level = level;
    }


    /**
     * Verplaats het voertuig van een bepaalde kleur in de opgegeven richting.
     * @param kleur de kleur van het voertuig
     * @param beweging de richting waar het voertuig in moet bewegen
     * @return true als de beweging gelukt is, anders false
     */
    public boolean verplaatsVoertuig(char kleur, Beweging beweging)
    {
        Voertuig voertuig = level.voertuigMetKleur(kleur);
        if (voertuig != null)
        {
            if (beweging == Beweging.Links)
            {
                voertuig.NaarLinks();
                return true;
            }

            if (beweging == Beweging.Rechts)
            {
                voertuig.NaarRechts();
                return true;
            }

            if (beweging == Beweging.NaarBeneden)
            {
                voertuig.NaarBeneden();
                return true;
            }

            if (beweging == Beweging.NaarBoven)
            {
                voertuig.NaarBeneden();
                return true;
            }

            return false;
        } else
            return false;
    }

    /**
     * Drukt de level af in het consolescherm
     */
    public void printLevel()
    {
        System.out.println(level.toString());
    }


    /**
     * Handelt gebruikersinteractie af
     */
    public void gebruikersInteractie()
    {
        System.out.println("Geef u invoer in (kleur+u,d,l,r of :m voor menu):");
        String input = System.console().readLine();

        // open menu
        if (menuPattern.matcher(input).find(0))
        {
            InGameMenu menu = new InGameMenu();
            menu.toon();
        } else 
        if (colorPattern.matcher(input).find(0))
        {
            Voertuig voertuig = level.voertuigMetKleur((char)input.charAt(0));
            if (voertuig != null)
            {
                if ( directionPattern.matcher(input).find(1))
                {
                    int location = directionPattern.matcher(input).start() + 1;
                    char direction = input.charAt(location);
                    if (direction == 'u')
                        stappen += voertuig.NaarBoven()?1:0;
                    if (direction == 'd')
                        stappen += voertuig.NaarBeneden()?1:0;
                    if (direction == 'r')
                        stappen += voertuig.NaarRechts()?1:0;
                    if (direction == 'l')
                        stappen += voertuig.NaarLinks()?1:0;

                    if (isLevelUit())
                    {
                        System.out.println(String.format("Uw score:%1$d", stappen));
                        System.out.print("\nNaam: ");
                        String naam = System.console().readLine();
                        try {
                            HighScores.voegHighScoreToe(naam, level, stappen);
                        } catch (Exception ex) {
                            Logger.getLogger(LevelController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else
            System.out.println("Geen geldige invoer.");
    }

    /**
     * Controleert oft het eerste voertuig de uitgang bereikt heeft
     * @return true als de level uitgespeeld is, anders false
     */
    private boolean isLevelUit()
    {
        return (level.voertuigOpPlaats(0).getY() < 0 && level.voertuigOpPlaats(0).getX() == (level.getVeld().getHoogte() / 2) ) ;
    }

    /**
     * The in-game menu
     */
    private class InGameMenu extends Menu
    {

        public InGameMenu() {
            super("Pauze");


            voegItemToe(new MenuItem("Terug naar spel", false) {

                @Override
                public void doAction() {
                    return;
                }
            });
            // Afsluiten
            voegItemToe(new MenuItem("Afsluiten",true){

                @Override
                public void doAction() {
                    System.out.println(this.toString());
                }
            });
        }

    }

}
