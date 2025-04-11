package vistaEscritorio.ChannelWindow;

import dto.lobby.UsuarioOnlineDTO;
import vistaEscritorio.InviteMembers.InviteMembersDialog;
import vistaEscritorio.PrivateChat.ChatDisplayPanel;
import vistaEscritorio.PrivateChat.MessageInputPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChannelWindow extends JFrame {

    private ChannelHeaderPanel headerPanel;
    private ChatDisplayPanel chatDisplayPanel;
    private MessageInputPanel messageInputPanel;
    private MemberListPanel memberListPanel;

    public ChannelWindow(String channelName, String[] members) {
        setTitle("CHAT CLIENT - Channel: " + channelName);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents(channelName, members);

        // 🔴 Listener para cerrar la ventana
        headerPanel.addCloseListener(e -> dispose());

        // ✅ Callback para mostrar el diálogo de invitar miembros
        headerPanel.setOnViewMembersCallback(() -> {
            InviteMembersDialog dialog = new InviteMembersDialog(this, channelName);

            // 🔧 Generar usuarios ficticios
            List<UsuarioOnlineDTO> fakeUsers = generarUsuariosFicticios();

            dialog.populateUserList(fakeUsers);

            dialog.setOnInviteListener(usernames -> {
                System.out.println("Invited users: " + usernames);
                // Aquí puedes añadir lógica adicional, como actualizar la lista del canal, etc.
            });

            dialog.setVisible(true);
        });
    }

    private void initComponents(String channelName, String[] members) {
        setLayout(new BorderLayout());

        headerPanel = new ChannelHeaderPanel(channelName);
        chatDisplayPanel = new ChatDisplayPanel();
        messageInputPanel = new MessageInputPanel();
        memberListPanel = new MemberListPanel(members);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(messageInputPanel, BorderLayout.CENTER);
        bottomPanel.add(memberListPanel, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);
        add(chatDisplayPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private List<UsuarioOnlineDTO> generarUsuariosFicticios() {
        String[] nombres = {"Alice", "Bob", "Charlie"};
        return IntStream.range(0, nombres.length)
                .mapToObj(i -> new UsuarioOnlineDTO(nombres[i], "online", i + 1))
                .collect(Collectors.toList());
    }
}
