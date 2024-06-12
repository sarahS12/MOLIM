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
public class UniController implements Initializable {

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
    private Button course1;
    
    @FXML
    private Button course2;
    
    @FXML
    private Button course3;
    
    @FXML
    private Button course4;
    
    public static String co;
    
     
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
    
    @FXML
    private void goCertificate(ActionEvent event) {
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
    
    private void goToCourse1(MouseEvent event) {
        SearchController.co="التأمين بشكل عام";
        co="التأمين بشكل عام";
        goToCourse( event);
    }
     private void goToCourse2(MouseEvent event) {
        SearchController.co="فن إدارة الوقت";
        co="فن إدارة الوقت";
        goToCourse( event);
    }
      private void goToCourse3(MouseEvent event) {
        SearchController.co="تقنية البحث في مصادر المعلومات";
        co="تقنية البحث في مصادر المعلومات";
        goToCourse( event);
    }
       private void goToCourse4(MouseEvent event) {
        SearchController.co="التمكين الشخصي";
        co="التمكين الشخصي";
        goToCourse( event);
    }
    
   private void goToCourse(MouseEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Course1info.fxml"));
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
        search.setOnAction(this::goToSearch);
        myCourse.setOnAction(this::goMyCourses);
        back.setOnAction(this::goHome);
        profile.setOnAction(this::goProfile);
        certificate.setOnAction(this::goCertificate);
        course1.setOnMouseClicked(this::goToCourse1);
        course2.setOnMouseClicked(this::goToCourse2);
        course3.setOnMouseClicked(this::goToCourse3);
        course4.setOnMouseClicked(this::goToCourse4);
       
        
    }      
    
}    
    

