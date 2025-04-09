package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;

public class OnlineUsersPanel extends JPanel {

    private DefaultListModel<String> usersModel;
    private JList<String> usersList;

    public OnlineUsersPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("ONLINE USERS (42)"));

        usersModel = new DefaultListModel<>();
        usersList = new JList<>(usersModel);

        add(new JScrollPane(usersList), BorderLayout.CENTER);
    }

    public void addUser(String username) {
        usersModel.addElement("🟢 " + username);
    }
}
