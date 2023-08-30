package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이2 {
	static int K, H, W;
	static int[][] map;
	static boolean[][][] visited; // k가 추가된
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hdx = { -2, -1, -2, -1, 2, 1, 2, 1 };
	static int[] hdy = { -1, -2, 1, 2, -1, -2, 1, 2 };
	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0, K);
		
	}
	
	static void bfs(int x, int y, int k) {
		visited[0][0][k] = true;
		queue.offer(new Node(x, y, k, 0));
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			// 도착 지점에 도달했을 경우에는 d 값을 출력하고 끝
			if (cur.x == H - 1 && cur.y == W - 1) {
				System.out.println(cur.d);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1) {
					continue;
				}
				
				if (!visited[nx][ny][cur.k]) {
					visited[nx][ny][cur.k] = true;
					queue.offer(new Node(nx, ny, cur.k, cur.d + 1));
				}
			}
			
			if (cur.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + hdx[i];
					int ny = cur.y + hdy[i];
					
					if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 1) {
						continue;
					}
					
					if (!visited[nx][ny][cur.k - 1]) {
						visited[nx][ny][cur.k - 1] = true;
						queue.offer(new Node(nx, ny, cur.k - 1, cur.d + 1));
					}
					
				}
			}
			
		}
		
		System.out.println(-1);
	}
	
	static class Node {
		int x, y, k, d;

		public Node(int x, int y, int k, int d) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.d = d;
		}
		
		
	}
}
















