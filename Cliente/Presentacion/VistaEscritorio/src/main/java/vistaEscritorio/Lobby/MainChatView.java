package vistaEscritorio.Lobby;

import dto.lobby.ChannelDTO;
import gestionUsuarios.lobby.ChannelService;
import gestionUsuarios.lobby.NotificationService;
import vistaEscritorio.ChannelWindow.ChannelWindow;

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
        notificationsPanel = new NotificationsPanel(new NotificationService());

        centerPanel.add(onlineUsersPanel);
        centerPanel.add(notificationsPanel);
        return centerPanel;
    }

    private JPanel createChannelsPanel() {
        channelsPanel = new ChannelViewPanel(nombreUsuario);

        channelsPanel.setChannelViewListener(new ChannelViewListener() {
            @Override
            public void onCreateChannelClicked() {
                JOptionPane.showMessageDialog(MainChatView.this, "Funcionalidad de creación aún no implementada.");
            }

            @Override
            public void onChannelSelected(String channelName) {
                ChannelService service = new ChannelService();

                for (String userChannel : service.getChannelsForUser(nombreUsuario)) {
                    channelsPanel.addChannel(userChannel);
                }

                ChannelDTO channel = service.getChannelDetails(channelName);

                if (channel != null) {
                    SwingUtilities.invokeLater(() -> {
                        ChannelWindow window = new ChannelWindow(
                                channel.getName(),
                                channel.getMembers().toArray(new String[0])
                        );

                        window.setVisible(true);
                    });
                } else {
                    JOptionPane.showMessageDialog(MainChatView.this, "No se pudo abrir el canal: " + channelName);
                }
            }
        });

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
