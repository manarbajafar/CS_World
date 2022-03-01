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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Manar
 */
public class L2_Q1Controller implements Initializable {

    @FXML
    private ImageView space1;
    @FXML
    private ImageView space2;
    @FXML
    private Pane space1pane;
    @FXML
    private Pane space2pane;
    @FXML
    private ImageView outof;
    @FXML
    private Pane outofpane;
    @FXML
    private ImageView column;
    @FXML
    private Pane columnpane;
    @FXML
    private ImageView from;
    @FXML
    private Pane frompane;
    @FXML
    private ImageView birthdate;
    @FXML
    private Pane birthdatepane;
    @FXML
    private ImageView to;
    @FXML
    private Pane topane;
    @FXML
    private ImageView name;
    @FXML
    private VBox namepane;
    @FXML
    private HBox choices;
    
    //flags
    private boolean isoutofplaced=false;
    private boolean iscolumnplaced=false;
    private boolean isfromplaced=false;
    private boolean isbirthdateplaced=false;
    private boolean istoplaced=false;
    private boolean isnameplaced=false;
    @FXML
    private Label instructions;
    @FXML
    private StackPane ans1;
    @FXML
    private StackPane ans2;
    @FXML
    private StackPane ch1pane;
    @FXML
    private StackPane ch2pane;
    @FXML
    private StackPane ch3pane;
    @FXML
    private StackPane ch4pane;
    @FXML
    private StackPane ch5pane;
    @FXML
    private StackPane ch6pane;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button next;
    @FXML
    private Button CheckAnswer;
    @FXML
    private ImageView true1;
    @FXML
    private ImageView false2;
    @FXML
    private ImageView true2;
    @FXML
    private ImageView false1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //key event on ex4
		rootpane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {				
				switch(event.getCode()) {
				case DIGIT1:
					putInSpace(1);
					break;
				case DIGIT2:
					putInSpace(2);
					break;
                                case DIGIT3:
					putInSpace(3);
					break;
                                case DIGIT4:
					putInSpace(4);
					break;
                                case DIGIT5:
					putInSpace(5);
					break;
                                case DIGIT6:
					putInSpace(6);
					break;
				}		
			}	
		});
        
    }    
    public void putInSpace(int num) {
        if(ans1.getChildren().contains(space1pane)) {     
              switch (num){
                  case 1:
                      if(!isoutofplaced){
                      ans1.getChildren().remove(space1pane);
                      ans1.getChildren().add(outofpane);
                      isoutofplaced=true;
                      }
                      break;
                  case 2:
                      if(!iscolumnplaced){
                      ans1.getChildren().remove(space1pane);
                      ans1.getChildren().add(columnpane);
                      iscolumnplaced=true;
                      }
                      break;
                  case 3:
                      if(!isfromplaced){
                      ans1.getChildren().remove(space1pane);
                      ans1.getChildren().add(frompane);
                      isfromplaced=true;
                      }
                      break;
                  case 4:
                      if(!isbirthdateplaced){
                      ans1.getChildren().remove(space1pane);
                      ans1.getChildren().add(birthdatepane);
                      isbirthdateplaced=true;
                      }
                      break;
                  case 5:
                      if(!istoplaced){
                      ans1.getChildren().remove(space1pane);
                      ans1.getChildren().add(topane);
                      istoplaced=true;
                      }
                      break;
                  case 6:
                      if(!isnameplaced){
                      ans1.getChildren().remove(space1pane);
                      ans1.getChildren().add(namepane);
                      isnameplaced=true; 
                      }
                      break; 
              }
                }
        else if (ans2.getChildren().contains(space2pane)) {
              switch (num){
                  case 1:
                      if(!isoutofplaced){
                      ans2.getChildren().remove(space2pane);
                      ans2.getChildren().add(outofpane);
                      isoutofplaced=true;
                      }
                      break;
                  case 2:
                      if(!iscolumnplaced){
                      ans2.getChildren().remove(space2pane);
                      ans2.getChildren().add(columnpane);
                      iscolumnplaced=true;
                      }
                      break;
                  case 3:
                      if(!isfromplaced){
                      ans2.getChildren().remove(space2pane);
                      ans2.getChildren().add(frompane);
                      isfromplaced=true;
                      }
                      break;
                  case 4:
                      if(!isbirthdateplaced){
                      ans2.getChildren().remove(space2pane);
                      ans2.getChildren().add(birthdatepane);
                      isbirthdateplaced=true;
                      }
                      break;
                  case 5: 
                      if(!istoplaced){
                      ans2.getChildren().remove(space2pane);
                      ans2.getChildren().add(topane);
                      istoplaced=true;
                      }
                      break;
                  case 6:
                      if(!isnameplaced){
                      ans2.getChildren().remove(space2pane);
                      ans2.getChildren().add(namepane);
                      isnameplaced=true; 
                      }
                      break; 
              }   
        }
    }
   

    @FXML
    private void outofClicked(MouseEvent event) {
        if (ans1.getChildren().contains(outofpane)){
            ans1.getChildren().remove(outofpane);
            ans1.getChildren().add(space1pane);
            ch1pane.getChildren().add(outofpane);
            isoutofplaced=false;
        }
        else if (ans2.getChildren().contains(outofpane)){
            ans2.getChildren().remove(outofpane);
            ans2.getChildren().add(space2pane);
            ch1pane.getChildren().add(outofpane);
            isoutofplaced=false;
        }
    }

    @FXML
    private void columnClicked(MouseEvent event) {
        if (ans1.getChildren().contains(columnpane)){
            ans1.getChildren().remove(columnpane);
            ans1.getChildren().add(space1pane);
            ch2pane.getChildren().add(columnpane);
            iscolumnplaced=false;
        }
        else if (ans2.getChildren().contains(columnpane)){
            ans2.getChildren().remove(columnpane);
            ans2.getChildren().add(space2pane);
            ch2pane.getChildren().add(columnpane);
            iscolumnplaced=false;
        }
    }

    @FXML
    private void fromClicked(MouseEvent event) {
        if (ans1.getChildren().contains(frompane)){
            ans1.getChildren().remove(frompane);
            ans1.getChildren().add(space1pane);
            ch3pane.getChildren().add(frompane);
            isfromplaced=false;
        }
        else if (ans2.getChildren().contains(frompane)){
            ans2.getChildren().remove(frompane);
            ans2.getChildren().add(space2pane);
            ch3pane.getChildren().add(frompane);
            isfromplaced=false;
        }
    }

    @FXML
    private void birthdateClicked(MouseEvent event) {
         if (ans1.getChildren().contains(birthdatepane)){
            ans1.getChildren().remove(birthdatepane);
            ans1.getChildren().add(space1pane);
            ch4pane.getChildren().add(birthdatepane);
            isbirthdateplaced=false;
        }
        else if (ans2.getChildren().contains(birthdatepane)){
            ans2.getChildren().remove(birthdatepane);
            ans2.getChildren().add(space2pane);
            ch4pane.getChildren().add(birthdatepane);
            isbirthdateplaced=false;
        }
    }

    @FXML
    private void toClicked(MouseEvent event) {
         if (ans1.getChildren().contains(topane)){
            ans1.getChildren().remove(topane);
            ans1.getChildren().add(space1pane);
            ch5pane.getChildren().add(topane);
            istoplaced=false;
        }
        else if (ans2.getChildren().contains(topane)){
            ans2.getChildren().remove(topane);
            ans2.getChildren().add(space2pane);
            ch5pane.getChildren().add(topane);
            istoplaced=false;
        }
    }

    @FXML
    private void nameClicked(MouseEvent event) {
        if (ans1.getChildren().contains(namepane)){
            ans1.getChildren().remove(namepane);
            ans1.getChildren().add(space1pane);
            ch6pane.getChildren().add(namepane);
            isnameplaced=false;
        }
        else if (ans2.getChildren().contains(namepane)){
            ans2.getChildren().remove(namepane);
            ans2.getChildren().add(space2pane);
            ch6pane.getChildren().add(namepane);
            isnameplaced=false;
        }
    }

    @FXML
    private void nextButton(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("L2_Q2.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
    }

    @FXML
    private void checkButton(ActionEvent event) { 
        if(ans1.getChildren().contains(namepane)&&ans2.getChildren().contains(frompane)){
            true1.setVisible(true);
            true2.setVisible(true);
            userLogInNow.increaseUserScore();
        }
        else if(ans1.getChildren().contains(namepane)&&!ans2.getChildren().contains(frompane)){
            true1.setVisible(true);
            false2.setVisible(true);
        }
        else if(!ans1.getChildren().contains(namepane)&&ans2.getChildren().contains(frompane)){
            true2.setVisible(true);
            false1.setVisible(true);
        }
        else{
            false1.setVisible(true);
            false2.setVisible(true);
        }
        next.setDisable(false);
        ans1.setDisable(true);
        ans2.setDisable(true);
    }

    @FXML
    private void alertInsttructions(MouseEvent event) {
        Alert alertInformation = new Alert(Alert.AlertType.INFORMATION);
        alertInformation.setTitle("Instructions");
        alertInformation.setHeaderText("Instructions");
        alertInformation.setContentText("Press the puzzle number using the keyboard to place it in the blanks. If you want to change the answer, press the puzzle piece with the mouse.");
        alertInformation.showAndWait();
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

