/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Manar
 */
public class MainPageController implements Initializable {
       

    @FXML
    private Slider soundSlider;
    @FXML
    private ImageView c;
    @FXML
    private ImageView s;
    @FXML
    private ImageView w;
    @FXML
    private ImageView o;
    @FXML
    private ImageView r;
    @FXML
    private ImageView l;
    @FXML
    private ImageView d;
    @FXML
    private ImageView imgButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       TranslateTransition translateC = new TranslateTransition();
       translateC.setNode(c);
       translateC.setDuration(Duration.millis(1000));
       translateC.setCycleCount(TranslateTransition.INDEFINITE);
       translateC.setByY(5);
       translateC.setAutoReverse(true);
       translateC.play();
       
       TranslateTransition translateS = new TranslateTransition();
       translateS.setNode(s);
       translateS.setDuration(Duration.millis(1000));
       translateS.setCycleCount(TranslateTransition.INDEFINITE);
       translateS.setByY(-5);
       translateS.setAutoReverse(true);
       translateS.play();
       
       TranslateTransition translateW = new TranslateTransition();
       translateW.setNode(w);
       translateW.setDuration(Duration.millis(1000));
       translateW.setCycleCount(TranslateTransition.INDEFINITE);
       translateW.setByY(5);
       translateW.setAutoReverse(true);
       translateW.play();
       
       TranslateTransition translateO = new TranslateTransition();
       translateO.setNode(o);
       translateO.setDuration(Duration.millis(1000));
       translateO.setCycleCount(TranslateTransition.INDEFINITE);
       translateO.setByY(-5);
       translateO.setAutoReverse(true);
       translateO.play();
       
       TranslateTransition translateR = new TranslateTransition();
       translateR.setNode(r);
       translateR.setDuration(Duration.millis(1000));
       translateR.setCycleCount(TranslateTransition.INDEFINITE);
       translateR.setByY(5);
       translateR.setAutoReverse(true);
       translateR.play();
       
       TranslateTransition translateL = new TranslateTransition();
       translateL.setNode(l);
       translateL.setDuration(Duration.millis(1000));
       translateL.setCycleCount(TranslateTransition.INDEFINITE);
       translateL.setByY(-5);
       translateL.setAutoReverse(true);
       translateL.play();
       
       TranslateTransition translateD = new TranslateTransition();
       translateD.setNode(d);
       translateD.setDuration(Duration.millis(1000));
       translateD.setCycleCount(TranslateTransition.INDEFINITE);
       translateD.setByY(5);
       translateD.setAutoReverse(true);
       translateD.play();

        
        soundSlider.setValue(CS_World.mediaPlayer.getVolume()*40);
        soundSlider.valueProperty().addListener(new InvalidationListener(){
            @Override
            public void invalidated(Observable observable) {
              CS_World.mediaPlayer.setVolume(soundSlider.getValue()/100);
            }
            
        });
}
   
 @FXML
    public void switchTologin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

    
    @FXML
    private void minimizeButton(MouseEvent event) {
        imgButton.setFitHeight(imgButton.getFitHeight()-5);
        imgButton.setFitWidth(imgButton.getFitWidth()-5);
        imgButton.setTranslateX(imgButton.getTranslateX()+5);
        
    }

    @FXML
    private void enlargeButton(MouseEvent event) {
        imgButton.setFitHeight(imgButton.getFitHeight()+5);
        imgButton.setFitWidth(imgButton.getFitWidth()+5);
        imgButton.setTranslateX(imgButton.getTranslateX()-5);
    }
}
