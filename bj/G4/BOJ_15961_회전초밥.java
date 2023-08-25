package bj.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15961_회전초밥 {
	// 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시수, 쿠폰번호
	static int[] initMenu;
	static int[] changeMenu;
	static int[] arr;
	static int result;
	static boolean[] check;
	static int n, d, k, c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		d = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);
		c = Integer.parseInt(s[3]);

		arr = new int[n + k];
		initMenu = new int[d + 1];
		changeMenu = new int[d + 1];
		check = new boolean[d + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			initMenu[arr[i]]++;
			changeMenu[arr[i]]++;
		}

		changeMenu[c]++;

		for (int i = n + 1; i < n + k; i++) {
			arr[i] = arr[i - n];
		}

		solve();
		System.out.println(result);
	}

	private static void solve() {
		int left = 1;
		int right = 1;
		int count = 0;
		while (left <= right) {
			if (right - left < k) {
				if (!check[arr[right]]) {
					changeMenu[arr[right]]--;
					count++;
					check[arr[right]] = true;
				} else {
					changeMenu[arr[right]]--;
				}
				right++;
			} else {
				changeMenu[arr[left]]++;
				if (changeMenu[arr[left]] == initMenu[arr[left]]) {
					check[arr[left]] = false;
					count--;
				}
				left++;
			}
			if (!check[c]) {
				result = Math.max(result, count + 1);
			} else {
				result = Math.max(result, count);
			}
			if (right == n + k) {
				break;
			}
		}
	}
}
