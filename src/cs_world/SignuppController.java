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
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author KSA
 */
public class SignuppController implements Initializable {

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
    private Label passwordVmsg2;

    @FXML
    private TextField emailbox2;

    @FXML
    private TextField namebox2;

    @FXML
    private PasswordField passwordbox2;

    @FXML
    private PasswordField verifybox2;

    @FXML
    private Label emailmsg2;

    @FXML
    private Label namemsg2;

    @FXML
    private Label passwordmsg2;

    @FXML
    public void signUpButton(ActionEvent event) throws IOException {
        User new_user = new User();
        new_user.setName(namebox2.getText());
        new_user.setPassword(passwordbox2.getText());
        new_user.setEmail(emailbox2.getText());
        new_user.setVpassword(verifybox2.getText());
        
        String domain = "";
        try {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<User> user_list = null;
        String queryStr = "from User";
        Query query = session1.createQuery(queryStr);
        user_list =  query.list();
        session1.close();
        
        //chick if the email has already been used:
        for (User u : user_list) {
           if(u.getEmail().equals(emailbox2.getText())){
               emailmsg2.setText("The Email is already taken");
               return;
           }
            
        }
        //check if fields are empty:
        if (namebox2.getText().equals("")){
            namemsg2.setText("Please enter username");
        }            
        else
            namemsg2.setText("");
        
        if (passwordbox2.getText().equals("")){
            passwordmsg2.setText("Please enter password");
        } 
        else
            passwordmsg2.setText("");
        
        if (verifybox2.getText().equals("")){
            passwordVmsg2.setText("Please enter password again");
        }
        else
            passwordVmsg2.setText("");
        
        if (emailbox2.getText().equals("")){
            emailmsg2.setText("Please enter e-mail");
        }            
        else
            emailmsg2.setText("");
        
              
        //check if email is valid or display alert:
        int index=1;
        if (emailbox2.getText().contains("@")) {
        index = emailbox2.getText().indexOf("@");
        domain = emailbox2.getText().substring(index);
        }   
        boolean invalidDomain=!(domain.equals("@gmail.com")) && !(domain.equals("@yahoo.com")) && !(domain.equals("@outlook.com")) && !(domain.equals("@hotmail.com")) && !(domain.equals("@st.uqu.edu.sa"));   
        if ((invalidDomain && !emailbox2.getText().equals("")) || (index-1 <0)) { //index-1= -1 when email like @hotmail.com without name 
           emailmsg2.setText("Please enter a valid e-mail"); 
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Invalid e-mail format");
            a.setContentText("Please enter a vaild e-mail format.\n\nAccepted formats: \n\t\t- yourName@st.uqu.edu.sa\n\t\t- yourName@gmail.com \n\t\t- yourName@yahoo.com \n\t\t- yourName@outlook.com \n\t\t- yourName@hotmail.com");
            a.show();  
        }
        else if(!invalidDomain){
           emailmsg2.setText(""); 
        }
        
        //Check if the password and password verification match:
        boolean dontMatch=!(passwordbox2.getText().equals(verifybox2.getText()));
        if (dontMatch &&  !passwordbox2.getText().equals("") && !verifybox2.getText().equals("")) {
            passwordmsg2.setText("passwords don't match");
        }
        
        
        if (namebox2.getText().equals("") || passwordbox2.getText().equals("") || verifybox2.getText().equals("") || emailbox2.getText().equals("")|| invalidDomain || dontMatch ||(index-1 <0))
            return;
        
        
   
        //save the new user information in database:
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session2.beginTransaction();
        session2.save(new_user);
        tx.commit();
        session2.close(); 
        
        //add user name to score table:
        Score s=new Score();
        s.setName(namebox2.getText());
        session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.save(s);
        tx2.commit();
        session2.close();
        System.out.println("inserted user score: " + s.getName());
                
        userLogInNow.userLogIn=namebox2.getText();
        System.out.println(userLogInNow.userLogIn+" log in now");
                              
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chooseCharacter.fxml"));
        Parent root = (Parent)loader.load();
      
      
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.show();
        }
        
        
        catch (Exception e){namemsg2.setText("The UserName is already taken");}
        
    }
     @FXML
    public void switchTologin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
