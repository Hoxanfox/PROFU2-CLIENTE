package controlador;

import dto.lobby.ChannelDTO;
import gestionUsuarios.lobby.ChannelService;
import vistaEscritorio.ChannelCreateWindow.ChannelCreateForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ChannelCreateController {

    private final ChannelService channelService;
    private final ChannelCreateForm form;

    public ChannelCreateController(ChannelService channelService, ChannelCreateForm form) {
        this.channelService = channelService;
        this.form = form;
        initListeners();
    }

    private void initListeners() {
        form.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String channelName = form.getChannelName();
                String[] selectedUsers = form.getSelectedUsers();
                ChannelDTO dto = new ChannelDTO(channelName, Arrays.asList(selectedUsers));

                boolean created = channelService.createChannel(dto);
                if (created) {
                    JOptionPane.showMessageDialog(form, "Canal creado exitosamente.");
                    SwingUtilities.getWindowAncestor(form).dispose();
                } else {
                    JOptionPane.showMessageDialog(form, "Error al crear el canal.");
                }
            }
        });

        form.getCancelButton().addActionListener(e -> {
            SwingUtilities.getWindowAncestor(form).dispose();
        });
    }
}
