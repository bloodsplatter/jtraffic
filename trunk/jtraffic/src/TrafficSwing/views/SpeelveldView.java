/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;

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
    
    public SpeelveldView()
    {
        
    }
}
