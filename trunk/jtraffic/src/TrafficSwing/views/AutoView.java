
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;
import TrafficSwing.util.ResourceManager;

/**
 * De view klasse voor Auto
 * @author bloodsplatter
 * @version 2009.05.08
 */
public class AutoView extends JPanel {
    protected Auto auto;
    protected ImageIcon img;
    //left or up
    protected JButton dirButton;
    // right or down
    protected JButton odirButton;
    

    /**
     * Constructor
     * @param orientatie de oriëntatie van de auto
     * @param kleur de kleur van de auto
     */
    public AutoView(Orientatie orientatie,Kleur kleur)
    {
        super(new BorderLayout());
        auto = new Auto(orientatie);
        auto.setKleur(kleur);
        img = ResourceManager.getInstance().getAfbeeldingVoorVoertuig(auto);
        super.add(new JLabel(img), BorderLayout.CENTER);
        if (auto.getOrientatie() == Orientatie.Horizontaal)
        {
            // knop naar links
            dirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_LINKS));
            dirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    auto.NaarLinks();
                }
            });

            // knop naar rechts
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_RECHTS));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    auto.NaarRechts();
                }
            });
        } else
        {
            // knop naar boven
            dirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_BOVEN));
            dirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    auto.NaarBoven();
                }
            });

            // knop naar rechts
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_BENEDEN));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    auto.NaarBeneden();
                }
            });
        }
    }
}
