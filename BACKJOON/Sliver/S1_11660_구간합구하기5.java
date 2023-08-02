package BACKJOON.Sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1 3 6 10
 * 2 5 9 14
 * 3 7 12 18
 * 4 9 15 22
 * 
 * 행이 다르면 행을 걍 끝까지 누적합에서 구해주면 됨 ex 2랑 3이 나온거면 [2][4] - [2][1] + [3][4] - [3][1] / --->3 이런식으로
 * 구간을 행 열의 차이로 정하면 될듯 
 * 예를 들어보면) 2,2 - 4.4 ? -> 2행에 4열 - 2열 합 + 3행에 4열 - 2열 + 4행에 4열 - 2열 
 */
public class S1_11660_구간합구하기5 {
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
				accu[i][j] = accu[i][j - 1] + Integer.parseInt(st.nextToken());
//				System.out.print(accu[i][j]);
			}
		}
		for (int i = 0; i < m; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			for (int j = start_x; j <= end_x; j++) {
				sum += accu[j][end_y] - accu[j][start_y - 1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}
}
