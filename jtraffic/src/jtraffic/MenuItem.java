package jtraffic;

import java.util.Scanner;

/**
 * Een item in een menu
 * @author bloodsplatter
 * @version 2009.04.20 */
public abstract class MenuItem {

    protected String naam;
    protected boolean confirms;
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
     * @param de naam van het menu item
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public abstract void doAction();

    @Override
    public String toString() {
        return naam;
    }

    /**
     * Constructor
     * @param naam de naam van het menu item
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
