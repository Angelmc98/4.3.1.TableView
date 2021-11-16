/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Angel Medina Cantos
 */
public class Main extends Application 
{
    
    // Crea la tabla 
    private final TableView<Person> table = new TableView<>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")
        );
    
    final HBox hb = new HBox(); // Crea un Hbox
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) 
    {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View");
        stage.setWidth(450);
        stage.setHeight(550);
        
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20)); // Pone el label con letra Arial
        
        table.setEditable(true);
        
        /* Creamos las columnas de las tablas */
        // Columna FirstName
        
        TableColumn<Person, String> firstNameCol = 
            new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));
        
        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstNameCol.setOnEditCommit(
            (CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
        });
        
        
        
        // Columna LastName
        TableColumn<Person, String> lastNameCol = 
            new TableColumn<>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
       lastNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
       lastNameCol.setOnEditCommit(
            (CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
        });
        
        
        
        
        
        
        //Columna Email
        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<>("email"));
        emailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());       
        emailCol.setOnEditCommit(
            (CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
        });
        
        
        
        
        
        
        table.setItems(data);// añadimos los datos la tabla
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);// Añadimos las columnas que hemos creado en la tabla
        
        /* AÑADIMOS CAMPOS DE TEXTO PARA INGRESAR NUEVOS DATOS  */ 
        
        // Campo texto FirstName
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());

        // Campo texto LastName
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");

        //Campo texto Email
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");
        
        // Botton
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Person(
                    addFirstName.getText(),
                    addLastName.getText(),
                    addEmail.getText()));
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
        });
        
        hb.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hb.setSpacing(3);
        
        
        
        
        //Creamos un Vbox y añadimos al vbox la tabla
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        
        
        
        
        stage.setScene(scene);
        stage.show();

        
    }  
}
