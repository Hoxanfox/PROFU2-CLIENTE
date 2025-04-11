// controlador/NotificationsPanelController.java
package controlador;

import dto.lobby.NotificationDTO;
import gestionUsuarios.lobby.NotificationService;
import vistaEscritorio.Lobby.NotificationsPanel;

import java.util.List;

public class NotificationsPanelController {

    private final NotificationsPanel panel;
    private final NotificationService service;

    public NotificationsPanelController(NotificationsPanel panel, NotificationService service) {
        this.panel = panel;
        this.service = service;
        loadNotifications();
    }

    private void loadNotifications() {
        List<NotificationDTO> notifications = service.getAllNotifications();
        for (NotificationDTO n : notifications) {
            panel.addNotification2(n.getMessage()); // Este método acepta String
        }
    }
}
