package leetcode;

/* Given a positive integer n and you can do operations as follow:

 If n is even, replace n with n/2.
 If n is odd, you can replace n with either n + 1 or n - 1.
 What is the minimum number of replacements needed for n to become 1?
 */
public class IntegerReplacement2 {
	public int integerReplacement(int n) {
		int count = 0;
		long t = n;
		while (t > 1) {
			count++;
			if ((t & 1) > 0) {
				if (((t & 2) > 0) && (t != 3))
					t++;
				else
					t--;
			} else
				t >>= 1;
		}
		return count;
	}
}
