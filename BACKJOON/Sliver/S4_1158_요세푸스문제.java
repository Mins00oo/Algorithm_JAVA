package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 배열 혹은 큐를 사용할까 고민했던 문제
 * 큐를 사용해서 풀기로 마음을 먹었는데 특정 위치에 해당하는 값을 꺼내야 하는데 큐에는 그렇게 직접 해주기가 힘듬
 * 그래서 앞에 값들을 꺼내서 뒤로 보내고 해당 위치에 해당하는 값을 제거하도록 함
 * 메모리 상으로는 배열이 훨씬 낫다는 것을 알 수 있음
 */
public class S4_1158_요세푸스문제 {
	static StringTokenizer st;
	static int n, k, arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		sb.append("<");
		while (!queue.isEmpty()) {
			// k -1개 만큼 수를 뒤로 보내고 k번째 수는 poll
			for (int i = 0; i < k - 1; i++) {
				queue.offer(queue.poll());
			}
			Integer poll = queue.poll();
			sb.append(poll).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);

	}
}
