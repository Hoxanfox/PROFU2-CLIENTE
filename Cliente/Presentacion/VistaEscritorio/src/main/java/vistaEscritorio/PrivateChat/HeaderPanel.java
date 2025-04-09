package vistaEscritorio.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {

    public HeaderPanel(String contactName) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(new Color(240, 240, 240));

        JLabel userLabel = new JLabel("Chatting with: " + contactName);
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        });

        add(userLabel, BorderLayout.WEST);
        add(closeButton, BorderLayout.EAST);
    }
}
