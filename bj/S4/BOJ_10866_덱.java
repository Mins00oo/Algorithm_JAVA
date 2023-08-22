package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866_덱 {
	static int N;
	static Deque<Integer> deque = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			switch (com) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (!deque.isEmpty()) {
					sb.append(deque.poll()).append("\n");	
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "pop_back":
				if (!deque.isEmpty()) {
					sb.append(deque.pollLast()).append("\n");	
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if (!deque.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
				break;
			case "front":
				if (!deque.isEmpty()) {
					sb.append(deque.peek()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "back":
				if (!deque.isEmpty()) {
					sb.append(deque.peekLast()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;

			}
		}
		
		System.out.println(sb);
	}
}
