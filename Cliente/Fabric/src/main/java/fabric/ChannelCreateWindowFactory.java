package fabric;

import controlador.ChannelCreateController;
import gestionUsuarios.ChannelService;
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
