//package application;
//
//import javafx.animation.FadeTransition;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.Menu;
//import javafx.scene.control.MenuBar;
//import javafx.scene.control.MenuItem;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class CRMView extends VBox {
//    private TableView<Member> table;
//
//    public CRMView(Member model, Runnable actionHandler) {
//    	
//    	
//    	
////    	 TextField numberTF = new TextField();
//////         numberTF.textProperty().bindBidirectional(model.numberProperty());
////         HBox dataBox = new HBox(4, new Label("Enter a number: "), numberTF);
////         Button button = new Button("Add 5");
////         button.setOnAction(evt -> actionHandler.run());
//////         button.disableProperty().bind(model.moreAllowedProperty().not());
////         getChildren().addAll(dataBox, button);
//    	
//    	
////        table = new TableView<>();
////        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
////        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
////
////        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
////        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
////
////        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
////        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
////
////        TableColumn<Member, String> actionColumn = new TableColumn<>("Action");
////        actionColumn.setCellValueFactory(new PropertyValueFactory<>("action"));
////
////        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, actionColumn);
//    }
//
////    public void start(Stage primaryStage) {
////        primaryStage.setTitle("CRM Application");
////
////        VBox vbox = new VBox(table);
////        Scene scene = new Scene(vbox);
////
////        primaryStage.setScene(scene);
////        primaryStage.show();
////    }
////
////    public void setTableData(ObservableList<Member> data) {
////        table.setItems(data);
////    }
//}


package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CRMView extends VBox {
    public CRMView(Member model, Runnable actionHandler) {
        VBox menu = new VBox();
        menu.setStyle("-fx-background-color: blue;");
        menu.setFillWidth(true);

        Button backBtn = new Button("Left Arrow");
        backBtn.setPrefWidth(100);
        backBtn.getStyleClass().add("custom-menu-button");

        Button infoBtn = new Button("Info");
        infoBtn.setPrefWidth(100);
        infoBtn.getStyleClass().add("custom-menu-button");

        Button newBtn = new Button("New");
        newBtn.setPrefWidth(100);
        newBtn.getStyleClass().add("custom-menu-button");

        Button openBtn = new Button("Open");
        openBtn.setPrefWidth(100);
        openBtn.getStyleClass().add("custom-menu-button");

        menu.getChildren().addAll(backBtn, infoBtn, newBtn, openBtn);

        // Ensure buttons are evenly spaced
        VBox.setVgrow(backBtn, Priority.ALWAYS);
        VBox.setVgrow(infoBtn, Priority.ALWAYS);
        VBox.setVgrow(newBtn, Priority.ALWAYS);
        VBox.setVgrow(openBtn, Priority.ALWAYS);

        HBox root = new HBox();
        root.getChildren().add(menu);
        
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        getChildren().add(root);
    }
}

