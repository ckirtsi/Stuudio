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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stopwatch extends Application {
    public Stopwatch(){}

    @Override
    public void start(Stage primaryStage) {
        Label stopwatch = new Label();
        BooleanProperty tootab = new SimpleBooleanProperty(false);

        AnimationTimer timer = new AnimationTimer() {

            private LocalTime startTime ;

            @Override
            public void handle(long now) {
                long aeg = Duration.between(startTime, LocalTime.now()).getSeconds();
                long minutid = aeg / 60 ;
                double summa = (double)(minutid * 15) / 60;
                stopwatch.setText("Aeg: "+minutid +" minutit. Tasuda " + summa + " eurot");
            }
            @Override
            public void start() {
                tootab.set(true);
                startTime = LocalTime.now();
                super.start();
            }
            @Override
            public void stop() {
                tootab.set(false);
                super.stop();
            }
        };

        Button startStop = new Button();
        startStop.textProperty().bind(Bindings.when(tootab).then("Stop").otherwise("Start"));
        startStop.setOnAction(e -> {
            if (tootab.get()) {
                timer.stop();
            } else {
                timer.start();
            }
        });


        VBox uusAken = new VBox(10, stopwatch, startStop);
        uusAken.setPadding(new Insets(24));
        uusAken.setMinWidth(240);
        uusAken.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(uusAken));
        primaryStage.show();
        primaryStage.setTitle("Golf Experience");

    }

    public static void main(String[] args) {
        launch(args);
    }

}
