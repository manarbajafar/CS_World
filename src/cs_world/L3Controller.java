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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Manar
 */
public class L3Controller implements Initializable {
	
	
	//Sheared Function 
	//Answer that will appear when button clicked
	public void text(Text text, Button button) {
		String type = button.getText()+"digram";
		if(text.getText().contentEquals("You aren't chooseing any answer yet ...")) {
			text.setText(type);
		}
		else if(text.getText().contains(type)) {
			return;	
		}
		else {
			text.setText(text.getText()+", "+type);
		}
	}
	
	//last Q transition
	
	public void finish(ImageView s, ImageView s2, ImageView s3) {
		TranslateTransition translate = new TranslateTransition();
		//Adding the image view to translate object
		translate.setNode(s);
		translate.setByX(30);
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setDuration(Duration.millis(600));
		//translate.setAutoReverse(true);
		translate.setByY(30);
		translate.play();
		
		TranslateTransition translate2 = new TranslateTransition();
		//Adding the image view to translate object
		translate2.setNode(s2);
		translate2.setByX(-30);
		translate2.setCycleCount(TranslateTransition.INDEFINITE);
		translate2.setDuration(Duration.millis(600));
		//translate2.setAutoReverse(true);
		translate2.setByY(-30);
		translate2.play();
		
		TranslateTransition translate3 = new TranslateTransition();
		//Adding the image view to translate object
		translate3.setNode(s3);
		translate3.setByX(30);
		translate3.setCycleCount(TranslateTransition.INDEFINITE);
		translate3.setDuration(Duration.millis(600));
		//translate3.setAutoReverse(true);
		translate3.setByY(-30);
		translate3.play();
                userLogInNow.UpdatelevelDoneNum();
	}
	
	
	//Switching scene 
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToQ2(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("L3_Q2.fxml"));
		//1- Get the source and cast it to a node, 2- get Scene and window then cast it all to a stage 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToQ3(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("L3_Q3.fxml"));
		//1- Get the source and cast it to a node, 2- get Scene and window then cast it all to a stage 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToQ4(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("L3_Q4.fxml"));
		//1- Get the source and cast it to a node, 2- get Scene and window then cast it all to a stage 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToQ5(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("L3_Q5.fxml"));
		//1- Get the source and cast it to a node, 2- get Scene and window then cast it all to a stage 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
        
        public void switchToscore(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("levelscore.fxml"));
		//1- Get the source and cast it to a node, 2- get Scene and window then cast it all to a stage 
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
	//Q1 Scene content 
	@FXML
	private Text question;
	@FXML
	private Text answer;
	@FXML
	private Button ActivityButton ;
	@FXML
	private Button UseCaseButton ;
	@FXML
	private Button CycleButton ;
	@FXML
	private Button StateButton ;
	@FXML
	private Button SequenceButton;
	@FXML
	private Button WaterfallButton;
	
	//Validation button + Change Scene button 
	@FXML
	private Button CheckAnswer;
	@FXML
	private Button next;
	
	public void ifActivityButton(ActionEvent e) {
		text(answer,ActivityButton);	
	}
	public void ifUseCaseButton(ActionEvent e) {
		text(answer,UseCaseButton);	
	}
	public void ifCycleButton(ActionEvent e) {
		text(answer,CycleButton);	
	}
	public void ifStateButton(ActionEvent e) {
		text(answer,StateButton);	
	}
	public void ifSequenceButton(ActionEvent e) {
		text(answer,SequenceButton);	
	}
	public void ifWaterfallButton(ActionEvent e) {
		text(answer,WaterfallButton);	
	}
	
	//Check answer function
	//Correct check mark
	@FXML
	private ImageView checkMark1;
	@FXML
	private ImageView checkMark2;
	@FXML
	private ImageView checkMark3;
	@FXML
	private ImageView checkMark4;
	
