package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.animation.TranslateTransition;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.text.Text;

import java.awt.Button;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.scene.layout.StackPane;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;


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
	
	/*******************************************/
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
 
		Group circles = new Group();
		for (int i = 0; i < 30; i++) {
			Circle circle = new Circle(150, Color.web("yellow", 0.08));
			circle.setStrokeType(StrokeType.OUTSIDE);
			circle.setStroke(Color.web("white", 0.5));
			circle.setStrokeWidth(4);
			circles.getChildren().add(circle);
		}
		circles.setEffect(new BoxBlur(10, 10, 3));
 
		Scene scene = new Scene(root, 900, 700, Color.BLACK);
		primaryStage.setScene(scene);
 
		Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
				new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
						new Stop[] { new Stop(0, Color.web("#f8bd55")),
								new Stop(0.14, Color.web("#c0fe56")),
								new Stop(0.28, Color.web("#5dfbc1")),
								new Stop(0.43, Color.web("#64c2f8")),
								new Stop(0.57, Color.web("#be4af7")),
								new Stop(0.71, Color.web("#ed5fc2")),
								new Stop(0.85, Color.web("#ef504c")),
								new Stop(1, Color.web("#f2660f")), }));
 
		colors.widthProperty().bind(scene.widthProperty());
		colors.heightProperty().bind(scene.heightProperty());
 
		Group blendModeGroup = new Group(new Group(new Rectangle(
				scene.getWidth(), scene.getHeight(), Color.LIGHTBLUE), circles),colors);
		
		colors.setBlendMode(BlendMode.OVERLAY);
		
		root.getChildren().add(blendModeGroup);
		
		
		Timeline timeline = new Timeline();
		for (Node circle: circles.getChildren()) {
		    timeline.getKeyFrames().addAll(
		        new KeyFrame(Duration.ZERO, // set start position at 0
		            new KeyValue(circle.translateXProperty(), Math.random() * 900),
		            new KeyValue(circle.translateYProperty(), Math.random() * 700)
		        ),
		        new KeyFrame(new Duration(10000), // set end position at 10s
		            new KeyValue(circle.translateXProperty(), Math.random() * 900),
		            new KeyValue(circle.translateYProperty(), Math.random() * 700)
		        )
		    );
		}
		
		
		
		
		/*********************************************/
		
	    ProgressBar p = new ProgressBar(); 
	    p.setPrefSize(500, 10);
	    p.setTranslateX(200.0);
	    p.setTranslateY(450.0);
	    root.getChildren().add(p);
	    
	    primaryStage.show();
	    
		/*********************************************/
	  
       

	  
	    /*********************************************/
	    primaryStage.setTitle("");
 
        Text t = new Text();
        t.setX(30.0);
        t.setY(340.0);
        t.setCache(true);
        t.setText("作業系統期末專案");
        t.setFill(Color.LIGHTPINK);
        t.setFont(Font.font(null, FontWeight.BOLD, 100));
       
        Reflection r = new Reflection();
        r.setFraction(0.7);
        t.setEffect(r);
       
        root.getChildren().add(t); 
        
        Text d = new Text();
        d.setX(600.0);
        d.setY(550.0);
        d.setWrappingWidth(200);
        d.setText("第二組            105703001 李筱涵 105703021 吳秋潔 105703027 賴雅鈴 ");
        d.setFont(new Font(20));
        d.setFill(Color.CORNFLOWERBLUE);
       
        root.getChildren().add(d); 
	    
		timeline.play();
        primaryStage.show();
	    /*********************************************/
       
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(0),
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                    	nstart();
                    
                    }
                }

                ), new KeyFrame(Duration.seconds(1)));
                      timeline.setCycleCount(Animation.INDEFINITE);
                timeline1.play(); // timeline.stop()
		
       
  
	}
        
        
        
        
        
        
        
        
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/****************************************************/
	
	
	
	
	
		public void nstart() {
		Stage stage =new Stage();
		
		

		ImageView bar = new ImageView();
		bar.setImage(new Image("file:src/pictures/bar.png"));
		bar.setFitWidth(900);
		bar.setFitHeight(700);
		
		
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
		
		
		
		window = stage;
	   window.setScene(home());
		window.show();
  
		 BasicPlayer player = new BasicPlayer();
	        try {
	            player.open(new URL("file:src/music/1.wav"));
	            player.play();
	        } catch (BasicPlayerException | MalformedURLException e) {
	            e.printStackTrace();
	        }     
	    
	   
	  
		
	}
	
	
	public static void main(String[] args) {			

		 
		launch(args);
	
	
	}
	
}
