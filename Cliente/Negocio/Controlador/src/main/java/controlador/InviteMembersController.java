package controlador;

import dto.lobby.UsuarioOnlineDTO;
import gestionUsuarios.canal.InviteService;
import vistaEscritorio.InviteMembers.InviteMembersDialog;

import java.util.ArrayList;
import java.util.List;

public class InviteMembersController {

    private final InviteMembersDialog dialog;
    private final InviteService inviteService;
    private final String channelName;
    private final List<UsuarioOnlineDTO> availableUsers;

    public InviteMembersController(InviteMembersDialog dialog, InviteService inviteService, String channelName) {
        this.dialog = dialog;
        this.inviteService = inviteService;
        this.channelName = channelName;

        this.availableUsers = inviteService.getAvailableUsers();
        dialog.populateUserList(availableUsers);

        dialog.setOnInviteListener(this::handleInvite);
    }

    private void handleInvite(List<String> selectedUsernames) {
        List<UsuarioOnlineDTO> selectedUsers = new ArrayList<>();
        for (UsuarioOnlineDTO user : availableUsers) {
            if (selectedUsernames.contains(user.getNombreUsuario())) {
                selectedUsers.add(user);
            }
        }

        inviteService.sendInvites(selectedUsers, channelName);
    }
}
