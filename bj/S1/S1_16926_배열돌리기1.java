package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16926_배열돌리기1 {
	static int n, m, r, arr[][], result[][];
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = new int[n + 1][m + 1];
		for (int i = 0; i < r; i++) {
			sol();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void sol() {
		int cycle = n / 2;
		for (int k = 1; k <= cycle; k++) {
			for (int i = k; i < n; i++) {
				result[i + 1][k] = arr[i][k];
			}
			for (int i = k; i < m - k + 1; i++) {
				result[k][i] = arr[k][i + 1];
			}
//			for (int i = n - k + 1; i > 0; i--) {
//				result[i - 1][m - k + 1] = arr[i][m - k + 1];
//			}
			for (int i = n - k + 1; i > 0; i--) {
				result[i - 1][m - k + 1] = arr[i][m - k + 1];
			}
		}

	}

}
