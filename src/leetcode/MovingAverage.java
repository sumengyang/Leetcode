package leetcode;

import java.util.LinkedList;

/*
 * 	Given a stream of integers and a window size, 
 * 	calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 方法：使用双端链表保持窗口内的数值。
 */

public class MovingAverage {
	private LinkedList<Integer> dequeue = new LinkedList<Integer>();
	private int size;
	private double sum;

	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		if (dequeue.size() == size)
			sum -= dequeue.removeFirst();
		dequeue.add(val);
		sum += val;

		return sum / dequeue.size();
	}

	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1) + "\t" + ma.next(10) + "\t" + ma.next(3)
				+ "\t" + ma.next(5) + "\t");
		MovingAverage2 ma2 = new MovingAverage2(3);
		System.out.println(ma2.next(1) + "\t" + ma2.next(10) + "\t"
				+ ma2.next(3) + "\t" + ma2.next(5) + "\t");
	}
}

class MovingAverage2 {
	private int[] vars;
	private int start, size;
	private double sum;

	public MovingAverage2(int size) {
		vars = new int[size];
	}

	public double next(int val) {
		if (size < vars.length) {
			sum += val;
			vars[size++] = val;
		} else {
			sum -= vars[start];
			sum += val;
			vars[start] = val;
			start = (start + 1) % vars.length;
		}

		return sum / size;
	}
}
