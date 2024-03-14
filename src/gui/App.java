package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import dominio.Farmacia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {

        AnchorPane root;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
            Scene scene = new Scene(root);


            stage.setScene(scene);
            stage.setTitle("Farmacia");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * @param args the command line arguments
         */

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
