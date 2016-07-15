package leetcode;

/* Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 * Java的Int类型为32位范围为-2147483648——2147483647，
 * 而3在32位里最大为1162261467(3的19次方)
 * 所以用1162261467去除n取余
 */
public class PowerofThree2 {
	public boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

}
