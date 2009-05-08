/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private final int IMGHEIGHT = 586;
    private final int IMGWIDTH = 527;
    protected ImageIcon img;

    /**
     * Constructor
     */
    public SpeelveldView()
    {
        super();
        img = ResourceManager.getInstance().getBord();
        super.setSize(IMGWIDTH,IMGHEIGHT);
        super.setIcon(img);
    }
}
