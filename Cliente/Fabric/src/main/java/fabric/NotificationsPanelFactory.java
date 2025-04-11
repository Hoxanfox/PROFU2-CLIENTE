package fabric;

import controlador.NotificationsPanelController;
import gestionUsuarios.lobby.NotificationService;
import vistaEscritorio.Lobby.NotificationsPanel;

public class NotificationsPanelFactory {

    public static NotificationsPanel create() {
        NotificationService service = new NotificationService();
        NotificationsPanel panel = new NotificationsPanel(service); // ✅ Se pasa el servicio
        new NotificationsPanelController(panel, service);
        return panel;
    }
}

