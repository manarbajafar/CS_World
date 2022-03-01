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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author afnan
 */
public class chooseCharacterController implements Initializable {
    
     public void changeScenetoStory1(ActionEvent event) throws IOException{
         userLogInNow.ChosenCharacter=1;
         Parent epParent2 = FXMLLoader.load(getClass().getResource("girl1story.fxml"));
         Scene episodescene2 = new Scene(epParent2);
         
         //This gets the stage info
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(episodescene2);
        window.show();
     }  
     
     public void changeScenetoStory2(ActionEvent event) throws IOException{
         userLogInNow.ChosenCharacter=2;
         Parent epParent2 = FXMLLoader.load(getClass().getResource("girl2story.fxml"));
         Scene episodescene2 = new Scene(epParent2);
         
         //This gets the stage info
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(episodescene2);
        window.show();
     }   
    
     public void changeScenetoStory3(ActionEvent event) throws IOException{
         userLogInNow.ChosenCharacter=3;         
         Parent epParent2 = FXMLLoader.load(getClass().getResource("girl3story.fxml"));
         Scene episodescene2 = new Scene(epParent2);
         
         //This gets the stage info
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(episodescene2);
        window.show();
     }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
