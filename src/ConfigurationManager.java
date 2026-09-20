public class ConfigurationManager {

    // Eagerly create the Singleton when the class is loaded
    private static final ConfigurationManager instance =
            new ConfigurationManager();

    // Game configuration settings
    private int volume;
    private String resolution;
    private String displayMode;

    // Private constructor prevents other classes from creating objects
    private ConfigurationManager() {
        volume = 75;
        resolution = "1920x1080";
        displayMode = "Fullscreen";
    }

    // Global access method
    public static ConfigurationManager getInstance() {
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