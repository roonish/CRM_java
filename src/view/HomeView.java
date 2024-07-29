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
import model.CustomerDetail;

import java.util.Arrays;
import java.util.List;

public class HomeView extends BorderPane {
    public HomeView(String userName) {
        VBox content = new VBox(20); // Increased vertical spacing
        content.setPadding(new Insets(20)); // Increased padding

        // Greeting
        Text greeting = new Text("Hello, " + userName);
        greeting.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");
        greeting.setTextAlignment(javafx.scene.text.TextAlignment.LEFT);
        
        // Sales Report Title
        Text salesReportTitle = new Text("Sales Report");
        salesReportTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Sales Report Bar Chart
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

        // Container for Sales Report
        VBox salesContainer = new VBox(10);
        salesContainer.setPadding(new Insets(20)); // Increased padding
        salesContainer.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        salesContainer.getChildren().addAll(salesReportTitle, salesChart);

        // Customer Moments Title
        Text customerMomentsTitle = new Text("Customer Moments");
        customerMomentsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Mock customer moments
        List<CustomerDetail> customerMoments = Arrays.asList(
                new CustomerDetail("John Doe", "01/01/2024", "5", "john.doe@example.com"),
                new CustomerDetail("Jane Smith", "01/02/2024", "4", "jane.smith@example.com"),
                new CustomerDetail("Bob Johnson", "01/03/2024", "3", "bob.johnson@example.com")
        );

        TableView<CustomerDetail> customerMomentsTable = new TableView<>();
        customerMomentsTable.setItems(FXCollections.observableArrayList(customerMoments));
        customerMomentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<CustomerDetail, String> customerColumn = new TableColumn<>("Customer");
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));

        TableColumn<CustomerDetail, String> enrolledColumn = new TableColumn<>("Enrolled");
        enrolledColumn.setCellValueFactory(new PropertyValueFactory<>("enrolled"));

        TableColumn<CustomerDetail, String> ratingColumn = new TableColumn<>("Rating");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        ratingColumn.setCellFactory(new Callback<TableColumn<CustomerDetail, String>, TableCell<CustomerDetail, String>>() {
            @Override
            public TableCell<CustomerDetail, String> call(TableColumn<CustomerDetail, String> param) {
                return new TableCell<CustomerDetail, String>() {
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

        TableColumn<CustomerDetail, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        customerMomentsTable.getColumns().addAll(customerColumn, enrolledColumn, ratingColumn, emailColumn);

        // Container for Customer Moments
        VBox customerMomentsContainer = new VBox(10);
        customerMomentsContainer.setPadding(new Insets(20)); // Increased padding
        customerMomentsContainer.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        customerMomentsContainer.getChildren().addAll(customerMomentsTitle, customerMomentsTable);

        // Add everything to the main content
        content.getChildren().addAll(greeting, salesContainer, customerMomentsContainer);
        setCenter(content);
    }
}


