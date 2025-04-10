package vistaEscritorio.ChannelCreateWindow;

import javax.swing.*;
import java.awt.*;

public class ChannelCreateForm extends JPanel {

    private JTextField channelNameField;
    private JCheckBox publicCheckBox;
    private JCheckBox privateCheckBox;
    private JCheckBox notifyCheckBox;
    private JButton cancelButton;
    private JButton createButton;
    private JList<String> userList;

    public ChannelCreateForm(String[] allUsers) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        add(new JLabel("Channel Name:"));
        channelNameField = new JTextField();
        add(channelNameField);
        add(Box.createVerticalStrut(10));

        add(new JLabel("Channel Type:"));
        publicCheckBox = new JCheckBox("Public - Anyone can join");
        privateCheckBox = new JCheckBox("Private - Invitation only");
        add(publicCheckBox);
        add(privateCheckBox);
        add(Box.createVerticalStrut(10));

        add(new JLabel("Invite Users:"));
        userList = new JList<>(allUsers);
        userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setPreferredSize(new Dimension(300, 80));
        add(scrollPane);
        add(Box.createVerticalStrut(10));

        notifyCheckBox = new JCheckBox("Notify users about invitation");
        add(notifyCheckBox);
        add(Box.createVerticalStrut(10));

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        cancelButton = new JButton("Cancel");
        createButton = new JButton("Create");
        buttonPanel.add(cancelButton);
        buttonPanel.add(createButton);
        add(buttonPanel);
    }

    // Getters para recoger los datos del formulario
    public String getChannelName() {
        return channelNameField.getText();
    }

    public boolean isPublic() {
        return publicCheckBox.isSelected();
    }

    public boolean isPrivate() {
        return privateCheckBox.isSelected();
    }

    public String[] getSelectedUsers() {
        return userList.getSelectedValuesList().toArray(new String[0]);
    }

    public boolean notifyUsers() {
        return notifyCheckBox.isSelected();
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public Label getChannelNameField() {
        return null;
    }
}
