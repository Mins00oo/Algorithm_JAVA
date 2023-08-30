package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회 {
	static int[] tgt;
	static boolean[] selected;
	static int N, min = Integer.MAX_VALUE;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		tgt = new int[N + 1];
		selected = new boolean[N + 1];
		
		// 1번부터 N번까지 갈 때 비용이 얼마 드는지 저장
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(1);
		
		System.out.println(min);
	}
	
	static void perm(int idx) {
		if (idx == N + 1) {
			cal(tgt);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				continue;
			}
			tgt[idx] = i;
			selected[i] = true;
			perm(idx + 1);
			selected[i] = false;
		}
	}
	
	static void cal(int[] tgt) {
		int sum = 0;
		for (int i = 1; i <= N - 1; i++) {
			int t1 = tgt[i];
			int t2 = tgt[i + 1];
			
			// 다른 도시로 가는 도중 길이 없다면 다른 경우의 수로 넘어가면 되고
			if (map[t1][t2] == 0) {
				return;
			}
			
			sum += map[t1][t2];
		}
		
		if (map[tgt[N]][tgt[1]] == 0) {
			return;
		}
		
		sum += map[tgt[N]][tgt[1]];
		
		min = Math.min(sum, min);
		
	}
}	














