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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Manar
 */
public class L2_Q2Controller implements Initializable {

    @FXML
    private ToggleButton ch1;
    @FXML
    private ToggleButton ch2;
    @FXML
    private ToggleButton ch3;

    ToggleGroup group = new ToggleGroup();
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button next;
    @FXML
    private Button CheckAnswer;
    @FXML
    private ImageView false1;
    @FXML
    private ImageView false2;
    @FXML
    private ImageView true1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        ch1.setToggleGroup(group);
        ch2.setToggleGroup(group);
        ch3.setToggleGroup(group);

    }    

    @FXML
    private void ch1Action(ActionEvent event) {
         if(ch1.isSelected())
            ch1.setStyle("-fx-border-color: #E9D788; -fx-background-color: White; -fx-border-width: 4");
        ch2.setStyle("-fx-border-color: White; -fx-background-color: White;");
        ch3.setStyle("-fx-border-color: White; -fx-background-color: White;");
    }

    @FXML
    private void ch2Action(ActionEvent event) {
        if(ch2.isSelected())ch2.setStyle("-fx-border-color: #E9D788; -fx-background-color: White; -fx-border-width: 4");
        ch1.setStyle("-fx-border-color: White;-fx-background-color: White;");
        ch3.setStyle("-fx-border-color: White;-fx-background-color: White;");

    }

    @FXML
    private void ch3Action(ActionEvent event) {
         if(ch3.isSelected())ch3.setStyle("-fx-border-color: #E9D788; -fx-background-color: White; -fx-border-width: 4");
        ch1.setStyle("-fx-border-color: White; -fx-background-color: White;");
        ch2.setStyle("-fx-border-color: White; -fx-background-color: White;");
    }


    @FXML
    private void nextButton(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("L2_Q3.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
    }

    @FXML
    private void checkButton(ActionEvent event) {
          if(ch3.isSelected()){
              true1.setVisible(true);
              userLogInNow.increaseUserScore();
          }
          else if (ch1.isSelected()){
              false1.setVisible(true);
          }
          else if (ch2.isSelected()){
              false2.setVisible(true);
          }
          next.setDisable(false);
          ch1.setDisable(true);
          ch2.setDisable(true);
          ch3.setDisable(true);
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
    
}
