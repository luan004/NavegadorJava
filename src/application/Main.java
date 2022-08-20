package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
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
    	Scene scene = new Scene(vBox, 800, 500);
    	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Godzilla Giroflex");
        primaryStage.show();
    	
    }
}