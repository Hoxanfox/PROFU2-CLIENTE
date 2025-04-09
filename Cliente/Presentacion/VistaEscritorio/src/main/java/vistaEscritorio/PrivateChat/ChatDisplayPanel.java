package vistaEscritorio.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class ChatDisplayPanel extends JPanel {

    private JTextArea chatArea;

    public ChatDisplayPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendMessage(String message) {
        chatArea.append(message + "\n\n");
    }
}
