package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 전체를 탐색해서 전부 다 똑같은건지 check해주는데 0이면 0리턴 1이면 1리턴해서 sb에 추가
 */
public class BOJ_1992_쿼드트리 {
	static int n;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), "");
			String s = st.nextToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}
		solve(0, 0, n);
		System.out.println(sb);
	}

	static void solve(int x, int y, int size) {
		// 바로 그냥 전부 다 같은 숫자라면 sb에 추가해주고
		if (check(x, y, size)) {
			if (map[x][y] == 0) {
				sb.append(0);
			} else {
				sb.append(1);
			}
			return;
		}
		int newSize = size / 2;
		// 만약에 다른 숫자가 있다면 4등분해서 다 재귀 돌려야 함
		sb.append("(");
		solve(x, y, newSize);
		solve(x, y + newSize, newSize);
		solve(x + newSize, y, newSize);
		solve(x + newSize, y + newSize, newSize);
		sb.append(")");
	}

	static boolean check(int x, int y, int size) {
		// 비교를 해줄 기준점을 잡고
		int std = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != std) {
					return false;
				}
			}
		}
		// 전부 다 같다면 true를 리턴, 다르다면 false를 리턴
		return true;
	}
}
