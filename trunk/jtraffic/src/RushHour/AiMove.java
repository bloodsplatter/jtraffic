
package RushHour;

/**
 * Een move voor de AI
 * @author chris
 */
public class AiMove {

    private Voertuig voertuig;
    private int richting;

    /**
     * Constructor
     * @param voertuig het voertuig
     * @param richting de richting waarin bewogen wordt
     */
    public AiMove(Voertuig voertuig,int richting){
        this.voertuig = voertuig;
        this.richting = richting;
    }
    /**
     * Geeft de richting
     * @return de richting
     */
    public int getRichting(){
        return richting;
    }
    /**
     * Het voertuig dat bewogen wordt
     * @return het voertuig
     */
    public Voertuig getVoertuig(){
        return voertuig;
    }
}
