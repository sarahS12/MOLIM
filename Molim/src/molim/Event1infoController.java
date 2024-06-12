/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class Event1infoController implements Initializable {

    @FXML
    private Button backToEvent1;
        
    Activities ac = new Activities();
    StudentActivity stac;

  //  List<Studentactivity> myac;
    
    @FXML
    private Button signbt;
    
    @FXML
    private TextArea txdescrip;

    @FXML
    private ImageView img1;
    @FXML
    private Button btadd;
    @FXML
    private Label lbname;
    
    @FXML
    private void goEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Event.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public int compare(String  o)  {
    if (ac.getActivitiesdate().compareTo(o) > 0) {
        // if current object is greater, then return 1.
        return 1;
    } else if (ac.getActivitiesdate().compareTo(o) < 0) {
        // if current object is smaller, then return -1.
        return -1;
    } else {
        // if current object is equal to o, then return 0.
        return 0;
    }
    
    }
    
    @FXML
    private void addTOAC(ActionEvent e){
        String d2 =LocalDate.now().toString(); 
        if(compare(d2)!=1)  {
        btadd.setText("ناسف انتهى التسجيل ");
        btadd.setTextFill(Color.RED);
        btadd.setStyle("-fx-background-color: #faebeb; -fx-border-color: red; -fx-border-width: 2px; -fx-background-radius: 10px; -fx-border-radius: 10px;");

        Font font = new Font("29LT Bukra Bold", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
        btadd.setFont(font);
               
        btadd.setVisible(true); 
        } else if (DB.getObject("FROM StudentActivity WHERE st_id = ? AND activitiesName= ? AND activities_description= ?", Nowid.id, ac.getActivitiesName(), ac.getActivitiesDescription()) == null) {
            
            stac=new  StudentActivity();
            stac.setActivitiesName(ac.getActivitiesName());
            stac.setActivitiesDescription(ac.getActivitiesDescription());
            stac.setActivitiesdate(ac.getActivitiesdate());

            stac.setStudent(Nowid.id);  //  Nowid.id)
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(stac);
            tx.commit();
            session.close();
            btadd.setVisible(true);
            }else{
      btadd.setText("قمت بإضافة الدورة مسبقا");
      btadd.setTextFill(Color.RED);
      Font font = new Font("29LT Bukra Bold", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
      btadd.setFont(font);
               
              btadd.setVisible(true); 
        }
        
    
    
    String path= "/Users/whyyy/Downloads/Molim.1/Molim/src/molim/click.mp3";
    Media media =new Media(new File(path).toURI().toString());
    MediaPlayer mediaPalyer = new MediaPlayer(media);
    
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String acs= EventController.act; 
        System.out.println(acs);
        ac = (Activities)DB.getObject("FROM Activities WHERE activitiesName= ?", acs);
     
        if (ac != null) {
            // Access or manipulate the ac variable
            lbname.setText(ac.getActivitiesName());
            img1.setImage(new Image(ac.getImgurl()));
            txdescrip.setText(ac.getActivitiesDescription());
        }else{
            lbname.setText(ac.getActivitiesName());
            img1.setImage(new Image(ac.getImgurl()));
            txdescrip.setText(ac.getActivitiesDescription());
        }
        
//        lbname.setText(ac.getActivitiesName());
//        img1.setImage(new Image(ac.getImgurl()));
//        txdescrip.setText(ac.getActivitiesDescription());
  
        signbt.setOnMouseEntered(e -> {
            // Change  color on mouse hover
            signbt.setStyle("-fx-background-color: #091c5b; -fx-background-radius: 20");
        });
        
        signbt.setOnMouseExited(e -> {
            // Change  color on mouse hover
            signbt.setStyle("-fx-background-color:#42A8B4; -fx-background-radius: 20 ");
        });
 
        btadd.setOnMouseEntered(e -> {
            // Change  color on mouse hover
            btadd.setVisible(false);
        });
        backToEvent1.setOnAction(this::goEvent);
    }   
    
    
//     public void addac(){
//   
////      String s=lbname.getText();
//        //Studentactivity;
//        
//      //  if (check(ac.getActivitiesName(),ac.getActivitiesDescription()))
//            if(check(ac.getActivitiesName(),ac.getActivitiesDescription()).getActivitiesName()!=null){
//               btadd.setText("قمت ياضافة الفعالية مسبقا");
//               btadd.setTextFill(Color.RED);
//               btadd.setFont(Font.font("Times New Roman", 12));
//               
//              btadd.setVisible(true); 
//              
//           }else{
//                StudentActivity stac=new  StudentActivity();
//                stac.setActivitiesName(ac.getActivitiesName());
//                stac.setActivitiesDescription(ac.getActivitiesDescription());
//                stac.setActivitiesdate(ac.getActivitiesdate());
//
//                stac.setStudent(18);  //  Nowid.id)
//                Session session = HibernateUtil.getSessionFactory().openSession();
//                session = HibernateUtil.getSessionFactory().openSession();
//                Transaction tx = session.beginTransaction();
//                session.save(stac);
//                tx.commit();
//                session.close();
//                btadd.setVisible(true);
//            }
//    }
//     
//       public  StudentActivity  check(String setCoursename ,String setCourseDescription){
//           StudentActivity  stco=( StudentActivity )DB.getObject("FROM studentactivity WHERE st_id= ? AND  activitiesName = ? and activities_description = ?",
//                 18, setCoursename , setCourseDescription);
//         return stco;
//         
//     }  

    
}
