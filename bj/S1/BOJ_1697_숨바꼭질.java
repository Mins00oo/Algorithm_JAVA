package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int n, k, ans;
	static boolean[] visited = new boolean[100002];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n == k) {
			ans = 0;
		} else {
			bfs(0);
		} 

		System.out.println(ans);
	}

	static void bfs(int num) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { n, 0 });
		visited[n] = true;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			visited[poll[0]] = true;
			for (int i = 0; i < 3; i++) {
				int next = 0;
				if (i == 0) {
					next = poll[0] - 1;
				} else if (i == 1) {
					next = poll[0] + 1;
				} else if (i == 2) {
					next = poll[0] * 2;
				}
				
				if (next == k) {
					ans = poll[1] + 1;
					return;
				}
				
				if (next >= 0 && next < 100001 && !visited[next]) {
					visited[next] = true;
					queue.offer(new int[] {next, poll[1] + 1});
				}
			}


		}
	}
}
