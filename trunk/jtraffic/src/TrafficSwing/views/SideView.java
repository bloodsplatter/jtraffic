
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;
import TrafficSwing.Application;

/**
 * Een zijview
 * @author bloodsplatter
 * @version 2009.05.12
 */
public abstract class SideView extends View {
    protected JFrame frame;

    public SideView()
    {
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    @Override
    public void sluitRequest() {
    }

    @Override
    public boolean kanSluiten() {
        return true;
    }

    @Override
    public void sluit() {
    }

}
