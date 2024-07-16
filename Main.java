public class Main {
    public static void main(String[] args) {
        Applications app = new Applications();
        app.config();

        Editor editor = new Editor();

        LoggingListener log = new LoggingListener("Test.txt", "Someone has opened the file: %s");
        editor.events.subscribe("open", log);

        EmailAlertsListener Alerts = new EmailAlertsListener("a@gmail.com", "Someone has changed the file: %s");
        editor.events.subscribe("save", Alerts);

        editor.openFile("Test.txt");
        editor.saveFile();

        Alerts.print();
    }
}
