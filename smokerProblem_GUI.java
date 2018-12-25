package application;
	
import javafx.application.Application;


import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.TranslateTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;


public class smokerProblem_GUI extends Application {
	
	private Scene home;
	private Stage window; 
	private static Pane root;
	private  Calendar dateTime;
	
	static ImageView cigarette = new ImageView();
	static ImageView tobacco1 = new ImageView();
	static ImageView paper1 = new ImageView();
	static ImageView match1 = new ImageView();
	
	static Label matchNum = new Label();
	static Label paperNum = new Label();
	static Label tobaccoNum = new Label();
	static Label timeDown = new Label();
	static Label eventHappen = new Label();
	
	static String[] resources_name = new String[] { ("Tobacco"), ("Paper"), ("Matches") };
	static final int TOBACCO = 0;
	static final int PAPER = 1;
	static final int MATCHES = 2;
	
	static CyclicBarrier barrier = new CyclicBarrier(3);
	static Semaphore agentSem = new Semaphore(1);
	static Semaphore[] smokerSem = new Semaphore[3];
	
    static int i;
    
	public Scene home() {
		//Pane root = new Pane();
		
	    if (home == null) {
	        // build my scene
	        home = new Scene(pane(), 900, 700);
	    }
	    
	    return home;
	} 
	public static Pane pane() {
		if(root == null) {
			root = new Pane(); 
		}
		return root;
	}
	public static void matchMove() {
		Platform.runLater(()->{
		match1.setImage(new Image("file:src/pictures/cerillos.png"));
		match1.setFitWidth(70);
		match1.setFitHeight(70);
		match1.setLayoutX(570);
		match1.setLayoutY(410);
		pane().getChildren().add(match1);//});
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(match1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);
		translate.setNode(match1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(3));
		translate.setToX(-150);
		translate.setToY(-350);
		scale.play();
		translate.play();});
	}
	public static void paperMove() {
		
		Platform.runLater(()->{
		paper1.setImage(new Image("file:src/pictures/paper.png"));
		paper1.setFitWidth(70);
		paper1.setFitHeight(70);
		paper1.setLayoutX(640);
		paper1.setLayoutY(410);
		pane().getChildren().add(paper1);//});
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(paper1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.4));
		scale.setToX(2);
		scale.setToY(2);
		translate.setNode(paper1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(3));
		translate.setToX(-60);
		translate.setToY(-350);
		scale.play();
		translate.play();});
	}
