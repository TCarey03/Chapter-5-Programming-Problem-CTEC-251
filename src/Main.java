public class Main {

    public static void main(String[] args) {

        System.out.println("Program started.");

        System.out.println("Getting the first configuration reference...");
        ConfigurationManager config1 =
                ConfigurationManager.getInstance();

        System.out.println("Getting the second configuration reference...");
        ConfigurationManager config2 =
                ConfigurationManager.getInstance();

        // Verify both references point to the same object
        System.out.println("Same object: " + (config1 == config2));

        // Test shared state
        System.out.println("Original volume: " + config1.getVolume());

        config1.setVolume(50);

        System.out.println("Volume from config2: "
                + config2.getVolume());
    }
}
