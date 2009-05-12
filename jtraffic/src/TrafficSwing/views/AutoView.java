
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;
import TrafficSwing.util.ResourceManager;

/**
 * De view klasse voor Auto
 * @author bloodsplatter
 * @version 2009.05.12
 */
public class AutoView extends VoertuigView {

    /**
     * Constructor
     * @param orientatie de oriëntatie van de auto
     * @param kleur de kleur van de auto
     */
    public AutoView(Orientatie orientatie,Kleur kleur)
    {
        super();
        voertuig = new Auto(orientatie);
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
     * Geeft de onderliggende auto
     * @return de onderliggende Auto
     */
    public Auto getAuto()
    {
        return (Auto)super.voertuig;
    }

    /**
     * Creëert een view voor de opgegeven auto
     * @param auto de auto waarvan je een view wilt
     * @return de view voor de opgegeven auto
     */
    public static AutoView createAutoView(Auto auto)
    {
        AutoView av = new AutoView(auto.getOrientatie(), auto.getKleur());
        return av;
    }
}
