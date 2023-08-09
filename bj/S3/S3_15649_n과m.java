package bj.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15649_n과m {
	static int n; // 1부터 n까지의 자연수 중
	static int m; // m가지를 선택하도록
	static int[] num;
	static int[] tgt;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n];
		tgt = new int[m];
		select = new boolean[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}
		perm(0);
		System.out.println(sb);
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == m) {
			for (int i : tgt) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (select[i]) {
				continue;
			}
			tgt[tgtIdx] = num[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
}
