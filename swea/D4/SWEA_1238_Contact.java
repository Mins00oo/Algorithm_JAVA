package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static int T = 10;
	static int len, start, max;
	static List<List<Integer>> list;
	static int[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			visited = new int[101];
			list = new ArrayList<>();

			for (int i = 0; i <= 100; i++) {
				list.add(new ArrayList<>());
			}

			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < len / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);

			}

			bfs(start);

			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = 1;
		int depth = 1;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Integer li : list.get(cur)) {
				if (visited[li] != 0) {
					queue.offer(li);
					visited[li] = visited[cur] + 1;
				}
			}
			
		}
	
	}
}
