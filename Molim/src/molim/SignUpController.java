/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.io.IOException;

/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class SignUpController implements Initializable {

    @FXML        
        private TextField st_name;
    @FXML
        private TextField st_id;
    @FXML        
        private TextField st_email;
    @FXML        
        private PasswordField st_password;
    @FXML        
        private Label msg;
    
    @FXML        
    private Button save;
    
    
    @FXML
    private void signup (ActionEvent event) {
        mediaPalyer.play();
        
        String name = st_name.getText();
        String id = st_id.getText();
        String email = st_email.getText();
        String password = st_password.getText();
        
     if (email.isEmpty() || id.isEmpty() || name.isEmpty() || password.isEmpty()) {
        msg.setText("يرجى تعبئة جميع الحقول.");
        return;
    }

    // Check email format
    else if (!email.contains("@") || !email.contains(".")) {
        msg.setText("يرجى إدخال البريد الإلكتروني الصحيح.");
        return;
        
//    }else if (DB.getObject("FROM Student SELECT stId = ?", id.contains(st_id.getText()))){
//        msg.setText("يرجى إدخال البريد الإلكتروني الصحيح.");
//        return;
    } else {
        
        Student st = new Student();
        st.setStName(name);
        st.setStId(Integer.parseInt(id));
        st.setStEmail(email);
        st.setStPassword(password);
        Nowid.id = st.getStId();

    
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(st);

        session.getTransaction().commit();
        session.close();
        
        msg.setText(".تم تسجيل المستخدم بنجاح");
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("نجاح");
        alert.setHeaderText(null);
        alert.setContentText(".تم تسجيل المستخدم بنجاح");
        alert.showAndWait();
        
        goToLogin(event);
    }
    }
    
    @FXML
    private void goToLogin(ActionEvent event) {
        try {
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
    public void initialize(URL location, ResourceBundle resources) {
        //save.setOnAction(this::goToLogin);
        
    }
}
     
