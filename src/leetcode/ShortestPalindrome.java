package leetcode;

/*
 Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 Find and return the shortest palindrome you can find by performing this transformation.
 For example:
 Given "aacecaaa", return "aaacecaaa".
 Given "abcd", return "dcbabcd".
 */

/*
 * [思路]
 从某个char开始向两边扩展(左右两边的字符相等), 如果能一直扩展到字符串的头部, 则将末尾余下的reverse,再加到原字符串的头部,即可. 
 tips:  	
 1. 中轴字符选从中间开始,这样找到的即为最短的. 
 2. 中轴字符可能为一个, 也可能为两个. 
 */

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int len = s.length();
		if (len <= 1)
			return s;
		int mid = (len - 1) / 2;
		String res = "";
		for (int i = mid; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				res = generatePalindrome(s, i, i + 1);
				if (res != null)
					return res;
			}
			res = generatePalindrome(s, i, i);
			if (res != null)
				return res;
		}
		return res;
	}

	public String generatePalindrome(String s, int left, int right) {
		int i = 1;
		int len = s.length();
		for (; left - i >= 0 && right + i < len; i++) {
			if (s.charAt(left - i) != s.charAt(right + i))
				break;
		}
		if (left - i >= 0)
			return null;
		StringBuilder sb = new StringBuilder(s.substring(right + i));
		sb.reverse();
		return sb + s;
	}
}
