package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	static int N, M;
	static int[] topo; // 차수를 의미하는 배열
	static List<List<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 비교 횟수
		topo = new int[N + 1];

		// 인접리스트
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 비교 횟수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a-> b로ㅓ 간다는 거라서
			graph.get(a).add(b);
			topo[b]++; // 진입 차수 증가
		}

		Queue<Integer> queue = new ArrayDeque<>();

		// 1. 진입차수가 0인 번호를 큐에 넣는다.
		for (int i = 1; i <= N; i++) {
			if (topo[i] == 0) {
				queue.offer(i);
			}
		}

		// 큐를 이용해 꺼내보면서 연결을 끊고 진입차수가 0인 번호를 담고를 반복
		while (!queue.isEmpty()) {
			// 진입차수가 0 즉, 시작점인 애들을 꺼내서 sb에 추가해주고
			int no = queue.poll();
			sb.append(no).append(" ");
			// no와 연결된 다른 정점들을 전부 꺼내서
			List<Integer> list = graph.get(no);
			int size = list.size();
			// no를 위에서 poll을 통해 제거하는 동시에 다른 곳으로의 연결도 끊어야 해서 진입차수를 1씩 줄인다.
			for (int i = 0; i < size; i++) {
				int temp = list.get(i);
				topo[temp]--;
				// 진입차수가 0이 되었다면 본인도 시작점이 될 수 있기에 큐에 추가
				if (topo[temp] == 0) {
					queue.offer(temp);
				}
			}
		}

		System.out.println(sb);
	}

}
