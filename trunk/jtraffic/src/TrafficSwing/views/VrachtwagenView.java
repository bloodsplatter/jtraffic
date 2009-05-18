
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
    public static final int IMAGE_WIDTH = 215;
    public static final int IMAGE_HEIGHT = 72;
    
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
                odirButton.setVisible(!odirButton.isVisible());
                dirButton.setVisible(!dirButton.isVisible());
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        this.setBounds(0, 0, (voertuig.getOrientatie()==Orientatie.Horizontaal)?IMAGE_WIDTH:IMAGE_HEIGHT, (voertuig.getOrientatie()==Orientatie.Verticaal)?IMAGE_WIDTH:IMAGE_HEIGHT);
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
        vv.setPositie(new Point(vrachtwagen.getX(), vrachtwagen.getY()));
        return vv;
    }
}
