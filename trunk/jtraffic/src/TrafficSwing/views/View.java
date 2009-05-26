package TrafficSwing.views;

import javax.swing.*;
import java.awt.*;

/**
 * De basis van de view klasse
 * @author bloodsplatter
 * @version 2009.05.12
 */
public abstract class View extends JPanel {

    /**
     * Constructor
     */
    public View()
    {
        super();
    }

    /**
     * Constructor
     * @param lm een LayoutManager
     */
    public View(LayoutManager lm)
    {
        super(lm);
    }

    /**
     * Om de view te sluiten
     * @return true als het gelukt is
     */
    public abstract boolean sluit();
}
