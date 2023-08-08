package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
	static int T, n, m, w[], select[];
	static int max;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			select = new int[2];
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 전체 과자 개수
			m = Integer.parseInt(st.nextToken()); // 무게 제한
			StringTokenizer string = new StringTokenizer(br.readLine());
			w = new int[n];
			for (int i = 0; i < n; i++) {
				w[i] = Integer.parseInt(string.nextToken());
			}
			comb(0, 0);
			if (max == Integer.MIN_VALUE) {
				sb.append("#").append(t).append(" ").append(-1).append("\n");
			} else {
				sb.append("#").append(t).append(" ").append(max).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void comb(int wIdx, int sIdx) {
		// 기저조건
		if (sIdx == 2) {
			int sum = 0;
			for (int s : select) {
				sum += s;
			}
			if (sum <= m) {
				max = Math.max(max, sum);
			}
			return;
		}
		if (wIdx == w.length) {
			return;
		}
		select[sIdx] = w[wIdx];
		comb(wIdx + 1, sIdx + 1);
		comb(wIdx + 1, sIdx);
	}
}
