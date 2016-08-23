package leetcode;

/*
Write a function that takes a string as input and returns the string reversed.
Example:
Given s = "hello", return "olleh".
*/
public class ReverseString2 {
	public String reverseString(String s) {
		int len = s.length();
		char[] res = s.toCharArray();
		for (int i = 0; i < len/2; i++){
			char temp = res[i];
			res[i] = res[len - 1 - i];
			res[len - 1 - i] = temp;
		}
		return new String(res);
	}
}
