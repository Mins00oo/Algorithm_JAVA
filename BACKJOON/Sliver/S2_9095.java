package BACKJOON.Sliver;

import java.util.Scanner;

public class S2_9095 {
	public static void main(String[] args) {
		/*
		 * dp 점화식 -> dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
