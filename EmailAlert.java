import java.io.*;

class EmailAlertsListener implements EventListener {
    private String email;
    private String message;
    private File logFile;

    public EmailAlertsListener(String email, String message) {
        this.email = email;
        this.message = message;
        this.logFile = new File(String.valueOf(logFile));
    }

    @Override
    public void update(String filename) {
        String formattedMessage = message.replace("%s", filename);
        System.out.println("Email sent to " + email + ": " + formattedMessage);
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            writer.println("Email sent to " + email + ": " + formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
            writer.println("Email: " + email);
            writer.println("Message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
