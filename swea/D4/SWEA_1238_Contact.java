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
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
		max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		visited = new boolean[101];
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
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			// 큐 안의 값들을 한꺼번에 연결되어있는 다른 번호까지 보기 위해 안에 크기를 가져오고
			int qSize = queue.size();
			// 큐에서 꺼낸 번호와 연결되어 있는 애들을 계속해서 새로 갱신하면서 담아주기 위해 생성
			ArrayList<Integer> arr = new ArrayList<>();
			
			for (int i = 0; i < qSize; i++) {
				int cur = queue.poll();
				for (int next : list.get(cur)) {
					if (!visited[next]) {
						visited[next] = true;
						queue.offer(next);
						arr.add(next);
					}
				}
			}
			Collections.sort(arr);
			if (arr.size() != 0) {
				max = arr.get(arr.size() - 1);
			}
		}

	}
}
