package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14940_쉬운최단거리 {
	static int N, M; // 행, 열의 길이
	static int[][] map;
	static int[][] dp;
	static int[] tgt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					dp[i][j] = 0;
					continue;
				} else if (map[i][j] == 1) {
					if (i - 1 < 0) {
						dp[i][j] = dp[i][j - 1] + 1;
					} else if (j - 1 < 0) {
						dp[i][j] = dp[i - 1][j] + 1;
					} else {
						dp[i][j] = dp[i][j - 1] + 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
