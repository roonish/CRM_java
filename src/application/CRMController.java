//package application;
//
//import javafx.scene.layout.Region;
//
//public class CRMController {
//    private CRMView view;
//
//    public CRMController() {
////        this.view = view;
////        initializeData();
//    	  Member viewMember = new Member("Cute Samridhi ", "+1-437-422-4578", "cute.samridhi@gmail.com");
//    	  CRMInteractor interactor = new CRMInteractor(viewMember);
//          view = new CRMView(viewMember, interactor::addFive);
//    }
//    
//    public Region getView() {
//        return view;
//    }
//
////    private void initializeData() {
////        ObservableList<Member> data = FXCollections.observableArrayList(
////            new Member("Cute Samridhi ", "+1-437-422-4578", "cute.samridhi@gmail.com"),
////            new Member("Ronish Siwakoti", "+1-437-432-4650", "ronish.siwakoti@gmail.com"),
////            new Member("Balpreet Guffadi", "+1-354-837-8523", "balpreet.guffadi@email.com")
////            // Add more members here
////        );
////        view.setTableData(data);
////    }
//}


package application;

import javafx.scene.layout.Region;

public class CRMController {
    private CRMView view;

    public CRMController() {
        Member viewMember = new Member("Cute Samridhi ", "+1-437-422-4578", "cute.samridhi@gmail.com");
        CRMInteractor interactor = new CRMInteractor(viewMember);
        view = new CRMView(viewMember, interactor::addFive);
    }

    public Region getView() {
        return view;
    }
}
