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

    /**
     * Vlag om te zien of de view gesloten is
     */
    protected boolean gesloten = false;
    /**
     * Het modelobject
     */
    protected Level level;
    /**
     * De afbeelding van het speelveld
     */
    protected BufferedImage speelveld;
    /**
     * De lijst van voertuigviews
     */
    protected java.util.List<VoertuigView> voertuigLijst;
    /**
     * De breedte van het bord
     */
    public static final int BORD_BREEDTE = 527;
    /**
     * De hoogte van het bord
     */
    public static final int BORD_HOOGTE = 586;
    private final Rectangle viewSize = new Rectangle(new Dimension(BORD_BREEDTE, BORD_HOOGTE));
    /**
     * De font om de naam van de level te tekenen
     */
    protected final Font levelNameFont = new Font("Arial", Font.BOLD, 16);
    /**
     * De font om de score te tekenen
     */
    protected final Font stappenFont = new Font("Arial", Font.PLAIN, 14);

    /**
     * Constructor
     * @param level de level die weergeven moet worden
     */
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

    /**
     * De sluitmethode
     * @return true als het gelukt is
     */
    @Override
    public boolean sluit() {
        if (gesloten) {
            return true;
        }

        if (level.isLevelUit()) {
            gesloten = true;
            super.removeAll();
            level.reset();
            Application.getInstance().setDefaultPanel();
            return true;
        } else {
            int answer = JOptionPane.showConfirmDialog(Application.getInstance(), "Weet u zeker dat u wilt stoppen?", "Waarschuwing", JOptionPane.WARNING_MESSAGE);
            if (answer == 0) {
                gesloten = true;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Zet een punt in het model om naar een punt in het scherm
     * @param point het punt om om te zetten
     * @return het omgezette punt
     */
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
        if (!gesloten) {
            super.paintComponent(g);
            g.setColor(Color.gray);
            g.drawImage(speelveld, 0, 0, null);

            if (level.isLevelUit() && !gesloten) {
                HighScoreView hsv = new HighScoreView();
                hsv.voegHighScoreToe(level.getAantalStappen());
                sluit();
            }

            if (voertuigLijst != null) {
                for (VoertuigView voertuigView : voertuigLijst) {
                    Rectangle bnds = voertuigView.getBounds();
                    bnds.x = transformeerPunt(voertuigView.getPositie()).x;
                    bnds.y = transformeerPunt(voertuigView.getPositie()).y;
                    voertuigView.setBounds(bnds);
                    voertuigView.repaint();
                    System.out.println(voertuigView.getPositie().toString());
                }
                System.out.println();
            }

            g.setColor(Color.BLACK);
            g.setFont(levelNameFont);
            FontMetrics fm = g.getFontMetrics();
            Rectangle2D stringSize = fm.getStringBounds(level.getNaam(), g);
            g.drawString(level.getNaam(), 20, (int) stringSize.getHeight() * 2);
            g.setFont(stappenFont);
            stringSize = fm.getStringBounds("Aantal stappen: " + level.getAantalStappen(), g);
            g.drawString("Aantal stappen: " + level.getAantalStappen(), viewSize.width / 2 - (int) stringSize.getWidth(), viewSize.height - 50);
        }
    }
}
