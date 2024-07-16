import java.io.*;
public class LoggingListener implements EventListener {
    private File log;
    private String message;

    public LoggingListener(String logFilename, String message) {
        this.log = new File(logFilename);
        this.message = message;
    }

    public void update(String filename) {
        try (FileWriter writer = new FileWriter(log, true)) {
            String formattedMessage = message.replace("%s", filename);
            writer.write(formattedMessage + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
