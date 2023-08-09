package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2961_도영이가만든맛있는음식 {
	static int n; // 재료의 개수
	static boolean[] select;
	static int[][] taste;
	static int min = Integer.MAX_VALUE;
	static int dif;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		taste = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			select = new boolean[n];
			taste[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			taste[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}

		subset(0);
		System.out.println(min);
	}

	static void subset(int Idx) {
		if (Idx == n) {
			int a_sum = 1;
			int b_sum = 0;
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (select[i]) { // 재료를 선택했다면
					count++;
					a_sum *= taste[i][0];
					b_sum += taste[i][1];
				}
			}
			if (count == 0) {
				return;
			}
			min = Math.min(min, Math.abs(b_sum - a_sum));
			return;
		}
		select[Idx] = true;
		subset(Idx + 1);
		select[Idx] = false;
		subset(Idx + 1);
	}

}
