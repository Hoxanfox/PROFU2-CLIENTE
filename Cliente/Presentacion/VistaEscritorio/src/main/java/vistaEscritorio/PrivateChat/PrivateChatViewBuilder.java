package vistaEscritorio.PrivateChat;

import javax.swing.*;
import java.awt.*;

public class PrivateChatViewBuilder {

    public JPanel buildChatPanel(String contactName,
                                 HeaderPanel headerPanel,
                                 ChatDisplayPanel chatDisplayPanel,
                                 MessageInputPanel messageInputPanel,
                                 TypingStatusPanel typingStatusPanel) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(messageInputPanel, BorderLayout.CENTER);
        bottomPanel.add(typingStatusPanel, BorderLayout.SOUTH);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(chatDisplayPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        return mainPanel;
    }
}
