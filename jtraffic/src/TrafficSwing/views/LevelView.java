package TrafficSwing.views;

import RushHour.*;
import TrafficSwing.resources.*;
import TrafficSwing.*;
import java.awt.event.MouseEvent;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
 * De view klasse van de level
 * @author Chris, bloodsplatter
 * @version 2009.05.15
 */
public class LevelView extends View {

    protected Level level;
    protected BufferedImage speelveld;
    protected java.util.List<VoertuigView> voertuigLijst;
    public static final int BORD_BREEDTE = 527;
    public static final int BORD_HOOGTE = 586;
    private final Rectangle viewSize = new Rectangle(new Dimension(BORD_BREEDTE, BORD_HOOGTE));
    protected final Font levelNameFont = new Font("Arial", Font.BOLD, 16);
    protected final Font stappenFont = new Font("Arial",Font.PLAIN,14);

    public LevelView(Level level) {
        super(null);
        super.setDoubleBuffered(true);
        try {
            speelveld = ImageIO.read(ResourceManager.getInstance().getBord());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Application.getInstance(), e);
        }
        this.level = level;
        voertuigLijst = new ArrayList<VoertuigView>();

        // creëert views voor alle auto's
        for (Voertuig voertuig : level.getVoertuigen()) {
            if (voertuig instanceof Auto) {
                voertuigLijst.add(AutoView.createAutoView((Auto) voertuig));
            } else if (voertuig instanceof Vrachtwagen) {
                voertuigLijst.add(VrachtwagenView.createView((Vrachtwagen) voertuig));
            }
        }

        for (VoertuigView voertuigView : voertuigLijst) {
            Rectangle r = voertuigView.getBounds();
            r.x = voertuigView.getPositie().x;
            r.y = voertuigView.getPositie().y;
            voertuigView.setBounds(r);
            add(voertuigView);
        }

        super.setSize(LevelView.BORD_BREEDTE, LevelView.BORD_HOOGTE);

        super.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                for (VoertuigView voertuig : voertuigLijst) {
                    voertuig.verbergKnoppen();
                }
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
    }

    @Override
    public boolean sluit() {
        /* TODO
         * Controlleer of de level nog bezig is, want dan moeten we eerst waarschuwen,
         * als de gebruiker dan nog wilt afsluiten kunnen we de huidige score opvragen.
         * Dan pas kan er veilig afgesloten worden.
         */
        return true;
    }

    protected Point transformeerPunt(Point point) {
        return new Point(50 + (point.x * 72), 71 + (point.y * 72));
    }

    /**
     * Geeft de onderliggende level
     * @return de onderliggende level
     */
    public Level getLevel() {
        return this.level;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.drawImage(speelveld, 0, 0, null);

        if (voertuigLijst != null) {
            for (VoertuigView voertuigView : voertuigLijst) {
                Rectangle bnds = voertuigView.getBounds();
                bnds.x = transformeerPunt(voertuigView.getPositie()).x;
                bnds.y = transformeerPunt(voertuigView.getPositie()).y;
                voertuigView.setBounds(bnds);
                voertuigView.repaint();
            }
            System.out.println(level.toString());
            System.out.println("Aantal stappen: "+level.getAantalStappen());
        }

        g.setColor(Color.BLACK);
        g.setFont(levelNameFont);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D stringSize = fm.getStringBounds(level.getNaam(), g);
        g.drawString(level.getNaam(), 20, 30);
        g.setFont(stappenFont);
        stringSize = fm.getStringBounds("Aantal stappen: "+level.getAantalStappen(), g);
        g.drawString("Aantal stappen: "+level.getAantalStappen(), viewSize.width / 2 - (int) stringSize.getWidth(), viewSize.height - 50);
    }
}
