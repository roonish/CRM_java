package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;
import javafx.util.Callback;
import model.CustomerMoment;

import java.util.Arrays;
import java.util.List;

public class HomeView extends BorderPane {
    public HomeView(String userName) {
        VBox content = new VBox(10);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.CENTER);

        // Greeting
        Text greeting = new Text("Hello, " + userName);
        greeting.setStyle("-fx-font-size: 18px;");

        // Sales Report
        Text salesReportTitle = new Text("Sales Report");
        salesReportTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Day of the Week");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Sales");

        BarChart<String, Number> salesChart = new BarChart<>(xAxis, yAxis);
        salesChart.setTitle("Sales Report for the Week");

        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.setName("Sales");

        // Mock sales data
        dataSeries.getData().add(new XYChart.Data<>("Sun", 10));
        dataSeries.getData().add(new XYChart.Data<>("Mon", 15));
        dataSeries.getData().add(new XYChart.Data<>("Tue", 20));
        dataSeries.getData().add(new XYChart.Data<>("Wed", 25));
        dataSeries.getData().add(new XYChart.Data<>("Thu", 30));
        dataSeries.getData().add(new XYChart.Data<>("Fri", 35));
        dataSeries.getData().add(new XYChart.Data<>("Sat", 40));

        salesChart.getData().add(dataSeries);

        // Customer Moments
        Text customerMomentsTitle = new Text("Customer Moments");
        customerMomentsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Mock customer moments
        List<CustomerMoment> customerMoments = Arrays.asList(
                new CustomerMoment("John Doe", "01/01/2024", "5", "john.doe@example.com"),
                new CustomerMoment("Jane Smith", "01/02/2024", "4", "jane.smith@example.com"),
                new CustomerMoment("Bob Johnson", "01/03/2024", "3", "bob.johnson@example.com")
        );

        TableView<CustomerMoment> customerMomentsTable = new TableView<>();
        customerMomentsTable.setItems(FXCollections.observableArrayList(customerMoments));
        customerMomentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<CustomerMoment, String> customerColumn = new TableColumn<>("Customer");
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));

        TableColumn<CustomerMoment, String> enrolledColumn = new TableColumn<>("Enrolled");
        enrolledColumn.setCellValueFactory(new PropertyValueFactory<>("enrolled"));

        TableColumn<CustomerMoment, String> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        ratingColumn.setCellFactory(new Callback<TableColumn<CustomerMoment, String>, TableCell<CustomerMoment, String>>() {
            @Override
            public TableCell<CustomerMoment, String> call(TableColumn<CustomerMoment, String> param) {
                return new TableCell<CustomerMoment, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            int rating = Integer.parseInt(item);
                            StringBuilder stars = new StringBuilder();
                            for (int i = 0; i < 5; i++) {
                                if (i < rating) {
                                    stars.append("★");
                                } else {
                                    stars.append("☆");
                                }
                            }
                            setText(stars.toString());
                        }
                    }
                };
            }
        });

        TableColumn<CustomerMoment, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        customerMomentsTable.getColumns().addAll(customerColumn, enrolledColumn, ratingColumn, emailColumn);

        content.getChildren().addAll(greeting, salesReportTitle, salesChart, customerMomentsTitle, customerMomentsTable);
        setCenter(content);
    }
}
