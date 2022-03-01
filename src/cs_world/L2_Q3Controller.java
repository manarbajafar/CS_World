/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Manar
 */
public class L2_Q3Controller implements Initializable {
 @FXML
    private ImageView ButtonL;
    @FXML
    private ImageView ButtonR;
    
    private ObservableList<String> invalidIPs;
    private ObservableList<String> validIPs;
    
    private ListView<String> invalidIPsListView;
    private ListView<String> validIPsListView;
    
    private ObservableList<String> trueValidIPs; 
    @FXML
    private StackPane validIPsPane;
    @FXML
    private StackPane invalidIPsPane;
    @FXML
    private Button next;
    @FXML
    private Button CheckAnswer;
    @FXML
    private ImageView false1;
    @FXML
    private ImageView true1;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        trueValidIPs=FXCollections.observableArrayList("126.1.0.0","190.7.2.0", "7.7.7.69", "1.2.3.4");
        
        invalidIPs= FXCollections.observableArrayList("131.107.300.80","126.1.0.0", "1.2.3.4", "255.255.255.255");
        validIPs=FXCollections.observableArrayList("190.7.2.0","0.127.4.100", "127.1.1.1", "7.7.7.69");
        invalidIPsListView=new ListView<>(invalidIPs);
        validIPsListView=new ListView<>(validIPs);
        
        validIPsPane.getChildren().add(validIPsListView);
        invalidIPsPane.getChildren().add(invalidIPsListView);
        
        
    }    

    @FXML
    private void nextButton(ActionEvent event) throws IOException {
          userLogInNow.UpdatelevelDoneNum();
          root = FXMLLoader.load(getClass().getResource("levelscore.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
    }

    @FXML
    private void checkButton(ActionEvent event) {
        if(validIPs.containsAll(trueValidIPs)){
            true1.setVisible(true);
            userLogInNow.increaseUserScore();
        }      
          else 
               false1.setVisible(true);
        next.setDisable(false);
        validIPsListView.setDisable(true);
        invalidIPsListView.setDisable(true);
    }

   

    @FXML
    private void clickButtonR(MouseEvent event) {
        String str = validIPsListView.getSelectionModel().getSelectedItem();
        if (str != null) {
        validIPsListView.getSelectionModel().clearSelection();
        validIPs.remove(str);
        invalidIPs.add(str); } 
    }

    @FXML
    private void clickButtonL(MouseEvent event) {
        String str = invalidIPsListView.getSelectionModel().getSelectedItem();
        if (str != null) {
        invalidIPsListView.getSelectionModel().clearSelection();
        invalidIPs.remove(str);
        validIPs.add(str);}
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
