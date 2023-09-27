package swea.D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1
3 0 1 0 1 0 1 0 1 0
 */
public class SWEA_1263_사람네트워크2 {
	static int T, min, n;
	static int[][] arr;
	static ArrayList<ArrayList<Integer>> adjust;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			adjust = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 사람의 수
			
			for (int i = 0; i < n; i++) {
				adjust.add(new ArrayList<>());
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int x = Integer.parseInt(st.nextToken());
					if (x == 1) {
						adjust.get(i).add(j);
					}
				}
			}
			
			// 각 정점별로 각자 최단경로를 찾는다. 구해서 min 갱신
			for (int i = 0; i < n; i++) {
				bfs(i);
			}
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int v) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		
		visited[v] = true;
		queue.offer(new Node(v, 0));
		int dist = 0;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int V : adjust.get(cur.v)) {
				if (visited[V]) {
					continue;
				}
				dist += cur.cnt+ 1;
				if (dist >= min) {
					return;
				}
				visited[V] = true;
				queue.offer(new Node(V, cur.cnt + 1));
			}
		}
		min = Math.min(min, dist);
	}
	
	static class Node {
		int v, cnt;

		public Node(int v, int cnt) {
			this.v = v;
			this.cnt = cnt;
		}
		
	}
}








