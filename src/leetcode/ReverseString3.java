package leetcode;

/*
 Write a function that takes a string as input and returns the string reversed.
 Example:
 Given s = "hello", return "olleh".
 */
//recursively
public class ReverseString3 {
	public static void main(String[] args){
		String str = "hello";
		str = reverseString(str);
		System.out.println(str);
	}
	public static String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		return reverse(s,sb);
	}
	
	public static String reverse(String s, StringBuilder sb){
		if(s.length() == 1){
			sb.append(s);
//			System.out.print(s);
			return sb.toString();
		}
		else{
			String sub1 = s.substring(0,s.length()-1);
			String sub2 = s.substring(s.length()-1);
			System.out.print(sub2);
			sb.append(sub2);
			reverse(sub1,sb);
		}
		return sb.toString();
	}
}
