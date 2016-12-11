import javafx.application.Application;
import javafx.scene.Scene;
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
    }

    private void aken() {
        taust = new GridPane();
        Scene scene = new Scene(taust, 1600, 500);
        Stage stage =new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
