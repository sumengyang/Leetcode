package leetcode;

/* Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */
/* method1 find from the center
 * brute 
 */
public class LongestPalindromicSubstring3 {
	public static void main(String[] args) {
		String str = "ababa";
		System.out.println(str.substring(0,1));
		String str0 = longestPalindrome(str);
		System.out.println(str0);
	}

	public static String longestPalindrome(String s) {
		int length = s.length();
		if (length < 2)
			return s;
		String longestPalindromeString = s.substring(0, 1);
		int maxLength = 1;
		for (int i = 0; i < length; i++)
			for (int j = i + 1; j < length; j++) {
				int len = j - i + 1;
				String curr = s.substring(i, j+1);
				if (isPalindrome(curr)) {
					if (len > maxLength) {
						longestPalindromeString = curr;
						maxLength = len;
					}
				}
			}
		return longestPalindromeString;
	}

	public static boolean isPalindrome(String s) {
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) != s.charAt(length - 1 - i))
				return false;
		}
		return true;
	}
}