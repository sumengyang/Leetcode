package leetcode;

import java.util.*;

public class ValidParentheses2 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ')':
				if (!stack.isEmpty()
						&& (Character.toString(stack.pop()).equals("(")))
					break;
				else
					return false;
			case '}':
				if (!stack.isEmpty()
						&& (Character.toString(stack.pop()).equals("{")))
					break;
				else
					return false;
			case ']':
				if (!stack.isEmpty()
						&& (Character.toString(stack.pop()).equals("[")))
					break;
				else
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}
}
