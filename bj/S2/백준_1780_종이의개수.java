package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 같은 수로 되어있는지 확인 -> 첫 좌표점 가져와서 전체 크기까지 탐색해서 다른점 나오면 false반환하도록
 * -> 전부 다 같은 수면 그대로 + 1장 해주고
 * 2. 다른 수로 되어있으면 그대로 거기서 9등분 그대로해서 계속 재귀
 */
public class 백준_1780_종이의개수 {
	static int n, a, b, c; // a는 -1, b는 0, c는 1
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, n);
		sb.append(a).append("\n").append(b).append("\n").append(c);
		System.out.println(sb);
	}

	static void solve(int x, int y, int size) {
		// 전부 다 같은 숫자면 그 숫자에 따라서 출력해야하는 총 개수 + 1해주고
		if (check(x, y, size)) {
			if (map[x][y] == -1) {
				a += 1;
			} else if (map[x][y] == 0) {
				b += 1;
			} else {
				c += 1;
			}
			return;
		}
		// 다른 숫자가 나온다면 9등분해서 재귀를 해줌
		int newSize = size / 3;
		solve(x, y, newSize);
		solve(x, y + newSize, newSize);
		solve(x, y + (2 * newSize), newSize);
		solve(x + newSize, y, newSize);
		solve(x + (2 * newSize), y, newSize);
		solve(x + newSize, y + newSize, newSize);
		solve(x + newSize, y + (2 * newSize), newSize);
		solve(x + (2 * newSize), y + newSize, newSize);
		solve(x + (2 * newSize), y + (2 * newSize), newSize);
	}

	static boolean check(int x, int y, int size) {
		int std = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] != std) {
					return false;
				}
			}
		}
		return true;
	}
}
