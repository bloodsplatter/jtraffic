
package RushHour;

/**
 * Een auto
 * @author bloodsplatter
 * @see RushHour.Voertuig
 */
public class Auto extends Voertuig {
    private int grootte;

    /**
     * Maakt een auto met de opgegeven oriëntatie
     * @param orientatie de gewenste oriëntatie
     */
    public Auto(Orientatie orientatie) {
        super(orientatie);
        grootte = 2;
    }

    /**
     * Maak een auto op de opgegeven locatie aan
     * @param X de X-coördinaat
     * @param Y de Y-coördinaat
     */
    public Auto(int X, int Y) {
        super(X, Y);
        grootte = 2;
    }

    /**
     * Constructor
     */
    public Auto() {
        super(0,0);
        grootte = 2;
    }

    /**
     * Geeft de grote van het voertuig
     * @return de grote van het voertuig
     */
    public int getGrootte() {
        return grootte;
    }

}
