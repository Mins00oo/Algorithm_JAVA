package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기_DP {
	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1,2에 가로 방향으로 놓여있다.
		dp[1][2][0] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				// 만약 벽인 곳을 만난다면 그냥 continue
				if (map[i][j] == 1) {
					continue;
				}
				
				dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
				dp[i][j][2] += dp[i - 1][j][2] + dp[i - 1][j][1];
				
				if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
					dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		
		
		
	}
}
