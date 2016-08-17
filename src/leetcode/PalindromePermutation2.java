package leetcode;

import java.util.Set;
import java.util.HashSet;
/* checks whether any permutation of an input string is a palindrome 
 * Examples:
 * "civic" should return True
 * "ivicc" should return True
 * "civil" should return False
 * "livci" should return False
 */
//用一个HashSet，第偶数个字符可以抵消Set中的字符，最后判断Set的大小是否小于等于1就行了。

public class PalindromePermutation2 {
	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		for(Character c : s.toCharArray()){
			if(set.contains(c))
				set.remove(c);
			else
				set.add(c);
		}
		return set.size() <= 1;
	}
}
