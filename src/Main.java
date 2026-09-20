public class Main {

    public static void main(String[] args) {

        // Get two references to the ConfigurationManager
        ConfigurationManager config1 =
                ConfigurationManager.getInstance();

        ConfigurationManager config2 =
                ConfigurationManager.getInstance();

        // Check if both references point to the same object
        System.out.println("Same object: " + (config1 == config2));

        // Display the original volume
        System.out.println("Original volume: " + config1.getVolume());

        // Change the volume through config1
        config1.setVolume(50);

        // Read the volume through config2
        System.out.println("Volume from config2: " + config2.getVolume());
    }
}