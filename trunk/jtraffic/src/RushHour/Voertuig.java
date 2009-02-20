package RushHour;


/**
 *  <p style="margin-top: 0">
 *        Een voertuig op het speelveld
 *      </p>
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.BCF3685A-9810-3D8C-7162-061D5F12D290]
// </editor-fold> 
public abstract class Voertuig {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8CC65A05-13B2-4140-7E90-79D620DF863B]
    // </editor-fold> 
    private Orientatie orientatie;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D7BA81A-DBCC-2912-8BD1-6895471622C8]
    // </editor-fold> 
    private int x;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6C396192-75D4-5F4B-D421-91BDB75DD6E9]
    // </editor-fold> 
    private int y;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B2EA278E-3163-DF9B-812E-995D2AAD641C]
    // </editor-fold> 
    /**
     * Constructor
     */
    public Voertuig() {
        y = 0;
        x = 0;
        this.orientatie = Orientatie.Horizontaal;
    }

    /**
     * Geparameteriseerde constructor
     * @param orientatie de orientatie van het voertuig
     */
    public Voertuig(Orientatie orientatie)
    {
        this.orientatie = orientatie;
        x = 0;
        y = 0;
    }

    /**
     * Geparameteriseerde constructor
     * @param X de horizontale positie van het voertuig in het speelveld
     * @param Y de verticale positie van het voertuig in het speelveld
     */
    public Voertuig(int X, int Y)
    {
        this.orientatie = Orientatie.Horizontaal;
        this.x = X;
        this.y = Y;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D74C6A0A-85DE-DA78-E7BC-E20D445D17F3]
    // </editor-fold> 
    /**
     * Geeft de oriëntatie van het voertuig
     * @return de oriëntatie van het voertuig
     */
    public Orientatie getOrientatie() {
        return orientatie;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DDBD8211-092A-D0DB-F626-369F25EC155A]
    // </editor-fold> 
    /**
     * Stelt de oriëntatie van het voertuig in
     * @param val de gewenste oriëntatie
     */
    public void setOrientatie(Orientatie val) {
        this.orientatie = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.07868CD2-4BC0-9B22-2663-894106232A4F]
    // </editor-fold> 
    /**
     * Geeft de X-coördinaat
     * @return de X-coördinaat
     */
    public int getX() {
        return x;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7A395978-B5D0-D622-8763-2D9F108B672A]
    // </editor-fold> 
    /**
     * Stelt de X-coördinaat in
     * @param val de gewenste X-coördinaat
     */
    public void setX(int val) {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.x = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5DFFBA52-8A94-6ADE-DBF1-B8208E7F03D0]
    // </editor-fold> 
    /**
     * Geeft de Y-coördinaat
     * @return de Y-coördinaat
     */
    public int getY() {
        return y;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2A69C894-15F3-9570-57FD-8442E6BF7BA9]
    // </editor-fold> 
    /**
     * Stelt de Y-coördinaat in
     * @param val de Y-coördinaat
     */
    public void setY(int val) {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.y = val;
    }

    /**
     *  <p style="margin-top: 0">
     *        Stel de positie in
     *      </p>
     * @param X de X-coördinaat
     * @param Y de Y-coördinaat
     */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B1AD730E-66D4-8101-094D-90D4ACA88853]
    // </editor-fold> 
    public void setPositie (int X, int Y) {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.x = X;
        this.y = Y;
    }

    /**
     * Geeft de grootte van het voertuig
     * @return de grootte van het voertuig
     */
    public abstract int getGrootte();
    
}

