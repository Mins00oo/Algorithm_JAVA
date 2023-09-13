package bj.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_27945_슬슬가지를먹지않으면죽는다 {
	static int N, M;
	static ArrayList<Node> edge = new ArrayList<>();
	static int[] parent;
	static int D = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			edge.add(new Node(u, v, t));
		}

		Collections.sort(edge, (a, b) -> a.t - b.t);

		for (int i = 0; i < M; i++) {
			Node node = edge.get(i);
			if (node.t != D) {
				break;
			}
			union(node.u, node.v);
		}
		System.out.println(D);

	}

	static class Node {
		int u, v, t;

		public Node(int u, int v, int t) {
			this.u = u;
			this.v = v;
			this.t = t;
		}

	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int a_parent = find(a);
		int b_parent = find(b);

		if (a_parent != b_parent) {
			if (a_parent < b_parent) {
				parent[b_parent] = a_parent;
				D++;
			} else {
				parent[a_parent] = b_parent;
				D++;
			}
		}

	}

}




