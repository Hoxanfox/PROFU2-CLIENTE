package controlador;

import vistaEscritorio.ChannelWindow.ChannelWindow;
import vistaEscritorio.Lobby.*;

import javax.swing.*;

public class MainChatController {

    private final MainChatView view;

    public MainChatController(MainChatView view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        ChannelViewPanel channelPanel = view.getChannelViewPanel();

        if (channelPanel != null) {
            channelPanel.setChannelViewListener(new ChannelViewListener() {
                @Override
                public void onCreateChannelClicked() {
                    System.out.println("Create Channel button clicked");
                    navegacion.ViewNavigator.showChannelCreateView();
                }

                @Override
                public void onChannelSelected(String channelName) {
                    System.out.println("Channel selected: " + channelName);

                    // Simulación: deberías obtener los miembros desde un servicio real
                    String[] members = {"john_doe", "alice123", "emma_j"};

                    // Crear y mostrar la ventana del canal
                    SwingUtilities.invokeLater(() -> {
                        ChannelWindow channelWindow = new ChannelWindow(channelName, members);
                        channelWindow.setVisible(true);
                    });
                }

            });
        }

        // Puedes agregar más listeners si fuera necesario
    }
}
