package controlador;

import vistaEscritorio.Lobby.*;

public class MainChatController {

    private final MainChatView view;

    public MainChatController(MainChatView view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        // Accedemos al panel de canales para registrar el listener
        ChannelViewPanel channelPanel = view.getChannelViewPanel();

        if (channelPanel != null) {
            channelPanel.setChannelViewListener(() -> {
                // Lógica cuando se hace clic en "+ Create Channel"
                System.out.println("Create Channel button clicked");
                navegacion.ViewNavigator.showChannelCreateView();
            });
        }

        // Puedes agregar más listeners si fuera necesario para:
        // - NotificationsPanel
        // - OnlineUsersPanel
        // - StatusBarPanel
    }
}
