import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SchedulingBAB {
	  // Number of threads, n
    private int numWorkers;
    // The processing time of each job i
    private long[] jobs;
    // The thread id of which each job is assigned to
    private int[] assignedWorker;
    // The thread ids of naive solution
    private int[] assignedWorker_naive;
    // The start_time of each job
    private long[] startTime, startTime_naive;
    public static void main(String[] args) throws IOException {
       // new SchedulingBAB().stressTest();
    }
    
    private void assignJobs_naive() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker_naive = new int[jobs.length];
        startTime_naive = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < jobs.length; i++) {
            long duration = jobs[i];
            int bestWorker = 0;
            // For each job i, select the first free thread;
            // that is, the `min` next free time
            for (int j = 0; j < numWorkers; ++j) {
                if (nextFreeTime[j] < nextFreeTime[bestWorker])
                    bestWorker = j;
            }
            assignedWorker_naive[i] = bestWorker;
            startTime_naive[i] = nextFreeTime[bestWorker];
            nextFreeTime[bestWorker] += duration;
        }
    }
    private void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        PriorityQueue<Worker> pq = new PriorityQueue<Worker>(numWorkers,
                new Comparator<Worker>(){
            @Override
            public int compare (Worker w1, Worker w2) {
                return w1.nextFreeTime == w2.nextFreeTime ? w1.id - w2.id :
                    (int) (w1.nextFreeTime - w2.nextFreeTime);
            }
        });
        for (int i = 0; i < numWorkers; i++)
            pq.offer(new Worker(i));
        for (int i = 0; i < jobs.length; i++) {
            Worker freeThread = pq.poll();
            assignedWorker[i] = freeThread.id;
            startTime[i] = freeThread.nextFreeTime;
            // Update next free time and offer back
            freeThread.nextFreeTime += jobs[i];
            pq.offer(freeThread);
            // This thread will be sorted again according to
            // its next free time, by next job to be processed
        }
    }
    private static class Worker {
        int id;
        long nextFreeTime;
        public Worker (int id) {
            this.id = id;
            nextFreeTime = 0;
        }
    }
    public void stressTest(int m, long [] jobs) {
    	this.numWorkers = m;
    	this.jobs = jobs;
    	for(int i = 0;i<8;i++) {
            // Fast and naive algorithms share the same
            // jobs and numWorkers, but different output
            long start = System.currentTimeMillis();
            assignJobs();
            long end   = System.currentTimeMillis();
            assignJobs_naive();
            if (Arrays.equals(assignedWorker, assignedWorker_naive)
                    && Arrays.equals(startTime, startTime_naive)) {
                System.out.println("OK: n=" + numWorkers + "\t"
                    + jobs[i] + "ms");
            }
            else System.out.println("Error: n=" + numWorkers);
    	}
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
}
}
