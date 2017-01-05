import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stopwatch extends Application {
    public Stopwatch() {
    }
    long sekundid;
    long minutid;
    double simulaator;
    int varakult;
    double rent;


    @Override
    public void start(Stage primaryStage) {
        Label stopwatch = new Label();
        BooleanProperty tootab = new SimpleBooleanProperty(false);
        Calendar time = Calendar.getInstance();
        varakult = time.get(Calendar.HOUR);




        //Siin sees on stopper
        AnimationTimer timer = new AnimationTimer() {



            private LocalTime startTime;



            @Override
            public void handle(long now) {
                long aeg = Duration.between(startTime, LocalTime.now()).getSeconds();
                minutid = aeg / 60;
                sekundid = aeg % 60;


                if (varakult < 16 && varakult >= 9){
                    simulaator = (double) (minutid * 15) / 60;
                } else {
                    simulaator = (double) (minutid * 20) / 60;
                }
                DecimalFormat df = new DecimalFormat("0.00");

                stopwatch.setText("Aeg: " + minutid +":" + sekundid + " Tasuda " + df.format(simulaator + rent) + "€");
            }

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
        ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList(
                "Varustuse rent: 5€", "Jah")
        );
        cb1.setValue("Varustuse rent: 5€");
        final List valik = cb1.getItems();


        cb1.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (ObservableValue observable, Object oldValue, Object newValue) -> {
                            rent = 5;
                        });



        //Aken milles on stopper
        VBox uusAken = new VBox(10, cb1, stopwatch, startStop);
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
