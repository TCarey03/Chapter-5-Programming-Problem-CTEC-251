public class Main {

    public static void main(String[] args) {

        // Get the Singleton
        ConfigurationManager config =
                ConfigurationManager.getInstance();

        // Create the game subsystems
        AudioSystem audio = new AudioSystem();
        GraphicsRenderer graphics = new GraphicsRenderer();

        System.out.println("=== Initial Game Status ===");

        audio.playMusic();
        graphics.renderGame();

        System.out.println();

        // Change the volume through the AudioSystem
        System.out.println("=== Changing Volume ===");

        audio.setVolume(40);

        System.out.println();

        // Both systems now see the updated configuration
        System.out.println("=== Updated Game Status ===");

        audio.playMusic();
        graphics.renderGame();

        System.out.println();

        // Change resolution directly through the Singleton
        config.setResolution("2560x1440");

        System.out.println("=== Resolution Changed ===");

        graphics.renderGame();
    }
}
