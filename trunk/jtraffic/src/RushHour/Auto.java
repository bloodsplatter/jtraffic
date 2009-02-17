
package RushHour;

/**
 * Een auto
 * @author bloodsplatter
 */
public class Auto extends Voertuig {
    private int grootte;

    /**
     * 
     * @param X
     * @param Y
     */
    public Auto(int X, int Y) {
        super(X, Y);
        grootte = 2;
    }

    /**
     *
     * @param X
     * @param Y
     * @param grootte
     */
    public Auto(int X, int Y, int grootte) {
        super(X, Y);
        this.grootte = grootte;
    }

    /**
     *
     * @param orientatie
     * @param grootte
     */
    public Auto(Orientatie orientatie, int grootte) {
        super(orientatie);
        this.grootte = grootte;
    }

    /**
     *
     * @param grootte
     */
    public Auto(int grootte) {
        super();
        this.grootte = grootte;
    }


    /**
     *
     */
    public Auto() {
        super(0,0);
        grootte = 2;
    }

    /**
     *
     * @return
     */
    public int getGrootte() {
        return grootte;
    }

}
