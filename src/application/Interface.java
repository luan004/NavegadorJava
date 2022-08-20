package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebView;

public class Interface {
	
	private HBox navbarBox = new HBox();
	
	@SuppressWarnings("static-access")
	public void createInterface(WebView browser) {
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
        	    	
        	    	urlBar.setText(browser.getEngine().getLocation());
        	        
    	        }
    	    }
    	});

    	
    
    	navbarBox.getChildren().addAll(voltar,recarregar,urlBar);
    	navbarBox.setHgrow(urlBar, Priority.ALWAYS);
    	navbarBox.setSpacing(5);
    	navbarBox.getStyleClass().add("navbar");
	}
	
	private void interfaceActions() {}

	public HBox getNavbarBox() {
		return navbarBox;
	}

	public void setNavbarBox(HBox navbarBox) {
		this.navbarBox = navbarBox;
	}
	
	

}
