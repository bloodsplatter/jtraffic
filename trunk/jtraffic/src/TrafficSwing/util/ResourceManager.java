
package TrafficSwing.util;

/**
 * Resouce manager
 * @author bloodsplatter
 * @version 2009.05.08
 */
public class ResourceManager {
    protected static ResourceManager _instance;
    protected ClassLoader cl;

    /**
     * Constructor
     */
    protected ResourceManager()
    {
        cl = this.getClass().getClassLoader();
    }

    /**
     * 
     */
    protected static void createInstance()
    {
        if (_instance == null) _instance = new ResourceManager();
    }

    /**
     * Gets the ResourceManager instance
     * @return the ResourceManager instance
     */
    public static ResourceManager getInstance()
    {
        if (_instance == null) createInstance();
        return _instance;
    }
}
