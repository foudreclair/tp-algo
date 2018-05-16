
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDeadly(6, 8));

	}

	public static int cheby(int n, int x) {
		if (n == 0) {
			return 1;
		} else {
			if (n == 1) {
				return x;
			} else {
				return (2 * x * cheby(n - 1, x) - cheby(n - 2, x));
			}
		}
	}

	public static int findDeadly(int s, int k) {
		int begin = 0;
		int returnValue = -1;
		int end = s;

		while (begin != end && k != 0) {
			int m = (end + begin) / 2;
			if (teststairs(m)) {
				begin = m + 1;
			} else {
				k = k--;
				end = m;
			}
		}
		if (k == 0) {
			return returnValue;
		} else {
			return begin;
		}

	}

	private static boolean teststairs(int m) {
		//L'entier qu'on entre ici est la valeur de l'étage mortel
		if(m>3) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
