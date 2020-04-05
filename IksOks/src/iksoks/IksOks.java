/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iksoks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lukak
 */
public class IksOks extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //root.getStylesheets().add("iksoks.CSS\\css.css");
                
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("MainWindowCSS.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setTitle("Iks Oks");
        stage.setMaxHeight(265.0);
        stage.setMaxWidth(500.0);
        stage.setMinHeight(265.0);
        stage.setMinWidth(500);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
