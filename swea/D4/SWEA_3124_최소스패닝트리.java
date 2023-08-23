package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리 {
	static int T, V, C;
	static long ans;
	static int[] parents;
	static List<Node> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			parents = new int[V + 1];
			list = new ArrayList<>();

			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())));
			}

			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				Node node = list.get(i);
				int a = node.from;
				int b = node.to;
				union(a, b, node.w);
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static void union(int a, int b, int w) {
		int a_parent = find(a);
		int b_parent = find(b);

		if (a_parent != b_parent) {
			ans += w;

			if (a_parent < b_parent) {
				parents[b_parent] = a_parent;
			} else {
				parents[a_parent] = b_parent;
			}
		}
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	static class Node implements Comparable<Node> {
		int from, to, w;

		public Node(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}
}
