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
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author KSA
 */
public class LevelscoreController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label percentage;

    @FXML
    private Label grade;

    @FXML
    private ProgressBar bar;


    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label levelScore;
    private int Score;
    private int level;
    @FXML
    public void nextButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("girl1eps.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void backButton(ActionEvent event) throws IOException { 
        root = FXMLLoader.load(getClass().getResource("chooseCharacter.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    @FXML
    public void logoutButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Score = userLogInNow.getScore();
        levelScore.setText(String.valueOf(Score));
        levelScore.setVisible(true);
        
        level= userLogInNow.getLevelDoneNum();
        switch(level){
            case 1:
                bar.setProgress(0.3);
                percentage.setText("30%");
                break;
            case 2:
                bar.setProgress(0.6);
                percentage.setText("60%");
                break;
            case 3:
                bar.setProgress(1);
                percentage.setText("100%");
                break;
        }
        

    }
}
