package leetcode;

/* Determine whether an integer is a Palindrome. Do this without extra space.
 * 
 */

//从两头依次取数字比较，向中间推进。
public class PalindromeNumber2 {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10)
			div *= 10;

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div = div / 100;
		}
		return true;
	}
}
