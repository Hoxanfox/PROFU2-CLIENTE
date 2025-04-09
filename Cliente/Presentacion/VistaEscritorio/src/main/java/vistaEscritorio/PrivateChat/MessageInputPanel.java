package vistaEscritorio.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class MessageInputPanel extends JPanel {

    private JTextField messageField;
    private JButton sendButton;
    private JButton uploadButton;

    public MessageInputPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        uploadButton = new JButton("Upload file");

        messageField = new JTextField("Type your message ...");
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(uploadButton, BorderLayout.WEST);
        add(inputPanel, BorderLayout.CENTER);
    }
}
