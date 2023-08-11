package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 단순히 옮겨 나누는게 아니라, 완전히 나누어 떨어지도록 해야함
 * 3킬로그램으로 계속 빼주면서 5킬로그램으로도 딱 나눠떨어지는지 확인
 */
public class 백준_2839_설탕배달 {
	static int n, totalCnt;
	static int[] type = { 5, 3 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		while (n >= 0) {
			if (n % 5 == 0) {
				totalCnt += n / 5;
				break;
			}
			n -= 3;
			totalCnt += 1;
		}
		if (n < 0) {
			totalCnt = -1;
		}
		sb.append(totalCnt);
		System.out.println(totalCnt);
	}
}
