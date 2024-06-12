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
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class ProfileController implements Initializable {
    
    Student st = new Student();
    
    @FXML
    private Label name;
    
    @FXML
    private Label stNo;
   
    @FXML
    private Label email;
    
    @FXML
    private Button back;
    
    @FXML
    private Button logout;
    
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
    private void logout(ActionEvent event) {
        try {
            mediaPalyer.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
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
        back.setOnAction(this::goHome);
        
        Student st=(Student)DB.getObject("FROM Student WHERE stId = ?", Nowid.id);
        if (st!=null){
            name.setText(st.getStName());
            stNo.setText(String.valueOf(st.getStId()));
            email.setText(st.getStEmail());
            System.out.println(st.getStEmail());
        }
        back.setOnAction(this::goHome);
        logout.setOnAction(this::logout);
    }  
}  

