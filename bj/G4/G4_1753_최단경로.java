package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1. 노드 타입으로 arraylist안에 arraylist를 선언해서 값을 넣어준다.
 */
public class G4_1753_최단경로 {
	static class Node implements Comparable<Node> {
		int end;
		int w;

		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return w - o.w;
		}
	}

	static StringTokenizer st;
	static int v; // 정점의 개수
	static int e; // 간선의 개수
	static int start_node; // 시작 노드 번호
	static ArrayList<ArrayList<Node>> list;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		dist = new int[v + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[v + 1];

		start_node = Integer.parseInt(br.readLine());

		for (int i = 0; i <= v; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(e, weight));
		}

		dijkstra(start_node);
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			if (!visited[poll.end]) {
				visited[poll.end] = true;
				for (Node n : list.get(poll.end)) {
					if (!visited[n.end] && dist[n.end] > dist[poll.end] + n.w) {
						dist[n.end] = dist[poll.end] + n.w;
						queue.offer(new Node(n.end, dist[n.end]));
					}
				}
			}

		}
	}
}
