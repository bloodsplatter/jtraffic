package jtraffic;

import RushHour.Level;
import RushHour.Voertuig;
import RushHour.Beweging;
import RushHour.HighScores;
import java.util.logging.Logger;
import java.io.*;

/**
 * Een controller voor de speelveld klasse
 * @author bloodsplatter
 * @version 2009.04.21
 */
public class LevelController {

    private Level level;

    /**
     * Constructor
     * @param level de level die bij de controller hoort
     */
    public LevelController(Level level) {
        this.level = level;
        level.zetStappenOpNul();
    }

    /**
     * Verplaats het voertuig van een bepaalde kleur in de opgegeven richting.
     * @param kleur de kleur van het voertuig
     * @param beweging de richting waar het voertuig in moet bewegen
     * @return true als de beweging gelukt is, anders false
     */
    public boolean verplaatsVoertuig(char kleur, Beweging beweging) {
        Voertuig voertuig = level.voertuigMetKleur(kleur);
        if (voertuig != null) {
            if (beweging == Beweging.Links) {
                voertuig.NaarLinks();
                return true;
            }

            if (beweging == Beweging.Rechts) {
                voertuig.NaarRechts();
                return true;
            }

            if (beweging == Beweging.NaarBeneden) {
                voertuig.NaarBeneden();
                return true;
            }

            if (beweging == Beweging.NaarBoven) {
                voertuig.NaarBeneden();
                return true;
            }

            return false;
        } else {
            return false;
        }
    }

    /**
     * Drukt de level af in het consolescherm
     */
    public void printLevel() {
        System.out.println(level.toString());
    }

    /**
     * Handelt gebruikersinteractie af
     */
    public void gebruikersInteractie() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            this.printLevel();
            System.out.println("\nGeef u invoer in (kleur+u,d,l,r of :m voor menu):");
            String input = null;

            try {
                input = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(LevelController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            // open menu
            if (input.startsWith(":m")) {
                InGameMenu menu = new InGameMenu();
                menu.toon();
                if (!menu.isOpen()) {
                    sluitAf(false);
                    break;
                }

            } else if (input.matches("^[a-z]\\+[udlr]$")) {
                Voertuig voertuig = level.voertuigMetKleur((char) input.charAt(0));
                if (voertuig != null) {
                    char direction = input.charAt(2);
                    if (direction == 'u' && voertuig.NaarBoven()) {
                        level.voegStapToe();
                    }
                    if (direction == 'd' && voertuig.NaarBeneden()) {
                        level.voegStapToe();
                    }
                    if (direction == 'r' && voertuig.NaarRechts()) {
                        level.voegStapToe();
                    }
                    if (direction == 'l' && voertuig.NaarLinks()) {
                        level.voegStapToe();
                    }

                    if (level.isLevelUit()) {
                        sluitAf(true);
                        break;
                    }
                }
            } else {
                System.out.println("Geen geldige invoer.");
            }
        }
    }

    /**
     * Om de level af te sluiten
     * @param houdScoreBij true om de score bij te houden, anders false
     */
    private void sluitAf(boolean houdScoreBij) {
        if (houdScoreBij) {
            System.out.println(String.format("Uw score:%1$d", level.getAantalStappen()));
            System.out.print("\nNaam: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String naam;

            try {
                naam = br.readLine();
                HighScores.voegHighScoreToe(naam, level, level.getAantalStappen());
            } catch (Exception ex) {
                Logger.getLogger(LevelController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * The in-game menu
     */
    private class InGameMenu extends Menu {

        public InGameMenu() {
            super("Pauze");


            voegItemToe(new MenuItem(this, "Terug naar spel", false) {

                @Override
                public void doAction() {
                    return;
                }
            });
            // Afsluiten
            voegItemToe(new MenuItem(this, "Afsluiten", true) {

                @Override
                public void doAction() {
                    parent.sluit();
                }
            });
        }
    }
}
