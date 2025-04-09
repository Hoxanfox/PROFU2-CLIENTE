package vistaEscritorio.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class TypingStatusPanel extends JPanel {

    private JLabel typingLabel;

    public TypingStatusPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        typingLabel = new JLabel("Status: ");
        typingLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        typingLabel.setForeground(Color.DARK_GRAY);
        add(typingLabel);
    }

    public void setStatus(String status) {
        typingLabel.setText("Status: " + status);
    }
}
