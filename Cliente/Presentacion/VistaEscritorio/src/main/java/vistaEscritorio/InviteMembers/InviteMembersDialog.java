package vistaEscritorio.InviteMembers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InviteMembersDialog extends JDialog {

    private JTextField searchField;
    private JPanel contactListPanel;
    private List<JCheckBox> contactCheckboxes = new ArrayList<>();

    public InviteMembersDialog(Frame parent, String channelName, String[] contacts) {
        super(parent, "Invite Members to " + channelName, true);
        setSize(400, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Top: Title
        JLabel title = new JLabel("Invite Members to " + channelName);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Search bar
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        searchField.setToolTipText("Search users to invite ...");
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        searchPanel.add(searchField, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.BEFORE_FIRST_LINE);

        // Contact list panel
        contactListPanel = new JPanel();
        contactListPanel.setLayout(new BoxLayout(contactListPanel, BoxLayout.Y_AXIS));

        for (String contact : contacts) {
            ContactItem item = new ContactItem(contact);
            contactCheckboxes.add(item.getCheckBox());
            contactListPanel.add(item);
        }

        JScrollPane scrollPane = new JScrollPane(contactListPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("AVAILABLE CONTACTS"));
        add(scrollPane, BorderLayout.CENTER);

        // Bottom: Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton cancelBtn = new JButton("Cancel");
        JButton inviteBtn = new JButton("Invite");

        cancelBtn.addActionListener(e -> dispose());
        inviteBtn.addActionListener(e -> {
            List<String> selected = new ArrayList<>();
            for (JCheckBox cb : contactCheckboxes) {
                if (cb.isSelected()) {
                    selected.add(cb.getText());
                }
            }
            System.out.println("Inviting: " + selected);
            dispose();
        });

        buttonPanel.add(cancelBtn);
        buttonPanel.add(inviteBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
