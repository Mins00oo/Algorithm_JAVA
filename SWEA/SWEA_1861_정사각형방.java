package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int T, n, map[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int room, answer, point;
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 1;
			point = Integer.MAX_VALUE;

			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[n][n];
					room = 1;
					dfs(i, j);
					// 방이 더 큰 경우에는 그냥 그 방의 좌표로 계속 바꾸고
					if (answer < room) {
						answer = room;
						point = map[i][j];
					} else if (answer == room) { // 방의 개수가 같을 경우에는 작은 좌표값으로 유지시킴
						point = Math.min(point, map[i][j]);
					}
				}
			}
			sb.append(point).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (0 > nx || nx >= n || 0 > ny || ny >= n) {
				continue;
			}
			if ((map[nx][ny] - map[x][y] == 1) && !visited[nx][ny]) {
				room++;
				dfs(nx, ny);
			}

		}
	}
}
