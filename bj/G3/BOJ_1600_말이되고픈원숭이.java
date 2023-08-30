package bj.G3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] horseX = { 1, 2, -1, -2, -2, -1, 1, 2 };
	static int[] horseY = { 2, 1, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H + 1][W + 1];
		visited = new boolean[H + 1][W + 1][K + 1];

		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(1, 1, K);

		System.out.println(ans);
	}

	static void bfs(int x, int y, int k) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(x, y, 0, k));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.x == H && cur.y == W) {
				ans++;
				continue;
			}

			if (cur.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + horseX[i];
					int ny = cur.y + horseY[i];

					if (nx < 1 || nx > H || ny < 1 || ny > W) {
						continue;
					}
//					if (!visited[nx][ny]) {
////						System.out.println(nx + " " + ny);
//						visited[nx][ny] = true;
//						queue.offer(new Node(nx, ny, cur.k - 1));
//					}

				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 1 || nx > H || ny < 1 || ny > W) {
					continue;
				}

//				if (!visited[nx][ny]) {
//					visited[nx][ny] = true;
//					queue.offer(new Node(nx, ny, k));
//				}
			}
		}
	}

	static class Node {
		int x, y, cnt, k;

		public Node(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}

	}
}
