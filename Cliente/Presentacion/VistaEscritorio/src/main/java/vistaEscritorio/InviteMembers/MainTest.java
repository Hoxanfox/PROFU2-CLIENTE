// archivo: vistaEscritorio/InviteMembers/MainTest.java
package vistaEscritorio.InviteMembers;

import javax.swing.*;

public class MainTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] contacts = {"david_w", "julian53"};
            InviteMembersDialog dialog = new InviteMembersDialog(null, "Team Alpha", contacts);
            dialog.setVisible(true);
        });
    }
}
