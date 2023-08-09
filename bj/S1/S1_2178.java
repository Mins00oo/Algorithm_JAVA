package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1. 특정 좌표까지 가기까지 걸리는 최소 횟수를 구하는 문제이기에 bfs로 풀면 될듯
2. 큐를 만들고 갈 수 있는 좌표값을 넣어보고 어차피 어떤 경로든 좌표까지 도착하기에 최단 거리니깐 큐에 넣으면서
한 칸씩 움직인다는 의미로 +1을 해주면 될듯
3. 마지막에 그냥 n - 1, m - 1 좌표값을 출력하면 될듯
 */
public class S1_2178 {
	static int n; // 행의 길이
	static int m; // 열의 길이
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		visited = new boolean[n][m];
		bfs(0, 0);
		System.out.println(map[n - 1][m - 1]);

	}

	static void bfs(int x, int y) {
		visited[x][y] = true; // 첫 시작점을 방문했다고 두고
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int a = now[0];
			int b = now[1];
			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];
				if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						queue.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
						map[nx][ny] = map[a][b] + 1;
					}
				}
			}
		}

	}
}
