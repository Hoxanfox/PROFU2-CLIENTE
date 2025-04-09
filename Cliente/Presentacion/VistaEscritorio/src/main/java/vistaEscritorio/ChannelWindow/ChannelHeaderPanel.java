package vistaEscritorio.ChannelWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChannelHeaderPanel extends JPanel {

    private JLabel channelLabel;
    private JButton closeButton;
    private JButton membersButton;

    public ChannelHeaderPanel(String channelName) {
        setLayout(new BorderLayout());
        setBackground(new Color(230, 230, 250));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Etiqueta del canal
        channelLabel = new JLabel("CHAT CLIENT - Channel: " + channelName);
        channelLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Botón de miembros (icono)
        membersButton = new JButton("\uD83D\uDC65"); // ícono de dos personas
        membersButton.setToolTipText("View Members");
        membersButton.setFocusPainted(false);
        membersButton.setBorderPainted(false);
        membersButton.setContentAreaFilled(false);

        // Botón de cerrar
        closeButton = new JButton("✖");
        closeButton.setToolTipText("Close");
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        rightPanel.setOpaque(false);
        rightPanel.add(membersButton);
        rightPanel.add(closeButton);

        add(channelLabel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    public void addCloseListener(ActionListener listener) {
        closeButton.addActionListener(listener);
    }

    public void addMembersListener(ActionListener listener) {
        membersButton.addActionListener(listener);
    }
}
