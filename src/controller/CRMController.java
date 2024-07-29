package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import util.CRMInteractor;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import view.*;
import view.DashboardView.SidebarView;
import view.LogsView.LogsView;
import view.RecordView.RecordView;

public class CRMController {
    private BorderPane view;
    private String userName;
    private Stage stage;

    public CRMController(Stage stage, String userName) {
        this.userName = userName;
        this.view = new BorderPane();
        this.stage = stage;

        SidebarView sidebar = new SidebarView(this);
        this.view.setLeft(sidebar);

        // Set initial view to HomeView
        setView(new HomeView(userName));

        Scene scene = new Scene(this.view, 800, 600);
        stage.setScene(scene);
        stage.setTitle("CRM Dashboard");
        stage.show();
    }

    public BorderPane getView() {
        return view;
    }

    public void setView(Node newView) {
        this.view.setCenter(newView);
    }

    public void navigateToHome() {
        setView(new HomeView(userName));
    }

    public void navigateToLogs() {
        setView(new LogsView(new CRMInteractor()));
    }

    public void navigateToAppointments() {
        setView(new AppointmentView());
    }

    public void navigateToSalesRecord() {
        setView(new RecordView());
    }

    public void logout() {
        new LoginController(stage);
    }
}

