package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChannelViewPanel extends JPanel {

    private DefaultListModel<String> channelsModel;
    private JList<String> channelsList;
    private JButton createChannelButton;

    private ChannelViewListener listener; // <-- nuevo

    public ChannelViewPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("CHANNELS"));

        channelsModel = new DefaultListModel<>();
        channelsList = new JList<>(channelsModel);
        JScrollPane scrollPane = new JScrollPane(channelsList);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        add(scrollPane);

        createChannelButton = new JButton("+ Create Channel");
        createChannelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(createChannelButton);

        // Escuchar clic en botón y notificar al listener
        createChannelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listener != null) {
                    listener.onCreateChannelClicked();
                }
            }
        });
    }

    public void addChannel(String name) {
        channelsModel.addElement("● " + name);
    }

    public JButton getCreateChannelButton() {
        return createChannelButton;
    }

    public void setChannelViewListener(ChannelViewListener listener) {
        this.listener = listener;
    }
}
