/**
 * Golf Experience simulaatorite aja programm
 *
 * @author Carlos Kirtsi
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Arigato extends Application implements Runnable {
    public Arigato() {
    }

    GridPane taust;
    Button macan;
    Button cayenne;
    Button panamera;
    Button turbo;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pildid();
        nupud();

    }

    private void nupud() {
        //macani nupp
        macan = new Button("Macan");
        macan.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(macan, 1, 2);
        macan.setOnAction(e -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    new Stopwatch().start(new Stage());
                }
            });
        });
        //cayenne nupp
        cayenne = new Button("Cayenne");
        cayenne.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(cayenne, 2, 2);
        cayenne.setOnAction(e -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    new Stopwatch().start(new Stage());
                }
            });
        });

        //panamera nupp
        panamera = new Button("Panamera");
        panamera.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(panamera, 3, 2);
        panamera.setOnAction(e -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    new Stopwatch().start(new Stage());
                }
            });
        });
        //turbo nupp
        turbo = new Button("911");
        turbo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(turbo, 4, 2);
        turbo.setOnAction(e -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    new Stopwatch().start(new Stage());
                }
            });
        });


    }


    public void pildid() {
        //taust
        taust = new GridPane();
        taust.setHgap(10);
        taust.setVgap(5);
        Scene scene = new Scene(taust, 1250, 250);

        //pildid
        ImageView macan = new ImageView(new Image("Autod/macan.png"));
        ImageView cayenne = new ImageView(new Image("Autod/cayenne.png"));
        ImageView panamera = new ImageView(new Image("Autod/panamera.png"));
        ImageView turbo = new ImageView(new Image("Autod/turbo.png"));

        //pildi suurused
        macan.setFitHeight(200);
        macan.setFitWidth(300);
        cayenne.setFitHeight(200);
        cayenne.setFitWidth(300);
        panamera.setFitHeight(200);
        panamera.setFitWidth(300);
        turbo.setFitHeight(200);
        turbo.setFitWidth(300);

        //lisab pildid gridile
        taust.add(macan, 1, 1);
        taust.add(cayenne, 2, 1);
        taust.add(panamera, 3, 1);
        taust.add(turbo, 4, 1);


        //lava
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        //tiitel
        stage.setTitle("Golf Experience");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    // Starteri kaudu kutsumiseks
    @Override
    public void run() {
        launch();
    }
}


