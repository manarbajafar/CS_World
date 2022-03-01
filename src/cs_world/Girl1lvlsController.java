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
public class Girl1lvlsController implements Initializable {
TextAnimator textAnimator1;
TextAnimator textAnimator2;
TextAnimator textAnimator3;
    Parent epParent;
    Scene lvlsscene;
    Stage window;
       
    @FXML
    private Text text;
    
    
    public void changeScenetogame(ActionEvent event) throws IOException{
         CS_World.typing.stop();
          switch(userLogInNow.ChosenLvl){
             case 1:              
                 epParent = FXMLLoader.load(getClass().getResource("L1_Q1.fxml"));;
                 break;
             case 2:
                 epParent = FXMLLoader.load(getClass().getResource("L2_Q1.fxml"));
                 break;
             case 3:
                 epParent = FXMLLoader.load(getClass().getResource("L3_Q1.fxml"));  
                 break;
         }
                 lvlsscene = new Scene(epParent);
                 window = (Stage)((Node)event.getSource()).getScene().getWindow();
                 window.setScene(lvlsscene);
                 window.show();
    }   
        
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
    textAnimator1 = new TextAnimator("This is the first year and I have exams in two subjects which are: Computer Programming and Digital Logic Design\n Lets work hard together to get good scores!!" ,100, textOutput);
    textAnimator2 = new TextAnimator("This is the second year and I have exams in two subjects which are: Database and Computer Networks\n Lets work hard together to get good scores!!" ,100, textOutput);
    textAnimator3 = new TextAnimator("This is the third year and I have exams in two subjects which are: Internet Applications and Software Engineering\n Lets work hard together to get good scores!!" ,100, textOutput);
    switch(userLogInNow.ChosenLvl){
             case 1:              
                 Thread thread1 = new Thread(textAnimator1);
                 thread1.start();
                 break;
             case 2:
                 Thread thread2 = new Thread(textAnimator2);
                 thread2.start();
                 break;
             case 3: 
                 Thread thread3 = new Thread(textAnimator3);
                 thread3.start();
                 break;
    }    
   CS_World.typing.play();
      }
    
    
       }
   
    
    
    

