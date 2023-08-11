package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 단순히 옮겨 나누는게 아니라, 완전히 나누어 떨어지도록 해야함
 * 3킬로그램으로 계속 빼주면서 5킬로그램으로도 딱 나눠떨어지는지 확인
 */
public class 백준_2839_설탕배달_메모이제이션 {
	static int n, totalCnt;
	static int[] d;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		// 전에 값을 가져와서 최솟값을 넣어줄 것이기 때문에
		//민수 어디갔어 이거 키압 50이구나 내껀 좀 더 가벼운데 보글보글 괜찮다 손목이 아프진 않니?
		//나 잠와 죽겠ㅆ어 -> 누구십니까
		
		
		// 화이팅 해 민수야 수업 3시간 밖에 안남았어
		
		d = new int[n + 5];
		Arrays.fill(d, 5000);
		d[3] = 1;
		d[5] = 1;
		for (int i = 6; i < n + 1; i++) {
			d[i] = Math.min(d[i - 3] + 1, d[i - 5] + 1);
		}
		if (d[n] < 5000) {
			System.out.println(d[n]);
		} else {
			System.out.println(-1);
		}
	}
}
