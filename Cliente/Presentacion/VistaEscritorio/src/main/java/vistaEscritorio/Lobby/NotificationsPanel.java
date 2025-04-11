package vistaEscritorio.Lobby;

import dto.lobby.NotificationDTO;
import gestionUsuarios.lobby.NotificationService;

import javax.swing.*;
import java.awt.*;

public class NotificationsPanel extends JPanel {

    private final DefaultListModel<String> notificationsModel;
    private final JList<String> notificationsList;
    private final NotificationService notificationService;

    public NotificationsPanel(NotificationService notificationService) {
        this.notificationService = notificationService;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS (0)"));

        notificationsModel = new DefaultListModel<>();
        notificationsList = new JList<>(notificationsModel);

        add(new JScrollPane(notificationsList), BorderLayout.CENTER);

        // Cargar notificaciones iniciales del servicio
        loadInitialNotifications();
    }

    public void addNotification(NotificationDTO dto) {
        if (dto == null || dto.getMessage().trim().isEmpty()) return;

        notificationService.addNotification(dto);
        notificationsModel.addElement(dto.getMessage());
        updateTitle();
    }

    private void loadInitialNotifications() {
        for (NotificationDTO dto : notificationService.getAllNotifications()) {
            notificationsModel.addElement(dto.getMessage());
        }
        updateTitle();
    }

    private void updateTitle() {
        int count = notificationsModel.getSize();
        setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS (" + count + ")"));
    }

    public void addNotification2(String message) {

    }
}
