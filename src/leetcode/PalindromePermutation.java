package leetcode;

import java.util.HashMap;
import java.util.Map;

/* checks whether any permutation of an input string is a palindrome 
 * Examples:
 * "civic" should return True
 * "ivicc" should return True
 * "civil" should return False
 * "livci" should return False
 */
/*回文中除了中心对称点的字符，其他字符都会出现偶数次。
 而中心对称点如果是字符，该字符会是奇数次， 如果在两个字符之间，则所有字符都是出现偶数次。
 所以，我们只要判断下字符串中每个字符出现的次数， 就知道该字符串的其他排列方式中是否有回文了。*/

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.isEmpty())
			return true;
		Map<Character, Integer> freq = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (freq.containsKey(c))
				freq.put(c, freq.get(c) + 1);
			else
				freq.put(c, 1);
		}
		int oddCount = 0;
		for (Integer i : freq.values()) {
			if ((i.intValue() % 2) != 0) {
				oddCount++;
				if (oddCount > 1)
					return false;
			}
		}
		return true;
	}
}
