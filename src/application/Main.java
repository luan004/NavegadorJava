package application;

import javax.print.DocFlavor.URL;
import javax.swing.Box;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
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

    @Override
    public void start(Stage primaryStage) {
    	
    	// BROWSER
    	WebView browser = new WebView();
    	java.net.URL url = this.getClass().getResource("/resources/novaguia.html");
    	browser.getEngine().load(url.toString());
    	
    	// BARRA DE PESQUISA
    	Button voltar = new Button("", new ImageView("/resources/back.png"));
    	Button recarregar = new Button("", new ImageView("/resources/reload.png"));
    	TextField urlBar = new TextField();
    	
    	voltar.setMinSize(30, 30);
    	recarregar.setMinSize(30, 30);
    	urlBar.setMinHeight(30);
    	
    	recarregar.getStyleClass().add("botoes-navbar");
    	voltar.getStyleClass().add("botoes-navbar");
    	urlBar.getStyleClass().add("urlbar");
    	
    	
    	voltar.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	        
    	    	browser.getEngine().executeScript("history.back()");
    	    	
    	    }
    	});
    	
    	recarregar.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override public void handle(ActionEvent e) {
    	        
    	    	browser.getEngine().reload();
    	    	
    	    }
    	});
    	

    	urlBar.setOnKeyPressed(new EventHandler<KeyEvent>() {
    	    @Override
    	    public void handle(KeyEvent ke) {
    	        if (ke.getCode().equals(KeyCode.ENTER)) {
        	    	if (urlBar.getText() == "") {
        	    		System.out.println("Nada");
        	    	}
        	    	else if (urlBar.getText().contains(".") && urlBar.getText().endsWith(".") == false) {
        	    		browser.getEngine().load("https://" + urlBar.getText());
        	    		System.out.println("Site");
        	    	}
        	    	else {
        	    		browser.getEngine().load("https://www.google.com/search?q=" + urlBar.getText());
        	    		System.out.println("Pesquisa");
        	    	}
        	        
    	        }
    	    }
    	});

    	
    	HBox navbarBox = new HBox(voltar,recarregar,urlBar);
    	navbarBox.setHgrow(urlBar, Priority.ALWAYS);
    	
    	navbarBox.setSpacing(5);
    	navbarBox.getStyleClass().add("navbar");

    	// SCENE STAGE
    	VBox vBox = new VBox(navbarBox, browser);
    	Scene scene = new Scene(vBox, 800, 500);
    	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Godzilla Giroflex");
        primaryStage.show();
    	
    }
}