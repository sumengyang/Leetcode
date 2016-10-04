package leetcode;

/*Find the nth digit of the infinite integer sequence
 *  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 */

public class NthDigit {
	public static void main(String[] args) {

	}

	public int findNthDigit(int n) {
		if (n <= 0)
			return 0;
		int start = 1;
		int len = 1;
		long count = 9;
		while (n > len * count) {
			n -= len * count;
			len++;
			start *= 10;
			count *= 10;
		}
		start += (n - 1) / len;
		return String.valueOf(start).charAt((n - 1) % len) - '0';
	}
}
