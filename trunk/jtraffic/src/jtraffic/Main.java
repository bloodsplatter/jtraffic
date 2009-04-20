
package jtraffic;

import RushHour.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * The main class
 * @author bloodsplatter
 * @version genesis
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // initialisatie
            LevelManager.Initialize();
            HighScores.Initialize();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.err.println("Kritieke fout.");
            System.exit(-2);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.err.println("Kritieke fout.");
            System.exit(-1);
        }

        MainMenu mainMenu = new MainMenu();
            while (true) {
                mainMenu.toon();
            }
    }

    /**
     * MainMenu klasse
     */
    private static class MainMenu extends Menu
    {
        public MainMenu()
        {
            super("Hoofdmenu");

            this.voegItemToe(new MenuItem(this,"Toon levels", false) {

                @Override
                public void doAction() {
                    Level[] levelLijst = LevelManager.toArray();
                    for (Level level : levelLijst) {
                        System.out.println(level.toString());
                    }
                    System.out.println();
                }
            });

            // Afsluiten
            this.voegItemToe(new MenuItem(this,"Afsluiten", true) {

                @Override
                public void doAction() {
                    System.exit(0);
                }
            });
        }
    }
}
