import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Arigato extends Application{
   GridPane taust;
    @Override
    public void start(Stage primaryStage) throws Exception{
        aken();
        taimer();
        lisad();


    }

    private void taimer() {
    }

    private void aken() {
        taust = new GridPane();
        ImageView macan = new ImageView(new Image("http://files2.porsche.com/filestore.aspx/model.png?pool=multimedia&type=image&id=rd-2013-po-416-r4-modelimage-sideshot&lang=en&filetype=model&version=4686acb0-c3cb-11e3-8043-001a64c55f5c"));
        ImageView cayenne = new ImageView(new Image("http://files1.porsche.com/filestore.aspx/model.png?pool=multimedia&type=image&id=rd-2013-9pa-e2-2nd-di-modelimage-sideshot&lang=none&filetype=model&version=87d26f89-01f4-11e4-84a6-001a64c55f5c"));
        ImageView panamera = new ImageView(new Image("http://files.porsche.com/filestore/image/multimedia/none/970-g2-tu-modelimage-sideshot/model/1345c8fc-33ba-11e6-9225-0019999cd470;s25/porsche-model.png"));
        ImageView turbo = new ImageView(new Image("http://files3.porsche.com/filestore.aspx/model.png?pool=multimedia&type=image&id=991-2nd-tus-modelimage-sideshot&lang=none&filetype=model&version=6e5afd5c-7316-11e5-b99f-0019999cd470"));
        Scene scene = new Scene(taust, 1600, 300);
        taust.add(macan,1,1);
        taust.add(cayenne,2,1);
        taust.add(panamera,3,1);
        taust.add(turbo,4,1);
        taust.setGridLinesVisible(true);
        //taust.getChildren().addAll(macan, cayenne, panamera, turbo);

        Stage stage =new Stage();
        stage.setScene(scene);
        stage.show();

  }

}
