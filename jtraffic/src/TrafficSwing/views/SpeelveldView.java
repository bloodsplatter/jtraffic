
package TrafficSwing.views;

import javax.swing.*;
import RushHour.*;
import TrafficSwing.util.ResourceManager;

/**
 * De view voor de Speelveldklasse
 * @author bloodsplatter
 * @version 2009.05.08
 */
public class SpeelveldView extends JLabel {
    protected Speelveld speelveld = new Speelveld(6, 6);
    public final static int IMAGE_HEIGHT = 586;
    public final static int IMAGE_WIDTH = 527;
    protected ImageIcon img;

    /**
     * Constructor
     */
    public SpeelveldView()
    {
        super();
        img = ResourceManager.getInstance().getBord();
        super.setSize(IMAGE_WIDTH,IMAGE_HEIGHT);
        super.setIcon(img);
    }

    /**
     * Geeft het speelveld
     * @return
     */
    public Speelveld getSpeelVeld()
    {
        return speelveld;
    }
}
