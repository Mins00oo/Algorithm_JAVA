package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1_11286_절댓값힙 {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1 == abs2) {
				return o1 - o2;
			}
			return abs1 - abs2;
		});

		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val == 0) {
				if (queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					Integer poll = queue.poll();
					sb.append(poll).append("\n");
				}
			} else {
				queue.offer(val);
			}
		}

		System.out.println(sb);
	}

}
