import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Arigato extends Application {
    GridPane taust;
    GridPane tiitel;
    Stopwatch stopper;
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
        macan = new Button("Macan");
        macan.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(macan, 1, 2);

        cayenne = new Button("Cayenne");
        cayenne.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(cayenne, 2, 2);

        panamera = new Button("Panamera");
        panamera.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(panamera, 3, 2);

        turbo = new Button("911");
        turbo.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        taust.add(turbo, 4, 2);



    }


    public void pildid() {
        taust = new GridPane();
        taust.setHgap(10);
        taust.setVgap(5);
        Scene scene = new Scene(taust,1650,350);

        ImageView macan = new ImageView(new Image("http://files2.porsche.com/filestore.aspx/model.png?pool=multimedia&type=image&id=rd-2013-po-416-r4-modelimage-sideshot&lang=en&filetype=model&version=4686acb0-c3cb-11e3-8043-001a64c55f5c"));
        ImageView cayenne = new ImageView(new Image("http://files1.porsche.com/filestore.aspx/model.png?pool=multimedia&type=image&id=rd-2013-9pa-e2-2nd-di-modelimage-sideshot&lang=none&filetype=model&version=87d26f89-01f4-11e4-84a6-001a64c55f5c"));
        ImageView panamera = new ImageView(new Image("http://files.porsche.com/filestore/image/multimedia/none/970-g2-tu-modelimage-sideshot/model/1345c8fc-33ba-11e6-9225-0019999cd470;s25/porsche-model.png"));
        ImageView turbo = new ImageView(new Image("http://files3.porsche.com/filestore.aspx/model.png?pool=multimedia&type=image&id=991-2nd-tus-modelimage-sideshot&lang=none&filetype=model&version=6e5afd5c-7316-11e5-b99f-0019999cd470"));

        taust.add(macan, 1, 1);
        taust.add(cayenne, 2, 1);
        taust.add(panamera, 3, 1);
        taust.add(turbo, 4, 1);


        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
