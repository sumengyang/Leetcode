package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list,
 so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 题意：给出一个字符串数组，将任意两个拼凑起来为对称字符串的索引对输出
 思路：刚开始直接按照题意写超时。后来改成哈希查找通过
 如4种情况：1、如果字符串有为空的，则任意一个对称字符串与之可以拼凑
 2、如果一个字符串是另一个字符串的反转，则可以拼凑
 3、如果字符串s1的前n个字符是对称的，即s1[0,n），并且s1[n,len)与s2是互为相反的，则(s2,s1)构成对称字符串
 4、如果字符串s2的后几个字符是对称的，即s1[n,len),并且s1[0,n)与s2是互为相反的，则(s1, s2)构成对称字符串
 */
public class PalindromePairs {
	class Solution {
		private String strrev(String s) {
			StringBuilder sb = new StringBuilder(s);
			return sb.reverse().toString();
		}
		private boolean palindrome(String s) {
			int len = s.length();
			for (int i = 0; i < len / 2; i++) {
				if (s.charAt(i) != s.charAt(len - 1 - i)) {
					return false;
				}
			}
			return true;
		}

		public List<List<Integer>> palindromePairs(String[] words) {
			List<List<Integer>> ret = new ArrayList<List<Integer>>();

			if (null == words || 0 == words.length) {
				return ret;
			}

			Map<String, Integer> hs = new HashMap<String, Integer>();
			for (int i = 0; i < words.length; i++) {
				hs.put(words[i], i);
			}

			if (hs.containsKey("")) {
				int index = hs.get("");
				for (int i = 0; i < words.length; i++) {
					if (palindrome(words[i])) {
						if (i == index)
							continue;
						ret.add(Arrays.asList(i, index));
						ret.add(Arrays.asList(index, i));
					}
				}
			}

			for (int i = 0; i < words.length; i++) {
				String rev = strrev(words[i]);
				if (hs.containsKey(rev)) {
					int index = hs.get(rev);
					if (index == i)
						continue;
					ret.add(Arrays.asList(i, index));
				}
			}

			for (int i = 0; i < words.length; i++) {
				for (int len = 1; len < words[i].length(); len++) {
					if (palindrome(words[i].substring(0, len))) {
						String rev = strrev(words[i].substring(len));
						if (hs.containsKey(rev)) {
							int index = hs.get(rev);
							if (i == index)
								continue;
							ret.add(Arrays.asList(index, i));
						}
					}

					if (palindrome(words[i].substring(len))) {
						String rev = strrev(words[i].substring(0, len));
						if (hs.containsKey(rev)) {
							int index = hs.get(rev);
							if (i == index)
								continue;
							ret.add(Arrays.asList(i, index));
						}
					}
				}
			}
			return ret;
		}
	}
}