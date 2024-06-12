/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author whyyy
 */
public class HomeController implements Initializable {
    
    @FXML
    private Button event;
    
    @FXML
    private Button uni;
    
    @FXML
    private Button certificate;
    
    @FXML
    private Button myCourse;
    
    @FXML
    private Button search;
    
    @FXML
    private Button profile;
    
    
    @FXML
    private void goToEvent(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Event.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void goToUni(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Uni.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void goToSearch(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Search.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void goMyCourses(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MyCourses.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void goProfile(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void goToCertificate(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Certificate.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    String path= "/Users/whyyy/Downloads/Molim.1/Molim/src/molim/click.mp3";
    Media media =new Media(new File(path).toURI().toString());
    MediaPlayer mediaPalyer = new MediaPlayer(media);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         event.setOnMouseEntered(e -> {
            // Change  color on mouse hover
            event.setStyle("-fx-background-color: LIGHTBLUE;");
        });

        event.setOnMouseExited(e -> {
            // Reset button color
            event.setStyle("-fx-background-color: WHITE;");
        });
        
        event.setOnAction(this::goToEvent);
        
        uni.setOnMouseEntered(e -> {
            // Change  color on mouse hover
            uni.setStyle("-fx-background-color: LIGHTBLUE;");
        });

        uni.setOnMouseExited(e -> {
            // Reset button color
            uni.setStyle("-fx-background-color: WHITE;");
        });
        uni.setOnAction(this::goToUni);
        search.setOnAction(this::goToSearch);
        myCourse.setOnAction(this::goMyCourses);
        profile.setOnAction(this::goProfile);
        certificate.setOnAction(this::goToCertificate);
        
    }    
    
}
