package BACKJOON.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 *
 */
public class G5_1916 {
	static int n; // 도시의 개수 5개
	static int m; // 버스의 개수 8개
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> list;
	static int[] dist; // 거리를 계속해서 더함
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE); // 거리는 전부 다 최댓값으로
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) { // ArrayList안에 노드 정보들을 ArrayList로 넣고
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(start).add(new Node(end, w));
		}

		st = new StringTokenizer(br.readLine());
		int s_node = Integer.parseInt(st.nextToken()); // 주어진 시작 노드
		int e_node = Integer.parseInt(st.nextToken()); // 주어진 도착 노드

//        for (int i = 1; i < list.length; i++) {
//            System.out.println(list[i].toString());
//        }

		dijkstra(s_node);
		System.out.println(dist[e_node]);

	}

	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0)); // 출발 도시와 거리 큐에 담고
		dist[start] = 0;
		
		// 시간 초과 코드
//		while (!queue.isEmpty()) {
//			Node queNode = queue.poll();
//			visited[queNode.end] = true;
//			for (Node n : list.get(queNode.end)) { // 출발 지점으로부터 도착할 수 있는 노드와 가중치 정보를 가져오고
//				if (!visited[n.end] && dist[n.end] > dist[queNode.end] + n.w) { // 바로 갈 수 있는 거리와 거쳐서 가는 거리 중 짧은 것으로 대체
//					dist[n.end] = dist[queNode.end] + n.w;
//					queue.offer(new Node(n.end, dist[n.end]));
//				}
//			}
//		}
		
		while (!queue.isEmpty()) {
			Node queNode = queue.poll();
			if (!visited[queNode.end]) {
				visited[queNode.end] = true;
				for (Node n : list.get(queNode.end)) { // 출발 지점으로부터 도착할 수 있는 노드와 가중치 정보를 가져오고
					if (!visited[n.end] && dist[n.end] > dist[queNode.end] + n.w) { // 바로 갈 수 있는 거리와 거쳐서 가는 거리 중 짧은 것으로 대체
						dist[n.end] = dist[queNode.end] + n.w;
						queue.offer(new Node(n.end, dist[n.end]));
					}
				}
			}
		}
	}

}

class Node implements Comparable<Node> {
	int end, w;

	public Node(int city, int w) {
		this.end = city;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return w - o.w;
	}
}