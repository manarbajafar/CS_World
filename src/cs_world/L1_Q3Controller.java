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
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class L1_Q3Controller implements Initializable {
    
    
    @FXML
    private CheckBox chBox1;
    @FXML
    private CheckBox chBox2;
    @FXML
    private CheckBox chBox3;    
    @FXML
    private CheckBox chBox4;
    @FXML
    private ImageView F;
    @FXML
    private ImageView T;
    private Button bt1 ;
    @FXML
    private Button next;
    @FXML
    private Button CheckAnswer;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
@FXML
    private void check(ActionEvent event) {
        next.setDisable(false);       
        if (chBox2.isSelected() &&chBox3.isSelected() && chBox4.isSelected()){
            T.setVisible(true);
            userLogInNow.increaseUserScore();
        }
        else{
            F.setVisible(true);
        }
        chBox1.setDisable(true);
        chBox2.setDisable(true);
        chBox3.setDisable(true);
        chBox4.setDisable(true);
    } 
    
    private void minimizeButton(MouseEvent event) {
        bt1.setPrefHeight(bt1.getPrefHeight()-5);
        bt1.setPrefWidth(bt1.getPrefWidth()-5);
        bt1.setTranslateX(bt1.getTranslateX()+5);

    }

    private void enlargeButton(MouseEvent event) {
        bt1.setPrefHeight(bt1.getPrefHeight()+5);
        bt1.setPrefWidth(bt1.getPrefWidth()+5);
        bt1.setTranslateX(bt1.getTranslateX()-5);
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
    

    
    @FXML
    public void toScores(ActionEvent event) throws IOException { 
        userLogInNow.UpdatelevelDoneNum();
        root = FXMLLoader.load(getClass().getResource("levelscore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
}
