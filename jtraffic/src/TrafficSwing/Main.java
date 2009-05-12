

package TrafficSwing;

import javax.swing.UIManager;

/**
 * Het entrypoint
 * @author bloodsplatter
 * @version 2009.05.12
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        { }
        Application app = Application.getInstance();
        app.setVisible(true);
    }
}
