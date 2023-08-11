package bj.B2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_3040_백설공주와일곱난쟁이 {
	static int arr[] = new int[9];
	static int tgt[] = new int[7];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int aIdx, int tIdx) {
		if (tIdx == 7) {
			int sum = 0;
			for (int t : tgt) {
				sum += t;
			}
			if (sum == 100) {
				for (int i : tgt) {
					sb.append(i).append("\n");
				}
			}
			return;
		}
		if (aIdx == 9) {
			return;
		}
		tgt[tIdx] = arr[aIdx];
		comb(aIdx + 1, tIdx + 1);
		comb(aIdx + 1, tIdx);
	}
}
