package RushHour;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *  <p style="margin-top: 0">
 *        Een level
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A1990BC5-05D5-C36D-C599-846C8E6F96CB]
// </editor-fold> 
public class Level {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5234BB41-70F2-FEE4-E9D6-C975C6805708]
    // </editor-fold> 
    private Speelveld veld;

    private String naam;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F0552C0C-0429-8133-D01A-6AFD160DF257]
    // </editor-fold> 
    private ArrayList<Voertuig> voertuigen;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D3AA990C-E595-4085-FF55-7F09B5CE95F2]
    // </editor-fold> 
    /**
     * Constructor
     */
    public Level() {
        this.voertuigen = new ArrayList<Voertuig>();
        naam = "";
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A9F52AD7-8366-ACC3-67CC-93A0E2FB2BCE]
    // </editor-fold> 
    /**
     * Geeft het speelveld
     * @return het speelveld
     */
    public Speelveld getVeld() {
        return veld;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F40D4C23-C90B-4328-0972-643BFEE3D1B1]
    // </editor-fold> 
    /**
     * Stelt het speelveld in
     * @param val het gewenste speelveld
     */
    public void setVeld(Speelveld val) {
        this.veld = val;
    }

    /**
     *
     * @return
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Stelt de naam van de level in
     * @param naam de gewenste naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString()
    {
        return this.naam;
    }

    /**
     *  <p style="margin-top: 0">
     *        Geeft een voertuig uit de lijst
     *      </p>
     * @param plaats de plaats van het voertuig in de lijst
     * @return het gevraagde voertuig
     * @throws ArrayIndexOutOfBoundsException als de plaats niet bestaat
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4AA52795-976D-7625-5514-67D107760A82]
    // </editor-fold> 
    public Voertuig voertuigOpPlaats (int plaats) throws ArrayIndexOutOfBoundsException {
        if (plaats >= 0 && plaats < voertuigen.size())
        {
            return voertuigen.get(plaats);
        }
        else
            throw new ArrayIndexOutOfBoundsException("Zoveel voertuigen zijn er niet.");
    }

    /**
     * Zoekt een voertuig op een bepaalde positie
     * @param X de X-coördinaat van het voertuig
     * @param Y de Y-coördinaat van het voertuig
     * @return null als het voertuig niet gevonden is, anders het voertuig zelf
     */
    public Voertuig voertuigOpPositie(int X, int Y)
    {
        Voertuig ret = null;
        Voertuig tmp;
        Iterator<Voertuig> it = voertuigen.iterator();

        while (it.hasNext())
        {
            tmp = it.next();
            if (tmp.getOrientatie() == Orientatie.Horizontaal)
            {
                if ((tmp.getX() <= X && tmp.getX()+tmp.getGrootte() >= X) && tmp.getY() == Y )
                {
                    ret = tmp;
                    break;
                }
            }
            else
            {
                if ((tmp.getY() <= Y && tmp.getY()+tmp.getGrootte() >= Y) && tmp.getX() == X)
                {
                    ret = tmp;
                    break;
                }
            }
        }

        return ret;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D2B3617D-ADA4-A3D4-308C-3734863ECB11]
    // </editor-fold>
    /**
     * Voegt een voertuig aan de level toe
     * @param voertuig het voertuig dat toegevoegd moet worden
     */
    public void voegVoertuigToe (Voertuig voertuig) {
        if (!voertuigen.contains(voertuig))
            voertuigen.add(voertuig);
    }

}

