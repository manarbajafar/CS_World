/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class L1_Q1Controller implements Initializable {

    @FXML
    private ImageView F1;
    @FXML
    private ImageView F2;
    @FXML
    private ImageView F3;
    @FXML
    private ImageView T;
    @FXML
    private ToggleButton bt1 ;
    @FXML
    private ToggleButton bt2 ;
    @FXML
    private ToggleButton bt3 ;
    @FXML
    private ToggleButton bt4 ;
    
    @FXML
    private ToggleGroup toggleGroup ;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button next;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
   
    @FXML
    private void toggleButton(MouseEvent event) {
        if (bt1.isPressed()){
            F1.setVisible(true);
            bt1.setDisable(true);
            bt2.setDisable(true);
            bt3.setDisable(true);
            bt4.setDisable(true);
            next.setDisable(false);
            return;
        }
        else if (bt2.isPressed()){ 
            T.setVisible(true);
            bt1.setDisable(true);
            bt2.setDisable(true);
            bt3.setDisable(true);
            bt4.setDisable(true);
            next.setDisable(false);
            
            userLogInNow.increaseUserScore();
            
            return ;
        }
        else if (bt3.isPressed()){
            F2.setVisible(true);
            bt1.setDisable(true);
            bt2.setDisable(true);
            bt3.setDisable(true);
            bt4.setDisable(true);
            next.setDisable(false);
            return;
        }
        else if (bt4.isPressed()){
            F3.setVisible(true);
            bt1.setDisable(true);
            bt2.setDisable(true);
            bt3.setDisable(true);
            bt4.setDisable(true);
            next.setDisable(false);
            return;
        }
    }                  
    
    @FXML
    private void minimizeButton(MouseEvent event) {
        bt1.setPrefHeight(bt1.getPrefHeight()-5);
        bt1.setPrefWidth(bt1.getPrefWidth()-5);
        bt1.setTranslateX(bt1.getTranslateX()+5);

    }

    @FXML
    private void enlargeButton(MouseEvent event) {
        bt1.setPrefHeight(bt1.getPrefHeight()+5);
        bt1.setPrefWidth(bt1.getPrefWidth()+5);
        bt1.setTranslateX(bt1.getTranslateX()-5);
    } 
    
    @FXML
    private void minimizeButton2(MouseEvent event) {
        bt2.setPrefHeight(bt2.getPrefHeight()-5);
        bt2.setPrefWidth(bt2.getPrefWidth()-5);
        bt2.setTranslateX(bt2.getTranslateX()+5);
    }

    @FXML
    private void enlargeButton2(MouseEvent event) {
        bt2.setPrefHeight(bt2.getPrefHeight()+5);
        bt2.setPrefWidth(bt2.getPrefWidth()+5);
        bt2.setTranslateX(bt2.getTranslateX()-5);
    }
    
    @FXML
    private void minimizeButton3(MouseEvent event) {
        bt3.setPrefHeight(bt3.getPrefHeight()-5);
        bt3.setPrefWidth(bt3.getPrefWidth()-5);
        bt3.setTranslateX(bt3.getTranslateX()+5);
        
    }

    @FXML
    private void enlargeButton3(MouseEvent event) {
        bt3.setPrefHeight(bt3.getPrefHeight()+5);
        bt3.setPrefWidth(bt3.getPrefWidth()+5);
        bt3.setTranslateX(bt3.getTranslateX()-5);
    }
    
    @FXML
    private void minimizeButton4(MouseEvent event) {
        bt4.setPrefHeight(bt4.getPrefHeight()-5);
        bt4.setPrefWidth(bt4.getPrefWidth()-5);
        bt4.setTranslateX(bt4.getTranslateX()+5);
        
    }

    @FXML
    private void enlargeButton4(MouseEvent event) {
        bt4.setPrefHeight(bt4.getPrefHeight()+5);
        bt4.setPrefWidth(bt4.getPrefWidth()+5);
        bt4.setTranslateX(bt4.getTranslateX()-5);
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
    public void toL1_Q2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("L1_Q2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
