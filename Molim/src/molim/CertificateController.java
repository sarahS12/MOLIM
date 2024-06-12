/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;


/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class CertificateController implements Initializable {
Certificates cerf = new Certificates();

List<Certificates> coser;
//    
//    @FXML
//    private Label name;
//    
//    @FXML
//    private Label title;
//    
    
    @FXML
    private Button back;
    
    @FXML
    private Button sh1;

    @FXML
    private Button sh2;

    @FXML
    private Button sh3;
    
    
    @FXML
    private VBox v;

    @FXML
    private AnchorPane anchor=new AnchorPane() ;
    
    
    public    static String s1="kojo";
    public static String s2="kojo";
    public  static String s3="kojo";
    public   static String s4="kojo";   
//    
    @FXML
    private Node pane;
          @FXML
    private Label lbcertificate;
    
//    
//    @FXML
//    private Pane cerpane;
//
//    @FXML
//    private Rectangle cerrec;
   
    @FXML
    private void goCer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Certificate.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
        @FXML
        private void goBack(MouseEvent event) {
                try {

                    FXMLLoader loadProfile = new FXMLLoader(getClass().getResource("Home.fxml")); //to get the fxml file to be displayed
                    Parent root = loadProfile.load(); //put it as a root 
                  
                    //profile.currentUser(this.currentSt);

                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    System.out.println(e);
            }

        }


    
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
private void showcertificate(ActionEvent event){ 
    mediaPalyer.play();
   Student st=DB.getObject("FROM Student WHERE stId = ?", Nowid.id);
    coser=DB.getList("FROM Certificates WHERE st_id= ?", Nowid.id);
    if (st.getStId()==coser.get(0).getStudent())
      s1=coser.get(0).getDepartment();
      s2=st.getStName();
      s3=coser.get(0).getCertificatesname();
      s4=coser.get(0).getCertificatedate();
      
      load();
}




@FXML
private void showcertificate2(ActionEvent event){ 
    mediaPalyer.play();
   Student st=DB.getObject("FROM Student WHERE stId = ?", Nowid.id);
    coser=DB.getList("FROM Certificates WHERE st_id= ?", Nowid.id);
    if (st.getStId()==coser.get(1).getStudent())
      s1=coser.get(1).getDepartment();
      s2=st.getStName();
      s3=coser.get(1).getCertificatesname();
      s4=coser.get(1).getCertificatedate();
      
      load();
}


@FXML
private void showcertificate3(ActionEvent event){ 
    mediaPalyer.play();
   Student st=DB.getObject("FROM Student WHERE stId = ?", Nowid.id);
    coser=DB.getList("FROM Certificates WHERE st_id= ?", Nowid.id);
    if (st.getStId()==coser.get(2).getStudent())
      s1=coser.get(2).getDepartment();
      s2=st.getStName();
      s3=coser.get(2).getCertificatesname();
      s4=coser.get(2).getCertificatedate();
      
      load();
}

    public void load(){
        mediaPalyer.play();
     try { FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MyCertificates.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                MyCertificatesController cer= fxmlLoader.getController();
                cer.intcer(s1, s2, s3, s4);
                Stage stage = new Stage();
                stage.setTitle("certificate");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CertificateController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
     
    
    String path= "/Users/whyyy/Downloads/Molim.1/Molim/src/molim/click.mp3";
    Media media =new Media(new File(path).toURI().toString());
    MediaPlayer mediaPalyer = new MediaPlayer(media);
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        
          
        // v.getChildren().clear();
        coser=DB.getList("FROM Certificates WHERE st_id= ?", Nowid.id);
        System.out.println( coser.size());
        System.out.println( coser.isEmpty());
        if ( coser.isEmpty()){
        v.getChildren().clear();
        lbcertificate.setVisible(true);

       }
       else
        {  
         
         
            lbcertificate.setVisible(false); 
              for(int i=0;i<coser.size();i++){
               
                Rectangle  cerrec=new Rectangle();
                  cerrec.setFill(Color.BLUE);
                 Pane cerpane=new  Pane();
                   cerpane.getChildren().addAll(cerrec);
                   v.getChildren().addAll(cerpane);
                   
                   
              }
            
        }
       
       
       
    
    sh1.setOnAction(this::showcertificate);
    back.setOnMouseClicked(this::goBack);
    //back.setOnAction(this::goHome);
    }
  
}

