package bj.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1463_1로만들기 {
	static int X;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		
		int[] memo = new int[3 * X + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		
		memo[1] = 0;
		for (int i = 1; i < X; i++) {
			memo[i+1] = Math.min(memo[i + 1], memo[i] + 1);
			memo[2*i] = Math.min(memo[2 * i], memo[i] + 1);
			memo[3*i] = Math.min(memo[3 * i], memo[i] + 1);
		}
		
		System.out.println(memo[X]);
	}

}