	//Wrong check mark
	@FXML
	private ImageView checkMark5;
	@FXML
	private ImageView checkMark6;
	
	
	@FXML
	 void checkAnswerQ1() {
		
		
		String temp = answer.getText();
		if(!temp.contentEquals("You aren't chooseing any answer yet ...")) {
			
			checkMark1.setVisible(true);
			checkMark2.setVisible(true);
			checkMark3.setVisible(true);
			checkMark4.setVisible(true);
			checkMark5.setVisible(true);
			checkMark6.setVisible(true);
			ActivityButton.setDisable(true);
			UseCaseButton.setDisable(true);
			CycleButton.setDisable(true);
			StateButton.setDisable(true);
			SequenceButton.setDisable(true);
			WaterfallButton.setDisable(true);
			CheckAnswer.setDisable(true);
			next.setDisable(false);
		}
	     
	    if((!temp.contains("Cycle") || !temp.contains("Waterfall")) && !temp.contentEquals("You aren't chooseing any answer yet ...")) {     
	    	userLogInNow.increaseUserScore();	    
	}
         }
	
	//Q2 Scene content 
	
	@FXML
	private ImageView writeImg;
	@FXML
	private ImageView theImg;
	@FXML
	private ImageView correctImg;
	@FXML
	private ImageView answerImg;
	@FXML
	private TextField answer2;
	
	
	//Check answer for Q2
	
	//Check marks
	@FXML
	private ImageView correctMarkQ2;
	@FXML
	private ImageView wrongMarkQ2;
	
	@FXML
	 void checkAnswerQ2() {
		
	    String temp = answer2.getText();
	    
	    if(temp.equalsIgnoreCase("DOCTYPE") || temp.equalsIgnoreCase("!DOCTYPE")) {
	    	correctMarkQ2.setVisible(true);
	    	answer2.setDisable(true);
	    	CheckAnswer.setDisable(true);
	    	next.setDisable(false);
                userLogInNow.increaseUserScore();
	    }
	    else if(temp.isEmpty()){
	    	return;
	    }
	    else {
	    	wrongMarkQ2.setVisible(true);
	    	answer2.setDisable(true);
	    	CheckAnswer.setDisable(true);
	    	next.setDisable(false);
	    }
	}

	
	//Q3 Scene content 
	
	@FXML
	private ImageView javaImg;
	@FXML
	private ImageView scriptImg;
	@FXML
	private CheckBox byTagName;
	@FXML
	private CheckBox byValue;
	@FXML
	private CheckBox byCssSelector;
	@FXML
	private CheckBox byLabel;
	@FXML
	private CheckBox byId;
	@FXML
	private CheckBox byClassName;
	
	
	//Check answer for Q3
	
	//Check marks
		@FXML
		private ImageView correctMarkQ3_1;
		@FXML
		private ImageView correctMarkQ3_2;
		@FXML
		private ImageView correctMarkQ3_3;
		@FXML
		private ImageView correctMarkQ3_4;
		@FXML
		private ImageView wrongMarkQ3_1;
		@FXML
		private ImageView wrongMarkQ3_2;
		
		
		@FXML
		 void checkAnswerQ3() {
			
			if(byValue.isSelected() || byLabel.isSelected() || byTagName.isSelected() 
					|| byCssSelector.isSelected() || byId.isSelected() || byClassName.isSelected()) {
				byValue.setDisable(true);
				byLabel.setDisable(true);
				byTagName.setDisable(true);
				byCssSelector.setDisable(true);
				byId.setDisable(true);
				byClassName.setDisable(true);
				correctMarkQ3_1.setVisible(true);
				correctMarkQ3_2.setVisible(true);
				correctMarkQ3_3.setVisible(true);
				correctMarkQ3_4.setVisible(true);
				wrongMarkQ3_1.setVisible(true);
				wrongMarkQ3_2.setVisible(true);
				CheckAnswer.setDisable(true);
				next.setDisable(false);
			}
			
                        
			else if(!byValue.isSelected() && !byLabel.isSelected() && !byTagName.isSelected() 
					&& !byCssSelector.isSelected() && !byId.isSelected() && !byClassName.isSelected()) {
		    	return;
			}
                        else if(!byValue.isSelected() || !byLabel.isSelected() ) {
				userLogInNow.increaseUserScore();
			}

		}

		
		//Q4 Scene content 
		@FXML
		private ImageView chooseImg;
		@FXML
		private Button validation1;
		@FXML
		private Button validation2;
		
		
		//Check answer for Q4
		
