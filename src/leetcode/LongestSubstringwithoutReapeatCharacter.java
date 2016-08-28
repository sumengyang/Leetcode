package leetcode;

import java.util.Map;
import java.util.HashMap;

/* Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringwithoutReapeatCharacter {
	public int lengthOfLongestSubstring(String s) {
		char[] str = s.toCharArray();
		int max = 0;
		for (int i = 0; i < str.length; i++) {
			int count = 0;
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int j = i; j < str.length; j++) {
				if (!map.containsKey(str[j])) {
					map.put(str[j], j);
				} else {
					count = map.get(str[j - 1]) - i + 1;
					break;
				}
			}
			if (count > max)
				max = count;
		}
		return max;
	}
}
