package gestionUsuarios.lobby;

import dto.lobby.NotificationDTO;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<NotificationDTO> notifications = new ArrayList<>();

    public void addNotification(NotificationDTO notification) {
        notifications.add(notification);
    }

    public List<NotificationDTO> getAllNotifications() {
        List<NotificationDTO> notifications = new ArrayList<>();
        notifications.add(new NotificationDTO("Notificación 1"));
        notifications.add(new NotificationDTO("Notificación 2"));
        return notifications;
    }

}
