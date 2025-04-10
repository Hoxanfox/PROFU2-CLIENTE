package vistaEscritorio.ViewMembersChannel;

import javax.swing.*;
import java.awt.*;

public class ViewChannelPanel extends JPanel {

    public ViewChannelPanel(String[] members, String[][] pendingInvitations) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Cabecera
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("CHANNEL MEMBERS (" + members.length + ")");
        JButton inviteButton = new JButton("➕ Invite");
        headerPanel.add(title, BorderLayout.WEST);
        headerPanel.add(inviteButton, BorderLayout.EAST);
        add(headerPanel);
        add(Box.createVerticalStrut(10));

        // Miembros actuales
        add(new JLabel("Members (" + members.length + "):"));
        for (String member : members) {
            add(createMemberCard(member));
            add(Box.createVerticalStrut(5));
        }

        // Invitaciones pendientes
        if (pendingInvitations.length > 0) {
            add(Box.createVerticalStrut(10));
            add(new JLabel("PENDING INVITATION"));

            for (String[] invite : pendingInvitations) {
                add(createInvitationCard(invite));
                add(Box.createVerticalStrut(5));
            }
        }
    }

    private JPanel createMemberCard(String memberName) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        card.setBackground(new Color(245, 245, 255));

        JLabel name = new JLabel("🔘 " + memberName);
        JLabel status = new JLabel("-Status : Online");
        JLabel joined = new JLabel("-Joined : Mar 16, 2025");
        JLabel lastActive = new JLabel("-Last active : 5 min ago");

        card.add(name);
        card.add(status);
        card.add(joined);
        card.add(lastActive);

        return card;
    }

    private JPanel createInvitationCard(String[] invite) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel inviteLabel = new JLabel(invite[0] + " - Invited by " + invite[1] + " on " + invite[2]);
        card.add(inviteLabel, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnPanel.add(new JButton("Cancel Invitation"));
        btnPanel.add(new JButton("Resend"));
        card.add(btnPanel, BorderLayout.SOUTH);

        return card;
    }
}
