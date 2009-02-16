package RushHour;


/**
 *  <p style="margin-top: 0">
 *        Een speelveld
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.9EE21979-4ACE-BA23-CA09-ECB3544CD651]
// </editor-fold> 
public class Speelveld {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D8BF197E-0238-5719-6267-E37DAA813A4D]
    // </editor-fold> 
    private int breedte;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.14E101EE-DFE2-345E-FBB1-862059ABF7DA]
    // </editor-fold> 
    private int hoogte;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.690378A2-439A-7846-B6E3-92EEE6A46272]
    // </editor-fold>
    /**
     * Constructor
     */
    public Speelveld () {
        breedte = 10;
        hoogte = 10;
    }

    /**
     * Geparameteriseerde constructor
     * @param breedte
     * @param hoogte
     */
    public Speelveld(int breedte, int hoogte)
    {
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4E76A7C0-5F2B-3BBC-FE42-6B670A957F8F]
    // </editor-fold> 
    /**
     * Geeft de breedte van het speelveld trug
     * @return de breedte van het speelveld
     */
    public int getBreedte() {
        return breedte;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9327832B-FDEF-9702-C689-6678F8428D04]
    // </editor-fold> 
    /**
     * Stelt de breedte in van het speelveld.
     * @param val de gewenste breedte van het speelveld
     */
    public void setBreedte(int val) {
        if (val > 0)
            this.breedte = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3DE66517-16C5-D7B2-2CFC-4F0F7D80B71A]
    // </editor-fold> 
    /**
     * Geeft de hoogte van het speelveld
     * @return de hoogte van het speelveld
     */
    public int getHoogte() {
        return hoogte;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FFBA37CB-512A-0845-0B5C-D2B60594FE2E]
    // </editor-fold> 
    /**
     * Stelt de hoogte van het speelveld in
     * @param val de gewenste hoogte van het speelveld
     */
    public void setHoogte(int val) {
        if (val > 0)
            this.hoogte = val;
    }

}

