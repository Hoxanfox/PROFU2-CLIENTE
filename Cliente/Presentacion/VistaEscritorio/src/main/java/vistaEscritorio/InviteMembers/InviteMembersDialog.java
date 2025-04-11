package vistaEscritorio.InviteMembers;

import dto.lobby.UsuarioOnlineDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InviteMembersDialog extends JDialog {

    private JTextField searchField;
    private JPanel contactListPanel;
    private List<JCheckBox> contactCheckboxes = new ArrayList<>();
    private Consumer<List<String>> onInviteListener;

    public InviteMembersDialog(Frame parent, String channelName) {
        super(parent, "Invite Members to " + channelName, true);
        setSize(400, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Invite Members to " + channelName);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        searchField.setToolTipText("Search users to invite ...");
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        searchPanel.add(searchField, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.BEFORE_FIRST_LINE);

        contactListPanel = new JPanel();
        contactListPanel.setLayout(new BoxLayout(contactListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(contactListPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("AVAILABLE CONTACTS"));
        add(scrollPane, BorderLayout.CENTER);

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

            if (onInviteListener != null) {
                onInviteListener.accept(selected);
            }

            dispose();
        });

        buttonPanel.add(cancelBtn);
        buttonPanel.add(inviteBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void populateUserList(List<UsuarioOnlineDTO> users) {
        contactListPanel.removeAll();
        contactCheckboxes.clear();

        for (UsuarioOnlineDTO user : users) {
            JCheckBox checkBox = new JCheckBox();

            // Cambiar ícono según estado
            String estadoIcono;
            switch (user.getEstado().toLowerCase()) {
                case "online":
                    estadoIcono = "🟢";
                    break;
                case "away":
                    estadoIcono = "🟡";
                    break;
                case "offline":
                    estadoIcono = "⚫";
                    break;
                default:
                    estadoIcono = "🔘";
                    break;
            }

            checkBox.setText(estadoIcono + " " + user.getNombreUsuario());
            checkBox.setActionCommand(String.valueOf(user.getId())); // Para guardar el ID si lo necesitas
            contactCheckboxes.add(checkBox);
            contactListPanel.add(checkBox);
        }

        revalidate();
        repaint();
    }


    public void setOnInviteListener(Consumer<List<String>> listener) {
        this.onInviteListener = listener;
    }
    private void filterContacts() {
        String filterText = searchField.getText().trim().toLowerCase();

        for (JCheckBox cb : contactCheckboxes) {
            boolean matches = cb.getText().toLowerCase().contains(filterText);
            cb.setVisible(matches);
        }

        contactListPanel.revalidate();
        contactListPanel.repaint();
    }

}