		//Check marks
		@FXML
		private ImageView correctMarkQ4;
		@FXML
		private ImageView wrongMarkQ4;
		
		
				@FXML
				 void checkAnswerQ4(ActionEvent e) {
					
					validation1.setDisable(true);
					validation2.setDisable(true);
					correctMarkQ4.setVisible(true);
					wrongMarkQ4.setVisible(true);
					next.setDisable(false);
					
					//for score
					if(e.getSource().equals(validation2) ) {
                                            userLogInNow.increaseUserScore();
					}
					
					
				}
		
				
			
			//Q5 Scene content
			@FXML
			private ImageView chooseimg;
		    @FXML
			private ImageView sImg;
		    @FXML
			private ImageView s2Img;
		    @FXML
			private ImageView s3Img;
		    @FXML 
		    private Button finishButton;
		    @FXML
		    private Button Design_Implementation;
		    @FXML
		    private Button Specification;
		    @FXML
		    private Button Evolution;
		    @FXML
		    private Button Validation;
		   
		    //Check Answer 
		    
		  //Check marks
			@FXML
			private ImageView correctMarkQ5;
			@FXML
			private ImageView wrongMarkQ5_1;
			@FXML
			private ImageView wrongMarkQ5_2;
			@FXML
			private ImageView wrongMarkQ5_3;
			
		    @FXML
			 void checkAnswerQ5(ActionEvent e) {
		    	
		    	Evolution.setDisable(true);
	    		Design_Implementation.setDisable(true);
	    		Specification.setDisable(true);
	    		Validation.setDisable(true);
	    		finishButton.setDisable(false);
	    		sImg.setVisible(true);
	    		s2Img.setVisible(true);
	    		s3Img.setVisible(true);
	    		correctMarkQ5.setVisible(true);
	    		wrongMarkQ5_1.setVisible(true);
	    		wrongMarkQ5_2.setVisible(true);
	    		wrongMarkQ5_3.setVisible(true);
	    		finish(sImg,s2Img,s3Img);
				
		    	if(e.getSource().equals(Evolution)) {	
                        userLogInNow.increaseUserScore();
		    	}

		    	
		    }    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//Translation  For first Q Scene
		TranslateTransition translate1 = new TranslateTransition();
		//Adding the buttons to translate object
		translate1.setNode(ActivityButton);
		translate1.setByX(5);
		translate1.setCycleCount(TranslateTransition.INDEFINITE);
		translate1.setDuration(Duration.millis(1000));
		translate1.setAutoReverse(true);
		translate1.setByY(5);
		translate1.play();
		
		TranslateTransition translate2 = new TranslateTransition();
		//Adding the buttons to translate object
		translate2.setNode(UseCaseButton);
		translate2.setByX(5);
		translate2.setCycleCount(TranslateTransition.INDEFINITE);
		translate2.setDuration(Duration.millis(1000));
		translate2.setAutoReverse(true);
		translate2.setByY(5);
		translate2.play();
		
		TranslateTransition translate3 = new TranslateTransition();
		//Adding the buttons to translate object
		translate3.setNode(CycleButton);
		translate3.setByX(5);
		translate3.setCycleCount(TranslateTransition.INDEFINITE);
		translate3.setDuration(Duration.millis(1000));
		translate3.setAutoReverse(true);
		translate3.setByY(5);
		translate3.play();
		
		TranslateTransition translate4 = new TranslateTransition();
		//Adding the buttons to translate object
		translate4.setNode(StateButton);
		translate4.setByX(5);
		translate4.setCycleCount(TranslateTransition.INDEFINITE);
		translate4.setDuration(Duration.millis(1000));
		translate4.setAutoReverse(true);
		translate4.setByY(5);
		translate4.play();
		
		TranslateTransition translate5 = new TranslateTransition();
		//Adding the buttons to translate object
		translate5.setNode(SequenceButton);
		translate5.setByX(5);
		translate5.setCycleCount(TranslateTransition.INDEFINITE);
		translate5.setDuration(Duration.millis(1000));
		translate5.setAutoReverse(true);
		translate5.setByY(5);
		translate5.play();
		
