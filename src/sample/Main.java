package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.Socket;

public class Main extends Application {
    public static Socket socket;
    static {
        try {
            socket = new Socket("127.0.0.1", 17545);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Train");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        DatabaseHandler databaseHandler=new DatabaseHandler();

    }




    public static void main(String[] args) {
        launch(args);

    }
}
