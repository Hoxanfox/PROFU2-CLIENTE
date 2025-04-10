package navegacion;

import controlador.MainChatController;
import vistaEscritorio.Lobby.MainChatView;

public class ViewNavigator {

    private static Runnable loginViewSupplier;
    private static Runnable registerViewSupplier;
    private static Runnable channelCreateViewSupplier;

    public static void showMainChatView(String nombreUsuario) {
        MainChatView chatView = new MainChatView(nombreUsuario);
        new MainChatController(chatView); // <-- conecta el controlador
        chatView.setVisible(true);
    }


    public static void setLoginViewSupplier(Runnable supplier) {
        loginViewSupplier = supplier;
    }

    public static void setRegisterViewSupplier(Runnable supplier) {
        registerViewSupplier = supplier;
    }

    public static void setChannelCreateViewSupplier(Runnable supplier) {
        channelCreateViewSupplier = supplier;
    }

    public static void showLoginView() {
        if (loginViewSupplier != null) loginViewSupplier.run();
        else throw new IllegalStateException("Login view supplier not set");
    }

    public static void showRegisterView() {
        if (registerViewSupplier != null) registerViewSupplier.run();
        else throw new IllegalStateException("Register view supplier not set");
    }

    public static void showChannelCreateView() {
        if (channelCreateViewSupplier != null) channelCreateViewSupplier.run();
        else throw new IllegalStateException("Channel create view supplier not set");
    }
}
