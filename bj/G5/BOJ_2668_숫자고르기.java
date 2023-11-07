package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668_숫자고르기 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (int li : list) {
			sb.append(li).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int idx, int tgt) {
		if (!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			dfs(arr[idx], tgt);
			visited[arr[idx]] = false;
		}
		
		// 사이클이 발생했기에
		if (arr[idx] == tgt) {
			list.add(tgt);
		}
	}
}


