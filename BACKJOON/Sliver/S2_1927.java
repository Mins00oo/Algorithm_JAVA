package BACKJOON.Sliver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class S2_1927 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 연산의 개수

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x > 0) {
				queue.add(x);
			} else {
				if (!queue.isEmpty()) {
					System.out.println(queue.poll());
				} else {
					System.out.println(0);
				}
			}
		}
	}

}
