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
    public Stopwatch() {
    }
    long minutid;
    double summa;

    @Override
    public void start(Stage primaryStage) {
        Label stopwatch = new Label();
        BooleanProperty tootab = new SimpleBooleanProperty(false);

        //Siin sees on stopper
        AnimationTimer timer = new AnimationTimer() {

            private LocalTime startTime;

            @Override
            public void handle(long now) {
                long aeg = Duration.between(startTime, LocalTime.now()).getSeconds();
                minutid = aeg % 60;
                stopwatch.setText("Aeg: " + minutid + " minutit. Tasuda " + summa + " eurot");
            }
           /** public void varajane(){
                if(LocalTime < 16){
                    summa = (double) (minutid * 15) / 60;
                }else {
                    summa = (double) (minutid * 20) / 60;
                }

            }
*/
            //Paneb aja jooksma
            @Override
            public void start() {
                tootab.set(true);
                startTime = LocalTime.now();
                super.start();
            }

            //Peatab aja
            @Override
            public void stop() {
                tootab.set(false);
                super.stop();
            }
        };

        //Nupp
        Button startStop = new Button();
        startStop.textProperty().bind(Bindings.when(tootab).then("Stop").otherwise("Start"));
        startStop.setOnAction(e -> {
            if (tootab.get()) {
                timer.stop();
            } else {
                timer.start();
            }
        });


        //Aken milles on stopper
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
