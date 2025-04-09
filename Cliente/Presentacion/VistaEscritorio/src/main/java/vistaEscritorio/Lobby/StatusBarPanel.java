package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;

public class StatusBarPanel extends JPanel {

    private JLabel statusLabel;

    public StatusBarPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel("Status: Connected | Server: chat.example.com | Ping: 45ms");
        add(statusLabel);
    }

    public void updateStatus(String status) {
        statusLabel.setText(status);
    }
}
