import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get the Singleton
        ConfigurationManager config =
                ConfigurationManager.getInstance();

        // Create game subsystems
        AudioSystem audio = new AudioSystem();
        GraphicsRenderer graphics = new GraphicsRenderer();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("===== GAME ENGINE CONSOLE =====");
            System.out.println("1. View current status");
            System.out.println("2. Change volume");
            System.out.println("3. Change resolution");
            System.out.println("4. Play music");
            System.out.println("5. Render game");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println();
                    System.out.println("=== Current Engine Status ===");
                    System.out.println("Volume: "
                            + config.getVolume());
                    System.out.println("Resolution: "
                            + config.getResolution());
                    System.out.println("Display Mode: "
                            + config.getDisplayMode());
                    break;

                case "2":
                    System.out.print("Enter new volume (0-100): ");

                    try {
                        int volume = Integer.parseInt(
                                scanner.nextLine()
                        );

                        if (volume >= 0 && volume <= 100) {
                            audio.setVolume(volume);
                        } else {
                            System.out.println(
                                    "Volume must be between 0 and 100."
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid input. Please enter a number."
                        );
                    }

                    break;

                case "3":
                    System.out.print(
                            "Enter new resolution (example: 2560x1440): "
                    );

                    String resolution = scanner.nextLine();

                    if (!resolution.isBlank()) {
                        config.setResolution(resolution);

                        System.out.println(
                                "Resolution changed to: "
                                        + resolution
                        );
                    } else {
                        System.out.println(
                                "Resolution cannot be empty."
                        );
                    }

                    break;

                case "4":
                    audio.playMusic();
                    break;

                case "5":
                    graphics.renderGame();
                    break;

                case "6":
                    running = false;
                    System.out.println(
                            "Shutting down game engine..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please choose 1-6."
                    );
            }
        }

        scanner.close();

        System.out.println("Game engine closed.");
    }
}
