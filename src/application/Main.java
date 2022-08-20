package application;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	// BROWSER
    	WebView browser = new WebView();
    	browser.getEngine().load("http://google.com");
    	
    	// BARRA DE PESQUISA
    	Button voltar = new Button("<");
    	Button recarregar = new Button("@");
    	TextField urlBar = new TextField();
    	Button go = new Button("Go");
    	
    	recarregar.getStyleClass().add("botoes");
    	voltar.getStyleClass().add("botoes");
    	go.getStyleClass().add("botoes");
    	urlBar.getStyleClass().add("urlbar");
    	
    	recarregar.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	        
    	    	browser.getEngine().reload();
    	    	
    	    }
    	});
    	
    	go.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	        
    	    	browser.getEngine().load("https://www.google.com/search?q=" + urlBar.getText());
    	    	
    	    }
    	});

    	
    	HBox hBox = new HBox(voltar,recarregar,urlBar, go);

    	// SCENE STAGE
    	VBox vBox = new VBox(hBox, browser);
    	Scene scene = new Scene(vBox, 800, 500);
    	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Godzilla Giroflex");
        primaryStage.show();
    	
    }
}