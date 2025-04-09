package vistaEscritorio.Lobby;

import javax.swing.*;
import java.awt.*;

public class ChannelsPanel extends JPanel {

    private DefaultListModel<String> channelsModel;
    private JList<String> channelsList;
    private JButton createChannelButton;

    public ChannelsPanel() {
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
    }

    public void addChannel(String name) {
        channelsModel.addElement("● " + name);
    }

    public JButton getCreateChannelButton() {
        return createChannelButton;
    }
}
