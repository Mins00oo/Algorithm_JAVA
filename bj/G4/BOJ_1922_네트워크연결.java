package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
	static int N, M, min; // n은 컴퓨터의 수, m은 선의 개수
	static int[] parents;
	static List<Node> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, (o1, o2) -> o1.c- o2.c);
		
		for (int i = 0; i < M; i++) {
			Node cur = list.get(i);
			int a_parent = find(cur.a);
			int b_parent = find(cur.b);
			
			if (a_parent != b_parent) {
				union(a_parent, b_parent);
				min += cur.c;
			}
		}
		
		System.out.println(min);
	}
	
	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		if (a < b) {
			parents[b] = parents[a];
		} else {
			parents[a] = parents[b];
		}
	}
	
	
	static class Node {
		int a, b, c;

		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	}
}
