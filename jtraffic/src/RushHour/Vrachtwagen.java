/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RushHour;

/**
 *
 * @author bloodsplatter
 */
public class Vrachtwagen extends Voertuig {
    private int grootte;

    /**
     *
     * @param X
     * @param Y
     */
    public Vrachtwagen(int X, int Y) {
        super(X, Y);
        grootte = 3;
    }

    /**
     *
     * @param orientatie
     */
    public Vrachtwagen(Orientatie orientatie) {
        super(orientatie);
        grootte = 3;
    }

    /**
     *
     */
    public Vrachtwagen() {
        super(0,0);
        grootte = 3;
    }

    /**
     *
     * @param X
     * @param Y
     * @param grootte
     */
    public Vrachtwagen(int X, int Y, int grootte) {
        super(X, Y);
        this.grootte = grootte;
    }

    /**
     *
     * @param orientatie
     * @param grootte
     */
    public Vrachtwagen(Orientatie orientatie, int grootte) {
        super(orientatie);
        this.grootte = grootte;
    }

    /**
     *
     * @param grootte
     */
    public Vrachtwagen(int grootte) {
        this.grootte = grootte;
    }

    /**
     * Geeft de grootte van de vrachtwagen
     * @return de grootte van de vrachtwagen
     */
    public int getGrootte() {
        return grootte;
    }

}
