package jtraffic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

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
        decoration += "+";

        sb.insert(0, decoration);
        sb.append(decoration);

        return sb.toString();
    }

    /**
     * Voert de actie die bij een menu item hoort uit
     * @param index de index van het menu item
     */
    public void selectItem(int index)
    {
        menuItems.get(index).doAction();
    }

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
}
