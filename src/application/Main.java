package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("static-access")
	@Override
    public void start(Stage primaryStage) {
    	
    	WebEngine classEngine = new WebEngine();
    	classEngine.createNewTab();
    	
    	Interface classInterface = new Interface();
    	classInterface.createInterface(classEngine.getBrowser());
    	


    	VBox vBox = new VBox(classInterface.getNavbarBox(), classEngine.getBrowser());
    	vBox.setVgrow(classEngine.getBrowser(), Priority.ALWAYS);
    	Scene scene = new Scene(vBox, 800, 500);
    	scene.getStylesheets().add(getClass().getResource("primaryStageStyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Godzilla Giroflex");
        primaryStage.show();
    	
    }
}