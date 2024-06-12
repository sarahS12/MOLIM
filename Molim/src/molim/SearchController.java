/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molim;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static molim.EventController.act;
import static molim.UniController.co;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;


/**
 * FXML Controller class
 *
 * @author whyyy
 */
public class SearchController implements Initializable {

    ArrayList<String> words = new ArrayList<>(
            Arrays.asList("استراتيجيات استثمار الوقت", "تقنية البحث في المصادر","التأمين بشكل عام ",
                    "التمكين الشخصي","معرض انتبه","احتفالية العيد","حملة كهاتين","معرض أصيلة")
    );

    @FXML
    private TextField searchBar;
    
    @FXML
    private Button but1;
    
    @FXML
    private Button but2;
    
    @FXML
    private Button but3;
   
    @FXML
    private ImageView backgroundImage;

    @FXML
    private ListView<String> listView;
    
    @FXML
    private Button back;
    
    public static String co;
    
    public static String sta="";
    
    @FXML
    void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),words));
    }
    
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
   
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        listView.getItems().addAll(words);
        //CHNAGE FONT
        
//        Font font = new Font("29LT Bukra Regular", 14); // Assuming "29LT_Bukra" is the desired font name and 12 is the desired font size
//        listView.setFont(font);
        
        listView.setStyle("-fx-font-family: '29LT Bukra Regular'; -fx-font-size: 14px;");
        but1.setOnAction(e -> showFirstThree());
        
        but3.setOnAction(e -> showLastThree());
        
        but2.setOnAction(e -> showMidThree());
        
        back.setOnAction(this::goHome);
        
        // Add listener to searchBar
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            // Perform search operation
            search(new ActionEvent());
        });
        
        listView.setOnMouseClicked(event -> {
            String selectedValue = listView.getSelectionModel().getSelectedItem();
            if (selectedValue != null) {
                if (selectedValue.equals("معرض انتبه")) {
                    sta=selectedValue;
                    System.out.println("page is displayed");
                } else if (selectedValue.equals("احتفالية عيد الفطر المبارك")){
                    sta=selectedValue;
                } else if (selectedValue.equals("حملة كهاتين")){
                    sta=selectedValue;
                } else if (selectedValue.equals("معرض اصيلة")){
                    sta=selectedValue;
                } else if (selectedValue.equals("التأمين بشكل عام")){
                    co=selectedValue;
                }else if (selectedValue.equals("فن إدارة الوقت")){
                    co=selectedValue;
               }else if (selectedValue.equals("تقنية البحث في مصادر المعلومات")){
                    co=selectedValue;
               }else if (selectedValue.equals("التمكين الشخصي")){
                    co=selectedValue;
               }
            }
                
});

        
        

    

    }
   

    private List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
    
     private void showFirstThree() {
        listView.getItems().clear();
        listView.getItems().addAll(words.subList(0, 8));
    }

    private void showMidThree() {
        listView.getItems().clear();
        listView.getItems().addAll(words.subList(0, 4));
    }
    
     private void showLastThree() {
        listView.getItems().clear();
        listView.getItems().addAll(words.subList(4, 8));
    }    
     
     
    
}
