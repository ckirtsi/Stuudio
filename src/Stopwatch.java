import java.time.Duration;
import java.time.LocalTime;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stopwatch {

    public void start(Stage primaryStage) {
        Label stopwatch = new Label();
        BooleanProperty running = new SimpleBooleanProperty(false);

        AnimationTimer timer = new AnimationTimer() {

            private LocalTime startTime;

            public void handle(long now) {
                long elapsedSeconds = Duration.between(startTime, LocalTime.now()).getSeconds();
                long minutes = elapsedSeconds / 60;
                long seconds = elapsedSeconds % 60;
                stopwatch.setText("Aeg: " + minutes + " minutid " + seconds + " sekundid");
            }

            public void start() {
                running.set(true);
                startTime = LocalTime.now();
                super.start();
            }

            public void stop() {
                running.set(false);
                super.stop();
            }
        };

        Button startStop = new Button();
        startStop.textProperty().bind(Bindings.when(running).then("Stop").otherwise("Start"));
        startStop.setOnAction(e -> {
            if (running.get()) {
                timer.stop();
            } else {
                timer.start();
            }
        });

        HBox root = new HBox(10, stopwatch, startStop);
        root.setPadding(new Insets(24));
        root.setMinWidth(240);
        root.setAlignment(Pos.BOTTOM_CENTER);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

