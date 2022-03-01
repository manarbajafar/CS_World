/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import static cs_world.userLogInNow.getLevelDoneNum;
import static cs_world.userLogInNow.userLogIn;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 * FXML Controller class
 *
 * @author afnan
 */
public class Girl1epsController implements Initializable {

    @FXML
    private ImageView lvl1;
    @FXML
    private ImageView lvl2;
    @FXML
    private ImageView lvl3;
    public int levelDoneNum;
    @FXML
    private Label lvl1Lb;
    @FXML
    private Label lvl2Lb;
    @FXML
    private Label lvl3Lb;
    @FXML
    private ImageView lock1;
    @FXML
    private ImageView lock2;
    @FXML
    private StackPane playAgainWindow;
    
    Parent epParent;
    Scene episodescene;
    Stage window;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {        
        levelDoneNum= userLogInNow.getLevelDoneNum(); 
        if (levelDoneNum ==0){
            lvl2.setDisable(true);
            lvl3.setDisable(true);
            lock1.setVisible(true);
            lock2.setVisible(true);
        }
        if (levelDoneNum ==1){
            lvl1.setDisable(true);
            lvl1.setEffect(new BoxBlur());
            lvl1Lb.setEffect(new BoxBlur());
            
            lock1.setVisible(false);
            lvl3.setDisable(true);
            lock2.setVisible(true);
            
        }
        else if (levelDoneNum ==2){
            lvl1.setDisable(true);
            lvl1.setEffect(new BoxBlur());
            lvl1Lb.setEffect(new BoxBlur()); 
            
            lvl2.setDisable(true);
            lvl2.setEffect(new BoxBlur());
            lvl2Lb.setEffect(new BoxBlur());
            
            lock1.setVisible(false);
            lock2.setVisible(false);
            lvl3.setDisable(false);
        }
        else if (levelDoneNum ==3){
            lvl1.setDisable(true);
            lvl1.setEffect(new BoxBlur());
            lvl1Lb.setEffect(new BoxBlur()); 
            
            lvl2.setDisable(true);
            lvl2.setEffect(new BoxBlur());
            lvl2Lb.setEffect(new BoxBlur());
            
            lvl3.setDisable(true);
            lvl3.setEffect(new BoxBlur());
            lvl3Lb.setEffect(new BoxBlur()); 
            
            lock1.setVisible(false);
            lock2.setVisible(false);
            playAgainWindow.setVisible(true);
        }
  
    }  

    @FXML
    public void changeScenetolvl1(MouseEvent event) throws IOException{
        userLogInNow.ChosenLvl=1;
         switch(userLogInNow.ChosenCharacter){
             case 1:              
                 epParent = FXMLLoader.load(getClass().getResource("girl1lvls.fxml"));
                 break;
             case 2:
                 epParent = FXMLLoader.load(getClass().getResource("girl2lvls.fxml"));
                 break;
             case 3:  
                 epParent = FXMLLoader.load(getClass().getResource("girl3lvls.fxml"));
                 break;
         }
                 episodescene = new Scene(epParent);
                 window = (Stage)((Node)event.getSource()).getScene().getWindow();
                 window.setScene(episodescene);
                 window.show();
         
     }   
    
    @FXML
    public void changeScenetolvl2(MouseEvent event) throws IOException{ 
        userLogInNow.ChosenLvl=2;
         switch(userLogInNow.ChosenCharacter){
             case 1:              
                 epParent = FXMLLoader.load(getClass().getResource("girl1lvls.fxml"));;
                 break;
             case 2:
                 epParent = FXMLLoader.load(getClass().getResource("girl2lvls.fxml"));
                 break;
             case 3:
                 epParent = FXMLLoader.load(getClass().getResource("girl3lvls.fxml"));              
         }
                 episodescene = new Scene(epParent);
                 window = (Stage)((Node)event.getSource()).getScene().getWindow();
                 window.setScene(episodescene);
                 window.show();
    }   
    
    @FXML
     public void changeScenetolvl3(MouseEvent event) throws IOException{
         userLogInNow.ChosenLvl=3;
         switch(userLogInNow.ChosenCharacter){
             case 1:              
                 epParent = FXMLLoader.load(getClass().getResource("girl1lvls.fxml"));
                 break;
             case 2:
                 epParent = FXMLLoader.load(getClass().getResource("girl2lvls.fxml"));
                 break;
             case 3:
                 epParent = FXMLLoader.load(getClass().getResource("girl3lvls.fxml"));                
         }
                 episodescene = new Scene(epParent);
                 window = (Stage)((Node)event.getSource()).getScene().getWindow();
                 window.setScene(episodescene);
                 window.show();
     }   

    @FXML
    private void playAgainAction(ActionEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Score> sList = null;
        String queryStr = "from Score";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        System.out.println("Score list size: "+sList.size());
        for(Score s: sList)
        {
            if(s.getName().equals(userLogIn)){
                userLogInNow.levelDoneNumForuserLogIn=0;
                userLogInNow.ScoreuserLogIn=0;
                
                Session session1 = HibernateUtil.getSessionFactory().openSession();
                Transaction tx1 = session1.beginTransaction();               
                s.setLevelDoneNum(userLogInNow.levelDoneNumForuserLogIn );
                s.setScore(userLogInNow.ScoreuserLogIn);
                session1.update(s);
                tx1.commit();
                session1.close();
            }
            
                }
        Parent epParent = FXMLLoader.load(getClass().getResource("girl1eps.fxml"));
        Scene episodescene = new Scene(epParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(episodescene);
        window.show();
        
    }

   

    @FXML
    private void viewScoresAction(ActionEvent event) throws IOException {
        Parent epParent = FXMLLoader.load(getClass().getResource("Scores.fxml"));
        Scene episodescene = new Scene(epParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(episodescene);
        window.show();
    }

   
      
     
      
}