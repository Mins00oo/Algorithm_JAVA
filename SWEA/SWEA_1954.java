package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n = 3) 3 -> 2 -> 2 -> 1 -> 1
 * n = 4) 4 -> 3 -> 3 -> 2 -> 2 -> 1 -> 1
 * n = 5) 5 -> 4 -> 
 */
public class SWEA_1954 {
	static int T; // 테스트 케이스 개수
	static int n; // 길이
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int dir;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			dir = 0;
			n = Integer.parseInt(br.readLine());
			sol(0, 0, 1, n);
		}
	}

	static void sol(int x, int y, int cnt, int length) {
		map = new int[n][n];
		map[x][y] = cnt;
		if (cnt == (n * n)) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		int nx = dx[dir] + x;
		int ny = dy[dir] + y;
		if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) {
			dir = (dir + 1) % 4;
		} else {
			sol(nx, ny, cnt + 1, length);	
		}
	}

}
