

package RushHour;

/**
 * Een vrachtwagen
 * @author bloodsplatter
 * @version 2009.04.27
 */
public class Vrachtwagen extends Voertuig {
    private int grootte;

    /**
     * Maakt een vrachtwagen op de opgegeven locatie
     * @param X de X-coördinaat
     * @param Y de Y-coördinaat
     * @param Kleur de kleur van de wagen
     */
    public Vrachtwagen(int X, int Y, Kleur kleur) {
        super(X, Y, kleur);
        super.setOrientatie(Orientatie.Horizontaal);
        super.setOrientatie(Orientatie.Horizontaal);
        grootte = 3;
    }

    /**
     * Maakt een vrachtwagen met de opgegeven oriëntatie
     * @param orientatie de gewenste oriëntatie
     */
    public Vrachtwagen(Orientatie orientatie) {
        super(orientatie);
        grootte = 3;
    }

    /**
     * Maakt een vrachtwagen
     */
    public Vrachtwagen() {
        super(0,0,Kleur.Groen);
        grootte = 3;
    }

    /**
     * Geeft de grootte van de vrachtwagen
     * @return de grootte van de vrachtwagen
     */
    public int getGrootte() {
        return grootte;
    }

    
    public Voertuig geefKopie() {
        Vrachtwagen ret = new Vrachtwagen(this.getX(), this.getY(), this.getKleur());
        ret.setOrientatie(this.getOrientatie());
        return ret;
    }

}
