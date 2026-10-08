package br.com.jvcid.transporte.simulation;

import br.com.jvcid.transporte.ui.SimulatorApplication;
import javafx.application.Application;

/** Ponto de entrada da aplicação gráfica. */
public final class Launcher {

    private Launcher() {
    }

    public static void main(String[] args) {
        Application.launch(SimulatorApplication.class, args);
    }
}
