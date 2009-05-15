
package TrafficSwing.views;

import java.awt.*;
import javax.swing.*;
import RushHour.Voertuig;

/**
 * De basisview voor voertuigen
 * @author bloodsplatter
 * @version 2009.05.13
 */
public abstract class VoertuigView extends JPanel {
    protected Voertuig voertuig;
    protected ImageIcon img;
    //left or up
    protected JButton dirButton;
    // right or down
    protected JButton odirButton;
    protected Point positie;

    /**
     * Constructor
     */
    public VoertuigView()
    {
        super(new BorderLayout());
    }

    /**
     * geeft het onderliggende voertuig
     * @return het onderliggende voertuig
     */
    public Voertuig getVoertuig()
    {
        return this.voertuig;
    }

    /**
     * Stelt de positie in
     * @return
     */
    public Point getPositie() {
        return positie;
    }

    /**
     * Stelt de positie in
     * @param positie
     */
    public void setPositie(Point positie) {
        this.positie = positie;
    }


}
