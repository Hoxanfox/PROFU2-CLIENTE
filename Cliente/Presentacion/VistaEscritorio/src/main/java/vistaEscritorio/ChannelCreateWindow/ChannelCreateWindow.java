package vistaEscritorio.ChannelCreateWindow;

import javax.swing.*;
import java.awt.*;

public class ChannelCreateWindow extends JFrame {

    public ChannelCreateWindow(String[] allUsers) {
        setTitle("Create New Channel");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Componentes principales
        ChannelCreateForm formPanel = new ChannelCreateForm(allUsers);
        add(formPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    public static class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new ChannelCreateWindow(new String[]{"alice123", "bob_smith", "mike_t"});
            });
        }
    }

}
