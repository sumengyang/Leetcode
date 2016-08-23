package leetcode;

/*
 Write a function that takes a string as input and returns the string reversed.
 Example:
 Given s = "hello", return "olleh".
 */
public class ReverseString {
	public String reverseString(String s) {
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = len - 1; i >= 0; i--)
			sb.append(s.charAt(i));
		return sb.toString();
		// return new StringBuilder(s).reverse().toString();
	}
}
