package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9655_돌게임 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if (N % 2 == 0) {
			sb.append("CY");
		} else {
			sb.append("SK");
		}
		System.out.println(sb);
	}
}
