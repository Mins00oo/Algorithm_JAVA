package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	static int r, c, k;
	static int cnt;
	static int[][] map = new int[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

	}
}
