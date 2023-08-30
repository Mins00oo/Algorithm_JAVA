package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기2 {
	static int T, n, m; // 테스트 케이스 개수, 서쪽 사이트 개수, 동쪽 사이트 개수
	static StringTokenizer st;
	static int[][] memoi;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			memoi = new int[m + 1][n + 1];

			sb.append(comb(m, n)).append("\n");

		}
		System.out.println(sb);

	}

	static int comb(int srcIdx, int tgtIdx) {

		if (srcIdx == tgtIdx || tgtIdx == 0) {
			return memoi[srcIdx][tgtIdx] = 1;

		}
		// 이미 계산된 것이 잇으면 그걸 이용
		if (memoi[srcIdx][tgtIdx] > 0) {
			return memoi[srcIdx][tgtIdx];
		}

		// 아직 계산된 값이 없으면 선택, 비선택 두 가지 경우의 수를 모두 구한 뒤에 합친다.
		return memoi[srcIdx][tgtIdx] = comb(srcIdx - 1, tgtIdx - 1) + comb(srcIdx - 1, tgtIdx);
	}

}
