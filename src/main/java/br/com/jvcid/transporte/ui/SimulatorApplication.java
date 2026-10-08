package br.com.jvcid.transporte.ui;

import java.util.Objects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Janela inicial. As regras dos protocolos serão implementadas fora deste pacote. */
public final class SimulatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("Simulador TCP e UDP");
        title.getStyleClass().add("title");

        Label subtitle = new Label("Máquinas de estados finitos da camada de transporte");
        subtitle.getStyleClass().add("subtitle");
        subtitle.setWrapText(true);
        subtitle.setMaxWidth(640);

        Label status = new Label("Etapa 1: janela inicial pronta");
        status.getStyleClass().add("status");

        Button closeButton = new Button("Fechar");
        closeButton.setOnAction(event -> stage.close());

        VBox root = new VBox(22, title, subtitle, status, closeButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(36));

        Scene scene = new Scene(root, 960, 600);
        scene.getStylesheets().add(Objects.requireNonNull(
                SimulatorApplication.class.getResource("/styles/app.css"),
                "O recurso /styles/app.css não foi encontrado").toExternalForm());

        stage.setTitle("Simulador da camada de transporte");
        stage.setScene(scene);
        stage.setMinWidth(760);
        stage.setMinHeight(480);
        stage.show();
    }
}
