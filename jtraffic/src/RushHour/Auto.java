
package RushHour;

/**
 * Een auto
 * @author bloodsplatter
 * @version 2009.05.08
 */
public class Auto extends Voertuig {
    private int grootte;

    /**
     * Constructor
     * @param orientatie de oriëntatie van het voertuig
     */
    public Auto(Orientatie orientatie) {
        super();
        super.setOrientatie(orientatie);
        grootte = 2;
    }

    /**
     * Maak een auto op de opgegeven locatie aan
     * @param X de X-coördinaat
     * @param Y de Y-coördinaat
     * @param Kleur de kleur van de wagen
     */
    public Auto(int X, int Y,Kleur kleur) {
        super();
        super.setX(X);
        super.setY(Y);
        super.setKleur(kleur);
        grootte = 2;
    }

    /**
     * Constructor
     */
    public Auto() {
        super();
        super.setKleur(Kleur.Rood);
        grootte = 2;
    }

    /**
     * Geeft de grote van het voertuig
     * @return de grote van het voertuig
     */
    public int getGrootte() {
        return grootte;
    }

    
    public Voertuig geefKopie() {
        Auto ret = new Auto(this.getX(), this.getY(), this.getKleur());
        ret.setOrientatie(this.getOrientatie());
        return ret;
    }

}
