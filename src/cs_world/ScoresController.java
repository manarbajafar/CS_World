/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs_world;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author horre
 */
public class ScoresController implements Initializable {

    @FXML
    private TableView<Score> scoreTable;
    @FXML
    private TableColumn<Score, Integer> Rank =new TableColumn<Score, Integer>("#");;
    @FXML
    private TableColumn<Score, String> Username;
    @FXML
    private TableColumn<Score, Integer> Score;
    @FXML
    private TableColumn<Score, Integer> Leveldonenumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //get users scores from database 
        List<Score> slist = new ArrayList<Score>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr = "from Score";
        Query query = session.createQuery(queryStr);
        slist = query.list();
        session.close();
        System.out.println("list size: " + slist.size());
        
        //sort the rows according to the highest score
        Comparator<Score> comparator = Comparator.comparing(e -> e.getScore());
        slist.sort(comparator.reversed());
        
        ObservableList<Score> data = FXCollections.observableArrayList(slist);
        scoreTable.setItems(data);
        
        Rank.setCellValueFactory(col-> new ReadOnlyObjectWrapper<Integer>(scoreTable.getItems().indexOf(col.getValue())+1));
        Username.setCellValueFactory( new PropertyValueFactory<Score, String>("name") );
        Score.setCellValueFactory( new PropertyValueFactory<Score, Integer>("score") );
        Leveldonenumber.setCellValueFactory( new PropertyValueFactory<Score, Integer>("levelDoneNum") );       
        
        
    }  
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private void logoutButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void backButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("chooseCharacter.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
