package bj.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1260_DFS와BFS {
	static int n, m, v;
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());

			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		visited = new boolean[n + 1];
		dfs(v, 0);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);

	}

	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			Collections.sort(graph.get(x));
			for (int i : graph.get(x)) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	static void dfs(int start, int depth) {
		System.out.print(start + " ");
		visited[start] = true;
		Collections.sort(graph.get(start));
		for (int i : graph.get(start)) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
	}

}
