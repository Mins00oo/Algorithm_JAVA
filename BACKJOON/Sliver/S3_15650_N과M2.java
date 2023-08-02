package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650_N과M2 {
	static int n, m;
	static StringTokenizer st;
	static int[] numbers;
	static int[] tgt;
	static StringBuilder sb = new StringBuilder();

	/*
	 * 아래 풀이는 순열로 풀되, 중복 제거 select[]은 필요 x
	 */
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//		tgt = new int[m];
//		
//		perm(0);
//		System.out.println(sb);
//	}
//
//	static void perm(int tgtIdx) {
//		if (tgtIdx == m) {
//			for (int i : tgt) {
//				sb.append(i).append(" ");
//			}
//			sb.append("\n");
//			return;
//		}
//
//		for (int i = 1; i <= n; i++) {
//			// 현재 tgtIdx보다 한 자리 이전 값과 i를 비교 (i보다 크거나 같으면 continue)
//			if (tgtIdx > 0 && tgt[tgtIdx - 1] >= i) {
//				continue;
//			}
//			tgt[tgtIdx] = i;
//			perm(tgtIdx + 1);
//
//		}
//	}
	
	// ----------------------------------------------------------
	
	/*
	 * 아래 풀이는 처음 내가 작성한 조합으로 푸는 풀이
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		numbers = new int[n];
		tgt = new int[m];

		for (int i = 0; i < n; i++) {
			numbers[i] = i + 1;
		}

		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int numIdx, int tgtIdx) {
		if (tgtIdx == m) {
			for (int i : tgt) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		/*
		 * for문으로 작성하거나 혹은 아래와 같이 재귀를 빠져나온 후 다시 재귀를 돌면서 하는 방법도 있음
		 */
//		for (int i = numIdx; i < numbers.length; i++) {
//			tgt[tgtIdx] = numbers[i];
//			comb(i + 1, tgtIdx + 1);
//		}
		
		if (numIdx == n) {
			return;
		}
		tgt[tgtIdx] = numbers[numIdx];
		comb(numIdx + 1, tgtIdx + 1);
		comb(numIdx + 1, tgtIdx);
	}

}
