
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;

/**
 * De view klasse voor Auto
 * @author bloodsplatter
 * @version 2009.05.08
 */
public class AutoView extends JLabel {
    protected Auto auto;

    /**
     * Constructor
     * @param orientatie de oriëntatie van de auto
     * @param kleur de kleur van de auto
     */
    public AutoView(Orientatie orientatie,Kleur kleur)
    {
        auto = new Auto(orientatie);
        auto.setKleur(kleur);
    }
}
