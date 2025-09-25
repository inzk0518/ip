package faith;

import faith.ui.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FaithApp extends Application {
    private Faith faith = new Faith("data/tasks.txt");

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(FaithApp.class.getResource("/view/MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        MainWindow controller = fxmlLoader.getController();
        controller.setFaith(faith);

        stage.setTitle("Faith");
        stage.setScene(scene);
        stage.show();
    }
}
