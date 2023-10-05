package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지 {
	static int T, N;
	static int[][] map, cost;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static final int INF = Integer.MAX_VALUE; // 충분히 큰 값으로 cost 배열 초기화
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) {
				System.out.println(sb);
				return;
			}
			map = new int[N][N];
			cost = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
			// 다익스트ㅡ라
			dijkstra();
			sb.append("Problem ").append(t).append(": ").append(cost[N - 1][N - 1]).append("\n");
			t++;
		}
	}
	
	static void dijkstra() {
		cost[0][0] = map[0][0];
		pqueue.offer(new Node(0, 0, cost[0][0]));
		// pqueue에서 비용이 가장 적은 Node를 선택해서 갈 수 있는 새로운 좌표의 cost[][]를 줄일 수 있으면 갱신
		while (!pqueue.isEmpty()) {
			Node cur = pqueue.poll();
			// 꺼낸 녀석에서부터 갈 수 있는 새로운 좌표 획득 -> 시작점에서 획득한 좌표로 이동할 때 최소비용과 꺼낸 녀석을거쳐서 가느 최소비용을 비교
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				// 비용 비교
				// 현재 기준 시작점 (0, 0) -> 고려하는 좌표 (nx, ny)로 가는 최소비용은 cost[nx][ny]
				// 꺼낸 좌표를 거쳐가는 비용 e.c + map[nx][ny]
				if (cur.cost + map[nx][ny] < cost[nx][ny]) {
					cost[nx][ny] = cur.cost + map[nx][ny];
					pqueue.offer(new Node(nx, ny, cost[nx][ny]));
				}
			}
		}
	}
	
	static class Node {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
	}
}












