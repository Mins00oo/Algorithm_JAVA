package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int T, n, m;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];

			for (int j = 1; j <= n; j++) {
				parent[j] = j;
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int val = Integer.parseInt(st.nextToken());

				if (val == 0) {
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				} else {
					int a_find = find(Integer.parseInt(st.nextToken()));
					int b_find = find(Integer.parseInt(st.nextToken()));

					if (a_find == b_find) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}

			sb.append("\n");
		}

		System.out.print(sb);
	}

	static void union(int x, int y) {
		int x_parent = find(x);
		int y_parent = find(y);

		if (x_parent != y_parent) {
			if (x_parent < y_parent) {
				parent[y_parent] = x_parent;
			} else {
				parent[x_parent] = y_parent;
			}
		}

	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
}
