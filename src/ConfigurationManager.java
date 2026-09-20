public class ConfigurationManager {

    // The instance starts as null
    private static ConfigurationManager instance = null;

    // Game configuration settings
    private int volume;
    private String resolution;
    private String displayMode;

    // Private constructor
    private ConfigurationManager() {
        System.out.println("ConfigurationManager was created!");

        volume = 75;
        resolution = "1920x1080";
        displayMode = "Fullscreen";
    }

    // Lazy initialization
    public static ConfigurationManager getInstance() {

        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    // Getters and setters
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(String displayMode) {
        this.displayMode = displayMode;
    }
}

