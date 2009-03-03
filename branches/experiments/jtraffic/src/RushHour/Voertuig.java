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

    private char k;

    private Level level;
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
     * @param kleur
     */
    public Voertuig(int X, int Y,char kleur)
    {
        this.orientatie = Orientatie.Horizontaal;
        this.x = X;
        this.y = Y;
        this.k = kleur;
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

    /**
     * Geeft de level waartoe het voertuig behoort
     * @return de level waartoe het voertuig behoort
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Stelt de level in waartoe het voertuig behoort
     * @param level de level waartoe het voertuig behoort
     */
    public void setLevel(Level level) {
        this.level = level;
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
     * Geeft de kleur van het voertuig
     * @return de kleur van het voertuig
     */
    public char getKleur() {
        return k;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2A69C894-15F3-9570-57FD-8442E6BF7BA9]
    // </editor-fold> 
    /**
     * Stelt de Y-coördinaat in
     * @param kleur
     */
    public void setKleur(char kleur) {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.k = kleur;
    }

    /**
     * Beweeg het voertuig 1 positie naar boven
     * @return true als het gelukt is, anders false
     */
    public boolean NaarBoven() {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.y -= 1;

        return true;
    }
    /**
     * Beweeg het voertuig 1 positie naar beneden
     * @return true als het gelukt is, anders false
     */
    public boolean NaarBeneden() {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.y += 1;
        return true;
    }
    /**
     * Beweeg het voertuig 1 positie naar links
     * @return true als het gelukt is, anders false
     */
    public boolean NaarLinks() {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.x -= 1;
        return true;
    }
    /**
     * Beweeg het voertuig 1 positie naar rechts
     * @return true als het gelukt is, anders false
     */
    public boolean NaarRechts() {
        // TODO hier moeten nog checks uitgevoerd worden.
        this.x += 1;
        return true;
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
     * Geeft de grote van het voertuig
     * @return de grootte van het voertuig
     */
    public abstract int getGrootte();

    public abstract Voertuig geefKopie();
}

