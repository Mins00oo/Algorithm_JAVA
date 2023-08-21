package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {
	static Deque<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			
			switch (p) {
			case "push":
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (!queue.isEmpty()) {
					sb.append(queue.pollFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (!queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
				break;
			case "front":
				if (!queue.isEmpty()) {
					sb.append(queue.peekFirst()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "back":
				if (!queue.isEmpty()) {
					sb.append(queue.peekLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;

			}
		}
		
		System.out.println(sb);
	}

}
