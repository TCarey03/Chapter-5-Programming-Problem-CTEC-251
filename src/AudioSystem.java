public class AudioSystem {

    public void playMusic() {
        ConfigurationManager config =
                ConfigurationManager.getInstance();

        System.out.println(
                "Playing music at volume: "
                        + config.getVolume()
        );
    }

    public void setVolume(int volume) {
        ConfigurationManager config =
                ConfigurationManager.getInstance();

        config.setVolume(volume);

        System.out.println(
                "Audio volume changed to: " + volume
        );
    }
}
