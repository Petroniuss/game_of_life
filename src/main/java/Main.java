import agh.iet.devs.config.Config;
import agh.iet.devs.map.World;
import agh.iet.devs.view.ViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private ViewController controller;
    private World world;

    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 900;

    @Override
    public void start(Stage stage) {
        final var config = Config.getInstance();

        final var grid = new GridPane();

        this.controller = new ViewController(grid, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.world = new World(this.controller);

        grid.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        final var scene = new Scene(grid, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add(getClass().getResource("styles/styles.css").toExternalForm());

        // longrunning operation runs on different thread
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = () -> world.onUpdate();

                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();

        stage.setTitle(config.name);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}