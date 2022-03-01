/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author KSA
 */
public class LoginnController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Media media;
     MediaPlayer mediaPlayer;  

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

    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
 
    @FXML
    public void switchToSignup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signupp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

    @FXML
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    
     
    
    
    @FXML 
    private TextField namebox;
    
    @FXML 
    private PasswordField passwordbox;
    
    @FXML 
    private Label namemsg;
    
    @FXML 
    private Label passwordmsg;
    
    @FXML 
    private Button loginb;
    
    
   
    @FXML
    public void LoginButton(ActionEvent event)throws IOException{
        //retrive student list
        namemsg.setText("");
        passwordmsg.setText("");
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> sList = null;
        String queryStr = "from User";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("user list size: "+sList.size());
        for(User u: sList)
        {
            System.out.println(u.getName());
        }
        
        
        //check database
        
        
        //check if fields are empty
        if(namebox.getText().equals("")){namemsg.setText("Please enter username");}
        if(passwordbox.getText().equals("")){passwordmsg.setText("Please enter password");}
            
             //now check if email is in the database and if password and email are correct
                        else{
                            boolean flag = false;
                            for(User u: sList){
                                //if user found 
                                if(u.getName().equals(namebox.getText())){ flag =true;
                                    
                                    if(passwordbox.getText().equals(u.getPassword())){
                                        
                                        
                                        userLogInNow.userLogIn=namebox.getText();
                                        System.out.println(userLogInNow.userLogIn+" log in now");
                                        
                                        root = FXMLLoader.load(getClass().getResource("chooseCharacter.fxml"));
                                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                        scene = new Scene(root);
                                        
                                        stage.setScene(scene);
                                        stage.show();
                                        }
                                    else {passwordmsg.setText("Invalid password");}
                                    }
                            }
                            if (flag == false){namemsg.setText("Username not found");}
                        
                        }
        
    }
    
    
    
    
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
    }    
    
}