		TranslateTransition translate6 = new TranslateTransition();
		//Adding the buttons to translate object
		translate6.setNode(WaterfallButton);
		translate6.setByX(5);
		translate6.setCycleCount(TranslateTransition.INDEFINITE);
		translate6.setDuration(Duration.millis(1000));
		translate6.setAutoReverse(true);
		translate6.setByY(5);
		translate6.play();
		
		//Translation  For Second Q Scene

		TranslateTransition translate7 = new TranslateTransition();
		//Adding the image view to translate object
		translate7.setNode(writeImg);
		translate7.setByX(5);
		translate7.setCycleCount(TranslateTransition.INDEFINITE);
		translate7.setDuration(Duration.millis(1000));
		translate7.setAutoReverse(true);
		translate7.setByY(5);
		translate7.play();
		
		TranslateTransition translate8 = new TranslateTransition();
		//Adding the image view to translate object
		translate8.setNode(theImg);
		translate8.setByX(5);
		translate8.setCycleCount(TranslateTransition.INDEFINITE);
		translate8.setDuration(Duration.millis(1000));
		translate8.setAutoReverse(true);
		translate8.setByY(5);
		translate8.play();
		
		
		TranslateTransition translate9 = new TranslateTransition();
		//Adding the image view to translate object
		translate9.setNode(correctImg);
		translate9.setByX(5);
		translate9.setCycleCount(TranslateTransition.INDEFINITE);
		translate9.setDuration(Duration.millis(1000));
		translate9.setAutoReverse(true);
		translate9.setByY(5);
		translate9.play();
		
		TranslateTransition translate10 = new TranslateTransition();
		//Adding the image view to translate object
		translate10.setNode(answerImg);
		translate10.setByX(5);
		translate10.setCycleCount(TranslateTransition.INDEFINITE);
		translate10.setDuration(Duration.millis(1000));
		translate10.setAutoReverse(true);
		translate10.setByY(5);
		translate10.play();
		
		//Translation  For Third Q Scene
		
		TranslateTransition translate11 = new TranslateTransition();
		//Adding the image view to translate object
		translate11.setNode(javaImg);
		translate11.setByX(3);
		translate11.setCycleCount(TranslateTransition.INDEFINITE);
		translate11.setDuration(Duration.millis(1000));
		translate11.setAutoReverse(true);
		translate11.setByY(3);
		translate11.play();
		
		TranslateTransition translate12 = new TranslateTransition();
		//Adding the image view to translate object
		translate12.setNode(scriptImg);
		translate12.setByX(3);
		translate12.setCycleCount(TranslateTransition.INDEFINITE);
		translate12.setDuration(Duration.millis(1000));
		translate12.setAutoReverse(true);
		translate12.setByY(3);
		translate12.play();
		
		//Translation  For Fourth Q Scene
		
				TranslateTransition translate13 = new TranslateTransition();
				//Adding the image view to translate object
				translate13.setNode(chooseImg);
				translate13.setByX(3);
				translate13.setCycleCount(TranslateTransition.INDEFINITE);
				translate13.setDuration(Duration.millis(1000));
				translate13.setAutoReverse(true);
				translate13.setByY(3);
				translate13.play();
				
				TranslateTransition translate14 = new TranslateTransition();
				//Adding the image view to translate object
				translate14.setNode(validation1);
				translate14.setByX(3);
				translate14.setCycleCount(TranslateTransition.INDEFINITE);
				translate14.setDuration(Duration.millis(1000));
				translate14.setAutoReverse(true);
				translate14.setByY(3);
				translate14.play();
				
				TranslateTransition translate15 = new TranslateTransition();
				//Adding the image view to translate object
				translate15.setNode(validation2);
				translate15.setByX(3);
				translate15.setCycleCount(TranslateTransition.INDEFINITE);
				translate15.setDuration(Duration.millis(1000));
				translate15.setAutoReverse(true);
				translate15.setByY(3);
				translate15.play();
				
				
                //Translation  For last Q Scene
				
				TranslateTransition translate17 = new TranslateTransition();
				//Adding the image view to translate object
				translate17.setNode(chooseimg);
				translate17.setByX(2);
				translate17.setCycleCount(TranslateTransition.INDEFINITE);
				translate17.setDuration(Duration.millis(1000));
				translate17.setAutoReverse(true);
				translate17.setByY(2);
				translate17.play();
	}
	
	
}
