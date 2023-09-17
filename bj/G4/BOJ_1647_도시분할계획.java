package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	static int N, M; // N은 집의 개수, M은 길의 개수
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new boolean[N + 1];
		
		// 2개 구역으로 분할 시킨 뒤
		subset(1);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == N + 1) {
			solve();
			return;
		}
		selected[srcIdx] = true;
		subset(srcIdx + 1);
		selected[srcIdx] = false;
		subset(srcIdx + 1);
		
	}
	
	
	static void solve() {
		
	}
	
	
}
