package vistaEscritorio.Lobby;

import dto.lobby.UsuarioOnlineDTO;
import gestionUsuarios.ServicioUsuariosOnline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OnlineUsersPanel extends JPanel {

    private DefaultListModel<UsuarioOnlineDTO> usersModel;
    private JList<UsuarioOnlineDTO> usersList;

    public OnlineUsersPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("ONLINE USERS (42)"));

        usersModel = new DefaultListModel<>();
        usersList = new JList<>(usersModel);

        ServicioUsuariosOnline servicio = new ServicioUsuariosOnline();

        servicio.agregarListener(usuario -> {
            this.addUser(usuario);
        });

        servicio.simularUsuarios();

        usersList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Doble clic
                    UsuarioOnlineDTO selectedUser = usersList.getSelectedValue();
                    if (selectedUser != null) {
                        abrirChatPrivado(selectedUser);
                    }
                }
            }
        });

        add(new JScrollPane(usersList), BorderLayout.CENTER);
    }


    public void addUser(UsuarioOnlineDTO usuario) {
        usersModel.addElement(usuario);
    }

    private void abrirChatPrivado(UsuarioOnlineDTO usuario) {
        SwingUtilities.invokeLater(() -> {
            new vistaEscritorio.PrivateChat.PrivateChat(usuario.getNombreUsuario()).setVisible(true);
        });
    }
}
