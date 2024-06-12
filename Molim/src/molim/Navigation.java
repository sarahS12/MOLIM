/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package molim;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author whyyy
 */
public class Navigation {
    
    // to change scene
    public static void changeScene(Event event, String sceneURL) throws IOException {

        Parent root = FXMLLoader.load(Navigation.class.getResource(sceneURL));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchAccount(ActionEvent event) throws IOException {
        changeScene(event, "Account.fxml");
    }

    @FXML
    public void switchSearch(ActionEvent event) throws IOException {
        changeScene(event, "\"file:/Users/whyyy/Desktop/Uni/CS/Year%203/Term%203/AdvProg/Prac/Project/Project1/src/project1/Search.fxml");
    }

    @FXML
    public void switchCourse(ActionEvent event) throws IOException {
        changeScene(event, "Course.fxml");
    }

    @FXML
    public void switchCertficate(ActionEvent event) throws IOException {
        changeScene(event, "Certficate.fxml");
    }

    @FXML
    public void switchUni(ActionEvent event) throws IOException {
        changeScene(event, "Uni.fxml");
    }
    
    @FXML
    public void switchEvent(ActionEvent event) throws IOException {
        changeScene(event, "Event.fxml");
    }
}
