package bj.G5;

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
public class G5_1916_2 {
	static int n; // 도시의 개수 5개
	static int m; // 버스의 개수 8개
	static boolean[] visited;
	static ArrayList<ArrayList<NodeInfo>> list;
	static int[] dist; // 거리를 계속해서 더함
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new int[n + 1];
		visited = new boolean[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE); // 거리는 처음에는 전부 다 최댓값으로 설정
		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) { // n + 1번만큼 arrayList안에 arrayList를 추가하는 작업
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(start).add(new NodeInfo(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		int s_node = Integer.parseInt(st.nextToken());
		int e_node = Integer.parseInt(st.nextToken());

		dijkstra(s_node);
		System.out.println(dist[e_node]);

	}

	static void dijkstra(int start) {
		PriorityQueue<NodeInfo> queue = new PriorityQueue<>();
		queue.offer(new NodeInfo(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			NodeInfo poll = queue.poll(); // 큐에서 꺼낸 노드 정보
			if (!visited[poll.end]) {
				visited[poll.end] = true;
				for (NodeInfo n : list.get(poll.end)) {
					if (!visited[n.end] && dist[n.end] > dist[poll.end] + n.w) {
						dist[n.end] = dist[poll.end] + n.w;
						queue.offer(new NodeInfo(n.end, dist[n.end])); // 큐에 다음 이동할 노드를 추가하는 과정에서 거리를 업데이트 시켜줘야 함
					}
				}
			}

		}

	}

}

class NodeInfo implements Comparable<NodeInfo>{
	int end;
	int w;

	public NodeInfo(int end, int w) {
		this.end = end;
		this.w = w;
	}
	
	@Override
	public int compareTo(NodeInfo o) {
		// TODO Auto-generated method stub
		return w - o.w;
	}
	
}
