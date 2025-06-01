package view.DashboardView;

import controller.CRMController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class SidebarView extends VBox {
    private Button homeButton;
    private Button employeeLogsButton;
    private Button appointmentButton;
    private Button salesRecordButton;
    private Button logoutButton;
    private CRMController controller;

    public SidebarView(CRMController controller) {
        this.controller = controller;
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.setStyle("-fx-background-color: #6A1B9A;");

        Text logo = new Text("CRM App");
        logo.setFill(Color.WHITE);
        logo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        homeButton = new Button("Home");
        homeButton.setMaxWidth(Double.MAX_VALUE);
        homeButton.getStyleClass().add("custom-menu-button");

        employeeLogsButton = new Button("Employees");
        employeeLogsButton.setMaxWidth(Double.MAX_VALUE);
        employeeLogsButton.getStyleClass().add("custom-menu-button");

        appointmentButton = new Button("Appointment");
        appointmentButton.setMaxWidth(Double.MAX_VALUE);
        appointmentButton.getStyleClass().add("custom-menu-button");

        salesRecordButton = new Button("Sales Report");
        salesRecordButton.setMaxWidth(Double.MAX_VALUE);
        salesRecordButton.getStyleClass().add("custom-menu-button");

        logoutButton = new Button("Logout");
        logoutButton.setMaxWidth(Double.MAX_VALUE);
        logoutButton.getStyleClass().add("custom-menu-button");

        homeButton.setOnAction(e -> controller.navigateToHome());
        employeeLogsButton.setOnAction(e -> controller.navigateToEmployeeLogs());
        appointmentButton.setOnAction(e -> controller.navigateToAppointments());
        salesRecordButton.setOnAction(e -> controller.navigateToSalesRecord());
        logoutButton.setOnAction(e -> controller.logout());

        this.getChildren().addAll(logo, homeButton, employeeLogsButton, appointmentButton, salesRecordButton, logoutButton);
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public Button getemployeeLogsButton() {
        return employeeLogsButton;
    }

    public Button getAppointmentButton() {
        return appointmentButton;
    }

    public Button getSalesRecordButton() {
        return salesRecordButton;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }
}
