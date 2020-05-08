package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Contact {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton Menubar;

    @FXML
    private MenuItem Home;

    @FXML
    private MenuItem Menu_message;

    @FXML
    private MenuItem Order;

    @FXML
    private MenuItem login;

    @FXML
    private MenuItem signin;
    @FXML
    private MenuItem Menu_log_out;







    @FXML
    private Label field_name;

    @FXML
    private Label emails_cont;

    @FXML
    private Label email1;

    @FXML
    private Label email2;

    @FXML
    private Label number_cont;

    @FXML
    private Label number1;

    @FXML
    private Label number2;

    @FXML
    private Label address_cont;

    @FXML
    private Label address1;

    @FXML
    private ImageView map;

    @FXML
    private Label address2;

    @FXML
    void initialize() {

        Order.setOnAction(actionEvent -> {
            OpenNewScene("/sample/fxml/.fxml");
        });
        Menu_message.setOnAction(actionEvent -> {
            OpenNewScene("/sample/message.fxml");
        });
       login.setOnAction(actionEvent -> {
            OpenNewScene("/sample/sample.fxml");
        });
        signin.setOnAction(actionEvent -> {
            OpenNewScene("/sample/app.fxml");
        });
       Home.setOnAction(actionEvent -> {
            OpenNewScene("/sample/Mainpage.fxml");
        });
        Menu_log_out.setOnAction(actionEvent -> {
            OpenNewScene("/sample/sample.fxml");
        });

    }
    public void OpenNewScene(String window){
        Menubar.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
