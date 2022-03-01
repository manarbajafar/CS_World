/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * FXML Controller class
 *
 * @author afnan
 */
public class Girl3storyController implements Initializable {

      TextAnimator textAnimator;
    
      public void changeScenetoEps(ActionEvent event) throws IOException{
         CS_World.typing.stop();
         Parent epParent = FXMLLoader.load(getClass().getResource("girl1eps.fxml"));
         Scene episodescene = new Scene(epParent);
         
         //This gets the stage info
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(episodescene);
        window.show();
     }      
      public void back(ActionEvent event) throws IOException{
         
         Parent epParent = FXMLLoader.load(getClass().getResource("chooseCharacter.fxml"));
         Scene episodescene = new Scene(epParent);
         
         //This gets the stage info
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(episodescene);
        window.show();
     }      
     
     

    @FXML
    private Text text;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         TextOutput textOutput = new TextOutput() {
            @Override
            public void writeText(String textOut) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(textOut);
                    }
                });
            }
        };
    textAnimator = new TextAnimator("hello there!! I hope you're doing great... I'm Mia and I'm a computer sceince student \n My Finals are coming and I need your help to be prepared and get ready for it" ,100, textOutput);
     Thread thread = new Thread(textAnimator);
        thread.start();
        CS_World.typing.play();
    }    
    
     
    
    }    
    

