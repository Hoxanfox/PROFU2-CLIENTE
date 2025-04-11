package vistaEscritorio.ChannelWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel superior del canal que muestra el nombre del canal, un botón para cerrar
 * y otro para ver los miembros del canal.
 */
public class ChannelHeaderPanel extends JPanel {

    private JLabel channelLabel;
    private JButton closeButton;
    private JButton membersButton;

    // Callback externo que se puede configurar para abrir el diálogo de miembros
    private Runnable onViewMembersCallback;

    public ChannelHeaderPanel(String channelName) {
        setLayout(new BorderLayout());
        setBackground(new Color(230, 230, 250));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Etiqueta con el nombre del canal
        channelLabel = new JLabel("CHAT CLIENT - Channel: " + channelName);
        channelLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Botón para ver miembros del canal (ícono de dos personas)
        membersButton = new JButton("\uD83D\uDC65");
        membersButton.setToolTipText("View Members");
        membersButton.setFocusPainted(false);
        membersButton.setBorderPainted(false);
        membersButton.setContentAreaFilled(false);

        // Botón para cerrar la ventana o canal
        closeButton = new JButton("✖");
        closeButton.setToolTipText("Close");
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);

        // Panel derecho para botones
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        rightPanel.setOpaque(false);
        rightPanel.add(membersButton);
        rightPanel.add(closeButton);

        // Agregar componentes al layout principal
        add(channelLabel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        // Acción por defecto del botón de miembros
        membersButton.addActionListener(e -> {
            if (onViewMembersCallback != null) {
                onViewMembersCallback.run();
            }
        });
    }

    /**
     * Permite agregar un listener para el botón de cerrar.
     */
    public void addCloseListener(ActionListener listener) {
        closeButton.addActionListener(listener);
    }

    /**
     * Permite configurar una acción personalizada cuando se presiona "View Members".
     * Por ejemplo, mostrar un diálogo con los usuarios online.
     */
    public void setOnViewMembersCallback(Runnable callback) {
        this.onViewMembersCallback = callback;
    }
}
