package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2164_카드2 {
	static int N;
	static Queue<Integer> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			int poll = queue.poll();
			queue.offer(poll);
		}
		
		System.out.println(queue.poll());
	}
}
