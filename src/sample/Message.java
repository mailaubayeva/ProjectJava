package sample;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.control.*;

public class Message {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton Menubar;



    @FXML
    private MenuItem Home;

    @FXML
    private MenuItem Contact;

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
    private TextArea Area;

    @FXML
    private TextField typing;

    @FXML
    private Button send_but;

    @FXML
    void initialize() {
        Home.setOnAction(actionEvent -> {
            OpenNewScene("/sample/Mainpage.fxml");
        });


        Contact.setOnAction(actionEvent -> {
            OpenNewScene("/sample/Contact_us.fxml");
        });
       Order.setOnAction(actionEvent -> {
            OpenNewScene("/sample/fxml/Credit.fxml");
        });
        signin.setOnAction(actionEvent -> {
            OpenNewScene("/sample/app.fxml");
        });
        login.setOnAction(actionEvent -> {
            OpenNewScene("/sample/sample.fxml");
        });
        Menu_log_out.setOnAction(actionEvent -> {
            OpenNewScene("/sample/sample.fxml");
        });
        send_but.setOnAction(actionEvent ->{
            if(!typing.equals("")){
                typing.setText(typing.getText());
                Area.setText(typing.getText() +"\n" );
                typing.setText("");

            }
            else {Area.setText("Write something");}
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
