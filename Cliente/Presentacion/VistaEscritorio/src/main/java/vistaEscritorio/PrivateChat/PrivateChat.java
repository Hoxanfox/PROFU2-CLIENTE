package vistaEscritorio.PrivateChat;

import javax.swing.*;

public class PrivateChat extends JFrame {

    private final ChatDisplayPanel chatDisplayPanel;
    private final MessageInputPanel messageInputPanel;
    private final TypingStatusPanel typingStatusPanel;
    private final HeaderPanel headerPanel;

    public PrivateChat(String contactName) {
        setTitle("CHAT CLIENT - Private Chat: " + contactName);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        this.chatDisplayPanel = new ChatDisplayPanel();
        this.messageInputPanel = new MessageInputPanel();
        this.typingStatusPanel = new TypingStatusPanel();
        this.headerPanel = new HeaderPanel(contactName);

        PrivateChatViewBuilder builder = new PrivateChatViewBuilder();
        JPanel mainPanel = builder.buildChatPanel(contactName, headerPanel, chatDisplayPanel, messageInputPanel, typingStatusPanel);
        setContentPane(mainPanel);
    }

    // Métodos públicos para acceder a componentes si se necesita control externo
    public ChatDisplayPanel getChatDisplayPanel() {
        return chatDisplayPanel;
    }

    public MessageInputPanel getMessageInputPanel() {
        return messageInputPanel;
    }

    public TypingStatusPanel getTypingStatusPanel() {
        return typingStatusPanel;
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }
}
