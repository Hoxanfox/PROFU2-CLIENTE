package vistaEscritorio.Lobby;

import dto.lobby.ChannelDTO;
import gestionUsuarios.lobby.ChannelService;
import vistaEscritorio.ChannelWindow.ChannelWindow;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChannelViewPanel extends JPanel {

    private DefaultListModel<String> channelsModel;
    private JList<String> channelsList;
    private JButton createChannelButton;
    private ChannelViewListener listener;

    private ChannelService channelService;
    private List<ChannelDTO> userChannels;

    public ChannelViewPanel(String username) {
        this.channelService = new ChannelService();
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

        // Carga inicial de canales
        loadUserChannels(username);

        // Clic en un canal
        channelsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedValue = channelsList.getSelectedValue();
                if (selectedValue != null && selectedValue.startsWith("● ")) {
                    String channelName = selectedValue.substring(2); // remover el símbolo
                    if (listener != null) {
                        listener.onChannelSelected(channelName);
                    }
                }
            }
        });


        createChannelButton.addActionListener(e -> {
            if (listener != null) {
                listener.onCreateChannelClicked();
            }
        });
    }

    private void loadUserChannels(String username) {
        userChannels = channelService.getUserChannels(username);
        channelsModel.clear();
        for (ChannelDTO channel : userChannels) {
            channelsModel.addElement("● " + channel.getName());
        }
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
