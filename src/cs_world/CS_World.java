/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author horre
 */
public class CS_World extends Application {
    public static Media media;
    public static  MediaPlayer mediaPlayer;
    public static AudioClip typing;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        media = new Media(getClass().getResource("/img-sound/music.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);  
        mediaPlayer.setAutoPlay(true); 
        mediaPlayer.setOnEndOfMedia(new Runnable() {
        public void run() {
         mediaPlayer.seek(Duration.ZERO);
       }
      });
        
        //sound of typing
        typing = new AudioClip(getClass().getResource("/img-sound/Typing.mp3").toString());
        
       //view main page                
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));              
	Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CS world");     
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
