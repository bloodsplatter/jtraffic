
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;
import TrafficSwing.util.ResourceManager;

/**
 * De view klasse voor Vrachtwagen
 * @author bloodsplatter
 * @version 2009.05.11
 */
public class VrachtwagenView extends JPanel {
    protected Vrachtwagen vrachtwagen;
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
    public VrachtwagenView(Orientatie orientatie,Kleur kleur)
    {
        super(new BorderLayout());
        vrachtwagen = new Vrachtwagen(orientatie);
        vrachtwagen.setKleur(kleur);
        img = ResourceManager.getInstance().getAfbeeldingVoorVoertuig(vrachtwagen);
        super.add(new JLabel(img), BorderLayout.CENTER);
        
        if (vrachtwagen.getOrientatie() == Orientatie.Horizontaal)
        {
            // knop naar links
            dirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_LINKS));
            dirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    vrachtwagen.NaarLinks();
                }
            });
            dirButton.setVisible(false);
            super.add(dirButton,BorderLayout.WEST);

            // knop naar rechts
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_RECHTS));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    vrachtwagen.NaarRechts();
                }
            });
            odirButton.setVisible(false);
            super.add(odirButton,BorderLayout.EAST);
        } else
        {
            // knop naar boven
            dirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_BOVEN));
            dirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    vrachtwagen.NaarBoven();
                }
            });
            dirButton.setVisible(false);
            super.add(dirButton,BorderLayout.NORTH);

            // knop naar onder
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_BENEDEN));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    vrachtwagen.NaarBeneden();
                }
            });
            odirButton.setVisible(false);
            super.add(odirButton,BorderLayout.SOUTH);
        }

        super.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
                odirButton.setVisible(true);
                dirButton.setVisible(true);
            }

            public void mouseExited(MouseEvent e) {
                odirButton.setVisible(false);
                dirButton.setVisible(false);
            }
        });
    }
    
}
