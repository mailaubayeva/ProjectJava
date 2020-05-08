package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.imageio.IIOException;

public class Controller2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Login;

    @FXML
    private TextField Parol;

    @FXML
    private Button NEWuser;

    @FXML
    private TextField Login1;

    @FXML
    private TextField Login2;
    @FXML
    private TextField parol;

    @FXML
    private Button Nazad;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler=new DatabaseHandler();
        NEWuser.setOnAction(event ->{
            signUpNewUser();

        });
        Nazad.setOnAction(event ->{
            Nazad.getScene().getWindow().hide();
            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/sample.fxml"));
            try{
                loader1.load();
            } catch (IIOException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent1=loader1.getRoot();
            Stage stage1=new Stage();
            stage1.setTitle("Train");
            stage1.setScene(new Scene(parent1));
            stage1.show();


        } );
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler=new DatabaseHandler();
        String firstName=Login.getText();
        String lastName=Parol.getText();
        String mail=Login1.getText();
        String username=Login2.getText();
        String password=parol.getText();
        User user=new User(firstName,lastName,mail,username,password);
        dbHandler.signUpUser(user);

    }
}

