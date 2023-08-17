package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Bottom up방식으로 풀이
 */
public class BOJ_1992_쿼드트리_BottomUP {
	static int n;
	static int[][] map;

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
		System.out.println(n);
		solve(0, 0, n);
	}

	static String solve(int x, int y, int size) {
		// 바로 그냥 전부 다 같은 숫자라면 sb에 추가해주고
		if (n == 1) {
			return String.valueOf(map[x][y]);
		}
		int newSize = size / 2;
		String s1 = solve(x, y, newSize);
		String s2 = solve(x, y + newSize, newSize);
		String s3 = solve(x + newSize, y, newSize);
		String s4 = solve(x + newSize, y + newSize, newSize);
		if (s1.length() == 1 && s1.equals(s2) && s1.equals(s3) && s1.equals(s4)) {
			return s1;
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("(").append(s1).append(s2).append(s3).append(s4).append(")");
			return sb.toString();
		}
	}

}
