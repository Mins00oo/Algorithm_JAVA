package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기3 {
	static int T, n, m; // 테스트 케이스 개수, 서쪽 사이트 개수, 동쪽 사이트 개수
	static StringTokenizer st;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			BigInteger child = BigInteger.ONE;
			BigInteger parent = BigInteger.ONE;

			for (int i = 0; i < n; i++) {
				child = child.multiply(new BigInteger(String.valueOf(m - i)));
				parent = parent.multiply(new BigInteger(String.valueOf(i + 1)));
			}
			sb.append(child.divide(parent)).append("\n");
		}
		
		System.out.println(sb);
	}
	

}
