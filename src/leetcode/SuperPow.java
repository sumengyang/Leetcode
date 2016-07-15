package leetcode;

public class SuperPow {
	private static final int CONST = 1337;

	public static int superPow(int a, int[] b) {
		if (!moreThanZero(b))
			return 1;
		a = a % CONST;
		boolean isEven = false;
		if (b[b.length - 1] % 2 == 0)
			isEven = true;
		div(b, 2);
		int result = superPow(a, b);
		// result = result % 1337;
		result = result * result;
		result = result % CONST;
		if (!isEven) {
			result = result * a % CONST;
		}

		return result;
	}

	private static boolean moreThanZero(int[] b) {
		for (int i = b.length - 1; i >= 0; i--)
			if (b[i] > 0)
				return true;
		return false;
	}

	private static void div(int[] b, int n) {
		int tmp = 0;
		for (int i = 0; i < b.length; i++) {
			b[i] = tmp * 10 + b[i];
			tmp = b[i] % n;
			b[i] = b[i] / n;
		}
	}

	public static void main(String[] args) {
		int a = 2;
		int[] b = {1,0,0};
		int c = superPow(a,b);
		System.out.println(c);

	}

}
