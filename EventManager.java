import java.util.*;

public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<String, List<EventListener>>();

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        if (users == null) {
            users = new ArrayList<>();
            listeners.put(eventType, users);
        }
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        if (users != null) {
            users.remove(listener);
        }
    }

    public void notify(String eventType, String data) {
        List<EventListener> users = listeners.get(eventType);

        if (users != null) {
            for (EventListener listener : users) {
                listener.update(data);
            }
        }
    }
}
