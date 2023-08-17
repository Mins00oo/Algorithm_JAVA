package bj.G4;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	static int n, col[], ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		col = new int[n + 1];
		ans = 0;
		setQueen(1);
		System.out.println(ans);
	}

	static void setQueen(int row) {
		if (!isAvaliable(row - 1)) {
			return;
		}

		if (row > n) {
			ans++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			col[row] = i;
			setQueen(row + 1);
		}
	}

	static boolean isAvaliable(int row) {
		for (int i = 1; i < row; i++) {
			if (col[i] == col[row] || row - i == Math.abs(col[row] - col[i])) {
				return false;
			}
		}
		return true;
	}
}
