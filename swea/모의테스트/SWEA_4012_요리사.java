package swea.모의테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int T, n, tgt[], ans[], synergy_sum, d_synergy_sum, des[], answer;
	static int[][] map;
	static boolean[] visited;
	static List<Integer> dif_sum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n + 1][n + 1];
			tgt = new int[n / 2];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = Integer.MAX_VALUE;
			comb(1, 0);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == n / 2) {
			synergy_sum = 0;
			d_synergy_sum = 0;
			visited = new boolean[n + 1];
			dif_sum = new ArrayList<>();
			ans = new int[2];
			des = new int[2];
			for (int t : tgt) {
				visited[t] = true;
			}
			comb_2(0, 0);

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					dif_sum.add(i);
				}
			}
			cal(0, 0);
			answer = Math.min(answer, Math.abs(synergy_sum - d_synergy_sum));
			return;
		}
		for (int i = srcIdx; i <= n; i++) {
			tgt[tgtIdx] = i;
			comb(i + 1, tgtIdx + 1);
		}
	}

	static void comb_2(int srcIdx, int ansIdx) {
		if (ansIdx == 2) {
//			System.out.println("ans= " + Arrays.toString(ans));
			synergy_sum += map[ans[0]][ans[1]];
			synergy_sum += map[ans[1]][ans[0]];
			
			return;
		}
		for (int i = srcIdx; i < tgt.length; i++) {
			ans[ansIdx] = tgt[i];
			comb_2(i + 1, ansIdx + 1);
		}
	}

	static void cal(int srcIdx, int ansIdx) {
		if (ansIdx == 2) {
			d_synergy_sum += map[des[0]][des[1]];
			d_synergy_sum += map[des[1]][des[0]];
			return;
		}
		for (int i = srcIdx; i < dif_sum.size(); i++) {
			des[ansIdx] = dif_sum.get(i);
			cal(i + 1, ansIdx + 1);
		}
	}
}
