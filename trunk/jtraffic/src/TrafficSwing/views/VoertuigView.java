
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
    /**
     * Het modelobject
     */
    protected Voertuig voertuig;
    /**
     * De afbeelding van het voertuig
     */
    protected ImageIcon img;
    //left or up
    /**
     * De knop om naar links of naar boven te gaan
     */
    protected JButton dirButton;
    // right or down
    /**
     * De knop om naar rechts of naar onderen te gaan
     */
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
     * Geeft het onderliggende voertuig
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

    /**
     * Verbergt de knoppen
     */
    public void verbergKnoppen()
    {
        odirButton.setVisible(false);
        dirButton.setVisible(false);
    }

    /**
     * Kijkt of de knoppen zichtbaar zijn
     * @return true als de knoppen zichtbaar zijn
     */
    public boolean knoppenZichtbaar()
    {
        return odirButton.isVisible() && dirButton.isVisible();
    }
}
