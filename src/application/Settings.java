package application;

import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings {
    
	
    public void createSettings() {
    	Stage settingsStage = new Stage();
    	
    	Label title = new Label("Configurações");
    	title.getStyleClass().add("title");
    	
    	CheckBox optionFavorites = new CheckBox("Barra de Favoritos");
    	
    	VBox settingsBox = new VBox(title,optionFavorites);
    	settingsBox.setSpacing(20);
    	settingsBox.getStyleClass().add("settingsBox");
    	optionFavorites.getStyleClass().add("checkBox");
    	
    	Scene settingsScene = new Scene(settingsBox, 300, 400);
    	settingsScene.getStylesheets().add(getClass().getResource("settingsStageStyle.css").toExternalForm());
    	settingsStage.setScene(settingsScene);
    	settingsStage.setTitle("Configurações");
    	settingsStage.show();
    }
}
