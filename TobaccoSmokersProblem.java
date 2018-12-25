package smokersproblem;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

public class TobaccoSmokersProblem {

	static String[] resources_name = new String[] { ("Tobacco"), ("Paper"), ("Matches") };
	static final int TOBACCO = 0;
	static final int PAPER = 1;
	static final int MATCHES = 2;
	
	static CyclicBarrier barrier = new CyclicBarrier(3);
	static Semaphore agentSem = new Semaphore(1);
	static Semaphore[] smokerSem = new Semaphore[3];
	
	
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
				try {
					sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Table.putItem(_ingred1);
				try {
					sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Table.putItem(_ingred2);
				
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
					sleep(5000);
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
						System.out.println(resources_name[ID]+"Smoker starts to smoke.");
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
		for(int i=time/1000;i>=0;i--) {
			System.out.print(i+" ");
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
