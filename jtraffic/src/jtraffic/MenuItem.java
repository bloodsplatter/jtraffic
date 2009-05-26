package jtraffic;

import java.util.Scanner;

/**
 * Een item in een menu
 * @author bloodsplatter
 * @version 2009.04.20 */
public abstract class MenuItem {

    /**
     * De naam van het menu item
     */
    protected String naam;
    /**
     * Of er bevestiging gevraagd moet worden
     */
    protected boolean confirms;
    /**
     * De ouder
     */
    protected Menu parent;

    /**
     * Geeft de naam van het menu item
     * @return de naam van het menu item
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Stelt de naam van het menu item in
     * @param naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * De actie om uit te voeren
     */
    public abstract void doAction();

    @Override
    public String toString() {
        return naam;
    }

    /**
     * Constructor
     * @param parent 
     * @param naam de naam van het menu item
     * @param confirms
     */
    public MenuItem(Menu parent, String naam, boolean confirms) {
        this.naam = naam;
        this.confirms = confirms;
        this.parent = parent;
    }

    /**
     * Selecteer dit menu
     */
    public void select() {
        if (this.confirms) {
            System.out.print("\nWeet u zeker dat u dit wilt doen (J/N)? [N] ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("j")) {
                    this.doAction();
                }
            }
        } else
            this.doAction();
    }
}
