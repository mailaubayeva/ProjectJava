package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.imageio.IIOException;

public class ControllerMain {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button order;

    @FXML
    private Button informarion;

    @FXML
    private Button contact;

    @FXML
    void initialize() {
        order.setOnAction(event ->{
            order.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/pac/Maink"));
            try{
                loader.load();
            } catch (IIOException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent=loader.getRoot();
            Stage stage=new Stage();
            stage.setTitle("Consunmer Basket");
            stage.setScene(new Scene(parent));
            stage.show();

        } );


    contact.setOnAction(event ->{
        contact.getScene().getWindow().hide();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/message.fxml"));
        try{
            loader.load();
        } catch (IIOException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent=loader.getRoot();
        Stage stage=new Stage();
        stage.setTitle("Consunmer Basket");
        stage.setScene(new Scene(parent));
        stage.show();

    } );
        informarion.setOnAction(event ->{
            informarion.getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/contact_us.fxml"));
            try{
                loader.load();
            } catch (IIOException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent parent=loader.getRoot();
            Stage stage=new Stage();
            stage.setTitle("Consunmer Basket");
            stage.setScene(new Scene(parent));
            stage.show();

        } );
}

    }

