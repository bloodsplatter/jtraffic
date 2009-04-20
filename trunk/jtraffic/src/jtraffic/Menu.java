package jtraffic;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Een tekstueel menu
 * @author bloodsplatter
 * @version 2009.04.18
 */
public class Menu {

    private String titel;
    private ArrayList<MenuItem> menuItems;

    /**
     * Geeft de titel van het menu
     * @return de titel van het menu
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Stel de titel van het menu in
     * @param Nieuwe titel voor het menu
     */
    public void setTitel(String Titel) {
        this.titel = Titel;
    }

    /**
     * Geeft het aantal items in het menu
     * @return het aantal items in het menu
     */
    public int aantalItems() {
        return menuItems.size();
    }

    /**
     * Verwijder alle items
     */
    public void verwijderAlleItems() {
        menuItems.clear();
    }

    /**
     * Voeg een item aan het menu toe
     * @param item het toe te voegen item
     */
    public void voegItemToe(MenuItem item) {
        menuItems.add(item);
    }

    /**
     * Geeft een array van MenuItems
     * @return een array van MenuItems
     */
    public MenuItem[] toArray() {
        MenuItem[] items = new MenuItem[menuItems.size()];
        menuItems.toArray(items);
        return items;
    }

    /**
     * Voegt de items toe aan het menu
     * @param items de toe te voegen items
     */
    public void voegItemstoe(MenuItem[] items) {
        for (MenuItem menuItem : items) {
            menuItems.add(menuItem);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int breedte = this.minimumBreedte() + 2;

        int counter = 1;
        for (MenuItem menuItem : menuItems) {
            String str = String.format("| %1$d) %2$s |", counter, menuItem.toString());
            if (str.length() > breedte)
                breedte = str.length();

            sb.append(str);
            sb.append('\n');
            counter++;
        }

        String decoration = "+";

        for (int i = 0; i < breedte - 2; i++)
        {
            decoration = decoration.concat("-");
        }
        decoration += "+\n";

        sb.insert(0, decoration);
        sb.append(decoration);

        return sb.toString();
    }

    /**
     * Voert de actie die bij een menu item hoort uit
     * @param index de index van het menu item
     */
    public boolean selecteerItem(int index)
    {
        if (index > 0 && index < menuItems.size())
        {
            menuItems.get(index).select();
            return true;
        }

        return false;
    }

    /**
     * Maakt een schatting van de minimumbreedte van het menu
     * @return de minimumbreedte
     */
    private int minimumBreedte() {
        int ret = 0;
        int length = 0;
        ListIterator<MenuItem> it = menuItems.listIterator();
        MenuItem next = null;

        while (it.hasNext()) {
            next = it.next();
            length = next.toString().length();
            if (length > ret) {
                ret = length;
            }
        }

        return ret + 2;
    }

    /**
     * Constructor
     */
    public Menu() {
        this.titel = "Menu";
        this.menuItems = new ArrayList<MenuItem>();
    }

    /**
     * Constructor met titel
     * @param titel de titel van het menu
     */
    public Menu(String titel) {
        this.titel = titel;
        this.menuItems = new ArrayList<MenuItem>();
    }

    /**
     * Toon het menu
     */
    @SuppressWarnings("empty-statement")
    public void toon()
    {
        System.out.println(this.titel);
        System.out.println(this.toString());
        System.out.println("Kies een optie:");
        Scanner scanner = new Scanner(System.in);
        while (!this.selecteerItem(scanner.nextInt()-1));
    }
}
