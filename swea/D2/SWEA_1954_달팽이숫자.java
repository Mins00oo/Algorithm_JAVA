package swea.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * n = 3) 3 -> 2 -> 2 -> 1 -> 1
 * n = 4) 4 -> 3 -> 3 -> 2 -> 2 -> 1 -> 1
 * n = 5) 5 -> 4 -> 
 */
public class SWEA_1954_달팽이숫자 {
	static int T; // 테스트 케이스 개수
	static int n; // 길이
	static int[][] numbers;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int dir;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			dir = 0;
			n = Integer.parseInt(br.readLine());
			numbers = new int[n][n];
			int x = 0, y = 0;
			for (int i = 1; i <= n * n; i++) {
				numbers[x][y] = i;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (nx >= n || nx < 0 || ny >= n || ny < 0 || numbers[nx][ny] != 0) {
					dir = (dir + 1) % 4;
				}
				x += dx[dir];
				y += dy[dir];

			}
			System.out.println("#" + t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(numbers[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
