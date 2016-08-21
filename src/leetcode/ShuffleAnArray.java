package leetcode;

/*
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */
import java.util.Random;

public class ShuffleAnArray {
	int[] result;

	public ShuffleAnArray(int[] nums) {
		result = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return result;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] temp = result;
		Random rand = new Random();
		for (int i = 0; i < temp.length; i++) {
			int r = rand.nextInt(temp.length);
			int swap = temp[r];
			temp[r] = temp[i];
			temp[i] = swap;
		}
		return temp;
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
