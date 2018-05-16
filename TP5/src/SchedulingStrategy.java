import java.util.List;

public interface SchedulingStrategy {
	public List<int[]> execute(int processors, long [] jobs);

}
