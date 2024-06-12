/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.io.IOException;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class LoginController implements Initializable {

    @FXML
    private Button login;
    
    @FXML
    private Button newUser;
    
    @FXML        
    private TextField st_email;
    
    @FXML        
    private PasswordField st_password;
    
    @FXML        
    private Label msg;
    
    private Student stu;
    
    @FXML 
    private ImageView logo;
    
//    if (PhoneNo.getText().isEmpty()) {
//                msg.setText("Enter the customer mobile number to print invoice.");
//            } else if (obCustomerMobiles.isEmpty()) {
//                msg.setText("No customers in the list.");
//            } else if (!obCustomerMobiles.contains(PhoneNo.getText())) {
//                msg.setText("The customer not found.");
//            } else {
    
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        
            mediaPalyer.play();
        
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session1.beginTransaction();
            Query query = session1.createQuery("from Student");
            List<Student> stList= query.list();
            System.out.println("connection suceeded");
            t.commit();
            session1.close();

            if (st_email.getText().isEmpty() && st_password.getText().isEmpty()) {
                msg.setText("يرجى تعبئة جميع الحقول.");
                return;
            }
            else if (st_email.getText().isEmpty() && !st_password.getText().isEmpty()) {
                msg.setText("يرجى أدخل بريدك الإلكتروني.");
                return;
            }
            else if (st_email.getText().isEmpty() && !st_password.getText().isEmpty() ) {
                msg.setText("من فضلك أدخل رقمك السري.");
                return;
            }
            
            else if (!(st_email.getText().contains("@")|| st_email.getText().contains("."))) {
                st_email.clear();
                msg.setText("يرجى إدخال البريد الإلكتروني الصحيح.");
                return;
            }
            
            else if(stList.isEmpty()){
                msg.setText("لا يوجد حساب بهذا البريد الإلكتروني ، يرجى التسجيل.");
                return;
            } else {
                for(Student i : stList){
                    stu=i;
                    if ((i != null) && i.getStEmail().equals(st_email.getText())) {
                        if (i.getStPassword().equals(st_password.getText())) {
                        Nowid.id=stu.getStId();
                        goToHome(event);
                        
                        }else{
                            msg.setText("كلمة سر خاطئة! من فضلك أدخل رقمك السري");
                            return;
                        }
                    }
                }
                if(!stu.getStEmail().equals(st_email.getText())){
                    msg.setText("لا يوجد حساب بهذا البريد الإلكتروني ، يرجى التسجيل.");
                    return;
                }
            }
    }
            
 
    
    @FXML
    private void goToSignUp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void goToHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
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
        newUser.setOnAction(this::goToSignUp);
        
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(logo);
        translate.setDuration(Duration.millis(1500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(-20);
        translate.setAutoReverse(true);
        translate.play();

        
    }
}

   
