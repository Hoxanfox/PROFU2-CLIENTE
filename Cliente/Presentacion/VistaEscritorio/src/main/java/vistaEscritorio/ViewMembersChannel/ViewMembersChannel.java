package vistaEscritorio.ViewMembersChannel;

import javax.swing.*;
import java.awt.*;

// Clase que representa la vista
public class ViewMembersChannel extends JFrame {

    public ViewMembersChannel(String channelName, String[] members, String[][] pendingInvitations) {
        configureFrame(channelName);
        initComponents(members, pendingInvitations);
    }

    private void configureFrame(String channelName) {
        setTitle("CHAT CLIENT - Channel : " + channelName + " - Members");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void initComponents(String[] members, String[][] pendingInvitations) {
        ViewChannelPanel viewPanel = new ViewChannelPanel(members, pendingInvitations);
        add(viewPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
