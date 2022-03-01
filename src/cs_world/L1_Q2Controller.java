/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

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
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class L1_Q2Controller implements Initializable {

    @FXML
    private ImageView check1;
    @FXML
    private ImageView check2;
    @FXML
    private ImageView check3;
    @FXML
    private ImageView check4;
    @FXML
    private ComboBox combo2;
    @FXML
    private ComboBox combo3;
    @FXML
    private ComboBox combo4;
    @FXML
    private ComboBox combo1;
    @FXML
    private Button CheckAnswer;
    @FXML
    private Button next;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        combo1.getItems().addAll("arr [ i ]","int i = 0 ;" , "String [ ]", "arr [ ]");
        combo2.getItems().addAll("arr [ i ]","int i = 0 ;" , "String [ ]", "arr [ ]");
        combo3.getItems().addAll("arr [ i ]","int i = 0 ;" , "String [ ]", "arr [ ]");
        combo4.getItems().addAll("arr [ i ]","int i = 0 ;" , "String [ ]", "arr [ ]");

        
    }    


    @FXML
    private void minimizeNext(MouseEvent event) {
        next.setPrefHeight(next.getPrefHeight()-5);
        next.setPrefWidth(next.getPrefWidth()-5);
        next.setTranslateX(next.getTranslateX()+5);
    }

    @FXML
    private void enlargeNext(MouseEvent event) {
        next.setPrefHeight(next.getPrefHeight()+5);
        next.setPrefWidth(next.getPrefWidth()+5);
        next.setTranslateX(next.getTranslateX()-5);
    }

    @FXML
    private void minimizeCheck(MouseEvent event) {
        CheckAnswer.setPrefHeight(CheckAnswer.getPrefHeight()-5);
        CheckAnswer.setPrefWidth(CheckAnswer.getPrefWidth()-5);
        CheckAnswer.setTranslateX(CheckAnswer.getTranslateX()+5);
    }

    @FXML
    private void enlargeCheck(MouseEvent event) {
        CheckAnswer.setPrefHeight(CheckAnswer.getPrefHeight()+5);
        CheckAnswer.setPrefWidth(CheckAnswer.getPrefWidth()+5);
        CheckAnswer.setTranslateX(CheckAnswer.getTranslateX()-5);
    }

    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void toL1_Q3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("L1_Q3.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    Image img = new Image(getClass().getResourceAsStream("/img-sound/false.png"));
    
    @FXML
    private void check(ActionEvent event) { 
        boolean flag1=false,flag2=false,flag3=false,flag4=false;
       try{
           if (combo1.getValue().toString()== "String [ ]")
        {
            check1.setVisible(true);
            flag1=true;
        }else {
            check1.setImage(img);
            check1.setVisible(true);            
        }
        if (combo2.getValue().toString()== "arr [ ]")
        {
            check2.setVisible(true);
            flag2=true;
        }else {
            check2.setImage(img);
            check2.setVisible(true);            
        }
        if (combo3.getValue().toString()== "int i = 0 ;")
        {
            check3.setVisible(true);
            flag3=true;
        }else {
            check3.setImage(img);
            check3.setVisible(true);            
        }
        if (combo4.getValue().toString()== "arr [ i ]")
        {
            check4.setVisible(true);
            flag4=true;
        }else {
            check4.setImage(img);
            check4.setVisible(true);            
        }
        if(flag1 && flag2 && flag3 && flag4){
            userLogInNow.increaseUserScore();
        }
           
        next.setDisable(false);
        combo1.setDisable(true);
        combo2.setDisable(true);
        combo3.setDisable(true);
        combo4.setDisable(true);
       }catch(RuntimeException e){
          next.setDisable(false);
          combo1.setDisable(true);
          combo2.setDisable(true);
          combo3.setDisable(true);
          combo4.setDisable(true);
       }
    }
    
}
