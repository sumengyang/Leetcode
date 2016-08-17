package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * [
 *  ["aa","b"],
 *  ["a","a","b"
 * ]
 */
/* 上述代码看似比较复杂，但其实就两个简单的部分：判断子串是否为回文串，然后深搜遍历所有的划分。
 * 判断子串是否为回文串采用了最朴素的循环遍历，在该题通过了测试，但是在第二题中将会超时，后面还会提到。
 * 深搜函数最重要的参数是第一个i，用来表示从字符串的i位置开始求划分，如果i已经超过了字符串的长度就说明完成了划分，保存一个可能的结果。
 * 如果i没有到字符串末尾，则判断从i开始到哪些位置是回文串，保存该回文串，然后从下一个位置继续深搜。如此就可以获得所有的划分。
 */
public class PalindromePartitioning2 {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				int k = 0;
				for (; k < (j - i + 1) / 2; k++) {
					if (s.charAt(i + k) != s.charAt(j - k))
						break;
				}
				if (k == (j - i + 1) / 2)
					dp[i][j] = 1;
			}
		}
		dfs(0, s, dp, list, result);
		return result;
	}

	public void dfs(int i, String s, int[][] dp, List<String> list,
			List<List<String>> result) {
		if (i == s.length()) {
			List<String> t = new ArrayList<String>(list);
			Collections.reverse(t);
			result.add(t);
			return;
		}
		for (int j = i; j < s.length(); j++) {
			if (dp[i][j] == 1) {
				list.add(0, s.substring(i, j + 1));
				dfs(j + 1, s, dp, list, result);
				list.remove(0);
			}
		}
	}
}
