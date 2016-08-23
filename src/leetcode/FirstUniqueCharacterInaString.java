package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 Examples:
 s = "leetcode" 	return 0.
 s = "loveleetcode", return 2.
 Note: You may assume the string contain only lowercase letters.
 */
/*
 给定一个string，找出第一个string里的unique character，如“cisco”的话就应该是1，“cat”的话就是0。
 第一种方法是用LinkedHashMap保留数据的顺序，过一遍string，对字符进行计数，然后找到第一个数量为1的字符即可。
 第二种方法是用一个HashSet来存已经重复的字符，然后用个arraylist来存仅出现了一次的字符。
 第三种方法是用HashMap来存数据以及count，然后再走一遍string，对每个字符检查计数是否为1.
 */

public class FirstUniqueCharacterInaString {
	public int firstUniqCharI(String s) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>(
				s.length());
		for (char c : s.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return s.indexOf(entry.getKey());
		}
		return -1;
	}

	public int firstUniqCharII(String s) {
		Set<Character> repeating = new HashSet<Character>();
		List<Character> nonrepeating = new ArrayList<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (repeating.contains(c))
				continue;
			if (nonrepeating.contains(c)) {
				nonrepeating.remove((Character) c);
				repeating.add(c);
			} else
				nonrepeating.add(c);
		}
		if (nonrepeating.size() > 0)
			return s.indexOf(nonrepeating.get(0));
		return -1;
	}

	public int firstUniqCharIII(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>(
				s.length());
		for (char c : s.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (map.get(c) == 1)
				return i;
		}
		return -1;
	}
}
