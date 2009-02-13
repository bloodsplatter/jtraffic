package RushHour;

import java.util.ArrayList;


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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F0552C0C-0429-8133-D01A-6AFD160DF257]
    // </editor-fold> 
    private ArrayList<Voertuig> voertuigen;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D3AA990C-E595-4085-FF55-7F09B5CE95F2]
    // </editor-fold> 
    public Level () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A9F52AD7-8366-ACC3-67CC-93A0E2FB2BCE]
    // </editor-fold> 
    public Speelveld getVeld () {
        return veld;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F40D4C23-C90B-4328-0972-643BFEE3D1B1]
    // </editor-fold> 
    public void setVeld (Speelveld val) {
        this.veld = val;
    }

    /**
     *  <p style="margin-top: 0">
     *        Geeft een voertuig uit de lijst
     *      </p>
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4AA52795-976D-7625-5514-67D107760A82]
    // </editor-fold> 
    public Voertuig voertuigOpPlaats (int plaats) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D2B3617D-ADA4-A3D4-308C-3734863ECB11]
    // </editor-fold> 
    public void voegVoertuigToe (Voertuig voertuig) {
    }

}

