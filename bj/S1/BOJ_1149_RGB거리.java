package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int N;
	static int[][] color;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		color = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] memo = new int[N][3];
		
		memo[0][0] = color[0][0];
		memo[0][1] = color[0][1];
		memo[0][2] = color[0][2];
		
		for (int i = 1; i < N; i++) {
			memo[i][0] = Math.min(color[i][0] + memo[i-1][1], color[i][0] + memo[i-1][2]);
			memo[i][1] = Math.min(color[i][1] + memo[i-1][0], color[i][1] + memo[i-1][2]);
			memo[i][2] = Math.min(color[i][2] + memo[i-1][0], color[i][2] + memo[i-1][1]);
		}
		
		int result = memo[N-1][0];
		for (int i = 0; i < 3; i++) {
			result = Math.min(memo[N-1][i], result);
		}
		System.out.println(result);
	}

}
