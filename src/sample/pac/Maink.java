package sample.pac;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.lang.model.element.Name;
//Это страница Order, которую я еще не соеденила с основным проектом,здесь клиенты могут добавлять продукты онлайн
public class Maink extends Application {

    private TableView<Product> table = new TableView<Product>();
    private final ObservableList<Product> data =
            FXCollections.observableArrayList(
                    new Product(2,"Carrot","Big"));

    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Consumer basket");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Your basket");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn Amount = new TableColumn("Amount");
        Amount.setMinWidth(100);
        Amount.setCellValueFactory(
                new PropertyValueFactory<Product, String>("number"));

        TableColumn Name = new TableColumn("Name");
        Name.setMinWidth(100);
        Name.setCellValueFactory(
                new PropertyValueFactory<Product, String>("name"));

        TableColumn special = new TableColumn("Special");
        special.setMinWidth(200);
        special.setCellValueFactory(
                new PropertyValueFactory<Product, String>("special"));

        table.setItems(data);
        table.getColumns().addAll(Amount, Name, special);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("Amount");
        addFirstName.setMaxWidth(Amount.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(Name.getPrefWidth());
        addLastName.setPromptText("Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(special.getPrefWidth());
        addEmail.setPromptText("special");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Product(
                        addFirstName.getPrefColumnCount(),
                        addLastName.getText(),
                        addEmail.getText()));
                addFirstName.clear();
                addLastName.clear();
                addEmail.clear();
            }
        });

        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Product {

        private final SimpleIntegerProperty number;
        private final SimpleStringProperty name;
        private final SimpleStringProperty special;

        public Product(int number, String name, String special) {
            this.number = new SimpleIntegerProperty(number);
            this.name = new SimpleStringProperty(name);
            this.special = new SimpleStringProperty(special);
        }

        public int getNumber() {
            return number.get();
        }

        public SimpleIntegerProperty numberProperty() {
            return number;
        }

        public void setNumber(int number) {
            this.number.set(number);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getSpecial() {
            return special.get();
        }

        public SimpleStringProperty specialProperty() {
            return special;
        }

        public void setSpecial(String special) {
            this.special.set(special);
        }
    }
}