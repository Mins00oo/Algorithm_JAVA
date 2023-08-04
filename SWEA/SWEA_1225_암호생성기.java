package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {
	static int[] numbers;
	static int T;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			while (true) {
				boolean is = false;
				// 1개의 사이클
				for (int i = 1; i <= 5; i++) {
					Integer poll = queue.poll();
					if (poll - i <= 0) {
						is = true;
						break;
					} else {
						poll -= i;
						queue.offer(poll);
					}
				}
				if (is) {
					queue.offer(0);
					sb.append("#").append(t);
					for (Integer integer : queue) {
						sb.append(" ").append(integer);
					}
					sb.append("\n");
					break;
				}
			}

		}
		System.out.println(sb);
	}
}
