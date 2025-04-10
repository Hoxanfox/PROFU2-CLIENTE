package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;

public class MainChatView extends JFrame {

    private OnlineUsersPanel onlineUsersPanel;
    private NotificationsPanel notificationsPanel;
    private ChannelViewPanel channelsPanel;
    private StatusBarPanel statusBarPanel;
    private String nombreUsuario;

    public MainChatView(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        configureFrame();
        initComponents();
    }

    private void configureFrame() {
        setTitle("CHAT CLIENT - Bienvenido " + nombreUsuario);
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        setJMenuBar(createMenuBar());
        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createChannelsPanel(), BorderLayout.WEST);
        add(createStatusBarPanel(), BorderLayout.SOUTH);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("File"));
        menuBar.add(new JMenu("Edit"));
        menuBar.add(new JMenu("View"));
        menuBar.add(new JMenu("Help"));
        return menuBar;
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(new JButton("🔔"));
        return topPanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        onlineUsersPanel = new OnlineUsersPanel();
        notificationsPanel = new NotificationsPanel();
        centerPanel.add(onlineUsersPanel);
        centerPanel.add(notificationsPanel);
        return centerPanel;
    }

    private JPanel createChannelsPanel() {
        channelsPanel = new ChannelViewPanel();
        return channelsPanel;
    }

    private JPanel createStatusBarPanel() {
        statusBarPanel = new StatusBarPanel();
        return statusBarPanel;
    }

    public ChannelViewPanel getChannelViewPanel() {
        return channelsPanel;
    }

    public OnlineUsersPanel getOnlineUsersPanel() {
        return onlineUsersPanel;
    }

    public NotificationsPanel getNotificationsPanel() {
        return notificationsPanel;
    }

    public StatusBarPanel getStatusBarPanel() {
        return statusBarPanel;
    }

}
