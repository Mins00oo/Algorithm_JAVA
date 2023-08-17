package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	static int T, h, w, n;
	static char[][] map;
	static char[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				map[i] = st.nextToken().toCharArray();
			}

			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			input = st.nextToken().toCharArray();

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					switch (map[i][j]) {
					case '^':
						solve(i, j, 0);
						break;
					case '>':
						solve(i, j, 1);
						break;
					case 'v':
						solve(i, j, 2);
						break;
					case '<':
						solve(i, j, 3);
						break;
					}
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}

	static void solve(int x, int y, int dir) {
		for (char c : input) {
			switch (c) {
			case 'U':
				// 방향 바꿔주고
				dir = 0;
				int nx = x - 1;
				int ny = y;
				// 범위 밖이면 패스
				if (nx < 0 || nx >= h) {
					continue;
				}
				// 갈 수 있으면 가고 
				if (map[nx][ny] == '.') {
					map[x][y] = '.';
					map[nx][ny] = '^';
				}
				break;
			case 'D':
				// 방향 바꿔주고
				dir = 0;
				int nx = x - 1;
				int ny = y;
				// 범위 밖이면 패스
				if (nx < 0 || nx >= h) {
					continue;
				}
				// 갈 수 있으면 가고 
				if (map[nx][ny] == '.') {
					map[x][y] = '.';
					map[nx][ny] = '^';
				}
				break;
			case 'L':
				// 방향 바꿔주고
				dir = 0;
				int nx = x - 1;
				int ny = y;
				// 범위 밖이면 패스
				if (nx < 0 || nx >= h) {
					continue;
				}
				// 갈 수 있으면 가고 
				if (map[nx][ny] == '.') {
					map[x][y] = '.';
					map[nx][ny] = '^';
				}
				break;
			case 'R':
				// 방향 바꿔주고
				dir = 0;
				int nx = x - 1;
				int ny = y;
				// 범위 밖이면 패스
				if (nx < 0 || nx >= h) {
					continue;
				}
				// 갈 수 있으면 가고 
				if (map[nx][ny] == '.') {
					map[x][y] = '.';
					map[nx][ny] = '^';
				}
				break;
			case 'S':

				break;
			}
		}
	}
}
