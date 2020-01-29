package jac444.wk6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author sahil
 * This is the main class that will load the GUI on the screen
 */
public class StudentApp extends Application {
//	private StudentDataAcessor dataAccessor ;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Student Application");
        primaryStage.setScene(new Scene(root, 700, 500));
/**
 * creates column inside the table view on load and lets the user edit the values by double clicking the values in the tableview row
 */
        TableView<Student> table = (TableView) primaryStage.getScene().lookup("#tblStudents");
        table.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name")
        );

		TableColumn courseCol = new TableColumn("Course");
        courseCol.setMinWidth(200);
        courseCol.setCellValueFactory(
                new PropertyValueFactory<Student, String>("course")
        );

        TableColumn gradeCol = new TableColumn("Grade");
        gradeCol.setMinWidth(200);
        gradeCol.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("grade")
        );


        table.getColumns().addAll(idCol, nameCol, courseCol, gradeCol);
//        table.getItems().addAll(dataAccessor.getStudentList());

        primaryStage.show();
    }
    


    /**
     * Main method to launch the application
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
