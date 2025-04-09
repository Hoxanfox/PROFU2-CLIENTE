package vistaEscritorio.ChannelWindow;

import vistaEscritorio.PrivateChat.ChatDisplayPanel;
import vistaEscritorio.PrivateChat.MessageInputPanel;

import javax.swing.*;
import java.awt.*;

public class ChannelWindow extends JFrame {

    private ChannelHeaderPanel headerPanel;
    private ChatDisplayPanel chatDisplayPanel;
    private MessageInputPanel messageInputPanel;
    private MemberListPanel memberListPanel;

    public ChannelWindow(String channelName, String[] members) {
        setTitle("CHAT CLIENT - Channel: " + channelName);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents(channelName, members);
    }

    private void initComponents(String channelName, String[] members) {
        setLayout(new BorderLayout());

        headerPanel = new ChannelHeaderPanel(channelName);
        chatDisplayPanel = new ChatDisplayPanel();
        messageInputPanel = new MessageInputPanel();
        memberListPanel = new MemberListPanel(members);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(messageInputPanel, BorderLayout.CENTER);
        bottomPanel.add(memberListPanel, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);
        add(chatDisplayPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChannelWindow window = new ChannelWindow("Team Alpha", new String[]{"john_doe", "alice123"});
            window.setVisible(true);

            window.chatDisplayPanel.appendMessage("SYSTEM - 20:10\nWelcome to Team Alpha channel");
            window.chatDisplayPanel.appendMessage("john_doe - 20:15\nHey team, let's discuss the upcoming release");
            window.chatDisplayPanel.appendMessage("alice123 - 20:16\nI've prepared the test cases");
            window.chatDisplayPanel.appendMessage("bob_smith - 20:17\nGreat! I've finished the backend implementation");
            window.chatDisplayPanel.appendMessage("emma_j - 20:18\nThe UI is ready for review");
            window.chatDisplayPanel.appendMessage("john_doe - 20:20\nLet's meet tomorrow to finalize everything");
        });
    }
}
