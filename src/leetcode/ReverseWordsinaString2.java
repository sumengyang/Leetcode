package leetcode;

import java.util.Stack;

/* Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * One simple approach is a two-pass solution: First pass to split the string by spaces into an array of words, then second pass to extract the words in reversed order.
 * We can do better in one-pass. While iterating the string in reverse order, we keep track of a word’s begin and end position. When we are at the beginning of a word, we append it.
 */
public class ReverseWordsinaString2 {
	public String reverseWords(String s) {
        s.trim();
        
        String[] arrayStr = s.split("\\s+");
        int len = arrayStr.length;
        System.out.println(len);
        String temp;
        for(int i = 0; i < len/2; i++)
        {
            temp = arrayStr[i];
            arrayStr[i] = arrayStr[len-i-1];
            arrayStr[len-i-1] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(i>0)
                sb.append(" ");
            sb.append(arrayStr[i]);
        }
        return sb.toString().trim();
    }
}
