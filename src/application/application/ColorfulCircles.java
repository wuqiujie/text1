package application;


import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;


/*
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
*/
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;





import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.util.concurrent.TimeUnit;
 
public class ColorfulCircles extends Application {
	smokerProblem_GUI ob = new smokerProblem_GUI();
	
	
	@Override
	public void start(Stage primaryStage ){
	

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
		
	    
		/*********************************************/
	  
       Button bt =new Button("start");
       bt.setPrefSize(100, 10);
       bt.setTranslateX(400.0);
	   bt.setTranslateY(550.0);
       bt.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
    	  public void handle(ActionEvent event) {
    	   primaryStage.setScene(ob.home());
    	   smokerProblem_GUI.main(null);
       }
       });
	   
	   
	   
	   
	   root.getChildren().add(bt);
      
      
     

	  
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
       
   

	    ProgressBar p = new ProgressBar(); 
	    p.setPrefSize(500, 10);
	    p.setTranslateX(200.0);
	    p.setTranslateY(450.0);
	    root.getChildren().add(p);
	    
	    primaryStage.show();
  
        
        
        
        
        
        
        
        
        
        
  
      
        
        BasicPlayer player = new BasicPlayer();
        try {
            player.open(new URL("file:src/music/1.mp3"));
            player.play();
        } catch (BasicPlayerException | MalformedURLException e) {
            e.printStackTrace();
        }
       
        primaryStage.show();
  
      
		
	}
	
	
	
	
	   
	  public static void main(String[] args) {
			launch(args);
		}
					
	
}







