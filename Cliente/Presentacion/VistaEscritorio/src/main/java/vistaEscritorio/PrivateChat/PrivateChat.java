package vistaEscritorio.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class PrivateChat extends JFrame {

    private ChatDisplayPanel chatDisplayPanel;
    private MessageInputPanel messageInputPanel;
    private TypingStatusPanel typingStatusPanel;
    private HeaderPanel headerPanel;

    public PrivateChat(String contactName) {
        setTitle("CHAT CLIENT - Private Chat: " + contactName);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents(contactName);
    }

    private void initComponents(String contactName) {
        setLayout(new BorderLayout());

        headerPanel = new HeaderPanel(contactName);
        chatDisplayPanel = new ChatDisplayPanel();
        messageInputPanel = new MessageInputPanel();
        typingStatusPanel = new TypingStatusPanel();

        // Contenedor inferior que agrupa input y estado de escritura
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(messageInputPanel, BorderLayout.CENTER);
        bottomPanel.add(typingStatusPanel, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);
        add(chatDisplayPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrivateChat frame = new PrivateChat("alice123");
            frame.setVisible(true);

            frame.chatDisplayPanel.appendMessage("john_doe - 20:15\nHey Alice, how's the project going?");
            frame.chatDisplayPanel.appendMessage("alice123 - 20:16\nHi John! It's going well. I've finished the first module.");
            frame.chatDisplayPanel.appendMessage("john_doe - 20:17\nThat's great! Can you send me the documentation?");
            frame.chatDisplayPanel.appendMessage("alice123 - 20:18\nSure, here it is. [documentation.pdf]");

            frame.typingStatusPanel.setStatus("alice123 is typing...");
        });
    }
}
