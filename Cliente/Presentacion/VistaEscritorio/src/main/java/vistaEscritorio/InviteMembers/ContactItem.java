package vistaEscritorio.InviteMembers;

import javax.swing.*;
import java.awt.*;

public class ContactItem extends JPanel {
    private JCheckBox checkBox;
    private JLabel statusLabel;

    public ContactItem(String contactName) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        checkBox = new JCheckBox(contactName);
        statusLabel = new JLabel("🟢 last activate : Just Now");

        add(checkBox, BorderLayout.WEST);
        add(statusLabel, BorderLayout.SOUTH);
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }
}
