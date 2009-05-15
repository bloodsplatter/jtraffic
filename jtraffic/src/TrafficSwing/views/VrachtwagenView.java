
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;
import TrafficSwing.resources.ResourceManager;

/**
 * De view klasse voor Vrachtwagen
 * @author bloodsplatter
 * @version 2009.05.13
 */
public class VrachtwagenView extends VoertuigView {
    
    /**
     * Constructor
     * @param orientatie de oriëntatie van de auto
     * @param kleur de kleur van de auto
     */
    public VrachtwagenView(Orientatie orientatie,Kleur kleur)
    {
        super();
        voertuig = new Vrachtwagen(orientatie);
        voertuig.setKleur(kleur);
        img = ResourceManager.getInstance().getAfbeeldingVoorVoertuig(voertuig);
        super.add(new JLabel(img), BorderLayout.CENTER);
        super.positie = new Point(voertuig.getX(), voertuig.getY());
        
        if (voertuig.getOrientatie() == Orientatie.Horizontaal)
        {
            // knop naar links
            dirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_LINKS));
            dirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    voertuig.NaarLinks();
                }
            });
            dirButton.setVisible(false);
            super.add(dirButton,BorderLayout.WEST);

            // knop naar rechts
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_RECHTS));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    voertuig.NaarRechts();
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
                    voertuig.NaarBoven();
                }
            });
            dirButton.setVisible(false);
            super.add(dirButton,BorderLayout.NORTH);

            // knop naar onder
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_BENEDEN));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    voertuig.NaarBeneden();
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
    
    /**
     * 
     * @return de onderliggende vrachtwagen
     */
    public Vrachtwagen getVrachtwagen()
    {
        return (Vrachtwagen)super.voertuig;
    }

    /**
     * Creëert een view voor een opgegeven vrachtwagen
     * @param vrachtwagen de vrachtwagen waarvan je een view wilt
     * @return de view van de opgegeven vrachtwagen
     */
    public static VrachtwagenView createView(Vrachtwagen vrachtwagen)
    {
        VrachtwagenView vv = new VrachtwagenView(vrachtwagen.getOrientatie(), vrachtwagen.getKleur());
        return vv;
    }

    @Override
    public boolean sluit() {
            this.setVisible(false);
            return true;
    }
}
