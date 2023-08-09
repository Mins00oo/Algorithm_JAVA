package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S4_2164_카드2 {
	static int n;
	static int[] card;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			Integer poll = queue.poll();
			queue.add(poll);
		}
		System.out.println(queue.poll());
		

	}
}
