
package TrafficSwing.views;

import RushHour.*;
import TrafficSwing.resources.*;
import TrafficSwing.*;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
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

    public LevelView(Level level)
    {
        try {
            speelveld = ImageIO.read(ResourceManager.getInstance().getBord());
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(Application.getInstance(), e);
        }
        this.level = level;
        voertuigLijst = new ArrayList<VoertuigView>();
        
        // creëert views voor alle auto's
        for (Voertuig voertuig : level.getVoertuigen()) {
            if (voertuig instanceof Auto)
            {
                voertuigLijst.add(AutoView.createAutoView((Auto)voertuig));
            } else if (voertuig instanceof Vrachtwagen)
            {
                voertuigLijst.add(VrachtwagenView.createView((Vrachtwagen)voertuig));
            }
        }

        super.setSize(LevelView.BORD_BREEDTE,LevelView.BORD_HOOGTE);
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

    @Override
    public void updateUI() {
        // bereken hier alle posities, stel alle labels in
        if(voertuigLijst != null){
            for (VoertuigView voertuigview : voertuigLijst) {
                voertuigview.setPositie(transformeerPunt(voertuigview.positie));
            }
        }
        super.updateUI();
    }

    protected Point transformeerPunt(Point point){
        return new Point(50 + (point.x * 72), 71 + (point.y * 72));
    }

    /**
     * Geeft de onderliggende level
     * @return de onderliggende level
     */
    public Level getLevel()
    {
        return this.level;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(speelveld, 0, 0, null);
        FontMetrics fm = g.getFontMetrics();
        Rectangle2D stringSize = fm.getStringBounds(level.getNaam(), g);
        g.drawString(level.getNaam(), viewSize.width / 2 - (int)stringSize.getWidth() / 2, viewSize.height - 30);
    }
}
