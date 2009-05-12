package TrafficSwing.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * De basis van de view klasse
 * @author bloodsplatter
 * @version 2009.05.12
 */
public abstract class View extends JPanel {

    public View()
    {
        super();
    }

    public View(LayoutManager lm)
    {
        super(lm);
    }

    public abstract void sluitRequest();
    public abstract boolean kanSluiten();
    public abstract void sluit();
}
