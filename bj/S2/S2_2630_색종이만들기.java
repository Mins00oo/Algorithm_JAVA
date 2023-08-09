package bj.S2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
 */
public class S2_2630_색종이만들기 {
	static int n; // 한 변의 길이
	static int[][] numbers;
	static StringTokenizer st;
	static int white, blue, total_white, total_blue;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numbers = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sol(0, 0, n);
		sb.append(total_white).append("\n").append(total_blue);
		System.out.println(sb);
	}

	static void sol(int x, int y, int size) {
		if (check(x, y, size)) {
			// 개수가 같다면
			if (numbers[x][y] == 0) {
				total_white++;
			} else {
				total_blue++;
			}
			return;
		}
		int newSize = (size / 2);
		sol(x, y, newSize);
		sol(x, y + newSize, newSize);
		sol(x + newSize, y, newSize);
		sol(x + newSize, y + newSize, newSize);
	}

	static boolean check(int x, int y, int size) {
		int std = numbers[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (numbers[i][j] != std) {
					return false;
				}
			}
		}
		return true;
	}

}
