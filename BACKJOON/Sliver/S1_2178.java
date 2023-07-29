package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {
	static int n; // 행의 길이
	static int m; // 열의 길이
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] visited;
	static int count;

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
		visited = new int[n][m];
		bfs(0, 0);

	}

	static void bfs(int x, int y) {
		visited[x][y] = 1; // 첫 시작점을 방문했다고 두고
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		while (!queue.isEmpty()) {
			count++;
			int[] now = queue.poll();
			System.out.println("now = " + Arrays.toString(now));
			int a = now[0];
			int b = now[1];
			if (a == n - 1 && b == m - 1) {
				System.out.println(count - 1);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];
				if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && map[nx][ny] == 1 && visited[nx][ny] == 0) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = 1;
				}
			}
		}

	}
}
