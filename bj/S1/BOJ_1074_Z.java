package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, r, c, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		solve((int) Math.pow(2, N), r, c);
		System.out.println(cnt - 1);
	}

	static void solve(int n, int r, int c) {
		if (n == 1) {
			cnt++;
			return;
		}
		// 왼쪽 위에 있을 때
		if (r < n / 2 && c < n / 2) {
			solve(n / 2, r, c);
		} else if (r < n / 2 && c >= n / 2) { // 오른쪽 위에
			cnt += (n / 2) * (n / 2);
			solve(n / 2, r, c - (n / 2));
		} else if (r >= n / 2 && c < n / 2) {
			cnt += ((n / 2) * (n / 2)) * 2;
			solve(n / 2, r - (n / 2), c);
		} else {
			cnt += ((n / 2) * (n / 2)) * 3;
			solve(n / 2, r - (n / 2), c - (n / 2));
		}
	}
}
