package controlador;

import vistaEscritorio.Lobby.ChannelViewListener;
import vistaEscritorio.Lobby.ChannelViewPanel;
import navegacion.ViewNavigator;

public class ChannelViewPanelController {

    private final ChannelViewPanel view;

    public ChannelViewPanelController(ChannelViewPanel view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        view.setChannelViewListener(new ChannelViewListener() {
            @Override
            public void onCreateChannelClicked() {
                ViewNavigator.showChannelCreateView();
            }
        });
    }

    public ChannelViewPanel getView() {
        return view;
    }
}
