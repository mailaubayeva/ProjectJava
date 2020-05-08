package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Login;


    @FXML
    private Button IN;

    @FXML
    private Button NEWuser;

    @FXML
    private PasswordField Parol;


    @FXML
    void initialize() {
        IN.setOnAction(actionEvent ->{
            String loginText=Login.getText().trim();
            String loginPassword=Parol.getText().trim();
            if(!loginText.equals("")&&!loginPassword.equals("")){
                loginUser(loginText,loginPassword);
                IN.getScene().getWindow().hide();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/Mainpage.fxml"));
                try{
                    loader.load();
                } catch (IIOException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent parent=loader.getRoot();
                Stage stage=new Stage();
                stage.setTitle("Train");
                stage.setScene(new Scene(parent));
                stage.show();
            }
                else
                System.out.println("Error");


        } );
        NEWuser.setOnAction(event ->{
            NEWuser.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/app.fxml"));
            try{
                loader.load();
            } catch (IIOException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent=loader.getRoot();
            Stage stage=new Stage();
            stage.setTitle("Train");
            stage.setScene(new Scene(parent));
            stage.show();

        } );
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler=new DatabaseHandler();
        User user=new User();
        user.setUsername(loginText);
        user.setPassword(loginPassword);
        ResultSet result=dbHandler.getUser(user);

        int counter=0;
        try {
            while (result.next()) {
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(counter>=1){
            System.out.println("Success!");
        }
        else {
            System.out.println("You have to register");
        }
    }
}
