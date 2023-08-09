package bj.S1;

import java.util.Arrays;
import java.util.Scanner;

public class S1_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n];

		for (int i = 0; i < n; i++) {
			wine[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(wine));
		
		int[] dp = new int[n];
		dp[0] = 0;
	}

}
