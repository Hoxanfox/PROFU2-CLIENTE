package vistaEscritorio.ViewChannelWindow;

import javax.swing.*;
import java.awt.*;

public class ViewChannelWindow extends JFrame {

    public ViewChannelWindow(String channelName, String[] members, String[][] pendingInvitations) {
        setTitle("CHAT CLIENT - Channel : " + channelName + " - Members");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        ViewChannelPanel viewPanel = new ViewChannelPanel(members, pendingInvitations);
        add(viewPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    public static class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                String[] members = {"bob_smith", "ana_eliana"};
                String[][] invites = {
                        {"david_w", "john_doe", "Mar 30"},
                        {"david_w", "john_doe", "Mar 30"},
                };
                new ViewChannelWindow("Team Alpha", members, invites);
            });
        }
    }

}
