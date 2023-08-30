package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 서쪽게이트에서 첫번째 인덱스부터 시작해서 놓아줘야 하는 tgt에 놓아주는데 배정받을때마다 그냥 +1씩 해주고
 * 시간초과 발생 -> 어떻게 해결할 ㅅ ㅜ있을까 ..
 * -> 알고보니 규칙이 있는 거였음 ! dp로 풀어보니 시간초과 해결하고 문제 풀 수 있었다
 */
public class BOJ_1010_다리놓기 {
	static int T, n, m; // 테스트 케이스 개수, 서쪽 사이트 개수, 동쪽 사이트 개수
	static StringTokenizer st;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	static int[][] dp;

//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		T = Integer.parseInt(br.readLine());
//
//		for (int t = 0; t < T; t++) {
//			cnt = 0;
//			st = new StringTokenizer(br.readLine());
//			n = Integer.parseInt(st.nextToken());
//			m = Integer.parseInt(st.nextToken());
//			fun(0, 0);
//			sb.append(cnt).append("\n");
//		}
//		System.out.println(sb);
//	}
//
//	static void fun(int stIdx, int connect) {
//
//		if (connect == n) {
//			cnt++;
//			return;
//		}
//		if (stIdx == m) {
//			return;
//		}
//		fun(stIdx + 1, connect + 1);
//		fun(stIdx + 1, connect);
//	}

	// ======================================================

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp = new int[31][31];

		for (int j = 1; j <= 30; j++) {
			dp[1][j] = j;
		}

		for (int i = 2; i <= 30; i++) {
			for (int j = i; j <= 30; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
			}
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sb.append(dp[n][m]).append("\n");
		}
		System.out.println(sb);

	}

}
