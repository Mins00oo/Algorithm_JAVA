package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	static int r, c, k, row_length, col_length;
	static int cnt;
	static int ans;
	static int[][] map = new int[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		row_length = 3;
		col_length = 3;
		int cnt = 0;
		int ans = -1;

		while (cnt <= 100) {
			if (map[r - 1][c- 1] == k) {
				ans = cnt;
				break;
			}
			
			if (row_length >= col_length) {
				r();
			} else {
				c();
			}
			
			cnt++;

		}

		System.out.println(ans);

	}

	static void r() {
		int col = 0;
		int[][] map_copy = new int[101][101];

		for (int i = 0; i < row_length; i++) {
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int j = 0; j < col_length; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				// 기존에 이미 나왔던 숫자라면 그 숫자의 value +1를 해주고
				if (hash.containsKey(map[i][j])) {
					hash.put(map[i][j], hash.get(map[i][j]) + 1);
				} else {
					hash.put(map[i][j], 1);
				}
			}
			ArrayList<Node> list = new ArrayList<>();

			for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
				list.add(new Node(entry.getKey(), entry.getValue()));
			}

			Collections.sort(list);
			col = Math.max(col, list.size() * 2);

			for (int k = 0; k < list.size(); k++) {
				Node node = list.get(k);
				map_copy[i][2 * k] = node.num;
				map_copy[i][2 * k + 1] = node.cnt;
			}
		}

		col_length = Math.min(99, col);
		map = map_copy;
	}

	static void c() {
		int[][] map_copy = new int[101][101];
		int row = 0;
		
		for (int j = 0; j < col_length; j++) {
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int i = 0; i < row_length; i++) {
				if (map[i][j] == 0)
					continue;
				if (hash.containsKey(map[i][j])) {
					hash.put(map[i][j], hash.get(map[i][j]) + 1);
				} else {
					hash.put(map[i][j], 1);
				}
			}
			ArrayList<Node> list = new ArrayList<>();
			
			for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
				list.add(new Node(entry.getKey(), entry.getValue()));
			}
			
			row = Math.max(row, list.size() * 2);
			Collections.sort(list);
			
			for (int p = 0; p < list.size(); p++) {
				if (p >= 50)
					break;
				Node node = list.get(p);
				map_copy[2 * p][j] = node.num;
				map_copy[2 * p + 1][j] = node.cnt;
			}
		}
		
		row_length = Math.min(99, row);
		map = map_copy;
	}

	static class Node implements Comparable<Node> {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}

	}
}
