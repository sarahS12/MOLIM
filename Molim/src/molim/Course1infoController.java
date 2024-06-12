/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
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
public class Course1infoController implements Initializable {

    Course course = new Course();
     
    StudentCourse stco;

    @FXML
    private Button signbt;
    
     @FXML
    private TextArea txdescrip;

    @FXML
    private ImageView img1;
    
    @FXML
    private Button btadd;
    
    @FXML
    private Button backToCourse1;
    
    @FXML
    private Label lbname;
    
    @FXML
    private void goUni(ActionEvent event) {
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

    
    public int compare(String  o)  {
    if (course.getCourseDate().compareTo(o) > 0) {
        // if current object is greater, then return 1.
        return 1;
    } else if (course.getCourseDate().compareTo(o) < 0) {
        // if current object is smaller, then return -1.
        return -1;
    } else {
        // if current object is equal to o, then return 0.
        return 0;
    }
}

   

   
    @FXML
    private void addTOAC(ActionEvent e){
        mediaPalyer.play();
    String d2 =LocalDate.now().toString();
    if(compare( d2)!=1)  {
        btadd.setText("ناسف انتهى التسجيل ");
        btadd.setTextFill(Color.RED);
        btadd.setStyle("-fx-background-color: #faebeb; -fx-border-color: red; -fx-border-width: 2px; -fx-background-radius: 10px; -fx-border-radius: 10px;");

        Font font = new Font("29LT Bukra Bold", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
           btadd.setFont(font);
        btadd.setVisible(true); 
        
    } else if(DB.getObject("SELECT coursename FROM StudentCourse WHERE st_id= ? AND  coursename= ? AND courseDescription= ?", Nowid.id , course.getCourseName(), course.getCourseDescription()) == null){
        
        stco = null;
        //if (DB.getObject("SELECT Coursename FROM studentCourse WHERE st_id = ? AND coursename = ? AND courseDescription = ?", Nowid.id, course.getCourseName(), course.getCourseDescription()) == null)

                //  {
            stco = new StudentCourse();
            stco.setCoursename(course.getCourseName());
            stco.setCourseDescription(course.getCourseDescription());
            stco.setCourseDate(course.getCourseDate());
            stco.setStudent(Nowid.id); // Nowid.id
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(stco);
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
 }

    
    @FXML
    private void bthide(KeyEvent event){
          mediaPalyer.play();
          System.out.print( (event.getCode()==KeyCode.ENTER));
        // btadd.setVisible(false);
        }  
    
   
    String path= "/Users/whyyy/Downloads/Molim.1/Molim/src/molim/click.mp3";
    Media media =new Media(new File(path).toURI().toString());
    MediaPlayer mediaPalyer = new MediaPlayer(media);
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String cos=UniController.co; 
   
        System.out.println(cos);

       
//Session session = HibernateUtil.getSessionFactory().openSession();
//Query query = session.createQuery("FROM Activities WHERE activitiesId = 2");
//ac= (Activities)query.uniqueResult();
//session.close();

 
   
        course=(Course)DB.getObject("FROM Course WHERE courseName= ?",cos);
        lbname.setText(course.getCourseName());
        img1.setImage(new Image(course.getImgurl()));
        txdescrip.setText(course.getCourseDescription());

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
        backToCourse1.setOnAction(this::goUni);
    }   
    
    
//    public void addac(){
//        if(check(course.getCourseName(),course.getCourseDescription()).getCoursename()!=null){
//            btadd.setText("قمت بإضافة الدورة مسبقا");
//            btadd.setTextFill(Color.RED);
//            btadd.setFont(Font.font("Times New Roman", 12));
//               
//            btadd.setVisible(true); 
//              
//           }
//         else{
//        StudentCourse stco=new  StudentCourse();
//        
//        stco.setCoursename(course.getCourseName());
//        stco.setCourseDescription(course.getCourseDescription());
//        stco.setCourseDate(course.getCourseDate());
//        
//        stco.setStudent(Nowid.id);  //  Nowid.id)
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(stco);
//        tx.commit();
//        session.close();
//        btadd.setVisible(true);
//       
//           }
//    }
//     
//     
//     public StudentCourse check(String setCoursename ,String setCourseDescription){
//      StudentCourse stco=(StudentCourse)DB.getObject("FROM studentCourse WHERE st_id= ? AND  coursename= ? and courseDescription= ?",
//                 Nowid.id,setCoursename , setCourseDescription);
//         return stco;
//         
//     }     
    
}
