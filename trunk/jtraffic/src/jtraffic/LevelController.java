package jtraffic;

import RushHour.Level;
import RushHour.Voertuig;
import RushHour.Beweging;
import java.util.regex.*;

/**
 * Een controller voor de speelveld klasse
 * @author bloodsplatter
 * @version 2009.04.20
 */
public class LevelController {

    private Level level;
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
        }
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
                        voertuig.NaarBoven();
                    if (direction == 'd')
                        voertuig.NaarBeneden();
                    if (direction == 'r')
                        voertuig.NaarRechts();
                    if (direction == 'l')
                        voertuig.NaarLinks();
                }
            }
        } else
            System.out.println("Geen geldige invoer.");
    }

    /**
     * The in-game menu
     */
    private class InGameMenu extends Menu
    {

        public InGameMenu() {
            super("Pauze");

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
