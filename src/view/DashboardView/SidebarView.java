package view.DashboardView;

import controller.CRMController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

public class SidebarView extends VBox {
    private Button homeButton;
    private Button logsButton;
    private Button appointmentButton;
    private Button contactButton;
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

        logsButton = new Button("Logs");
        logsButton.setMaxWidth(Double.MAX_VALUE);
        logsButton.getStyleClass().add("custom-menu-button");

        appointmentButton = new Button("Appointment");
        appointmentButton.setMaxWidth(Double.MAX_VALUE);
        appointmentButton.getStyleClass().add("custom-menu-button");

        contactButton = new Button("Contact");
        contactButton.setMaxWidth(Double.MAX_VALUE);
        contactButton.getStyleClass().add("custom-menu-button");

        logoutButton = new Button("Logout");
        logoutButton.setMaxWidth(Double.MAX_VALUE);
        logoutButton.getStyleClass().add("custom-menu-button");

        homeButton.setOnAction(e -> controller.navigateToHome());
        logsButton.setOnAction(e -> controller.navigateToLogs());
        appointmentButton.setOnAction(e -> controller.navigateToAppointments());
        contactButton.setOnAction(e -> controller.navigateToContacts());
        logoutButton.setOnAction(e -> controller.logout());

        this.getChildren().addAll(logo, homeButton, logsButton, appointmentButton, contactButton, logoutButton);
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public Button getLogsButton() {
        return logsButton;
    }

    public Button getAppointmentButton() {
        return appointmentButton;
    }

    public Button getContactButton() {
        return contactButton;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }
}
