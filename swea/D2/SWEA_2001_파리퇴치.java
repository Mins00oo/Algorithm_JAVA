package swea.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	static int T;
	static int[][] map;
	static int sum;
	static int max;;
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sol(i, j, m);
					max = Math.max(max, sum);
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}

	static void sol(int x, int y, int m) {
		sum = 0;
		for (int i = x; i < (x + m); i++) {
			for (int j = y; j < (y + m); j++) {
				if (i >= n || i < 0 || j >= n || j < 0) {
					continue;
				}
				sum += map[i][j];
			}
		}
	}

}
