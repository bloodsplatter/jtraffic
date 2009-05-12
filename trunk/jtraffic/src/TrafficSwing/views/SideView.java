
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
        super();
        init();
    }

    private void init()
    {
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public SideView(LayoutManager lm)
    {
        super(lm);
        init();
    }

    @Override
    public boolean kanSluiten() {
        return true;
    }

}
