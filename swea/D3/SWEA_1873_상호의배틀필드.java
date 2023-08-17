package swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	static int T, h, w, n;
	static char[][] map;
	static char[] input;
	static StringBuilder sb = new StringBuilder();

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
			int x = 0;
			int y = 0;
			int dir = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					switch (map[i][j]) {
					case '^':
						x = i;
						y = j;
						dir = 1;
						break;
					case '>':
						x = i;
						y = j;
						dir = 4;
						break;
					case 'v':
						x = i;
						y = j;
						dir = 2;
						break;
					case '<':
						x = i;
						y = j;
						dir = 3;
						break;
					}
				}
			}

			solve(x, y, dir);

			sb.append("#").append(t).append(" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void solve(int x, int y, int dir) {
		for (char c : input) {
			switch (c) {
			case 'U':
				// 방향 바꿔주고
				dir = 1;
				// 범위 밖이면 패스
				if (x - 1 < 0) {
					continue;
				}

				// 갈 수 있으면 가고
				if (map[x - 1][y] == '.') {
					map[x][y] = '.';
					map[x - 1][y] = '^';
					x -= 1;
				}
				break;

			case 'D':
				// 방향 바꿔주고
				dir = 2;
				// 범위 밖이면 패스
				if (x + 1 >= h) {
					continue;
				}

				// 갈 수 있으면 가고
				if (map[x + 1][y] == '.') {
					map[x][y] = '.';
					map[x + 1][y] = 'v';
					x += 1;
				}
				break;

			case 'L':
				// 방향 바꿔주고
				dir = 3;
				// 범위 밖이면 패스
				if (y - 1 < 0) {
					continue;
				}

				// 갈 수 있으면 가고
				if (map[x][y - 1] == '.') {
					map[x][y] = '.';
					map[x][y - 1] = '<';
					y -= 1;
				}
				break;

			case 'R':
				// 방향 바꿔주고
				dir = 4;

				// 범위 밖이면 패스
				if (y + 1 >= w) {
					continue;
				}

				// 갈 수 있으면 가고
				if (map[x][y + 1] == '.') {
					map[x][y] = '.';
					map[x][y + 1] = '>';
					y += 1;
				}
				break;

			case 'S':
				switch (dir) {
				case 1:
					for (int j = x - 1; j >= 0; j--) { // 현재위치 위부터 맨위까지
						if (map[j][y] == '*') { // 벽돌벽만나면
							map[j][y] = '.'; // 평지만들기
							break;
						}
						if (map[j][y] == '#') // 강철벽만나면 종료
							break;

					}
					break;

				case 2:
					for (int j = x + 1; j < h; j++) {
						if (map[j][y] == '*') {
							map[j][y] = '.';
							break;
						}
						if (map[j][y] == '#')
							break;

					}
					break;

				case 3:
					for (int j = y - 1; j >= 0; j--) {
						if (map[x][j] == '*') {
							map[x][j] = '.';
							break;
						}
						if (map[x][j] == '#')
							break;

					}
					break;

				case 4:
					for (int j = y + 1; j < w; j++) {
						if (map[x][j] == '*') {
							map[x][j] = '.';
							break;
						}
						if (map[x][j] == '#')
							break;

					}
					break;
				}
				break;
			}
		}
	}
}
