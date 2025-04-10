package main;

import fabric.AppFactory;

import javax.swing.*;

public class Aplicacion {

    public static void main(String[] args) {
        // Configura la UI para que se vea bien en todos los sistemas
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el look and feel del sistema.");
        }

        // Configurar los suppliers del ViewNavigator desde la fábrica
        AppFactory.configureNavigator();

        // Mostrar la vista de login inicial
        SwingUtilities.invokeLater(() -> AppFactory.showLoginView());
    }
}
