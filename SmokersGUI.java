package application;
	
import javafx.application.Application;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.TranslateTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SmokersGUI extends Application {
	
	private Scene home;
	private Stage window; 
	private Pane root;
	private  Calendar dateTime;
	
	ImageView cigarette = new ImageView();
	ImageView tobacco1 = new ImageView();
	ImageView paper1 = new ImageView();
	ImageView match1 = new ImageView();

	public Scene home() {
		//Pane root = new Pane();
		
	    if (home == null) {
	        // build my scene
	        home = new Scene(pane(), 900, 700);

	        // or maybe do this without testing, if the scene was created before???
	    }
	    
	    return home;
	} 
	public Pane pane() {
		if(root == null) {
			root = new Pane(); 
		}
		return root;
	}
	public void matchMove() {
		//ImageView match1 = new ImageView();
		match1.setImage(new Image("file:src/pictures/cerillos.png"));
		match1.setFitWidth(70);
		match1.setFitHeight(70);
		match1.setLayoutX(570);
		match1.setLayoutY(410);
		pane().getChildren().add(match1);
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(match1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);
		translate.setNode(match1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(4));
		translate.setToX(-150);
		translate.setToY(-350);
		translate.setOnFinished(e->paperMove());
		scale.play();
		translate.play();
	}
	public void paperMove() {
		
		//ImageView paper1 = new ImageView();
		paper1.setImage(new Image("file:src/pictures/paper.png"));
		paper1.setFitWidth(70);
		paper1.setFitHeight(70);
		paper1.setLayoutX(640);
		paper1.setLayoutY(410);
		pane().getChildren().add(paper1);
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(paper1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);
		translate.setNode(paper1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(4));
		translate.setToX(-60);
		translate.setToY(-350);
		translate.setOnFinished(e->tobaccoMove());
		scale.play();
		translate.play();
	}
public void tobaccoMove() {
		
		//ImageView tobacco1 = new ImageView();
		tobacco1.setImage(new Image("file:src/pictures/tobacco.png"));
		tobacco1.setFitWidth(70);
		tobacco1.setFitHeight(70);
		tobacco1.setLayoutX(715);
		tobacco1.setLayoutY(410);
		pane().getChildren().add(tobacco1);
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(tobacco1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);
		translate.setNode(tobacco1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(4));
		translate.setToX(40);
		translate.setToY(-350);
		//translate.setOnFinished(e->CigaretteMoveToPaper());
		//translate.setOnFinished(e->CigaretteMoveToMatch());
		translate.setOnFinished(e->CigaretteMoveToTobacco());
		scale.play();
		translate.play();
		//deleteCigarette();
	}
	public void CigaretteMoveToMatch() {
		//ImageView cigarette = new ImageView();
		cigarette.setImage(new Image("file:src/pictures/1530542745.png"));
		cigarette.setFitWidth(140);
		cigarette.setFitHeight(140);
		cigarette.setLayoutX(540);
		cigarette.setLayoutY(10);
		pane().getChildren().add(cigarette);
		pane().getChildren().remove(tobacco1);
		pane().getChildren().remove(paper1);
		TranslateTransition translate = new TranslateTransition();
		/*ScaleTransition scale = new ScaleTransition();
		scale.setNode(cigarette);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);*/
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(5));
		translate.setToX(-400);
		translate.setToY(500);
		//scale.play();
		translate.play();
	}
	
	public void CigaretteMoveToPaper() {
		//ImageView cigarette = new ImageView();
		cigarette.setImage(new Image("file:src/pictures/1530542745.png"));
		cigarette.setFitWidth(140);
		cigarette.setFitHeight(140);
		cigarette.setLayoutX(540);
		cigarette.setLayoutY(10);
		pane().getChildren().add(cigarette);
		pane().getChildren().remove(tobacco1);
		pane().getChildren().remove(match1);
		TranslateTransition translate = new TranslateTransition();
		/*ScaleTransition scale = new ScaleTransition();
		scale.setNode(cigarette);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);*/
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(5));
		translate.setToX(-100);
		translate.setToY(500);
		//scale.play();
		translate.play();
	}
	
	public void CigaretteMoveToTobacco() {
		//ImageView cigarette = new ImageView();
		cigarette.setImage(new Image("file:src/pictures/1530542745.png"));
		cigarette.setFitWidth(140);
		cigarette.setFitHeight(140);
		cigarette.setLayoutX(540);
		cigarette.setLayoutY(10);
		pane().getChildren().add(cigarette);
		pane().getChildren().remove(paper1);
		pane().getChildren().remove(match1);
		TranslateTransition translate = new TranslateTransition();		
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(5));
		translate.setToX(200);
		translate.setToY(500);
		translate.play();
		translate.setOnFinished(e->deleteCigarette());
	}
	
	public void deleteCigarette() {
		pane().getChildren().remove(cigarette);
	}
	@Override
	public void start(Stage stage) {
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		ImageView bar = new ImageView();
		bar.setImage(new Image("file:src/pictures/bar.png"));
		bar.setFitWidth(900);
		bar.setFitHeight(700);
		
		//Image image = new Image("file:src/pictures/timeWhite.gif");
	    /*ImageView time = new ImageView();
	    time.setImage(new Image("file:src/pictures/timeWhite.gif"));
	    time.setFitWidth(70);
	    time.setFitHeight(70);
	    time.setLayoutX(80);
		time.setLayoutY(80);*/
		
		/*Label label1 = new Label("Time");
		label1.setLayoutX(50);
		label1.setLayoutY(50);
		label1.setTextFill(Color.web("#FFFFFF"));
	    label1.setFont(new Font("Arial", 30));
	    pane().getChildren().add(label1);*/

		ImageView match = new ImageView();
		match.setImage(new Image("file:src/pictures/cerillos.png"));
		match.setFitWidth(70);
		match.setFitHeight(70);
		match.setLayoutX(570);
		match.setLayoutY(410);
		
		ImageView paper = new ImageView();
		paper.setImage(new Image("file:src/pictures/paper.png"));
		paper.setFitWidth(70);
		paper.setFitHeight(70);
		paper.setLayoutX(640);
		paper.setLayoutY(410);
		
		ImageView tobacco = new ImageView();
		tobacco.setImage(new Image("file:src/pictures/tobacco.png"));
		tobacco.setFitWidth(70);
		tobacco.setFitHeight(70);
		tobacco.setLayoutX(715);
		tobacco.setLayoutY(410);
		
		ImageView matchPeople = new ImageView();
		matchPeople.setImage(new Image("file:src/pictures/matchPeople.png"));
		matchPeople.setFitWidth(150);
		matchPeople.setFitHeight(150);
		matchPeople.setLayoutX(70);
		matchPeople.setLayoutY(540);
		
		ImageView paperPeople = new ImageView();
		paperPeople.setImage(new Image("file:src/pictures/paperPeople.png"));
		paperPeople.setFitWidth(150);
		paperPeople.setFitHeight(150);
		paperPeople.setLayoutX(370);
		paperPeople.setLayoutY(540);
		
		ImageView tobaccoPeople = new ImageView();
		tobaccoPeople.setImage(new Image("file:src/pictures/tobaccoPeople.png"));
		tobaccoPeople.setFitWidth(150);
		tobaccoPeople.setFitHeight(150);
		tobaccoPeople.setLayoutX(670);
		tobaccoPeople.setLayoutY(540);
		
		ImageView time = new ImageView();
		time.setImage(new Image("file:src/pictures/沙漏.png"));
		time.setFitWidth(190);
		time.setFitHeight(160);
		time.setLayoutX(-50);
		time.setLayoutY(0);
		RotateTransition  rotate = new RotateTransition();
		rotate.setNode(time);
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setDuration(Duration.seconds(2));
		rotate.setFromAngle(0);
		rotate.setToAngle(360);
		rotate.play();
		//HBox hbox = new HBox();

		Label label1 = new Label("Time:");
		label1.setLayoutX(85);
		label1.setLayoutY(60);
	
		label1.setTextFill(Color.web("#FFFFFF"));
	    label1.setFont(new Font("Arial", 35));
	    
	    ImageView event = new ImageView();
		event.setImage(new Image("file:src/pictures/event.png"));
		event.setFitWidth(60);
		event.setFitHeight(60);
		event.setLayoutX(10);
		event.setLayoutY(120);
	    Label label2 = new Label("Event:");
		label2.setLayoutX(90);
		label2.setLayoutY(130);
		label2.setTextFill(Color.web("#FFFFFF"));
	    label2.setFont(new Font("Arial", 35));
	   
	   // hbox.setLayoutX(100);
	    //hbox.setLayoutY(100);
	    //hbox.setSpacing(30);
	    //hbox.getChildren().add((label1));
	    //pane().getChildren().add(hbox);
	    //pane().getChildren().add(label1);
		
		//Pane root = new Pane();
		pane().getChildren().add(bar);
		pane().getChildren().add(match);
		pane().getChildren().add(paper);
		pane().getChildren().add(tobacco);
		pane().getChildren().add(matchPeople);
		pane().getChildren().add(paperPeople);
		pane().getChildren().add(tobaccoPeople);
		pane().getChildren().add(label1);
		pane().getChildren().add(time);
		pane().getChildren().add(label2);
		pane().getChildren().add(event);
		//Scene scene = new Scene(root, 900 , 700);
		//matchMove();
		//paperMove();
		//tobaccoMove();
		window = stage;
	    window.setScene(home());
		window.show();
	}
	public static void main(String[] args) {			
		launch(args);
	}
}
