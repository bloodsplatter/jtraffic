
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

    /**
     * Constructor
     */
    public VoertuigView()
    {
        super(new BorderLayout());
        super.setVisible(true);
        super.setBackground(null);
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
        return new Point(voertuig.getX(), voertuig.getY());
    }

    /**
     * Stelt de positie in
     * @param positie
     */
    public void setPositie(Point positie) {
        voertuig.setX(positie.x);
        voertuig.setY(positie.y);
    }

    public void verbergKnoppen()
    {
        odirButton.setVisible(false);
        dirButton.setVisible(false);
    }
}
