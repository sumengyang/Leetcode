package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequencyElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		List list = topKFrequency(nums, k);
		System.out.println(list);
	}

	public static List<Integer> topKFrequency(int[] nums, int k) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			if (map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}

		List[] freq = new ArrayList[n + 1];
		for (int num : map.keySet()) {
			int i = map.get(num);
			if (freq[i] == null)
				freq[i] = new ArrayList();
			freq[i].add(num);
		}

		List result = new ArrayList();
		for (int i = n; i >= 0 && result.size() < k; i--)
			if (freq[i] != null)
				result.addAll(freq[i]);

		return result;

	}
}
