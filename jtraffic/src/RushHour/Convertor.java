
package RushHour;

/**
 * Een klasse om enumeraties naar getallen om te zetten
 * @author bloodsplatter
 */
public class Convertor {

    /**
     * Converteert een grootte naar een integer
     * @param grootte de grootte
     * @return de bijhorende integerwaarde
     */
    public static int GrootteNaarInt(Grootte grootte)
    {
        return (grootte == Grootte.Auto)?2:3;
    }

}
