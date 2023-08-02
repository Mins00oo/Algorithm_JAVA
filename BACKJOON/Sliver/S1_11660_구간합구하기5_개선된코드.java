package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 각 좌표에 원점으로부터 좌표까지의 사각형 영역의 합을 미리 계산
 */
public class S1_11660_구간합구하기5_개선된코드 {
	static int[][] accu; // 누적된 행의 합의 값
	static int n, m;
	static int sum;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		accu = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				accu[i][j] = accu[i - 1][j] + accu[i][j - 1] - accu[i - 1][j - 1] + Integer.parseInt(st.nextToken());

			}

		}
		for (int i = 0; i < m; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());

			sb.append(accu[end_x][end_y] - accu[start_x - 1][end_y] - accu[end_x][start_y - 1]
					+ accu[start_x - 1][start_y - 1]).append("\n");
		}
		System.out.println(sb);

	}
}
