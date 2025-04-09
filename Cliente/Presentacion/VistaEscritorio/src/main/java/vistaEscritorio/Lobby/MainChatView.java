package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;

public class MainChatView extends JFrame {

    private OnlineUsersPanel onlineUsersPanel;
    private NotificationsPanel notificationsPanel;
    private ChannelsPanel channelsPanel;
    private StatusBarPanel statusBarPanel;

    public MainChatView() {
        setTitle("CHAT CLIENT");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("File"));
        menuBar.add(new JMenu("Edit"));
        menuBar.add(new JMenu("View"));
        menuBar.add(new JMenu("Help"));
        setJMenuBar(menuBar);

        // Panel superior (ícono de notificaciones)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(new JButton("🔔"));
        add(topPanel, BorderLayout.NORTH);

        // Panel central dividido en usuarios y notificaciones
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        onlineUsersPanel = new OnlineUsersPanel();
        notificationsPanel = new NotificationsPanel();
        centerPanel.add(onlineUsersPanel);
        centerPanel.add(notificationsPanel);
        add(centerPanel, BorderLayout.CENTER);

        // Panel izquierdo con canales
        channelsPanel = new ChannelsPanel();
        add(channelsPanel, BorderLayout.WEST);

        // Barra inferior
        statusBarPanel = new StatusBarPanel();
        add(statusBarPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainChatView view = new MainChatView();
            view.setVisible(true);

            view.onlineUsersPanel.addUser("john_doe");
            view.onlineUsersPanel.addUser("alice123");

            view.notificationsPanel.addNotification("alice123 mentioned you in Team Alpha");

            view.channelsPanel.addChannel("General");
            view.channelsPanel.addChannel("Tech Support");
        });
    }
}
