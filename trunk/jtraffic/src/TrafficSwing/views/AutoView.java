
package TrafficSwing.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import RushHour.*;
import TrafficSwing.resources.ResourceManager;

/**
 * De view klasse voor Auto
 * @author bloodsplatter
 * @version 2009.05.13
 */
public class AutoView extends VoertuigView {
    public static final int IMAGE_WIDTH = 144;
    public static final int IMAGE_HEIGHT = 72;

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
        
        if (voertuig.getOrientatie() == Orientatie.Horizontaal)
        {
            // knop naar links
            dirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_LINKS));
            dirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    if (voertuig.NaarLinks())
                        setBounds(voertuig.getX(), voertuig.getY(), getSize().width, getSize().height);
                }
            });
            dirButton.setVisible(false);
            super.add(dirButton,BorderLayout.WEST);

            // knop naar rechts
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_RECHTS));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    if (voertuig.NaarRechts())
                        setBounds(voertuig.getX(), voertuig.getY(), getSize().width, getSize().height);
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
                    if (voertuig.NaarBoven())
                        setBounds(voertuig.getX(), voertuig.getY(), getSize().width, getSize().height);

                }
            });
            dirButton.setVisible(false);
            super.add(dirButton,BorderLayout.NORTH);

            // knop naar onder
            odirButton = new JButton(ResourceManager.getInstance().getPijl(ResourceManager.PIJL_BENEDEN));
            odirButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    if (voertuig.NaarBeneden())
                        setBounds(voertuig.getX(), voertuig.getY(), getSize().width, getSize().height);
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
        this.setBounds(voertuig.getX(), voertuig.getY(), (voertuig.getOrientatie()==Orientatie.Horizontaal)?IMAGE_WIDTH:IMAGE_HEIGHT, (voertuig.getOrientatie()==Orientatie.Verticaal)?IMAGE_WIDTH:IMAGE_HEIGHT);
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
        av.setPositie(new Point(auto.getX(),auto.getY()));
        return av;
    }
}
