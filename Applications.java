class Applications {
    public void config() {
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener("test.txt", "Someone has opened the file: %s");
        editor.events.subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener("a@example.com", "Someone has changed the file: %s");
        editor.events.subscribe("save", emailAlerts);
    }
}
