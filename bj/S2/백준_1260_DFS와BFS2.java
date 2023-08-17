package bj.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1260_DFS와BFS2 {
	static int n, m, v;
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		
		visited = new boolean[n + 1];
		dfs(v);
		sb.append("\n");
		visited = new boolean[n + 1];
		bfs(v);
		System.out.println(sb);
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[start] = true;
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			sb.append(poll).append(" ");
			for (int i = 1; i <= n; i++) {
				if (graph[poll][i] == 0 || visited[i]) {
					continue;
				}
				queue.offer(i);
				visited[i] = true;
			}
		}
	}
	
	static void dfs(int start) {
		sb.append(start).append(" ");
		visited[start] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[start][i] == 0) {
				continue;
			}
			if (!visited[i]) {
				dfs(i);
			}
		}
	}


}
