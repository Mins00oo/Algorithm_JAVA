package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	static int n, m;
	static boolean[] visited;
	static List<List<Integer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 0; i < n; i++) {
			visited[i] = true;
			if (dfs(i, 0)) {
				System.out.println(1);
				return;
			}
			visited[i] = false;
		}
		System.out.println(0);
	}

	static boolean dfs(int x, int depth) {
		if (depth >= 4) {
			return true;
		}
		for (int i : list.get(x)) {
			if (!visited[i]) {
				visited[i] = true;
				if (dfs(i, depth + 1)) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
}
