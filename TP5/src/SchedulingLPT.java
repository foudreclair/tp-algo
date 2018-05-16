import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SchedulingLPT implements SchedulingStrategy{

	public List<int[]> LPT(long[] L, int m) {
		L = tri(L);
		int[] T = new int[m];
		List<int[]> S = new ArrayList<int[]>();
		for (long l : L) {
			int p = min(T);
			S.add(new int[] { p, (int) l });
			T[p] += l;
		}
		return S;

	}

	private int min(int[] T) {
		int min = 0;
		int max = 10000;
		for (int i = 0; i < T.length; i++) {
			min = T[i] < T[min] ? i : min;
	//		max = T[T.length-i] > T[T.leg] ? i;
		}
		return min;
	}
	
	private long[] tri(long [] L) {
		Long [] longArray = new Long[L.length];
		long [] l = new long[L.length];
		for(int i = 0;i<L.length;i++) {
			longArray[i] = new Long(L[i]);
		}
		Arrays.sort(longArray, Collections.reverseOrder());
		for(int j = 0;j<L.length;j++) {
			l[j] = longArray[j];
		}
		return l;
	}

	@Override
	public List<int[]> execute(int processors, long[] jobs) {
		// TODO Auto-generated method stub
		return LPT(jobs, processors);
	}
}
