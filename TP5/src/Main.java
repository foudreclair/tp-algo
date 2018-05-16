import java.util.List;
import java.util.Random;

public class Main {
	
	private static final Random rand = new Random(System.currentTimeMillis());
	
	public static long [] generateJobs(int nbJobs) {
		long [] jobs = new long[nbJobs];
		
		for(int j=0;j< jobs.length; j++)
			jobs[j] = (long) rand.nextInt(10000);
		
		return jobs;
	}
	
	public static void main(String [] args) {
		
		long [] jobs = generateJobs(9);
		SchedulingLPT lpt = new SchedulingLPT();
		List<int[]> l = lpt.execute(5, jobs);
		for(int [] L : l) {
			System.out.print(L[0] + " ");
			System.out.println(L[1]);
		}
		SchedulingBAB bab = new SchedulingBAB();
		bab.stressTest(5, jobs);
		/*
		Scheduler lptScheduler = new Scheduler(5, jobs, new SchedulingLPT());
		lptScheduler.startScheduling();
		
		

		
		Scheduler babScheduler = new Scheduler(5, jobs, new SchedulingBAB());
		babScheduler.startScheduling();
		
		
		System.out.println("LPT result = " + lptScheduler.getMakespan());
		System.out.println("BAB result = " + babScheduler.getMakespan());
		*/
				
	}
}
