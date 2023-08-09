package bj.B2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_2798_블랙잭 {
	static StringTokenizer st;
	static int n; // 카드의 수
	static int m; // 넘지 말아야 할 합의 수
	static int[] tgt = new int[3];
	static int[] src;
	static int sum;
	static int max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		src = new int[n];
		for (int i = 0; i < n; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		System.out.println(max);
	}

	static void comb(int numIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			sum = 0;
			for (int i : tgt) {
				sum += i;
			}
			if (sum <= m) {
				max = Math.max(max, sum);
			}
			return;
		}

		for (int i = numIdx; i < n; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}

//		if (numIdx == src.length) {
//			return;
//		}
//		tgt[tgtIdx] = src[numIdx];
//		comb(numIdx + 1, tgtIdx + 1);
//		comb(numIdx + 1, tgtIdx);

	}
}
