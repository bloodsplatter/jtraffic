
package jtraffic;

import java.util.Scanner;

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
        // TODO code application logic here
        MainMenu mainMenu = new MainMenu();
        mainMenu.toon();
        Scanner scanner = new Scanner(System.in);
        mainMenu.selecteerItem(scanner.nextInt());
    }

    /**
     * MainMenu klasse
     */
    private static class MainMenu extends Menu
    {
        public MainMenu()
        {
            super("Hoofdmenu");

            // Afsluiten
            this.voegItemToe(new MenuItem("Afsluiten", true) {

                @Override
                public void doAction() {
                    System.exit(0);
                }
            });
        }
    }
}
