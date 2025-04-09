package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;

public class NotificationsPanel extends JPanel {

    private DefaultListModel<String> notificationsModel;
    private JList<String> notificationsList;

    public NotificationsPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("NOTIFICATIONS (5)"));

        notificationsModel = new DefaultListModel<>();
        notificationsList = new JList<>(notificationsModel);

        add(new JScrollPane(notificationsList), BorderLayout.CENTER);
    }

    public void addNotification(String text) {
        notificationsModel.addElement(text);
    }
}
