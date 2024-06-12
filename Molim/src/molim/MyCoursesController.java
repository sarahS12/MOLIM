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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class MyCoursesController implements Initializable {

    @FXML
    private Label lbno;
    
    @FXML
    private ToggleButton tog2;

    @FXML
    private ToggleButton  tog1;
    @FXML
    private Button back;
    
// #0c1c49
    @FXML
    private void goHome(ActionEvent event) {
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
  
        Button bt ;
  List<StudentCourse> course;
   List<StudentActivity> activ;
  
  @FXML
   private  VBox v= new VBox();
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        if(!getlistco(18).isEmpty()){
            course=getlistco(18);
      displayCourse(course);}
      
//         if(!getlistac(18).isEmpty()){
//            activ=getlistac(18);
//      displayactivity(activ);}
//        
       
        back.setOnAction(this::goHome);
      
    
}
public void displayCourse(  List<StudentCourse> stcourse){
    
     {
           v.getChildren().clear();
            for(int i=0;i<stcourse.size();i++){
          Rectangle rec =new  Rectangle(200,90);

      rec.setFill(Color.valueOf("#42A8B4"));  
      rec.setArcHeight(20);
       rec.setArcWidth(20);
       rec.setOpacity(0.4);
      Text t=new Text();
     
     Label l=new Label(stcourse.get(i).getCoursename());
           // l.setAlignment(Pos.CENTER_RIGHT);
           l.setTextAlignment(TextAlignment.RIGHT);
           l.setAlignment(Pos.CENTER_RIGHT);
           l.prefWidth(190);
           l.prefHeight(30);
           
           Font font = new Font("29LT Bukra Regular", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
           l.setFont(font);
     
         l.setPadding(new Insets(20,0,0,40));
            bt =new Button("المزيد");
            
            bt.setFont(font);
           
            bt.setAlignment(Pos.CENTER_RIGHT);
            bt.setStyle("-fx-background-color: #FEFFF3; -fx-background-radius:20");
           bt.setTranslateX(80);
            bt.setTranslateY(50);
    VBox vt= new VBox();
            
  vt.setAlignment(Pos.CENTER_RIGHT);
    vt.setPadding(new Insets(0,0,0,30));
            vt.getChildren().addAll(l);
             Pane p=new Pane();
           p.setPadding(new Insets(0,0,0,10));
              p.getChildren().addAll(rec,vt,bt);
 
            v.setPadding(new Insets(10,0,0,10));
             v.setSpacing(5);
            v.getChildren().addAll(p);}
         }
     
   

}


 @FXML
    private void changeSelect(ActionEvent event) {
    
      if(tog1.isSelected()){
         
          tog1.setTextFill(Color.WHITE);
          tog1.setStyle("-fx-background-color: #42A8B4;  -fx-background-radius:20 ");
          tog2.setTextFill(Color.BLACK);
          tog2.setStyle("-fx-background-color: #FFFFFF;  -fx-background-radius:20 ");
           if(!getlistco(Nowid.id).isEmpty()){
            course=getlistco(Nowid.id);
      displayCourse(course);}
      }
      
    }
@FXML
    private void changeSelect2(ActionEvent event) {
if(tog2.isSelected()){  
          v.getChildren().clear();
          tog1.setTextFill(Color.BLACK);
          tog1.setStyle("-fx-background-color: #FFFFFF;  -fx-background-radius:20 ");
          tog2.setTextFill(Color.WHITE);
          tog2.setStyle("-fx-background-color: #42A8B4;  -fx-background-radius:20 ");
          
           if(!getlistac(Nowid.id).isEmpty()){
           activ=getlistac(Nowid.id);
           displayactivity(activ);}
      }
    }

public void displayactivity(  List<StudentActivity> stact){
    
     {
           v.getChildren().clear();
            for(int i=0;i<stact.size();i++){
          Rectangle rec =new  Rectangle(200,90);

      rec.setFill(Color.valueOf("#42A8B4"));  
      rec.setArcHeight(20);
       rec.setArcWidth(20);
       rec.setOpacity(0.4);
      Text t=new Text();
     
     Label l=new Label(stact.get(i).getActivitiesName());
           // l.setAlignment(Pos.CENTER_RIGHT);
           l.setTextAlignment(TextAlignment.RIGHT);
           l.setAlignment(Pos.CENTER_RIGHT);
           l.prefWidth(190);
           l.prefHeight(30);
           
           Font font = new Font("29LT Bukra Regular", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
           l.setFont(font);
            
        l.setPadding(new Insets(20,0,0,40));
            bt =new Button("المزيد");
            
//            Font font = new Font("29LT_Bukra", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
           bt.setFont(font);
           
            bt.setAlignment(Pos.CENTER_RIGHT);
            bt.setStyle("-fx-background-color: #FEFFF3; -fx-background-radius:20");
           bt.setTranslateX(80);
            bt.setTranslateY(50);
    VBox vt= new VBox();
    
    vt.setAlignment(Pos.CENTER_RIGHT);
    vt.setPadding(new Insets(0,0,0,30));
            vt.getChildren().addAll(l);
             Pane p=new Pane();
           p.setPadding(new Insets(0,0,0,10));
              p.getChildren().addAll(rec,vt,bt);
              

          v.setPadding(new Insets(10,0,0,10));
             v.setSpacing(5);
            v.getChildren().addAll(p);}
         }
     
   

}

public List getlistco(int id){
        return DB.getList("FROM StudentCourse WHERE st_id= ?", Nowid.id);
    
}
public List getlistac(int id){
        return DB.getList("FROM StudentActivity WHERE st_id= ?", Nowid.id);
    
}
}
    
    

