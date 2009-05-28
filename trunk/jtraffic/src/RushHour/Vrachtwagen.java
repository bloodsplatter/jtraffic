

package RushHour;

/**
 * Een vrachtwagen
 * @author bloodsplatter
 * @version 2009.04.27
 */
public class Vrachtwagen extends Voertuig {
    private int grootte = 3;

    /**
     * Maakt een vrachtwagen met de opgegeven oriëntatie
     * @param orientatie de gewenste oriëntatie
     */
    public Vrachtwagen(Orientatie orientatie) {
        super();
        super.setOrientatie(orientatie);
    }

    /**
     * Maakt een vrachtwagen
     */
    public Vrachtwagen() {
        super();
    }

    /**
     * Geeft de grootte van de vrachtwagen
     * @return de grootte van de vrachtwagen
     */
    public int getGrootte() {
        return grootte;
    }

    
    public Voertuig geefKopie() {
        Vrachtwagen ret = new Vrachtwagen();
        ret.setPositie(this.getX(), this.getY());
        ret.setKleur(this.getKleur());
        ret.setOrientatie(this.getOrientatie());
        ret.setLevel(this.getLevel());
        return ret;
    }

}
