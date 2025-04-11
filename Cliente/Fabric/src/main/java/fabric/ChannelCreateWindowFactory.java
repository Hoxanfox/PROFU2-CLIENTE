package fabric;

import controlador.ChannelCreateController;
import gestionUsuarios.lobby.ChannelService; // Asegúrate que sea el correcto
import vistaEscritorio.ChannelCreateWindow.ChannelCreateForm;
import vistaEscritorio.ChannelCreateWindow.ChannelCreateWindow;

public class ChannelCreateWindowFactory {

    public static ChannelCreateWindow create(String[] allUsers) {
        ChannelCreateWindow window = new ChannelCreateWindow(allUsers);
        ChannelCreateForm form = window.getFormPanel();

        ChannelService service = new ChannelService();
        new ChannelCreateController(service, form);

        return window;
    }
}
