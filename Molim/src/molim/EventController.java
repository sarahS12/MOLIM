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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class EventController implements Initializable {
    
     @FXML
    private Button certificate;
    
    @FXML
    private Button myCourse;
    
    @FXML
    private Button search;
    
    @FXML
    private Button profile;
    
    @FXML
    private Button back;
    
    @FXML
    private Button event1;
    
    @FXML
    private Button event2;
    
    @FXML
    private Button event3;
    
    @FXML
    private Button event4;
    
    public static String act="";
    
     
    @FXML
    private void goHome(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
    
    private void goToEvent(MouseEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Event1info.fxml"));
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    public void goToEvent1(MouseEvent event) {
        SearchController.sta="معرض انتبه";
        act="معرض انتبه";
        goToEvent(event);
    }
      
     public void goToEvent2(MouseEvent event) {
        SearchController.sta="احتفالية عيد الفطر المبارك";
        act="احتفالية عيد الفطر المبارك";
        goToEvent( event);
    }
      public void goToEvent3(MouseEvent event) {
        SearchController.sta="حملة كهاتين";
        act="حملة كهاتين";
       goToEvent( event);
    }
       public void goToEvent4(MouseEvent event) {
        SearchController.sta="معرض اصيل";
        act="معرض اصيلة";
        goToEvent( event);
    }
           
    String path= "/Users/whyyy/Downloads/Molim.1/Molim/src/molim/click.mp3";
    Media media =new Media(new File(path).toURI().toString());
    MediaPlayer mediaPalyer = new MediaPlayer(media);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        search.setOnAction(this::goToSearch);
        myCourse.setOnAction(this::goMyCourses);
        back.setOnAction(this::goHome);
        profile.setOnAction(this::goProfile);
        certificate.setOnAction(this::goToCertificate);
        event1.setOnMouseClicked(this::goToEvent1);
        event2.setOnMouseClicked(this::goToEvent2);
        event3.setOnMouseClicked(this::goToEvent3);
        event4.setOnMouseClicked(this::goToEvent4);
    }     
    
}
