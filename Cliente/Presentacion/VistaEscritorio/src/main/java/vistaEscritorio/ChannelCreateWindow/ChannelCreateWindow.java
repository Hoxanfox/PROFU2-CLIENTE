package vistaEscritorio.ChannelCreateWindow;

import javax.swing.*;
import java.awt.*;

public class ChannelCreateWindow extends JFrame {

    private final ChannelCreateForm formPanel;

    public ChannelCreateWindow(String[] allUsers) {
        setTitle("Create New Channel");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        formPanel = new ChannelCreateForm(allUsers);
        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public ChannelCreateForm getFormPanel() {
        return formPanel;
    }
}