public static void tobaccoMove() {
		
	    Platform.runLater(()->{
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
		translate.setDuration(Duration.seconds(3));
		translate.setToX(40);
		translate.setToY(-350);
		scale.play();
		translate.play();});
	}
	public static void CigaretteMoveToMatch() {
		cigarette.setImage(new Image("file:src/pictures/1530542745.png"));
		cigarette.setFitWidth(140);
		cigarette.setFitHeight(140);
		cigarette.setLayoutX(540);
		cigarette.setLayoutY(10);
		Platform.runLater(()->{
		pane().getChildren().add(cigarette);});
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(2));
		translate.setToX(-400);
		translate.setToY(500);
		translate.play();//});
	}
	
	public static void CigaretteMoveToPaper() {
		cigarette.setImage(new Image("file:src/pictures/1530542745.png"));
		cigarette.setFitWidth(140);
		cigarette.setFitHeight(140);
		cigarette.setLayoutX(540);
		cigarette.setLayoutY(10);
		Platform.runLater(()->{
		pane().getChildren().add(cigarette);});
		TranslateTransition translate = new TranslateTransition();		
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(2));
		translate.setToX(-100);
		translate.setToY(500);
		translate.play();//});
	}
	
	public static void CigaretteMoveToTobacco() {
		cigarette.setImage(new Image("file:src/pictures/1530542745.png"));
		cigarette.setFitWidth(140);
		cigarette.setFitHeight(140);
		cigarette.setLayoutX(540);
		cigarette.setLayoutY(10);
		Platform.runLater(()->{
		pane().getChildren().add(cigarette);});
		TranslateTransition translate = new TranslateTransition();		
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(2));
		translate.setToX(200);
		translate.setToY(500);
		translate.play();//});
	}
	
	public static void deleteCigarette() {
		Platform.runLater(()->{
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(cigarette);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(0.1));
		translate.setToX(0);
		translate.setToY(2);
		translate.play();
		pane().getChildren().remove(cigarette);});
	}
	public static void deleteMatch() {
		Platform.runLater(()->{
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(match1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.1));
		scale.setToX(1);
		scale.setToY(1);
		translate.setNode(match1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(0.1));
		translate.setToX(0);
		translate.setToY(2);
		scale.play();
		translate.play();
			pane().getChildren().remove(match1);});
	}
	public static void deletePaper() {
		Platform.runLater(()->{
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(paper1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.1));
		scale.setToX(1);
		scale.setToY(1);
		translate.setNode(paper1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(0.1));
		translate.setToX(0);
		translate.setToY(2);
		scale.play();
		translate.play();
			pane().getChildren().remove(paper1);});
	}
	public static void deleteTobacco() {
		Platform.runLater(()->{
		TranslateTransition translate = new TranslateTransition();
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(tobacco1);
		scale.setCycleCount(1);
		scale.setDuration(Duration.seconds(0.1));
		scale.setToX(1);
		scale.setToY(1);
		translate.setNode(tobacco1);
		translate.setCycleCount(1);
		translate.setDuration(Duration.seconds(0.1));
		translate.setToX(0);
		translate.setToY(2);
		scale.play();
		translate.play();
			pane().getChildren().remove(tobacco1);});
	}

	@Override
	public void start(Stage stage) {
		
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
		time.setLayoutY(10);
		RotateTransition  rotate = new RotateTransition();
		rotate.setNode(time);
		rotate.setCycleCount(Timeline.INDEFINITE);
		rotate.setDuration(Duration.seconds(2));
		rotate.setFromAngle(0);
		rotate.setToAngle(360);
		rotate.play();
		

		Label label1 = new Label("Time:");
		label1.setLayoutX(85);
		label1.setLayoutY(70);
	
		label1.setTextFill(Color.web("#FFFFFF"));
	    label1.setFont(new Font("Arial", 35));
	    
	    ImageView event = new ImageView();
		event.setImage(new Image("file:src/pictures/event.png"));
		event.setFitWidth(60);
		event.setFitHeight(60);
		event.setLayoutX(10);
		event.setLayoutY(130);
		
	    Label label2 = new Label("Event:");
		label2.setLayoutX(90);
		label2.setLayoutY(140);
		label2.setTextFill(Color.web("#FFFFFF"));
	    label2.setFont(new Font("Arial", 35));
	   
	    matchNum.setText("0");
		matchNum.setLayoutX(250);
		matchNum.setLayoutY(650);	
		matchNum.setTextFill(Color.web("#FFFFFF"));
		matchNum.setFont(new Font("Arial", 35));
		
		paperNum.setText("0");
		paperNum.setLayoutX(550);
		paperNum.setLayoutY(650);	
		paperNum.setTextFill(Color.web("#FFFFFF"));
		paperNum.setFont(new Font("Arial", 35));
		
		tobaccoNum.setText("0");
		tobaccoNum.setLayoutX(850);
		tobaccoNum.setLayoutY(650);	
		tobaccoNum.setTextFill(Color.web("#FFFFFF"));
		tobaccoNum.setFont(new Font("Arial", 35));
		
		timeDown.setText(" ");
		timeDown.setLayoutX(190);
		timeDown.setLayoutY(70);	
		timeDown.setTextFill(Color.web("#FFFFFF"));
		timeDown.setFont(new Font("Arial", 35));
		
		eventHappen.setText(" ");
		eventHappen.setLayoutX(200);
		eventHappen.setLayoutY(150);	
		eventHappen.setTextFill(Color.web("#FFFFFF"));
		eventHappen.setFont(new Font("Arial", 25));
		
		
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
		pane().getChildren().add(matchNum);
		pane().getChildren().add(paperNum);
		pane().getChildren().add(tobaccoNum);
		pane().getChildren().add(timeDown);
		pane().getChildren().add(eventHappen);
	
		window = stage;
	    window.setScene(home());
		window.show();
	}
	
	
	
	
	
	public static void main(String[] args) {
		
				// smokerSemaphore set 0 to prevent the Deadlock.
				for (int i = 0; i < smokerSem.length; i++) {
					smokerSem[i] = new Semaphore(0);
				}
				
				Agent paper_matches_agent = new Agent(PAPER, MATCHES, 0);
				Agent matches_tobacco_agent = new Agent(MATCHES, TOBACCO, 1);
				Agent tobacco_paper_agent = new Agent(TOBACCO, PAPER, 2);

				Smoker tobacco_smoker = new Smoker(PAPER, MATCHES, 0);
				Smoker paper_smoker = new Smoker(MATCHES, TOBACCO, 1);
				Smoker matches_smoker = new Smoker(TOBACCO, PAPER, 2);

				
				tobacco_paper_agent.start();
				paper_matches_agent.start();
				matches_tobacco_agent.start();
				
				tobacco_smoker.start();
				paper_smoker.start();
				matches_smoker.start();
				Application.launch(Main.class, args);
	}
	
	public static class Agent extends Thread {
		private int _ingred1, _ingred2, called_smoker;
		private static int round;
		private static int previous;
		private static int previous_time;
		
		public Agent(int ingred1, int ingred2, int smoker) {
			super();
			this._ingred1 = ingred1;
			this._ingred2 = ingred2;
			this.called_smoker = smoker;
		}
		
		public void run() {
			try {
				barrier.await();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
			while(true) {
				
				if(previous_time > 2 && previous == this.called_smoker) {
					System.out.println("Over 3 times!");
					previous_time = 0;
					continue;
				}
				System.out.println(this.getName());
				while(agentSem.availablePermits()==0);
				System.out.println(this.getName());
				// Wait for the agent to prepare ingredient.
				try {					
					agentSem.acquire();	
					synchronized(this) {
						System.out.println(previous+" "+previous_time);
						if(previous == this.called_smoker) previous_time++;
						else previous_time=0;
						previous = this.called_smoker;
					}
					sleep(3000);
					System.out.println("------------------------------");
					synchronized (this){
						round++;
						System.out.println("Round "+round+":");
					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				// Put two ingredient on the table.
				System.out.println("Agent prepare for " + resources_name[_ingred1] + " & " + resources_name[_ingred2]+".");
				Platform.runLater(()->{
				eventHappen.setText("Agent prepare for " + resources_name[_ingred1] + " & " + resources_name[_ingred2]+".");});
				try {
					sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Table.putItem(_ingred1);
				if(_ingred1 == 0) {
					tobaccoMove();
				}
				else if(_ingred1 == 1) {
					paperMove();
				}
				else if(_ingred1 == 2) {
					matchMove();
				}
				try {
					sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Table.putItem(_ingred2);
				if(_ingred2 == 0) {
					tobaccoMove();
				}
				else if(_ingred2 == 1) {
					paperMove();
				}
				else if(_ingred2 == 2) {
					matchMove();
				}
				
				// Release the called smoker.				
				smokerSem[called_smoker].release();
			}
		}
	}
	
	private static class Smoker extends Thread {
		private int _need1,_need2;
		private boolean completeSmoke;
		private int ID;
		private int smoking_times;
		private int timer;
		
		public Smoker(int need1, int need2, int ID) {
			super();
			this._need1 = need1;
			this._need2 = need2;
			this.ID = ID;
			this.completeSmoke = false;
		}
		
		public void run() {

			while(true) {
				
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(Table.isItemExisted(_need1,_need2)) {
					try {
						smokerSem[ID].acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(Table.getItem(_need1) && Table.getItem(_need2)) {
						try {
							sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(ID == 0) {
							CigaretteMoveToTobacco();
						}
						else if(ID == 1) {
							CigaretteMoveToPaper();
						}
						else if(ID == 2) {
							CigaretteMoveToMatch();
						}
						
						System.out.println(resources_name[ID]+"Smoker starts to smoke.");
						Platform.runLater(()->{
							eventHappen.setText(resources_name[ID]+"Smoker starts to smoke.");});
						synchronized (this) {
							timer = getPoissonRandom(8)*1000;
							timerCountDown(timer);
						}
						this.completeSmoke = true;
					}
					else {
						System.out.println("Found no ingredient on the table!");
					}
				}
				
				if (this.completeSmoke) {
					this.completeSmoke = false;

					synchronized(this) {
						smoking_times++;
						System.out.println("Done! "+ resources_name[ID] + "Smoker complete the smoking "+ smoking_times +" times!");
						Platform.runLater(()->{
							eventHappen.setText(resources_name[ID] + "Smoker complete.");});
						if(ID == 0) {
							deleteCigarette();
							deleteMatch();
							deletePaper();
							Platform.runLater(()->{
							tobaccoNum.setText(smoking_times + " ");});
						}
						else if(ID == 1) {
							deleteCigarette();
							deleteMatch();
							deleteTobacco();
							Platform.runLater(()->{
							paperNum.setText(smoking_times + " ");});
						}
						else if(ID == 2) {
							deleteCigarette();
							deletePaper();
							deleteTobacco();
							Platform.runLater(()->{
							matchNum.setText(smoking_times + " ");});
						}
					}
					
					synchronized (this) {
						timer = getPoissonRandom(8)*1000;
						timerCountDown(timer);
					}
					agentSem.release();
				}
			}
		}
	}
	
	private static class Table {
		private static boolean[] resources = new boolean[] {false, false, false};
		
		// Put two items on the table
		public static void putItem(int item) {
			resources[item] = true;
			System.out.println(resources_name[item]+" is on the table.");
			Platform.runLater(()->{
				eventHappen.setText(resources_name[item]+" is on the table.");});
		}
		
		// Get the item from the table
		public static boolean getItem(int item) {
			if (resources[item]) {
				resources[item] = false;
				return true;
			}
			else return false;
		}
		
		// Check if the item is existed on the table
		public static boolean isItemExisted(int item1,int item2) {
			return resources[item1] && resources[item2];
		}
		
	}
	
	private static int getPoissonRandom(double mean) {
		Random r = new Random();
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do {
			p = p * r.nextDouble();
			k++;
		} while (p > L);
		return k - 1;
	}
	
	private static void timerCountDown(int time) {
		for(i=time/1000;i>=0;i--) {
			System.out.print(i+" ");
			Platform.runLater(()->{
				timeDown.setText(i+" ");});
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}

