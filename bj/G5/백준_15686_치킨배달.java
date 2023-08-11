package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_15686_치킨배달 {
	static int n, m;
	static int answer = Integer.MAX_VALUE;
	static int map[][];
	static List<int[]> list = new ArrayList<>();
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new int[] { i, j });
				}
			}
		}
		check = new boolean[list.size()];
		comb(0, 0);
		System.out.println(answer);
	}

	static void comb(int sIdx, int tIdx) {
		// 전체 치킨집 개수에서 m만큼 빼서 폐업시킬 치킨집 개수
		if (tIdx == m) {
			solve();
			return;
		}
		if (sIdx == list.size()) {
			return;
		}
		check[sIdx] = true;
		comb(sIdx + 1, tIdx + 1);
		check[sIdx] = false;
		comb(sIdx + 1, tIdx);

	}

	static void solve() {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					// 각 집마다 치킨 집까지의 거리
					int home_range = cal(i, j);
					// 리턴받은 각 치킨집거리를 전부 더해주고
					sum += home_range;
				}
			}
		}
		// 최종결과값은 제일 최솟값으로 교체
		answer = Math.min(answer, sum);
	}

	static int cal(int x, int y) {
		// 한 집에 대해서 최소 치킨거리를 구해서 리턴
		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (!check[i]) {
				continue;
			}
			int absX = Math.abs(x - list.get(i)[0]);
			int absY = Math.abs(y - list.get(i)[1]);
			sum = Math.min(sum, absX + absY);
		}
		return sum;
	}
}
