package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterSectionofTwoArraysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1 };
		int[] nums2 = { 1, 1 };
		int[] nums3 = intersect(nums1, nums2);
		for (int n : nums3)
			System.out.println(n);
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = nums1.length;
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], 1 + map.get(nums1[i]));
			else
				map.put(nums1[i], 1);
		}

		len = nums2.length;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums2[i])) {
				if (map.get(nums2[i]) > 0) {
					list.add(nums2[i]);
					map.put(nums2[i], map.get(nums2[i]) - 1);
				}
			}
		}
		len = list.size();
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = list.get(i);
		}

		return result;

	}

}
