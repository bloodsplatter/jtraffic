
package jtraffic;

/**
 * Een item in een menu
 * @author bloodsplatter
 * @version 2009.04.18
 */
public abstract class MenuItem {

    protected String naam;

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
    public String toString()
    {
        return naam;
    }
}
