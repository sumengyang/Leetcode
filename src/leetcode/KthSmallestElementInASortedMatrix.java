package leetcode;

import java.util.Stack;

/* Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 */
//本题只需记录每行最小数位置，每次n个最小位置中的最小位置，使其加以，继续循环直到循环次数大于k
public class KthSmallestElementInASortedMatrix {
	public static void main(String[] args) {
		System.out.println( kthSmallest(new int[][]{{1,5, 9},{10,11,13},{12,13,15}}, 3));
	}
	public static int kthSmallest(int[][] matrix, int k) {
		int[] tem=new int[matrix.length];
		int[] temIndex=new int[matrix.length];
		int tar=0;
		for(int i=0;i<k;i++){
			for(int j=0;j<matrix.length;j++)
				tem[j]=matrix[j][temIndex[j]];
			int temm=findSmall(tem, 0, tem.length-1);
			if(i==k-1){
				tar=matrix[temm][temIndex[temm]];
			}
			if(temIndex[temm]==matrix.length-1){
				matrix[temm][temIndex[temm]]=Integer.MAX_VALUE;
			}else {
				temIndex[temm]++;
			}
		}
	    return tar;
	}
	static int findSmall(int[] t,int start,int stop){
		if(start==stop)
			return start;
		else {
			int left=findSmall(t, start, (start+stop)/2);
			int right=findSmall(t, (start+stop)/2+1, stop);
			if(t[left]<t[right])
				return left;
			else {
				return right;
			}
		}
	}
}
