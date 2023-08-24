package swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
	static int N, T;
	static double cost;
	static double E;
	static int[][] loc; // 섬들의 x, y 좌표를 담을 공간[N][2]
	static int tgt[];
	static int parents[];
	static List<Node> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			parents = new int[N];
			cost = 0;
			loc = new int[N][2];
			tgt = new int[2];
			list = new ArrayList<>();
			// 섬들의 좌표를 입력받아서 넣어주고
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					loc[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			// 노드들의 부모를 자기 자신으로 초기화 해놓고
			for (int i = 0; i < N; i++) {
				parents[i] = i;
			}

			E = Double.parseDouble(br.readLine());
			comb(0, 0);

			// x,y,비용이 들어있는 Node를 비용순으로 오름차순 정렬 해주고 Union-find로 연결해주면 됨
			Collections.sort(list, (o1, o2) -> Double.compare(o1.w, o2.w));
			int size = list.size();

			for (int i = 0; i < size; i++) {
				Node node = list.get(i);
				union(node.x, node.y, node.w);
			}

			sb.append("#").append(t).append(" ").append(Math.round(cost * E)).append("\n");

		}
		System.out.println(sb);
	}

	static void union(int a, int b, double c) {
		int a_parent = find(a);
		int b_parent = find(b);

		if (a_parent != b_parent) {
			cost += c;
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

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 2) {
			int a = tgt[0]; // a섬에서
			int b = tgt[1]; // b섬까지
			int[] a_loc = loc[a]; // a의 좌표를 가져오고
			int[] b_loc = loc[b]; // b의 좌표를 가져와서 길이를 구해주고
			long dis = (long) (Math.pow(Math.abs(a_loc[0] - b_loc[0]), 2) + Math.pow(Math.abs(a_loc[1] - b_loc[1]), 2));

			list.add(new Node(a, b, dis));
			return;
		}
		if (srcIdx == N) {
			return;
		}
		tgt[tgtIdx] = srcIdx;
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}

	static class Node {
		int x, y;
		long w;

		public Node(int x, int y, long w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}
