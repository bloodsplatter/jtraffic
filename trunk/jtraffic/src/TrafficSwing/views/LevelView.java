
package TrafficSwing.views;

import RushHour.*;
import java.awt.Point;
import javax.swing.*;
import java.util.*;

/**
 * De view klasse van de level
 * @author Chris
 * @version 2009.05.13
 */
public class LevelView extends View {
    protected Level level;
    protected SpeelveldView speelveld;
    protected List<VoertuigView> voertuigLijst;
    
    protected JLabel scoreLabel;
    protected JLabel naamLabel;

    public LevelView(Level level)
    {
        this.level = level;
        speelveld = new SpeelveldView();
        
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
        updateUI();
    }

    @Override
    public boolean sluit() {
        /* TODO
         * Controlleer of de level nog bezig is, want dan moeten we eerst waarschuwen,
         * als de gebruiker dan nog wilt afsluiten kunnen we de huidige score opvragen.
         * Dan pas kan er veilig afgesloten worden.
         */
        return false;
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
    private Point transformeerPunt(Point point){
        return new Point((point.x * 10) + 10,(point.y*10) + 10 );
    }

    /**
     * Geeft de onderliggende level
     * @return de onderliggende level
     */
    public Level getLevel()
    {
        return this.level;
    }
}
